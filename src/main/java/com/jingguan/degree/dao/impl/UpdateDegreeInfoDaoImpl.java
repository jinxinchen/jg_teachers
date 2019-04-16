package com.jingguan.degree.dao.impl;

import com.jingguan.baseInfo.dao.UpdateBaseInfoDao;
import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.degree.dao.UpdateDegreeInfoDao;
import com.jingguan.degree.po.TEducateDegreeEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 陈 on 2017/11/10.
 */
@Repository("updateDegreeInfo")
public class UpdateDegreeInfoDaoImpl extends BaseDao implements UpdateDegreeInfoDao{
    @Override
    public int updateDegreeInfo(int user_id, TEducateDegreeEntity temp) {

        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        TEducateDegreeEntity tEducateDegreeEntity1 = (TEducateDegreeEntity) session.createCriteria(TEducateDegreeEntity.class).add(Restrictions.eq("userId",user_id)).list().get(0);

        tEducateDegreeEntity1.setEducateDegreeName(temp.getEducateDegreeName());
        tEducateDegreeEntity1.setEducateTime(temp.getEducateTime());
        tEducateDegreeEntity1.setIsMentor(temp.getIsMentor());
        tEducateDegreeEntity1.setMajor(temp.getMajor());
        tEducateDegreeEntity1.setAdminFunction(temp.getAdminFunction());
        tEducateDegreeEntity1.setForClass(temp.getForClass());
        tEducateDegreeEntity1.setResearch(temp.getResearch());
        tEducateDegreeEntity1.setSocialFunction(temp.getSocialFunction());
        tEducateDegreeEntity1.setMentorType(temp.getMentorType());
        tEducateDegreeEntity1.setPositionType(temp.getPositionType());
        tEducateDegreeEntity1.setEducateDegreeLevel(temp.getEducateDegreeLevel());
        tEducateDegreeEntity1.setReportTime(temp.getReportTime());
        try{
            session.update(tEducateDegreeEntity1);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public void uploadFile(String fileName, String filename, int id, int user_id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        TEducateDegreeEntity tEducateDegreeEntity = session.load(TEducateDegreeEntity.class,id);
        tEducateDegreeEntity.setEducateDegreeSrc(fileName);
        tEducateDegreeEntity.setFileName(filename);

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tEducateDegreeEntity.setUploadTime(ft.format(dNow).toString());

        session.update(tEducateDegreeEntity);
        transaction.commit();
    }

    @Override
    public void uploadMentorFile(String fileName, String filename, int id, int user_id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        TEducateDegreeEntity tEducateDegreeEntity = session.load(TEducateDegreeEntity.class,id);

        tEducateDegreeEntity.setMentorEvidenceSrc(fileName);
        tEducateDegreeEntity.setMentorFileName(filename);



        session.update(tEducateDegreeEntity);
        transaction.commit();
    }

    @Override
    public String getDegreeSrcById(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

//        TEducateDegreeEntity tEducateDegreeEntity = session.load(TEducateDegreeEntity.class,id);
        List<TEducateDegreeEntity> tEducateDegreeEntity = session.createCriteria(TEducateDegreeEntity.class).add(Restrictions.eq("id",id)).list();

        transaction.commit();
        return tEducateDegreeEntity.get(0).getEducateDegreeSrc();
    }

    @Override
    public String getDegreeMentorSrcById(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

//        TEducateDegreeEntity tEducateDegreeEntity = session.load(TEducateDegreeEntity.class,id);
        List<TEducateDegreeEntity> tEducateDegreeEntity = session.createCriteria(TEducateDegreeEntity.class).add(Restrictions.eq("id",id)).list();

        transaction.commit();
        return tEducateDegreeEntity.get(0).getMentorEvidenceSrc();
    }
}
