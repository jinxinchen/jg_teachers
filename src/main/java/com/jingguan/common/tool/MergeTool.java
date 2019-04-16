package com.jingguan.common.tool;


import org.apache.commons.beanutils.BeanMap;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 融合class
 */
public class MergeTool {


    /**
     * 主要将更新的字段赋予到datebaseObject完成在java成眠
     * @param updateObject 有更新数据的object
     * @param databaseObject 在数据拿到的旧数据
     */
    public static void mergeObject(Object updateObject,Object databaseObject){
        //将updateObject转化为map
         Map updateMap = new BeanMap(updateObject);
        Method[]  m = databaseObject.getClass().getMethods();


        //遍历uodateMap把不是null的更新到datebasObject里面
        for(Object it : updateMap.keySet()){
            if(updateMap.get(it)!=null){
                //不是空到请更新
                try {
                    setObject(databaseObject,m,it.toString(),updateMap.get(it));
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }

    }
    private static void setObject(Object datebaseObject,Method[] m,String name,Object value) throws InvocationTargetException, IllegalAccessException {
        for(int i=0;i<m.length;i++){
            if(("set"+name).toLowerCase().equals(m[i].getName().toLowerCase())){
                m[i].invoke(datebaseObject,value);
            }
        }
    }

}
