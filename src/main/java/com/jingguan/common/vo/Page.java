package com.jingguan.common.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangbo on 2016/8/14.
 */
public class Page<T> {
    public static final String ASC = "ASC";
    public static final String DESC = "DESC";
    private int page;  //要取的页码
    private int limit;  //每页容量


    private String filters; //多条件查询时的过滤条件字符串

    private FilterModel filterModel;   //filters转化成的过滤条件模型

    private String sidx;  //排序字段
    private String sord;  //排序规则，eg:正序或倒叙

    public SortPairModule sortPairModule;  // sidx和sord转化过后的排序模型

    private String searchField;  //单条件搜索时，用于搜索的字段
    private Object searchString;  //单条件搜索时，用于搜索的字段值
    private String searchOper;  //单条件搜索时，搜索操作
    private Long pages;    //总页数
    private Long recores;  //总记录数
    private List<T> result;  //记录

    public Page() {
        this.filterModel = new FilterModel();
        filterModel.setGroupOp(FilterModel.GROUP_AND);
    }

    public FilterModel getFilterModel() {
        return filterModel;
    }

    public void setFilterModel(FilterModel filterModel) {
        this.filterModel = filterModel;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
        SortPairModule sortPairModule = buildSortPairModule(sidx, sord);
        if (sortPairModule != null) {
            this.sortPairModule = sortPairModule;
        }
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
        SortPairModule sortPairModule = buildSortPairModule(sidx, sord);
        if (sortPairModule != null) {
            this.sortPairModule = sortPairModule;
        }
    }

    public String getSearchField() {
        return searchField;
    }

    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    public Object getSearchString() {
        return searchString;
    }

    public void setSearchString(Object searchString) {
        this.searchString = searchString;
        if (! StringUtils.isEmpty((String) searchField)) {
            this.filterModel.getRules().add(new FilterModel.Rule(searchField, searchString, searchOper));
        }
    }

    public String getSearchOper() {
        return searchOper;
    }

    public void setSearchOper(String searchOper) {
        this.searchOper = searchOper;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Long getRecores() {
        return recores;
    }

    public void setRecores(Long recores) {
        this.recores = recores;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
        if (!StringUtils.isEmpty(filters)) {
            this.filterModel.getGroups().add(JSON.parseObject(this.filters, new TypeReference<FilterModel>() {
            }));
        }
    }

    public SortPairModule getSortPairModule() {
        return sortPairModule;
    }

    public void setSortPairModule(SortPairModule sortPairModule) {
        this.sortPairModule = sortPairModule;
    }

    /**
     * 排序规则类
     */
    public static class SortPairModule {
        public static String ASC = "ASC";
        public static String DESC = "DESC";

        private String sortName;
        private String sortValue;
        private SortPairModule nextSort;

        public SortPairModule() {

        }



        public SortPairModule(String sortName, String sortValue, SortPairModule nextSort) {
            this.sortName = sortName;
            this.sortValue = sortValue;
            this.nextSort = nextSort;
        }

        public String getSortName() {
            return sortName;
        }

        public void setSortName(String sortName) {
            this.sortName = sortName;
        }

        public String getSortValue() {
            return sortValue;
        }

        public void setSortValue(String sortValue) {
            this.sortValue = sortValue;
        }

        public SortPairModule getNextSort() {
            return nextSort;
        }

        public void setNextSort(SortPairModule nextSort) {
            this.nextSort = nextSort;
        }
    }

    public SortPairModule buildSortPairModule(String sdix, String sord) {
        if (!StringUtils.isEmpty(sidx) && !StringUtils.isEmpty(sord)) {
            SortPairModule sortPairModule = new SortPairModule();
            String [] sordArr = sidx.split(",");
            if (sordArr.length == 1) {
                sortPairModule.setSortName(sidx.trim());
                sortPairModule.setSortValue(sord.trim());
            } else {
                SortPairModule mostDeepSortPairModule = sortPairModule;
                for (int i = 0; i < sordArr.length - 1; i++) {
                    String[] sortKV = sordArr[i].trim().split(" ");
                    String sortName = sortKV[0].trim();
                    String sortValue = sortKV[1].trim();
                    if (i == 0) {
                        mostDeepSortPairModule.setSortName(sortName);
                        mostDeepSortPairModule.setSortValue(sortValue);
                    } else {
                        SortPairModule sortPairModuleNext = new SortPairModule(sortName, sortValue, null);
                        mostDeepSortPairModule.setNextSort(sortPairModuleNext);

                        mostDeepSortPairModule = mostDeepSortPairModule.getNextSort();
                    }

                }
                SortPairModule sortPairModuleNext = new SortPairModule(sordArr[sordArr.length - 1].trim(), sord, null);
                mostDeepSortPairModule.setNextSort(sortPairModuleNext);
            }
            return sortPairModule;
        } else {
            return null;
        }
    }

    /**
     * 条件模型
     */
    public static class FilterModel {

        public static String GROUP_AND = "AND";
        public static String GROUP_OR = "OR";

        private String groupOp;

        private List<Rule> rules;

        private List<FilterModel> groups;

        @Override
        public String toString() {
            return "FilterModel{" +
                    "groupOp='" + groupOp + '\'' +
                    ", rules=" + rules +
                    ", groups=" + groups +
                    '}';
        }

        public FilterModel() {
            this.rules = new ArrayList<>();
            this.groups = new ArrayList<>();
        }

        public String getGroupOp() {
            return groupOp;
        }

        public void setGroupOp(String groupOp) {
            this.groupOp = groupOp;
        }

        public List<Rule> getRules() {
            return rules;
        }

        public void setRules(List<Rule> rules) {
            this.rules = rules;
        }

        public List<FilterModel> getGroups() {
            return groups;
        }

        public void setGroups(List<FilterModel> groups) {
            this.groups = groups;
        }

        public static class Rule {
            private String field;
            private String op;
            private Object data;

            @Override
            public String toString() {
                return "Rule{" +
                        "field='" + field + '\'' +
                        ", op='" + op + '\'' +
                        ", data=" + data +
                        '}';
            }

            public Rule(String field, Object data, String op) {
                this.field = field;
                this.op = op;
                this.data = data;
            }
            public Rule() {

            }

            public String getField() {
                return field;
            }

            public void setField(String field) {
                this.field = field;
            }

            public String getOp() {
                return op;
            }

            public void setOp(String op) {
                this.op = op;
            }

            public Object getData() {
                return data;
            }

            public void setData(Object data) {
                this.data = data;
            }
        }

    }

    //添加服务器代码端固定的过滤条件
    public void addFilter(FilterModel myFilterModel) {
        this.filterModel.getGroups().add(myFilterModel);
    }

    public void clearSearchCondition() {
        this.filterModel = null;
        this.filters = null;
        this.searchField = null;
        this.searchString = null;
        this.searchOper = null;
    }

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", limit=" + limit +
                ", filters='" + filters + '\'' +
                ", filterModel=" + filterModel +
                ", sidx='" + sidx + '\'' +
                ", sord='" + sord + '\'' +
                ", sortPairModule=" + sortPairModule +
                ", searchField='" + searchField + '\'' +
                ", searchString=" + searchString +
                ", searchOper='" + searchOper + '\'' +
                ", pages=" + pages +
                ", recores=" + recores +
                ", result=" + result +
                '}';
    }
}





