/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserDataServiceImpl
 * Author:   Administrator
 * Date:     2019/7/16 15:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.service.impl;


import com.tjch.grainbig.Utils.ExcelUtils;
import com.tjch.grainbig.base.ResponseBase;
import com.tjch.grainbig.dao.UserDataUserMapper;
import com.tjch.grainbig.dao.UserInfoMapper;
import com.tjch.grainbig.model.*;
import com.tjch.grainbig.pojo.UserData;
import com.tjch.grainbig.service.UserDataService;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ClassUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/7/16
 * @since 1.0.0
 */
@Service(value="userDataService")
@Transactional(readOnly = true)
public class UserDataServiceImpl implements UserDataService {
    @Autowired
    private UserDataUserMapper userDataUserMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public List<UserData> selectByKey(SelectParam param) {
        List<UserData> list=userDataUserMapper.selectUserDataByKey(param);

        List<UserData> nlist = new ArrayList<>();
        if(list.size()>0){
            for(UserData item :list){
                UserData ndata = new UserData();
                BeanUtils.copyProperties(item, ndata);
                if(item.getDhmc()!=null){
                    ndata.setDhmc(item.getDhmc().trim());
                }
                if(item.getJd()!=null){
                    ndata.setJd(item.getJd().trim());
                }
                if(item.getHtbh()!=null){
                    ndata.setHtbh(item.getHtbh().trim());
                }
                nlist.add(ndata);
            }
        }

        return nlist;
    }

    @Override
    public List<SelectItemGroup> selectGroupByJd(String  year) {
        List<SelectItemGroup> nlist = new ArrayList<>();
        List<String> jdNameList = userDataUserMapper.selectJdName( year);

        List<SelectItemGroup> jdlist = userDataUserMapper.selectGroupByJd(year);
        for(String jname:jdNameList){
            Integer nhs =0;
            Long htmj = 0L;
            SelectItemGroup nitem = new SelectItemGroup();
            for(SelectItemGroup item:jdlist){
                if(jname==item.getJdName()){
                    nhs += item.getNus();
                    htmj += item.getHtmj();
                }
            }
            nitem.setJdName(jname);
            nitem.setHtmj(htmj);
            nitem.setNus(nhs);
            nlist.add(nitem);
        }
        return nlist;
    }

    @Override
    public List<String> selectJdName(String year) {
        List<String> jdNameList = userDataUserMapper.selectJdName(year);
        return jdNameList;
    }

    @Override
    public List<SelectItemGroup> selectGroupByCun(String jdName,String year) {
        List<SelectItemGroup> nlist = new ArrayList<>();
        List<String> cunNameList = userDataUserMapper.selectCunName(jdName,year);
        List<SelectItemGroup> cunlist = userDataUserMapper.selectGroupByCun(jdName,year);
        for(String cname:cunNameList){
            Integer nhs =0;
            Long htmj = 0L;
            SelectItemGroup nitem = new SelectItemGroup();
            for(SelectItemGroup item:cunlist){
                if(cname==item.getCunName()){
                    nhs += item.getNus();
                    htmj += item.getHtmj();
                }
            }
            nitem.setCunName(cname);
            nitem.setHtmj(htmj);
            nitem.setNus(nhs);
            nlist.add(nitem);
        }
        return nlist;
    }

    @Override
    public ResponseBase selectUserDataCount(String username) {
        UserReaultMap user = userInfoMapper.getUserInfo(username);
        ResponseBase res = new ResponseBase();
        SimpleDateFormat df = new SimpleDateFormat("yyyy");// 设置日期格式
        String year =df.format(new Date());
        if(user!=null){
            Integer count = 0;
            if(user.getTypeid()==1|| user.getTypeid()==2){
                count=userDataUserMapper.selectUserDataCount(null,null,null,year);
            }
            if(user.getTypeid()==3){
                count=userDataUserMapper.selectUserDataCount(null,user.getTown().gettCode(),null,year);
            }
            if(user.getTypeid()==4){
                count=userDataUserMapper.selectUserDataCount(user.getVillage().getvCode(),null,null,year);
            }
            res.setData(count);
            res.setMsg("查询成功");
            res.setCode(200);
        }

        return res;
    }

