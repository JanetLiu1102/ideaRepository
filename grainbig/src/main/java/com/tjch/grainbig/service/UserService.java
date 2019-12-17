/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserService
 * Author:   Administrator
 * Date:     2019/4/23 14:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.service;

import com.tjch.grainbig.base.ResponseBase;
import com.tjch.grainbig.model.UserModel;
import com.tjch.grainbig.pojo.Users;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 *
 *
 * @author Administrator
 * @create 2019/4/23
 * @since 1.0.0
 */
public interface UserService {
    /**
     *用户列表
     */
    ResponseBase findAll(Integer enable,Integer typeId,String username);
    /**
     *添加用户
     */
     Users insertUser(Users user);
    /**
     *用户登录
     */
     Users loginUser(UserModel model);

     /**
      * 用户登录
      * @param username
      * @param password
      * @return
      */
      ResponseBase UserLogin(String username, String password)throws NoSuchAlgorithmException, UnsupportedEncodingException ;

    /**
     * 获取用户基本信息
     * @param  username
     * @return
     */
    ResponseBase getUserInfo(String username);
    /**
     *修改密码
     */
    ResponseBase editPassWord(String password,String newPassword, String username) throws NoSuchAlgorithmException,UnsupportedEncodingException;
    /**
     *退出登录
     */
    ResponseBase userExit(String username);
    /**
     *用户信息编辑
     */
    ResponseBase editUser(UserModel userModel);
    /**
     *开通账户
     */
    ResponseBase passUser(Integer...id);
    /**
     *删除用户
     */
    ResponseBase delUser(Integer...id);
}