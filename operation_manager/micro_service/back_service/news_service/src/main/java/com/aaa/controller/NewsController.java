package com.aaa.controller;

import com.aaa.dao.NewsDao;
import com.aaa.entity.News;
import com.aaa.entity.NewsDto;
import com.aaa.entity.ResultData;
import com.aaa.service.NewsService;
import com.aaa.util.ExcelUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.github.pagehelper.PageInfo;
import com.netflix.ribbon.proxy.annotation.Http;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author : bruceli
 * @version :$
 * @date :Created in 2020/8/1 11:10
 * @description :
 * @modified :
 */
@RestController
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsService newsService;
    //1.查询页面数据
    @GetMapping("newsPage")
    public PageInfo<HashMap> newsInfos( @Param("pageSize") Integer pageSize,@Param("pageNum")Integer pageNum ,
                                        @Param("newsTitle")String newsTitle, @Param("newsType")String newsType, @Param("createTime")String createTime){

        return newsService.newsInfos(pageSize,pageNum,newsTitle,newsType,createTime);
    }

    //2.新增新闻数据
    @PostMapping("addNewsInfo")
    public ResultData addNewsInfos(@RequestBody News news){
        ResultData resultData = newsService.addNews(news);
        return resultData;
    }

    //3.修改新闻数据
    @PutMapping("updateNewsInfo")
    public ResultData updateNewsInfos(@RequestBody News news){
        ResultData resultData = newsService.updateNews(news);
        return resultData;
    }
    //4.根据id查要修改的数据
    @GetMapping("selectByIdNew")
    public News selectByIdNews(Integer newsId){
       News news = newsService.selectNewsById(newsId);
        return news;
    }
    //5.根据id删除
    @PutMapping("deleteSingleNew")
    public ResultData deleteOneNews(@RequestBody News news){
        News optionNews = new News();
        optionNews.setNewsId(news.getNewsId());
        optionNews.setDelFlag(0);
        //实际上实现的更新一个
        ResultData resultData = newsService.deleteNews(optionNews);
        return resultData;
    }
    //6.批量删除
    @PutMapping("deleteMoreNews")
    public ResultData deleteMoreNewss(@RequestBody List<Integer> list){
        //本来可以用实体直接接过来，但是前台字段是数据库字段名，就封装成了数组

        //将前台传来的多个拿到
        List<News> newsList = new ArrayList<>();
        ResultData resultData = null;
        //取出前台带来的所有id值
        for (int i=0;i<list.size();i++){
            News news = new News();
            news.setNewsId(list.get(i));
            news.setDelFlag(0);
            newsList.add(news);
        }
        if (newsList!=null&&newsList.size()>0){

            boolean state = newsService.updateBatchById(newsList);
            if (state){
                resultData = new ResultData(true,"删除成功",null);
            }else{
                resultData = new ResultData(false,"删除失败",null);
            }
        }
        return resultData;
    }
    //7.文件上传
    @PostMapping("fileUpload")
    public ResultData toFileUpload(MultipartFile file){
        List<News> newsList = new ArrayList<>();
        //1.通过工具类读取excel文件
        Map<String,Object> map = new HashMap<>(16);
        //解析excel文件
        List<ArrayList<String>> row = ExcelUtil.uploadFile(file);
        if (row.size()>0){
            //说明excel表中有数据

            int size = 0;
            //获取一行数据  row.size()代表多少行  每一次循环取出一行数据放如一个实体内
            for (int i=0;i<row.size();i++){
                News news = new News();
                ArrayList<String> rowCells = row.get(i);
                //size代表每行单元格数
                size = rowCells.size();
                //不足32个的 补全
                for (int j=size;j<32;j++){
                    rowCells.add("");
                }
                news.setNewsId(Integer.valueOf(rowCells.get(0)));
                news.setNewsTitle(rowCells.get(1).toString());

                news.setNewsType(Integer.valueOf(rowCells.get(2)));

                news.setNewsIntroduce(rowCells.get(3).toString());

               news.setCreateUsername(rowCells.get(4).toString());

                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String dates = simpleDateFormat.format(new Date());
                    news.setCreateTime(simpleDateFormat.parse(dates));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                news.setCreateUserid(Integer.valueOf(rowCells.get(6)));
                news.setCreateUsernumber(rowCells.get(7).toString());
                news.setEnclosurePath(rowCells.get(8).toString());
                news.setEnclosureName(rowCells.get(9).toString());
                news.setDelFlag(Integer.valueOf(rowCells.get(10)));

                newsList.add(news);
            }
        }
        //此时newsList内已经存储了excel内的数据
        boolean state = newsService.insertBatch(newsList);
        ResultData resultData = null;
        if (state){
            resultData = new ResultData(true,"导入成功",null);
        }else{
            resultData = new ResultData(false,"删除成功",null);
        }
        return resultData;
    }
    //8.文件导出
    @GetMapping("exportFile")
    public void exportFiles(HttpServletResponse response)  {
        //创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet
        HSSFSheet sheet = workbook.createSheet("新闻信息表");
//        sheet.setColumnWidth(8,15*256);

       // String id = UUID.randomUUID().toString();
       // String fileName = "新闻信息.xls";//设置要导出文件的名字
        //在excel中的第一行放入表头
        String[] title = {"新闻编号","新闻标题","新闻类型","新闻内容","创建人","创建时间","创建人编号","创建人工号","附件路径","附件名","有效"};
        HSSFRow row = sheet.createRow(0);//第0行
        for (int i=0;i<title.length;i++){
            //创建单元格
            HSSFCell cell= row.createCell(i);
            //设置表头
            cell.setCellValue(title[i]);
        }
        //获取数据库中数据集合
        List<News> newsList = newsService.selectList(null);
        //在表中存放查询到的数据放入到对应的列中
        News news = null;
        //从1 开始是因为 前面第0行已经填放表头了
        for (int i=0;i<newsList.size();i++){
            news = newsList.get(i);
            row = sheet.createRow(i+1);
            //等于是从第二行的第一列开始赋值 "新闻编号","新闻标题","新闻类型","新闻内容","创建人","创建时间","附件名","附件路径"
            System.out.println(news.getNewsType());
            //数据库中不能有null值
            row.createCell(0,CellType.NUMERIC).setCellValue(news.getNewsId());


            row.createCell(1, CellType.STRING).setCellValue(news.getNewsTitle());


            row.createCell(2,CellType.NUMERIC).setCellValue(news.getNewsType());


            row.createCell(3,CellType.STRING).setCellValue(news.getNewsIntroduce());


            row.createCell(4,CellType.STRING).setCellValue(news.getCreateUsername());

            //转换日期格式
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            row.createCell(5).setCellValue(simpleDateFormat.format(news.getCreateTime()));


            row.createCell(6,CellType.NUMERIC).setCellValue(news.getCreateUserid());


            row.createCell(7,CellType.STRING).setCellValue(news.getCreateUsernumber());

            row.createCell(8,CellType.STRING).setCellValue(news.getEnclosurePath());

            row.createCell(9,CellType.STRING).setCellValue(news.getEnclosureName());


            row.createCell(10,CellType.NUMERIC).setCellValue(news.getDelFlag());

        }
        //现在在内存中，要将其输出到硬盘
        File file = new File("E:\\新建文件夹 (2)\\新闻信息.xls");
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            //把工作簿中数据 s输出到内存
            workbook.write(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
