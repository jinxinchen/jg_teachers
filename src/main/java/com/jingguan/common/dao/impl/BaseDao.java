package com.jingguan.common.dao.impl;


import com.jingguan.common.vo.Page;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yangbo on 2016/10/28.
 */
public class BaseDao<T> {
//    @Resource(name = "sessionFactory")
//    protected SessionFactory sessionFactory;

    private static SessionFactory sessionFactory;
    static {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

     public static Session  getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    /**
     * 获得查找标准
     * @param searchField
     * @param searchString
     * @param searchOper
     * @return
     */
    private Criterion complicateSearchOptionAdd(String searchField, Object searchString, String searchOper, Class feildType) {
        Criterion criterion = Restrictions.gt("id", -1);
        if (! StringUtils.isEmpty(searchOper)) {
            searchOper = searchOper.trim();
            if (!searchOper.equals("in") && !searchOper.equals("ni")) {
                if (feildType == Integer.class) {
                    searchString = Integer.valueOf(String.valueOf(searchString));
                }
            }
            switch (searchOper) {
                case "eq" :
                    criterion = Restrictions.eq(searchField, searchString);
                    break;
                case "ne" :
                    criterion = Restrictions.ne(searchField, searchString);
                    break;
                case "lt" :
                    criterion = Restrictions.lt(searchField, searchString);
                    break;
                case "le" :
                    criterion = Restrictions.le(searchField, searchString);
                    break;
                case "gt" :
                    criterion = Restrictions.gt(searchField, searchString);
                    break;
                case "ge" :
                    criterion = Restrictions.ge(searchField, searchString);
                    break;
                case "bw" :
                    criterion = Restrictions.like(searchField, searchString + "%");
                    break;
                case "bn" :
                    criterion = Restrictions.not(Restrictions.like(searchField, searchString + "%"));
                    break;
                case "in" :
                    if (feildType == Integer.class) {
                        String[] itstrs = ((String)searchString).split(",");
                        Integer[] its = new Integer[itstrs.length];
                        for (int i = 0; i < itstrs.length; i++) {
                            if (itstrs[i] != null && !"".equals(itstrs[i])) {
                                its[i] = Integer.valueOf(itstrs[i]);
                            }
                        }
                        criterion = Restrictions.in(searchField, its);
                    } else {
                        criterion = Restrictions.in(searchField, ((String)searchString).split(","));
                    }
                    break;

                case "ni" :
                    if (feildType == Integer.class) {
                        String[] itstrs = ((String)searchString).split(",");
                        Integer[] its = new Integer[itstrs.length];
                        for (int i = 0; i < itstrs.length; i++) {
                            if (itstrs[i] != null && !"".equals(itstrs[i])) {
                                its[i] = Integer.valueOf(itstrs[i]);
                            }
                        }
                        criterion = Restrictions.not(Restrictions.in(searchField, its));
                    } else {
                        criterion = Restrictions.not(Restrictions.in(searchField, ((String)searchString).split(",")));
                    }
                    break;
                case "ew" :
                    criterion = Restrictions.like(searchField, "%" + searchString);
                    break;
                case "en" :
                    criterion = Restrictions.not(Restrictions.like(searchField, "%" + searchString));
                    break;
                case "cn" :
                    //正确与否待定
                    criterion = Restrictions.like(searchField, "%" + searchString + "%");
                    break;
                case "nc" :
                    //正确与否待定
                    criterion = Restrictions.not(Restrictions.like(searchField, "%" + searchString + "%"));
                    break;
                default:;
            }
        }
        return criterion;
    }


    /**
     * 根据分页条件查询分页
     * @param page
     * @return
     */
    protected Page<T> listRecordsByCon(Page page, Class<T> t) {
        List result = null;
        Long records = 0L;
        Long pages= 0L;

        int pageNo = page.getPage();
        int pageLimt = page.getLimit();
        String sidx = page.getSidx();
        String sord = page.getSord();
        String searchField = page.getSearchField();
        Object searchObj = page.getSearchString();
        String searchOper = page.getSearchOper();
        Page.FilterModel filterModel = page.getFilterModel();
        Page.SortPairModule sortPairModule = page.getSortPairModule();
        Session session = null;
        try {
            session= getCurrentSession();
            Transaction transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(t);
            //根据字段搜索
            criteria.add(complicateSearchOptionAdd(filterModel, t));


            //基本页面信息搜索
            int firstRecord = (pageNo - 1) * pageLimt;
            criteria.setFirstResult(firstRecord);
            criteria.setMaxResults(pageLimt);
            buildOrderToCondition(criteria, sortPairModule);
            result = criteria.list();
            page.setResult(result);
        }finally {
            if(session!=null){
                session.close();
            }
        }

        //查询记录总记录数
        Session session1 =null;
        try{
            session1= getCurrentSession();
            Transaction transaction1 = session1.beginTransaction();
            Criteria criteria1 = session1.createCriteria(t);
            criteria1.add(complicateSearchOptionAdd(filterModel, t));
            criteria1.setProjection(Projections.rowCount());
            records = (Long) criteria1.uniqueResult();
            page.setRecores(records);
            //页数
            pages = (records + pageLimt - 1) / pageLimt;
        }finally {
            if(session1!=null){
                session1.close();
            }
        }
        page.setPages(pages);
        //查询条件清空
        page.clearSearchCondition();
        return page;
    }

    public void buildOrderToCondition(Criteria criteria, Page.SortPairModule sortPairModule) {
        if (sortPairModule != null) {
            String sortName = sortPairModule.getSortName();
            String sortValue = sortPairModule.getSortValue();
            Page.SortPairModule nextSortPairModule = sortPairModule.getNextSort();
            if (sortValue.toUpperCase().equals(Page.SortPairModule.ASC)) {
                criteria.addOrder(Order.asc(sortName));
            } else {
                criteria.addOrder(Order.desc(sortName));
            }
            while (nextSortPairModule != null) {
                String nSortName = nextSortPairModule.getSortName();
                String nSortValue = nextSortPairModule.getSortValue();
                if (nSortValue.toUpperCase().equals(Page.SortPairModule.ASC)) {
                    criteria.addOrder(Order.asc(nSortName));
                } else {
                    criteria.addOrder(Order.desc(nSortName));
                }
                nextSortPairModule = nextSortPairModule.getNextSort();
            }
        }
    }

    /**
     * 根据输入的过滤模型构造过滤复杂条件
     * @param filterModel
     * @return
     */
    public Criterion complicateSearchOptionAdd(Page.FilterModel filterModel, Class<T> t) {
        Criterion criterion = Restrictions.and();
        if (filterModel == null || ((filterModel.getRules() == null || filterModel.getRules().size() == 0) && (filterModel.getGroups() == null || filterModel.getGroups().size() == 0))) {
            //
        } else {
            List<Criterion> criterionList = new ArrayList<>();
            List<Page.FilterModel.Rule> rules = filterModel.getRules();
            List<Page.FilterModel> groups = filterModel.getGroups();
            String groupOp = filterModel.getGroupOp();

            //rules里面的条件
            if (rules != null) {
                Iterator<Page.FilterModel.Rule> ruleIterator = rules.iterator();
                while (ruleIterator.hasNext()) {
                    Page.FilterModel.Rule rule = ruleIterator.next();
                    Class feildType = null;
                    try {
                       Field field = t.getDeclaredField(rule.getField());
                       feildType = field.getType();
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                    criterionList.add(complicateSearchOptionAdd(rule.getField(), rule.getData(), rule.getOp(), feildType));
                }
            }
            //groups里面的条件
            if (groups != null) {
                Iterator<Page.FilterModel> filterModelIterator = groups.iterator();
                while (filterModelIterator.hasNext()) {
                    Page.FilterModel groupsFilterModel = filterModelIterator.next();
                    criterionList.add(complicateSearchOptionAdd(groupsFilterModel, t));
                }
            }
            //根据groupOp合并条件
            int criterionSize = criterionList.size();
            Criterion[] criterions = new Criterion[criterionSize];
            for (int i = 0; i < criterionSize; i++) {
                criterions[i] = criterionList.get(i);
            }
            if (groupOp.equals(Page.FilterModel.GROUP_AND)) {
                criterion = Restrictions.and(criterions);
            }
            if (groupOp.equals(Page.FilterModel.GROUP_OR)) {
                criterion = Restrictions.or(criterions);
            }
        }
        return criterion;
    }


    /**
     * 根据条件获得数据
     * @param  condition
     *@return
     */
    public List<T> getListRecordsByCondtions(Page.FilterModel condition,Class<T> t){
        List<T> records=null;
        Session session=null;
        try {
            session = getCurrentSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(t);
            criteria.add(complicateSearchOptionAdd(condition, t));
            records = criteria.list();
        }finally {
            if(session!=null){
               session.close();
            }
        }
        return  records;
    }
}
