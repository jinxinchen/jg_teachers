package com.jingguan.teachingArchives.service.impl;

import com.jingguan.common.vo.Page;
import com.jingguan.teachingArchives.dao.impl.TeachingArchivesDaoInpl;
import com.jingguan.teachingArchives.po.TAdminTeachingMaterialsEntity;
import com.jingguan.teachingArchives.service.TeachingArchivesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 陈 on 2018/6/16.
 */
@Service("adminTeachingArchivesService")
public class TeachingArchivesServiceImpl implements TeachingArchivesService{

    @Resource(name = "adminTeachingArchivesDaoInpl")
    private TeachingArchivesDaoInpl teachingArchivesDaoInpl;

    @Override
    public Page<TAdminTeachingMaterialsEntity> loadMaterial(Page page,String status) {
        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
        page.addFilter(filterModel);
        filterModel.getRules().add(new Page.FilterModel.Rule("status",status,"eq"));
        return teachingArchivesDaoInpl.loadMaterial(page);
    }

    @Override
    public int addMaterial(String name,String type,String status) {
        return teachingArchivesDaoInpl.addMaterial(name,type,status);
    }

    @Override
    public int editMaterial(int id, String name,String type) {
        return teachingArchivesDaoInpl.editMaterial(id,name,type);
    }

    @Override
    public int deleteMaterial(int id) {
        return teachingArchivesDaoInpl.deleteMaterial(id);
    }

    @Override
    public void uploadFile(String fileName, String filename, int id) {
        teachingArchivesDaoInpl.uploadFile(fileName,filename,id);
    }

    @Override
    public String getMaterialSrcById(int id) {
        return teachingArchivesDaoInpl.getMaterialSrcById(id);
    }
}
