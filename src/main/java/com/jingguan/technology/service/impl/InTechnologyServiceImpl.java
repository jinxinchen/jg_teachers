package com.jingguan.technology.service.impl;

import com.jingguan.technology.dao.InTechnologyDao;
import com.jingguan.technology.po.TTechnologyEntity;
import com.jingguan.technology.service.InTechnologyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 陈 on 2017/10/25.
 */
@Service("inTechnologyService")
public class InTechnologyServiceImpl implements InTechnologyService {

    @Resource(name = "inTechnologyDao")
    private InTechnologyDao inTechnologyDao;
    @Override
    public void InTechnologies(List<String[]> list) {
        for(int i=0;i<list.size();i++){
//            for(int j=0;j<list.get(i).length;j++){
                TTechnologyEntity tTechnologyEntity = new TTechnologyEntity();
                String techId = list.get(i)[0];
                String time = list.get(i)[1];
                String level = list.get(i)[2];
                String type = list.get(i)[3];
                String name = list.get(i)[4];
//                BigDecimal funds = new BigDecimal(list.get(i)[5]);
                Double funds = Double.valueOf(list.get(i)[5]);
                String leadPeople = list.get(i)[6];
                String office = list.get(i)[7];
                tTechnologyEntity.setTechId(techId);
                tTechnologyEntity.setTime(time);
                tTechnologyEntity.setLevel(level);
                tTechnologyEntity.setType(type);
                tTechnologyEntity.setName(name);
                tTechnologyEntity.setFunds(funds);
                tTechnologyEntity.setLeadPeople(leadPeople);
                tTechnologyEntity.setOffice(office);
                tTechnologyEntity.setStatus("审核通过");

                inTechnologyDao.InTechnology(tTechnologyEntity);
//            }
        }
    }
}
