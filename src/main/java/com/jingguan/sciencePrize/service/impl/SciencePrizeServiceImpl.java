package com.jingguan.sciencePrize.service.impl;

import com.jingguan.common.tool.ExportExcel;
import com.jingguan.common.vo.Page;
import com.jingguan.sciencePrize.dao.TEducateScientificEntityDao;
import com.jingguan.sciencePrize.dao.UploadFilePoDao;
import com.jingguan.sciencePrize.po.TEducateScientificEntity;
import com.jingguan.sciencePrize.po.UploadFilePo;
import com.jingguan.sciencePrize.service.SciencePrizeService;
import jxl.write.WriteException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.jingguan.common.dao.impl.BaseDao.getCurrentSession;

/**
 * Created by zhouliang on 2017/11/18 0018.
 */


@Service("sciencePrizeService")
public class SciencePrizeServiceImpl implements SciencePrizeService {

    @Resource(name = "tEducateScientificEntityDao")
    private TEducateScientificEntityDao tEducateScientificEntityDao;

    @Resource(name="tUploadFilePoDao")
    private UploadFilePoDao uploadFilePoDao;


    @Override
    public void getOutStream(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {
        List<TEducateScientificEntity> lists=tEducateScientificEntityDao.list(condition);
        String[] fields={"prizeName","educateScientificName","certifyNumber","type","prizeTime",
                        "theUnit","schoolName","author","membersList",
                        "others"
                        };
        String[] heads={"奖励名称","成果名称","证书编号","获奖类别","获奖日期","授予单位",
                        "学校署名排序","作者署名","成员名单","备注"};
        ExportExcel.getOS(os,lists,fields,heads);
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
    public void updatePath(String id, String path,String filename) {
        UploadFilePo uploadFilePo=new UploadFilePo();
        uploadFilePo.setId(Integer.valueOf(id.trim()));
        uploadFilePo.setEvidencePath(path);
        uploadFilePo.setFileName(filename);

        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);
        uploadFilePo.setUploadTime(time);

        uploadFilePoDao.updatePath(uploadFilePo);
    }

    @Override
    public String getPath(String id) {
        return uploadFilePoDao.getPath(Integer.valueOf(id.trim()));
    }

    @Override
    public void inSciencePrizeTemp(List<String[]> list, int user_id) {
        for(int i=0;i<list.size();i++){
            //排除重复导入
            Session session = getCurrentSession();
            Transaction transaction = session.beginTransaction();
            List<TEducateScientificEntity> tEducateScientificEntities = session.createCriteria(TEducateScientificEntity.class).
                    add(Restrictions.eq("userId",user_id)).
                    add(Restrictions.eq("certifyNumber",list.get(i)[2])).list();
            transaction.commit();
            if(tEducateScientificEntities.size() == 0){
                TEducateScientificEntity tEducateScientificEntity = new TEducateScientificEntity();
                String educateScientificName = list.get(i)[1];
                String prizeName = list.get(i)[0];
                String certifyNumber = list.get(i)[2];
                String type = list.get(i)[3];
                String prizeTime = list.get(i)[4];
                String theUnit = list.get(i)[5];
                String schoolName = list.get(i)[6];
                String author = list.get(i)[7];
                String membersList = list.get(i)[8];
                String others = list.get(i)[9];

                tEducateScientificEntity.setEducateScientificName(educateScientificName);
                tEducateScientificEntity.setPrizeName(prizeName);
                tEducateScientificEntity.setCertifyNumber(certifyNumber);
                tEducateScientificEntity.setType(type);
                tEducateScientificEntity.setPrizeTime(prizeTime);
                tEducateScientificEntity.setTheUnit(theUnit);
                tEducateScientificEntity.setSchoolName(schoolName);
                tEducateScientificEntity.setAuthor(author);
                tEducateScientificEntity.setMembersList(membersList);
                tEducateScientificEntity.setOthers(others);
                tEducateScientificEntity.setUserId(user_id);
                tEducateScientificEntity.setStatus("审核通过");

                tEducateScientificEntityDao.inSciencePrizeTemp(tEducateScientificEntity);
            }





        }
    }

    @Override
    public void inSciencePrizeAdminTemp(String[] list, int user_id) {

            if(user_id<0) return;
            //排除重复导入
            Session session = getCurrentSession();
            Transaction transaction = session.beginTransaction();
            List<TEducateScientificEntity> tEducateScientificEntities = session.createCriteria(TEducateScientificEntity.class).
                    add(Restrictions.eq("userId",user_id)).
                    add(Restrictions.eq("certifyNumber",list[3])).list();
        transaction.commit();
            if(tEducateScientificEntities.size() == 0){
                TEducateScientificEntity tEducateScientificEntity = new TEducateScientificEntity();
                String educateScientificName = list[2];
                String prizeName = list[1];
                String certifyNumber = list[3];
                String type = list[4];
                String prizeTime = list[5];
                String theUnit = list[6];
                String schoolName = list[7];
                String author = list[8];
                String membersList = list[9];
                String others = list[10];

                tEducateScientificEntity.setEducateScientificName(educateScientificName);
                tEducateScientificEntity.setPrizeName(prizeName);
                tEducateScientificEntity.setCertifyNumber(certifyNumber);
                tEducateScientificEntity.setType(type);
                tEducateScientificEntity.setPrizeTime(prizeTime);
                tEducateScientificEntity.setTheUnit(theUnit);
                tEducateScientificEntity.setSchoolName(schoolName);
                tEducateScientificEntity.setAuthor(author);
                tEducateScientificEntity.setMembersList(membersList);
                tEducateScientificEntity.setOthers(others);
                tEducateScientificEntity.setUserId(user_id);
                tEducateScientificEntity.setStatus("审核通过");

                tEducateScientificEntityDao.inSciencePrizeTemp(tEducateScientificEntity);

        }
    }

    @Override
    public Page<TEducateScientificEntity> listRecordsByCondition(String userid, Page page) {

        Page.FilterModel filterModel=new Page.FilterModel();


        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);

        int userId=Integer.valueOf(userid);

        filterModel.getRules().add(new Page.FilterModel.Rule("userId",userId,"eq"));

        page.addFilter(filterModel);

        tEducateScientificEntityDao.listRecordsByCondition(page);

        return page;

    }

    @Override
    public boolean saveRecord(int userId, TEducateScientificEntity record) {
        record.setUserId(userId);
        record.setStatus("未审核");
        tEducateScientificEntityDao.saveRecords(record);
        return true;
    }

    @Override
    public void updateRecord(TEducateScientificEntity records) {
            tEducateScientificEntityDao.updateRecords(records);
    }

    @Override
    public void deleteRecord(String id) {
        String[] ids=id.split(",");
        for (int i=0;i<ids.length;i++){
            TEducateScientificEntity tEducateScientificEntity=getRecord(Integer.valueOf(ids[i].trim()));
            tEducateScientificEntityDao.deleteRecords(tEducateScientificEntity);
        }
    }


    @Override
    public TEducateScientificEntity getRecord(Integer id) {
        return tEducateScientificEntityDao.getRecords(id);
    }
}
