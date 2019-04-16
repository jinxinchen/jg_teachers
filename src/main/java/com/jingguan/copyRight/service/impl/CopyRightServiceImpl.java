package com.jingguan.copyRight.service.impl;

import com.jingguan.common.tool.ExportExcel;
import com.jingguan.common.vo.Page;
import com.jingguan.copyRight.dao.CopyRightDao;
import com.jingguan.copyRight.po.TCopyrightEntity;
import com.jingguan.copyRight.service.CopyRightService;
import jxl.write.WriteException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;

import static com.jingguan.common.dao.impl.BaseDao.getCurrentSession;

/**
 * Created by 陈 on 2017/11/12.
 */
@Service("copyRightService")
public class CopyRightServiceImpl implements CopyRightService {
    @Resource(name = "copyRightDao")
    private CopyRightDao copyRightDao;

    @Override
    public void getOutStream(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {
        List<TCopyrightEntity> data=copyRightDao.getList(condition);

        String[] field={"ownerName","title","issbn","type",
                        "publishName", "publishTime","publishId","otherParticipator","notice"};
        String[] heads={"作者姓名", "著作名称","ISSBN","专著/教材/译著/其他",
                        "出版社","出版时间","著作号","其他参与者","备注"};

        ExportExcel.getOS(os,data,field,heads);

    }

    @Override
    public void getOutStreamPostGraduateArticle(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {

    }

    @Override
    public void getOutStreamPostGraduateKeyan(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {

    }

    @Override
    public void getOutStreamPostGraduateJingsai(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {

    }

    @Override
    public void getOutStreamStuAbroad(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {

    }

    @Override
    public void getOutStreamStuInfo(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {

    }

    @Override
    public Page<TCopyrightEntity> loadCopyRight(int user_id, Page page) {

        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
        filterModel.getRules().add(new Page.FilterModel.Rule("user_id", user_id, "eq"));
        page.addFilter(filterModel);
        return copyRightDao.loadCopyRight(page);
    }

    @Override
    public int addCopyRight(int user_id, TCopyrightEntity tCopyrightEntity) {
        return copyRightDao.addCopyRight(user_id,tCopyrightEntity);
    }

    @Override
    public int editCopyRight(int user_id, TCopyrightEntity tCopyrightEntity) {
        return copyRightDao.editCopyRight(user_id,tCopyrightEntity);
    }

    @Override
    public int deleteCopyRight(int id) {
        return copyRightDao.deleteCopyRight(id);
    }

    @Override
    public void inCopyRight(List<String[]> list, int user_id) {
        for(int i=0;i<list.size();i++){
            //排除重复导入
            Session session = getCurrentSession();
            Transaction transaction = session.beginTransaction();
            List<TCopyrightEntity> tCopyrightEntities = session.createCriteria(TCopyrightEntity.class).
                    add(Restrictions.eq("user_id",user_id)).
                    add(Restrictions.eq("issbn",list.get(i)[2])).list();
            if(tCopyrightEntities.size() == 0){
                TCopyrightEntity tCopyrightEntity = new TCopyrightEntity();
                String ownerName = list.get(i)[0];
                String title = list.get(i)[1];
                String issbn = list.get(i)[2];
                String type = list.get(i)[3];
                String publishName = list.get(i)[4];
                String publishTime = list.get(i)[5];
                String publishId = list.get(i)[6];
                String otherParticipator = list.get(i)[7];
                String notice = list.get(i)[8];

                tCopyrightEntity.setOwnerName(ownerName);
                tCopyrightEntity.setTitle(title);
                tCopyrightEntity.setIssbn(issbn);
                tCopyrightEntity.setType(type);
                tCopyrightEntity.setPublishName(publishName);
                tCopyrightEntity.setPublishTime(publishTime);
                tCopyrightEntity.setPublishId(publishId);
                tCopyrightEntity.setOtherParticipator(otherParticipator);
                tCopyrightEntity.setNotice(notice);
                tCopyrightEntity.setuser_id(user_id);
                tCopyrightEntity.setStatus("审核通过");

                copyRightDao.inCopyRight(tCopyrightEntity);
            }





        }
    }

    @Override
    public String getCopyRightSrcById(int id) {

        return copyRightDao.getCopyRightSrcById(id);
    }
}
