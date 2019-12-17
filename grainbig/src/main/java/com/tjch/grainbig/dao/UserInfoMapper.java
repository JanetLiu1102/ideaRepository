package com.tjch.grainbig.dao;

import com.tjch.grainbig.model.UserModel;
import com.tjch.grainbig.model.UserReaultMap;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    UserReaultMap selectLogin(UserModel model);

    UserReaultMap getUserInfo(String userName);

    UserReaultMap getUserInfoById(Integer id);

    List<UserReaultMap> selectAll(UserModel model);

    Integer editPassWord(@Param(value = "id") Integer id, @Param(value = "password") String password);

    Integer editUser(UserModel model);

    Integer passUser(@Param(value = "id") Integer...id);

    int deleteByPrimaryKey(@Param(value = "id")  Integer...id);




}
