/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserController
 * Author:   Administrator
 * Date:     2019/4/23 14:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.controller;

import com.tjch.grainbig.Utils.Md5Util;
import com.tjch.grainbig.base.ResponseBase;
import com.tjch.grainbig.dto.UserDto;
import com.tjch.grainbig.model.UserModel;
import com.tjch.grainbig.pojo.Users;
import com.tjch.grainbig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * 用户注册登录
 *
 *
 * @author Administrator
 * @create 2019/4/23
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "user")
public class UserController {


    @Autowired
    private UserService userService;
/**
 *
 * 用户注册
 *
 * @param  user
 * @return:
 * @since: 1.0.0
 * @Author:Administrator
 * @Date: 2019/4/25 14:11
 */

    @ResponseBody
    @RequestMapping(value = "saveUser",method = RequestMethod.POST)
    public ResponseBase saveUser(@RequestBody Users user) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        UserModel usermodel = new UserModel();
        ResponseBase resultModel = new ResponseBase();
        usermodel.setUsername(user.getName());
        Users nuser = userService.loginUser(usermodel);
        if(nuser!=null){
            resultModel.setMsg("用户名已存在，注册失败");
            resultModel.setCode(500);
        }else {
            if(user.getUserPassword()!=null){
                String nps = Md5Util.getEncryptedPwd(user.getUserPassword());
                user.setUserPassword(nps);
                resultModel.setCode(200);
                resultModel.setMsg("成功");
               Users suser = userService.insertUser(user);
                suser.setUserPassword(null);
                resultModel.setData(suser);
            }else{
                resultModel.setCode(500);
                resultModel.setMsg("密码不能为空");
            }
        }
        return resultModel;
    }


/*
登录
 */
    @RequestMapping("/login")
    public ResponseBase UserLogin(@RequestBody @Valid UserDto userDto, HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return userService.UserLogin(userDto.getUserName(), userDto.getPassword());
    }

/*

 */
    @RequestMapping("/getUserInfo")
    public ResponseBase getUserInfo(String  username) {
        return userService.getUserInfo(username);
    }

    @RequestMapping(value = "/getUserInfoWeb",method = RequestMethod.GET)
    public ResponseBase getUserInfoWeb(String  username) {
        return userService.getUserInfo(username);
    }
/*
修改密码
 */
    @RequestMapping("/editPassWord")
    public ResponseBase editPassWord(String  password,String newPassword, HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String username = request.getParameter("username");
        return userService.editPassWord(password,newPassword,username);
    }
/*
退出登录
 */
    @RequestMapping("/userExit")
    public ResponseBase userExit( HttpServletRequest request) {
        String username = request.getParameter("username");
        return userService.userExit(username);
    }
/*
编辑用户信息
 */
    @RequestMapping("/editUser")
    public ResponseBase editUser( HttpServletRequest request,@RequestBody  UserModel model) {
        return userService.editUser(model);
    }
/*
开通账户 管理员可操作
 */
    @RequestMapping("/passUser")
    public ResponseBase passUser( HttpServletRequest request,Integer...id) {
        UserModel usermodel = new UserModel();
        String username = request.getParameter("username");
        usermodel.setUsername(username);
        ResponseBase res = new ResponseBase();
        Users nuser = userService.loginUser(usermodel);
        if(nuser.getTypeid()==1){
            return userService.passUser(id);
        }else {
            res.setCode(500);
            res.setMsg("您没有操作权限,请联系管理员!");
            return res;
        }
    }
    /*
删除用户
     */
    @RequestMapping("/delUser")
    public ResponseBase delUser( HttpServletRequest request,Integer...id) {
        UserModel usermodel = new UserModel();
        String username = request.getParameter("username");
        usermodel.setUsername(username);
        ResponseBase res = new ResponseBase();
        Users nuser = userService.loginUser(usermodel);
        if(nuser.getTypeid()==1){
            return userService.delUser(id);
        }else {
            res.setCode(500);
            res.setMsg("您没有操作权限,请联系管理员!");
            return res;
        }
    }

    @RequestMapping("/userList")
    public ResponseBase userList( HttpServletRequest request,Integer enable,Integer typeId,String name) {
        UserModel usermodel = new UserModel();
        usermodel.setUsername(name);
        ResponseBase res = userService.findAll(enable,typeId,name);
        return res;
    }

}