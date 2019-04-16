package com.jingguan.common.tool;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by zhouliang on 2018/2/12 0012.
 */
public class  DeleteTools {
     String rex;
     String reallyPath;

    public void setRex(String rex) {
        this.rex = rex;
    }

    public void setReallyPath(String reallyPath) {
        this.reallyPath = reallyPath;
    }

    public boolean  deleteFile(String path){
        if(path==null){
            return false;
        }
        path=path.replace(rex,"");
        String uploadUrl = reallyPath + path + "/";
        boolean result=false;
        File deleteFile=new File(uploadUrl);

        if(deleteFile.exists()){
            deleteFile.delete();
            result=true;
        }else {
        }
        return  result;

    }
}
