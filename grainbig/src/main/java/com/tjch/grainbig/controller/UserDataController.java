/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserDataController
 * Author:   Administrator
 * Date:     2019/7/16 16:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.controller;

import com.tjch.grainbig.base.ResponseBase;
import com.tjch.grainbig.model.*;
import com.tjch.grainbig.service.UserDataService;
import com.tjch.grainbig.service.UserLogService;
import com.tjch.grainbig.service.UserService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/7/16
 * @since 1.0.0
 */
@Controller
@RequestMapping(value = "/userData")
public class UserDataController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDataService   userDataService;
    @Autowired
    private UserLogService userLogService;

    //模糊查询
    @ResponseBody
    @RequestMapping(value = "selectByKey",method = RequestMethod.POST)
    public ResponseBase selectByKey(String jdName, String cName, String cardId, String year,String nName,Integer pageIndex,Integer pageSize){
        ResponseBase res = new ResponseBase();
        SelectParam param = new SelectParam();
        param.setCardId(cardId);
        param.setcName(cName);
        param.setJdName(jdName);
        param.setnName(nName);
        param.setYear(year);
        param.setPageIndex(pageIndex);
        param.setPageSize(pageSize);
        UserDataResultListModel model = new UserDataResultListModel();
        model.setDataList(userDataService.selectByKey(param));
        model.setTotal(userDataService.selectCount(param));
        model.setPageIndex(pageIndex);
        model.setPageSize(pageSize);
        res.setData(model);
        res.setMsg("查询成功");
        res.setCode(200);
        return res;
    }

    //模糊查询
    @ResponseBody
    @RequestMapping(value = "selectGroupByJd",method = RequestMethod.POST)
    public ResponseBase selectGroupByJd( String year){
        ResponseBase res = new ResponseBase();
        res.setData(userDataService.selectGroupByJd(year));
        res.setMsg("查询成功");
        return res;
    }

    //模糊查询
    @ResponseBody
    @RequestMapping(value = "selectJdName",method = RequestMethod.POST)
    public ResponseBase selectJdName( String year){
        ResponseBase res = new ResponseBase();
        res.setData(userDataService.selectJdName(year));
        res.setMsg("查询成功");
        res.setCode(200);
        return res;
    }

    //模糊查询
    @ResponseBody
    @RequestMapping(value = "selectByKid",method = RequestMethod.POST)
    public ResponseBase selectByKid(HttpServletRequest request){
        ResponseBase res = new ResponseBase();
        SelectParam param = new SelectParam();
        res.setData(userDataService.selectByKey(param));
        res.setMsg("查询成功");
        return res;
    }
    //统计用户数量
    @ResponseBody
    @RequestMapping(value = "selectUserDataCount",method = RequestMethod.POST)
    public ResponseBase selectUserDataCount(HttpServletRequest request){
        String username = request.getParameter("username");
        return userDataService.selectUserDataCount(username);
    }

    //统计实测面积
    @ResponseBody
    @RequestMapping(value = "selectSCMJ",method = RequestMethod.POST)
    public ResponseBase selectSCMJ(HttpServletRequest request){
        String username = request.getParameter("username");
        return userDataService.selectSCMJ(username);
    }

    //统计合同面积
    @ResponseBody
    @RequestMapping(value = "selectHTMJ",method = RequestMethod.POST)
    public ResponseBase selectHTMJ(HttpServletRequest request){
        String username = request.getParameter("username");
        return userDataService.selectHTMJ(username);
    }
    @RequestMapping(value="/exportExcel",method={RequestMethod.POST,RequestMethod.GET})
    public void exportExcel(String jdName, String cName, String cardId, String nName, String year, Integer pageIndex,Integer pageSize,HttpServletResponse response, HttpServletRequest request) {
        XSSFWorkbook wb = null;
        SelectParam param = new SelectParam();
        param.setCardId(cardId);
        param.setcName(cName);
        param.setJdName(jdName);
        param.setnName(nName);
        param.setPageIndex(pageIndex);
        param.setPageSize(pageSize);
        try {
            wb=userDataService.exportTable(param, request);
            String downFileName = "大户数据" + ".xlsx";
            // 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
            String userAgent = request.getHeader("user-agent").toLowerCase();
            if (userAgent != null && userAgent.contains("msie") || userAgent.contains("like gecko") ) {
                // win10 ie edge 浏览器 和其他系统的ie
                downFileName = URLEncoder.encode(downFileName, "UTF-8");
            } else {
                // fe
                downFileName = new String(downFileName.getBytes("UTF-8"), "iso-8859-1");
            }
            response.setContentType("application/vnd.ms-excel");
            response.addHeader("Content-Disposition", "attachment;filename="+downFileName);
            response.addHeader("Content-Length", "");
            OutputStream ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    区级嵌套饼状图
    @ResponseBody
    @RequestMapping(value = "selectBing",method = RequestMethod.POST)
    public DataResultModel selectBing( String year){
        DataResultModel model = new DataResultModel();
        model.setData(userDataService.selectBing(year));
        return model;
    }

    //    镇级饼状图
    @ResponseBody
    @RequestMapping(value = "selectTidBing",method = RequestMethod.POST)
    public ResponseBase selectTidBing(String tid, String year){
        return userDataService.selZhenBing(tid,year);
    }

    //    村级饼状图
    @ResponseBody
    @RequestMapping(value = "selectVidBing",method = RequestMethod.POST)
    public ResponseBase selectVidBing(String vid, String year){
        return userDataService.selCunBing(vid,  year);
    }

    //    镇面积柱状图
    @ResponseBody
    @RequestMapping(value = "townBar")
    public ResponseBase townBar(String year){
        ResponseBase model = userDataService.countByTownArea(year);
        return model;
    }

// 村面积柱状图
    @ResponseBody
    @RequestMapping(value = "villageBar",method = RequestMethod.POST)
    public ResponseBase villageBar(String tid, String year){
        ResponseBase model = userDataService.areaCountByTown(tid,year);
        return model;
    }

    // 用户面积柱状图
    @ResponseBody
    @RequestMapping(value = "userdataBar",method = RequestMethod.POST)
    public ResponseBase userdataBar(String vid, String year){
        ResponseBase model = userDataService.areaCountByVillage(vid,year);
        return model;
    }

    // 日志
    @ResponseBody
    @RequestMapping(value = "userLog",method = RequestMethod.POST)
    public ResponseBase userLog(Integer pageIndex,Integer pageSize){
        ResponseBase model =userLogService.selectAll(pageIndex,pageSize);
        return model;
    }



}