    @Override
    public ResponseBase selectSCMJ(String username) {
        UserReaultMap user = userInfoMapper.getUserInfo(username);
        ResponseBase res = new ResponseBase();
        SimpleDateFormat df = new SimpleDateFormat("yyyy");// 设置日期格式
        String year =df.format(new Date());
        if(user!=null){
            double scSum = 0;
            if(user.getTypeid()==1|| user.getTypeid()==2){
                scSum=userDataUserMapper.selectSCMJ(null,null,null,year);
            }
            if(user.getTypeid()==3){
                scSum=userDataUserMapper.selectSCMJ(null,user.getTown().gettCode(),null,year);
            }
            if(user.getTypeid()==4){
                scSum=userDataUserMapper.selectSCMJ(user.getVillage().getvCode(),null,null,year);
            }
            res.setData(scSum);
            res.setMsg("查询成功");
            res.setCode(200);
        }
        return res;
    }

    @Override
    public ResponseBase selectHTMJ(String username) {
        UserReaultMap user = userInfoMapper.getUserInfo(username);
        ResponseBase res = new ResponseBase();
        SimpleDateFormat df = new SimpleDateFormat("yyyy");// 设置日期格式
        String year =df.format(new Date());
        if(user!=null){
            double htSum = 0;
            if(user.getTypeid()==1|| user.getTypeid()==2){
                htSum=userDataUserMapper.selectHTMJ(null,null,null,year);
            }
            if(user.getTypeid()==3){
                htSum=userDataUserMapper.selectHTMJ(null,user.getTown().gettCode(),null,year);
            }
            if(user.getTypeid()==4){
                htSum=userDataUserMapper.selectHTMJ(user.getVillage().getvCode(),null,null,year);
            }
            res.setData(htSum);
            res.setMsg("查询成功");
            res.setCode(200);
        }
        return res;
    }

    @Override
    public Long selectCount(SelectParam param) {
        return userDataUserMapper.selectCount(param);
    }

    @Override
    public XSSFWorkbook exportTable(SelectParam param, HttpServletRequest request) throws Exception {
        List<UserData> list=userDataUserMapper.selectUserDataByKey(param);

        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();

        File srcfile = new File(path+ "static/1.xlsx");
        File file = new File(path+"static/1_temp_"+System.currentTimeMillis()+".xlsx");
        FileUtils.copyFile(srcfile, file);
        XSSFWorkbook wb = null;
        wb = ExcelUtils.exportTable(list, file);
        return wb;
    }

    @Override
    public DataModel selectBing(String year) {
        DataModel model = new DataModel();
        List<SelectItem> town = userDataUserMapper.countByAllTown(year);
//        List<SelectItem> village = userDataUserMapper.countByAllVillage();
        List<String> name = userDataUserMapper.countName( year);
        model.setLeft(name);
        model.setTown(town);
//        model.setVillage(village);
        return model;
    }

    @Override
    public ResponseBase countByTownArea(String year) {
        ResponseBase res = new ResponseBase();
        List<SelectItemArea> areas = userDataUserMapper.countByTownArea(year);
        res.setCode(200);
        res.setMsg("查询成功");
        res.setData(areas);
        return res;
    }

    @Override
    public ResponseBase areaCountByTown(String tId,String year) {
        ResponseBase res = new ResponseBase();
        List<SelectItemArea> areas  = userDataUserMapper.areaCountByTown(tId,year);
        res.setCode(200);
        res.setMsg("查询成功");
        res.setData(areas);
        return res;
    }

    @Override
    public ResponseBase areaCountByVillage(String vId,String year) {
        ResponseBase res = new ResponseBase();
        List<SelectItemArea> areas  = userDataUserMapper.areaCountByVillage(vId,year);
        res.setCode(200);
        res.setMsg("查询成功");
        res.setData(areas);
        return res;
    }

    @Override
    public ResponseBase selCunBing(String codeId,String year) {
        List<SelectItem> town = userDataUserMapper.countByDH(codeId,year);
        HashMap<String, BigInteger> data = new HashMap<>();
        for(SelectItem item:town){
            data.put(item.getNname(),item.getNvalue());
        }
        ResponseBase responseBase = new ResponseBase();
        responseBase.setData(data);
        responseBase.setCode(200);
        responseBase.setMsg("查询成功");
        return responseBase;
    }

    @Override
    public ResponseBase selZhenBing(String tid,String year) {
        List<SelectItem> town = userDataUserMapper.countByVillage(tid,year);
        HashMap<String, BigInteger> data = new HashMap<>();
        for(SelectItem item:town){
            data.put(item.getNname(),item.getNvalue());
        }
        ResponseBase responseBase = new ResponseBase();
        responseBase.setData(data);
        responseBase.setCode(200);
        responseBase.setMsg("查询成功");
        return responseBase;
    }

}