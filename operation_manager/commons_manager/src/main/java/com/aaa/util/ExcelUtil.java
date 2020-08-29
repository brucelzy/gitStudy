package com.aaa.util;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * @author : bruceli
 * @version :$
 * @date :Created in 2020/8/4 19:58
 * @description : 导入导出excel工具
 * @modified :
 */
public class ExcelUtil {
    private static final Logger logger = LoggerFactory.getLogger(ExcelUtil.class);
    /**
     * 获取并解析excel文件，返回一个二维集合
     * @param file 上传的文件
     * @return 二维集合j即集合中存储着集合（第一重集合为行，第二重集合为列，
     * 每一行包含该行的列集合，列集合包含该行的全部单元格的值）
     *
     */
    public static ArrayList<ArrayList<String>> uploadFile(MultipartFile file){
        ArrayList<ArrayList<String>> fileResult = new ArrayList<>();
        //获取文件名称
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        Workbook workbook = null;
        try {
            //获取输入流
            InputStream inputStream = file.getInputStream();
            //判断excel版本

            if (judegExcelEdition(fileName)) {
                workbook = new XSSFWorkbook(inputStream);
            } else {
                workbook = new HSSFWorkbook(inputStream);
            }

          /*  if (POIFSFileSystem.hasPOIFSHeader(inputStream)){
                //为2003及以下版本
                workbook = new HSSFWorkbook();
            }
            if (POIXMLDocument.hasOOXMLHeader(inputStream)){
                //2007及以上
                workbook = new XSSFWorkbook();
            }*/

            //获取第一张工作表
            //sheet为工作表  row为表内行  cell行内单元格
            Sheet sheet = workbook.getSheetAt(0);
            //从第二行开始获取 因为第一行为表头
            Row row = null;
            //会将属于空的row的一起算上去
            for (int i=1;i<sheet.getPhysicalNumberOfRows();i++){
                //该嵌套循环 用来为每一行 取出所有列值
                row = sheet.getRow(i);
                //循环获取文件每一列  声明该list为存储每一行数据
                ArrayList<String> list = new ArrayList<>();
                Cell cell = null;
                //getPhysicalNumberOfCells() 是获取不为空的列个数
                for (int j=0;j<row.getPhysicalNumberOfCells();j++){

                    logger.info(i+":"+j);
                    //获取文件中 每行的每个单元格的值
                    cell = row.getCell(j);
                    if (cell==null){
                        cell = row.createCell(j);
                    }
                    if (row.getCell(j)!=null){
                        row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                    }
                   // cell.setCellType(CellType.STRING);
                    list.add(cell.getStringCellValue());
                }
                //将装有每一列的集合装入大集合中
                fileResult.add(list);

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("===================上传失败======================");
        }finally {
            //关闭资源
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return fileResult;
    }

    /**
     * 判断上传的excel文件版本（xls为2003，xlsx为2017）
     * @param fileName 文件路径
     * @return excel2007及以上版本返回true，excel2007以下版本返回false
     */
    private static boolean judegExcelEdition(String fileName){
        if (fileName.matches("^.+\\.(?i)(xls)$")){
            return false;
        }else {
            return true;
        }
    }
}
