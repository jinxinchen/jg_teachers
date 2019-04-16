package com.jingguan.uploadExcel.controller;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈 on 2017/9/27.
 */
//@Controller
//public class test {
//    @RequestMapping(value = "uploadExcel",method = RequestMethod.POST)
//    public void uploadExcelTest(HttpServletRequest request, @RequestParam MultipartFile file){
//        try {
//            //HSSFWorkbook表示整个excel
//            POIFSFileSystem pfs = new POIFSFileSystem(file.getInputStream());
//            HSSFWorkbook hwb = new HSSFWorkbook(pfs);
//
//            List<List<String>> result = new ArrayList<List<String>>();
//            for(int numSheet = 0;numSheet<hwb.getNumberOfSheets();numSheet++){
//                //表示Excel里的某一页，sheet
//                HSSFSheet hsf = hwb.getSheetAt(numSheet);
//                if(hsf == null){
//                    continue;
//                }
//                //处理当前页，循环每一行
//                for(int rowNum = 1;rowNum <= hsf.getLastRowNum();rowNum++){
//                    HSSFRow hsr = hsf.getRow(rowNum);
//                    int minColIx = hsr.getFirstCellNum();
//                    int maxColIx = hsr.getLastCellNum();
//                    List<String> rowList = new ArrayList<String>();
//                    //遍历该行，获取处理每一个cell元素
//                    for(int colIx = minColIx;colIx < maxColIx;colIx++){
//                        HSSFCell cell = hsr.getCell(colIx);
//                        if(cell == null){
//                            continue;
//                        }
////                        hssfCell.setCellType(CellType.STRING);
//                        rowList.add(cell.toString());
//                        System.out.print(getStringVal(cell)+" ");
//                    }
//                    result.add(rowList);
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public static String getStringVal(HSSFCell cell){
//        switch (cell.getCellType()){
//            case Cell.CELL_TYPE_BOOLEAN:
//
//                return cell.getBooleanCellValue() ? "TRUE" : "FALSE";
//            case Cell.CELL_TYPE_FORMULA:
//                return cell.getCellFormula();
//            case Cell.CELL_TYPE_NUMERIC:
//                cell.setCellType(Cell.CELL_TYPE_STRING);
//                return cell.getStringCellValue();
//            case Cell.CELL_TYPE_STRING:
//                return cell.getStringCellValue();
//            default:
//                return "";
//        }
//    }
//}
