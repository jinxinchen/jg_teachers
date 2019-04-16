package com.jingguan.copyRight.service;

import com.jingguan.common.tool.ExportExcelImpl;
import com.jingguan.common.vo.Page;
import com.jingguan.copyRight.po.TCopyrightEntity;

import java.util.List;

/**
 * Created by 陈 on 2017/11/12.
 */
public interface CopyRightService extends ExportExcelImpl {
    Page<TCopyrightEntity> loadCopyRight(int user_id, Page page);
    int addCopyRight(int user_id, TCopyrightEntity tCopyrightEntity);
    int editCopyRight(int user_id, TCopyrightEntity tCopyrightEntity);
    int deleteCopyRight(int id);
    void inCopyRight(List<String[]> list, int user_id);
    String getCopyRightSrcById(int id);
}
