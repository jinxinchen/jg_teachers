package com.jingguan.messageBoard.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import com.jingguan.messageBoard.dao.MessageBoardDao;
import com.jingguan.messageBoard.po.TMessageAboardEntity;
import com.jingguan.messageBoard.po.VMessageboardEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 陈 on 2018/5/17.
 */
@Repository("messageBoardDao")
public class MessageBoardDaoImpl extends BaseDao implements MessageBoardDao {
    @Override
    public Page loadMessageBoard(Page page) {
        return listRecordsByCon(page, TMessageAboardEntity.class);
    }

    @Override
    public int addMessageBoard(int user_id, TMessageAboardEntity tMessageAboardEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        tMessageAboardEntity.setUserId(user_id);
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tMessageAboardEntity.setDateTime(ft.format(dNow).toString());
        tMessageAboardEntity.setStatus("1");
        try{
            session.save(tMessageAboardEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int editMessageBoard(int user_id, TMessageAboardEntity tMessageAboardEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        //获取status
//        Session session1 = getCurrentSession();
//        Transaction transaction1 = session1.beginTransaction();
//        TMessageAboardEntity tMessageAboardEntity1 = session1.load(TMessageAboardEntity.class,tMessageAboardEntity.getId());


        try {
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            tMessageAboardEntity.setDateTime(ft.format(dNow).toString());
            tMessageAboardEntity.setUserId(user_id);


            session.update(tMessageAboardEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int deleteMessageBoard(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try{
            TMessageAboardEntity tMessageAboardEntity = session.load(TMessageAboardEntity.class,id);
            session.delete(tMessageAboardEntity);
            transaction.commit();
            return 200;
        }catch (Exception E){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public Page loadMessageBoardAdmin(Page page) {
        return listRecordsByCon(page, VMessageboardEntity.class);
    }
}
