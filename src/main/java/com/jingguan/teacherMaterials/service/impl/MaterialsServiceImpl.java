package com.jingguan.teacherMaterials.service.impl;

import com.jingguan.common.tool.DeleteTools;
import com.jingguan.common.tool.ExportExcel;
import com.jingguan.common.vo.Page;
import com.jingguan.teacherMaterials.dao.TTeachingMaterialEntityDao;
import com.jingguan.teacherMaterials.dao.TimeManDao;
import com.jingguan.teacherMaterials.po.TTeachingMaterialEntity;
import com.jingguan.teacherMaterials.po.TimeMan;
import com.jingguan.teacherMaterials.service.MaterialsService;
import jxl.write.WriteException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhouliang on 2017/12/17 0017.
 */
@Service("materialsService")
public class MaterialsServiceImpl implements MaterialsService {

    @Resource(name = "tTeachingMaterialEntityDao")
    private TTeachingMaterialEntityDao tTeachingMaterialEntityDao;

    @Resource(name = "timeManDao")
    private TimeManDao timeManDao;


    @Override
    public void getOutStream(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {
        List<TTeachingMaterialEntity> data=tTeachingMaterialEntityDao.getLists(condition);
        String[] heads={
                "课程名称",
                "上课学期",
                "类型",
                "上传时间"};
        String[] fields={"courseName","semester","type","fileTime"};
        ExportExcel.getOS(os,data,fields,heads);
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
    public Page<TTeachingMaterialEntity> listRecordsByCondition(String userid, Page page) {

        //查询条件
        Page.FilterModel filterModel=new Page.FilterModel();

        //过滤条件Rules是AND还是OR
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
        int userId=Integer.valueOf(userid);
        //只要为当前用户的获得记录
        filterModel.getRules().add(new Page.FilterModel.Rule("userId",userId,"eq"));

        page.addFilter(filterModel);

        tTeachingMaterialEntityDao.listRecordsByCondition(page);
        return page;
    }

    @Override
    public Page<TimeMan> listDateRecordsByCondition(String userid, Page page) {
        //查询条件
        Page.FilterModel filterModel=new Page.FilterModel();

        //过滤条件Rules是AND还是OR
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
        int userId=Integer.valueOf(userid);
        //只要为当前用户的获得记录
        filterModel.getRules().add(new Page.FilterModel.Rule("userId",userId,"eq"));

        page.addFilter(filterModel);
        timeManDao.listRecordsByCondition(page);
        return page;
    }

    @Override
    public void updatePath(String id, String path) {

    }

    @Override
    public boolean saveRecord(String userId, TTeachingMaterialEntity record) {
        record.setUserId(Integer.valueOf(userId.trim()));
        tTeachingMaterialEntityDao.saveRecords(record);
        return true;
    }

    @Override
    public void updateRecord(TTeachingMaterialEntity records) {
        tTeachingMaterialEntityDao.updateRecords(records);
    }

    @Override
    public void deleteRecord(String id,String realyp) {
        String[] ids=id.split(",");
        for (int i=0;i<ids.length;i++){
            TTeachingMaterialEntity tTeachingMaterialEntity=getRecord(Integer.valueOf(ids[i].trim()));

            //文件删除
            DeleteTools deleteTools=new DeleteTools();
            deleteTools.setRex("http://127.0.0.1:8080/teachers/");
            deleteTools.setReallyPath(realyp);
            deleteTools.deleteFile(tTeachingMaterialEntity.getFile());

            tTeachingMaterialEntityDao.deleteRecords(tTeachingMaterialEntity);
        }
    }

    @Override
    public TTeachingMaterialEntity getRecord(Integer id) {
        return tTeachingMaterialEntityDao.getRecords(id);
    }

    @Override
    public void updateTimeRecord(TimeMan records) {
        timeManDao.updateRecords(records);
    }

    @Override
    public TimeMan getTimeRecord(Integer id) {
        return timeManDao.getRecords(id);
    }

    @Override
    public String getPath(String id) {
        return null;
    }


}
