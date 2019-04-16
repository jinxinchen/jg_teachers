package com.jingguan.teachingMaterialsInAdmin.service.impl;

import com.jingguan.common.vo.Page;
import com.jingguan.teachingMaterialsInAdmin.dao.MaterialDao;
import com.jingguan.teachingMaterialsInAdmin.po.TAdminTeachingMaterialsEntity;
import com.jingguan.teachingMaterialsInAdmin.service.MaterialService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 陈 on 2017/12/23.
 */
@Service("adminTeachingMaterialService")
public class MaterialServiceImpl implements MaterialService {

    @Resource(name = "adminTeachingMaterialDao")
    private MaterialDao materialDao;

    @Override
    public Page<TAdminTeachingMaterialsEntity> loadMaterial(Page page) {
        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
        page.addFilter(filterModel);
        return materialDao.loadMaterial(page);

    }

    @Override
    public void uploadFile(String fileName, String filename, int id) {
        materialDao.uploadFile(fileName,filename,id);
    }

    @Override
    public String getMaterialSrcById(int id) {
        return materialDao.getMaterialSrcById(id);
    }

    @Override
    public int addMaterial(String name) {
        return materialDao.addMaterial(name);
    }

    @Override
    public int editMaterial(int id, String name) {
        return materialDao.editMaterial(id,name);
    }

    @Override
    public int deleteMaterial(int id) {
        return materialDao.deleteMaterial(id);
    }
}
