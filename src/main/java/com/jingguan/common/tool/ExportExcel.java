package com.jingguan.common.tool;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;


/**
 * Created by zhouliang on 2018/5/17 0017.
 */
public class ExportExcel {

    //heads的内容是将表格名字和属性名字一一对应的，如对于项目来说（ProjectId，项目编号）
    static public <T>  void getOS(ServletOutputStream os, List<T> data,String[] fieldNames,String[] heads)throws IOException, WriteException {

        WritableWorkbook workbook= Workbook.createWorkbook(os);
        //创建新的一页
        WritableSheet sheet=workbook.createSheet("First Sheet",0);

        //编写头部动作
        int col=heads.length;
        int line=1;
       // String[] keys=(String[])heads.keySet().toArray();//这个是要取的值的属性

        //这个是头部的处理
        for(int i=0;i<heads.length;i++){
            Label label=new Label(i,0,heads[i]);
            sheet.addCell(label);
        }

        //对身体的处理
        for (T d:data) {

            for(int i=0;i<fieldNames.length;i++){
                String elem=findFieldValueByName(fieldNames[i],d);
                Label label=new Label(i,line,elem);
                sheet.addCell(label);
            }
            ++line;
        }

        workbook.write();
        workbook.close();

    }

    //根据属性名获得属性值
    static private String findFieldValueByName(String fieldName, Object object){
        String result="";
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = object.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(object, new Object[] {});
            result=value+"";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  result;
    }

}
