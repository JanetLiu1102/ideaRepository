/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ExcelUtils
 * Author:   Administrator
 * Date:     2019/8/13 14:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.Utils;

import com.tjch.grainbig.pojo.UserData;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/8/13
 * @since 1.0.0
 */
public class ExcelUtils {

    public static XSSFWorkbook exportTable(List<UserData> list, File excelFile) throws Exception  {
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(excelFile));
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row = sheet.createRow((int) 1);
        XSSFCellStyle style = wb.createCellStyle();
        //生成一个字体
        XSSFFont font=wb.createFont();
        font.setFontHeightInPoints((short)10);
        //把字体应用到当前的样式
        style.setFont(font);
        XSSFRow xssfRow;
        XSSFCell xssfCell;
        for(int i=0;i<list.size();i++){
            //从第一行开始写入
            xssfRow = sheet.createRow(i+1);
            //创建每个单元格Cell，即列的数据
            UserData data =list.get(i);
            XSSFCell xssfCell1 = xssfRow.createCell(0); //创建单元格
                xssfCell1.setCellValue(i+1); //设置单元格内容
//大户名称
            XSSFCell xssfCell2 = xssfRow.createCell(1); //创建单元格
            if(data.getDhmc()!=null&&data.getDhmc()!=""){
                xssfCell2.setCellValue(data.getDhmc()); //设置单元格内容
            }
//身份证号
            XSSFCell xssfCell3 = xssfRow.createCell(2); //创建单元格
            if(data.getSfzh()!=null && data.getSfzh()!=""){
                xssfCell3.setCellValue(data.getSfzh()); //设置单元格内容
            }
//一卡通号
            XSSFCell xssfCell4 = xssfRow.createCell(3); //创建单元格
            if(data.getYkth()!=null && data.getYkth()!=""){
                xssfCell4.setCellValue(data.getYkth()); //设置单元格内容
            }
//街道名称
             XSSFCell xssfCell5 = xssfRow.createCell(4); //创建单元格
            if(data.getJd()!=null && data.getJd()!=""){
                xssfCell5.setCellValue(data.getJd()); //设置单元格内容
            }
//街道ID
            XSSFCell xssfCell6 = xssfRow.createCell(5); //创建单元格
            if(data.getJdId()!=null &&data.getJdId()!=""){
                xssfCell6.setCellValue(data.getJdId()); //设置单元格内容
            }
//村名称
            XSSFCell xssfCell7 = xssfRow.createCell(6); //创建单元格
            if(data.getCun()!=null&&data.getCun()!=""){
                xssfCell7.setCellValue(data.getCun()); //设置单元格内容
            }
//村ID
            XSSFCell xssfCell8 = xssfRow.createCell(7); //创建单元格
            if(data.getCunId()!=null&&data.getCunId()!=""){
                xssfCell8.setCellValue(data.getCunId()); //设置单元格内容
            }
//电话
            XSSFCell xssfCell9 = xssfRow.createCell(8); //创建单元格
            if(data.getDh()!=null &&data.getDh()!=""){
                xssfCell9.setCellValue(data.getDh()); //设置单元格内容
            }
//合同面积
            XSSFCell xssfCell10 = xssfRow.createCell(9); //创建单元格
            if(data.getHtmj()!=null){
                xssfCell10.setCellValue(data.getHtmj()); //设置单元格内容
            }
//实测面积
            XSSFCell xssfCell11 = xssfRow.createCell(10); //创建单元格
            if(data.getScmj()!=null){
                xssfCell11.setCellValue(data.getScmj()); //设置单元格内容
            }
//面积差
            XSSFCell xssfCell12 = xssfRow.createCell(11); //创建单元格
            if(data.getMjcha()!=null){
                xssfCell12.setCellValue(data.getMjcha()); //设置单元格内容
            }
//测量时间
            XSSFCell xssfCell13 = xssfRow.createCell(12); //创建单元格
            if(data.getClsj()!=null && data.getClsj()!=""){
                xssfCell13.setCellValue(data.getClsj()); //设置单元格内容
            }
//合同编号
            XSSFCell xssfCell14 = xssfRow.createCell(13); //创建单元格
            if(data.getHtbh()!=null && data.getHtbh()!=""){
                xssfCell14.setCellValue(data.getHtbh()); //设置单元格内容
            }
//确认单号
            XSSFCell xssfCell15 = xssfRow.createCell(14); //创建单元格
            if(data.getQrd()!=null && data.getQrd()!=""){
                xssfCell15.setCellValue(data.getQrd()); //设置单元格内容
            }
//备注
            XSSFCell xssfCell16 = xssfRow.createCell(15); //创建单元格
            if(data.getBz()!=null && data.getBz()!=""){
                xssfCell16.setCellValue(data.getBz()); //设置单元格内容
            }
//农户数
            XSSFCell xssfCell17 = xssfRow.createCell(16); //创建单元格
            if(data.getNhs()!=null ){
                xssfCell17.setCellValue(data.getNhs()); //设置单元格内容
            }

        }
//      自动换行
        style.setWrapText(true);


        return wb;
    }
}