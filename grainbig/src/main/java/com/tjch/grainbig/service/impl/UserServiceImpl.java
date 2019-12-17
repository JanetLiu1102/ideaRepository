/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserServiceImpl
 * Author:   Administrator
 * Date:     2019/4/23 14:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.service.impl;

import com.tjch.grainbig.Utils.Md5Util;
import com.tjch.grainbig.Utils.ProductToken;
import com.tjch.grainbig.base.BaseApiService;
import com.tjch.grainbig.base.ResponseBase;
import com.tjch.grainbig.dao.UserInfoMapper;
import com.tjch.grainbig.dao.UserLogMapper;
import com.tjch.grainbig.dao.UserLogUserMapper;
import com.tjch.grainbig.dao.UsersMapper;
import com.tjch.grainbig.dto.TokenInfo;
import com.tjch.grainbig.model.UserModel;
import com.tjch.grainbig.model.UserReaultMap;
import com.tjch.grainbig.pojo.UserLog;
import com.tjch.grainbig.pojo.Users;
import com.tjch.grainbig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/4/23
 * @since 1.0.0
 */
@Service(value="userService")
@Transactional
public class UserServiceImpl extends BaseApiService implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private ProductToken productToken;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserLogMapper userLogMapper;

    @Override
    public ResponseBase findAll(Integer enable,Integer typeId,String username) {
        UserModel model = new UserModel();
        model.setType(typeId);
        model.setUsername(username);
        model.setEnable(enable);
        List<UserReaultMap> list= userInfoMapper.selectAll(model);
        List<UserReaultMap> nlist = new ArrayList<>();
        for(UserReaultMap user:list){
            user.setUserPassword(null);
            nlist.add(user);
        }
        ResponseBase res = new ResponseBase();
        res.setCode(200);
        res.setMsg("查询成功");
        res.setData(nlist);
        return res;
    }

    @Override
    public Users insertUser(Users user) {
        usersMapper.insertSelective(user);
        return user;
    }

    @Override
    public Users loginUser(UserModel model) {
        return userInfoMapper.selectLogin(model);
    }



    @Override
    public ResponseBase UserLogin(String username, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //1.校验登陆是否成功
        UserReaultMap user = userInfoMapper.getUserInfo(username);
        //2.如果不成功返回提示
        if (user == null ) {
            return setResultError("用户名密码错误");
        }else if(!Md5Util.validPassword(password,user.getUserPassword())){
            return setResultError("用户名密码错误");
        }else if(user.getEnable()==0){
            return setResultError("该账户未开通,请联系管理员！");
        }else {
            //3.如果成功，生产一个token
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            Map<String, String> mapInfo = productToken.productToken( user.getName(),token);
            //3.返回token信息（有效期10分钟）
            TokenInfo info = new TokenInfo();
            info.setUsername(user.getName());
            info.setToken(token);
            info.setRealname(user.getRealName());
            UserLog userLog = new UserLog();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
            userLog.setContent(user.getRealName()+"在"+df.format(new Date())+"登录");
            userLog.setTime(df.format(new Date()));
            userLog.setUsername(user.getName());
            userLogMapper.insertSelective(userLog);
            return setResultSuccess((Object)info);
        }
    }

    @Override
    public ResponseBase getUserInfo(String username) {

        UserReaultMap user = userInfoMapper.getUserInfo(username);
        if(user != null) {
            UserModel info = new UserModel();
            info.setUsername(user.getName());
            info.setId(user.getId());
            if(user.getRealName()!=null){
                info.setRealName(user.getRealName());
            }
            if(user.getcId()!=null){
                info.setcId(user.getcId());
            }
            if(user.getEmail()!=null){
               info.setEmail(user.getEmail());
            }
            if(user.getEnable()!=null){
                info.setEnable(user.getEnable());
            }
            if(user.getSex()!=null){
                info.setSex(user.getSex());
            }
            if(user.getTel()!=null){
                info.setTel(user.getTel());
            }
            if(user.gettId()!=null){
                info.settId(user.gettId());
            }
            if(user.getTypeid()!=null){
                info.setType(user.getTypeid());
            }
            if(user.getvId()!=null){
                info.setvId(user.getvId());
            }
            if(user.getCounty()!=null){
                info.setCounty(user.getCounty());
            }
            if(user.getTown()!=null){
                info.setTown(user.getTown());
            }
            if(user.getVillage()!=null){
                info.setVillage(user.getVillage());
            }
            return setResultSuccess((Object)info);
        } else {
            return setResultSuccess("无此用户");
        }
    }

    @Override
    public ResponseBase editPassWord(String password, String newPassword, String username) throws NoSuchAlgorithmException,UnsupportedEncodingException{
        ResponseBase res = new ResponseBase();
        UserReaultMap user = userInfoMapper.getUserInfo(username);
        if(!Md5Util.validPassword(password,user.getUserPassword())){
            return setResultError("密码错误");
        }else {
//            新密码
            String nps = Md5Util.getEncryptedPwd(newPassword);
            Integer item=userInfoMapper.editPassWord(user.getId(),nps);
            if(item!=0){
                res.setCode(200);
                res.setMsg("编辑成功");
            }else {
                res.setCode(500);
                res.setMsg("编辑失败");
            }

        }
        return res;
    }

    @Override
    public ResponseBase userExit(String username) {
        Boolean code = productToken.clearToken(username);
        ResponseBase res = new ResponseBase();
        if(code){
            res.setMsg("成功");
            res.setCode(200);
        }else {
            res.setMsg("失败");
            res.setCode(500);
        }
        return res;
    }
    @Override
    public ResponseBase editUser(UserModel userModel) {
        ResponseBase res = new ResponseBase();
        Integer item =userInfoMapper.editUser(userModel);
        if(item!=0){
            res.setCode(200);
            res.setMsg("编辑成功");
        }else {
            res.setCode(500);
            res.setMsg("编辑失败");
        }
        return res;
    }
    @Override
    public ResponseBase passUser(Integer...id) {
        ResponseBase res = new ResponseBase();
       Integer item= userInfoMapper.passUser(id);
        if(item!=0){
            res.setCode(200);
            res.setMsg("开通成功");
        }else {
            res.setCode(500);
            res.setMsg("开通失败");
        }
        return res;
    }
    @Override
    public ResponseBase delUser(Integer...id) {
        ResponseBase res = new ResponseBase();
        Integer item = userInfoMapper.deleteByPrimaryKey(id);
        if(item!=0){
            res.setCode(200);
            res.setMsg("删除成功");
        }else {
            res.setCode(500);
            res.setMsg("删除失败");
        }
        return res;
    }
}