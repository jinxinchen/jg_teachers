package com.jingguan.student.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import com.jingguan.student.dao.StudentDao;
import com.jingguan.student.po.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentDao")
public class StudentDaoImpl extends BaseDao implements StudentDao {
    @Override
    public List<TStudentEntity> getList(Page.FilterModel condition) {
        return getListRecordsByCondtions(condition,TStudentEntity.class);
    }

    @Override
    public List<TPostgraduateArticleEntity> getListPostGraduateArticle(Page.FilterModel condition) {
        return getListRecordsByCondtions(condition,TPostgraduateArticleEntity.class);
    }

    @Override
    public List<TPostgraduateKeyanEntity> getListPostGraduateKeyan(Page.FilterModel condition) {
        return getListRecordsByCondtions(condition,TPostgraduateKeyanEntity.class);
    }

    @Override
    public List<TPostgraduateJingsaiEntity> getListPostGraduateJingsai(Page.FilterModel condition) {
        return getListRecordsByCondtions(condition,TPostgraduateJingsaiEntity.class);
    }

    @Override
    public List<TStuAbroadEntity> getListStuAbroad(Page.FilterModel condition) {
        return getListRecordsByCondtions(condition,TStuAbroadEntity.class);
    }

    @Override
    public List<TStuInfoEntity> getListStuInfo(Page.FilterModel condition) {
        return getListRecordsByCondtions(condition,TStuInfoEntity.class);
    }

    @Override
    public Page load(Page page) {
        return listRecordsByCon(page, TStudentEntity.class);
    }

    @Override
    public Page loadPostGraduateArticle(Page page) {
        return listRecordsByCon(page, TPostgraduateArticleEntity.class);
    }

    @Override
    public Page loadPostGraduateKeyan(Page page) {
        return listRecordsByCon(page, TPostgraduateKeyanEntity.class);
    }

    @Override
    public Page loadPostGraduateJingsai(Page page) {
        return listRecordsByCon(page, TPostgraduateJingsaiEntity.class);
    }

    @Override
    public Page loadStuAbroad(Page page) {
        return listRecordsByCon(page, TStuAbroadEntity.class);
    }

    @Override
    public Page loadStuInfo(Page page) {
        return listRecordsByCon(page, TStuInfoEntity.class);
    }

    @Override
    public int add(TStudentEntity tStudentEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(tStudentEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int addPostGraduateArticle(TPostgraduateArticleEntity tPostgraduateArticleEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(tPostgraduateArticleEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int addPostGraduateKeyan(TPostgraduateKeyanEntity tPostgraduateKeyanEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(tPostgraduateKeyanEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int addPostGraduateJingsai(TPostgraduateJingsaiEntity tPostgraduateJingsaiEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(tPostgraduateJingsaiEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int addStuAbroad(TStuAbroadEntity tStuAbroadEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(tStuAbroadEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int addInfo(TStuInfoEntity tStuInfoEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(tStuInfoEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int edit(TStudentEntity tStudentEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(tStudentEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int editPostGraduateArticle(TPostgraduateArticleEntity tPostgraduateArticleEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(tPostgraduateArticleEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int editPostGraduateKeyan(TPostgraduateKeyanEntity tPostgraduateKeyanEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(tPostgraduateKeyanEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int editPostGraduateJingsai(TPostgraduateJingsaiEntity tPostgraduateJingsaiEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(tPostgraduateJingsaiEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int editStuAbroad(TStuAbroadEntity tStuAbroadEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try{

            session.update(tStuAbroadEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int editInfo(TStuInfoEntity tStuInfoEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try{

            session.update(tStuInfoEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        TStudentEntity tStudentEntity = session.load(TStudentEntity.class,id);
        try{
            session.delete(tStudentEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int deletePostGraduateArticle(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        TPostgraduateArticleEntity tPostgraduateArticleEntity = session.load(TPostgraduateArticleEntity.class,id);
        try{
            session.delete(tPostgraduateArticleEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int deletePostGraduateKeyan(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        TPostgraduateKeyanEntity tPostgraduateKeyanEntity = session.load(TPostgraduateKeyanEntity.class,id);
        try{
            session.delete(tPostgraduateKeyanEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int deletePostGraduateJingsai(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        TPostgraduateJingsaiEntity tPostgraduateJingsaiEntity = session.load(TPostgraduateJingsaiEntity.class,id);
        try{
            session.delete(tPostgraduateJingsaiEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int deleteStuAbroad(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        TStuAbroadEntity tStuAbroadEntity = session.load(TStuAbroadEntity.class,id);
        try{
            session.delete(tStuAbroadEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int deleteInfo(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        TStuInfoEntity tStuInfoEntity = session.load(TStuInfoEntity.class,id);
        try{
            session.delete(tStuInfoEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public void inStudent(TStudentEntity tStudentEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.save(tStudentEntity);
        transaction.commit();
    }

    @Override
    public void inPostGraduateArticle(TPostgraduateArticleEntity tPostgraduateArticleEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.save(tPostgraduateArticleEntity);
        transaction.commit();
    }

    @Override
    public void inPostGraduateKeyan(TPostgraduateKeyanEntity tPostgraduateKeyanEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.save(tPostgraduateKeyanEntity);
        transaction.commit();
    }

    @Override
    public void inPostGraduateJingsai(TPostgraduateJingsaiEntity tPostgraduateJingsaiEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.save(tPostgraduateJingsaiEntity);
        transaction.commit();
    }

    @Override
    public void inStuAbroad(TStuAbroadEntity tStuAbroadEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.save(tStuAbroadEntity);
        transaction.commit();
    }

    @Override
    public void inStudentInfo(TStuInfoEntity tStuInfoEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.save(tStuInfoEntity);
        transaction.commit();
    }

    @Override
    public String getAwardSrcById(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
//        TStudentEntity tStudentEntity = session.load(TStudentEntity.class,id);
        List<TStudentEntity> tStudentEntity = session.createCriteria(TStudentEntity.class).add(Restrictions.eq("id",id)).list();

        transaction.commit();
        return tStudentEntity.get(0).getAwardFileSrc();
    }

    @Override
    public String getIssbnSrcById(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
//        TStudentEntity tStudentEntity = session.load(TStudentEntity.class,id);
        List<TStudentEntity> tStudentEntity = session.createCriteria(TStudentEntity.class).add(Restrictions.eq("id",id)).list();

        transaction.commit();
        return tStudentEntity.get(0).getIssnFileSrc();
    }

    @Override
    public String getJingsaiSrcById(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
//        TPostgraduateJingsaiEntity tPostgraduateJingsaiEntity = session.load(TPostgraduateJingsaiEntity.class,id);
        List<TPostgraduateJingsaiEntity> tPostgraduateJingsaiEntity = session.createCriteria(TPostgraduateJingsaiEntity.class).add(Restrictions.eq("id",id)).list();

        transaction.commit();
        return tPostgraduateJingsaiEntity.get(0).getFileSrc();
    }
}
