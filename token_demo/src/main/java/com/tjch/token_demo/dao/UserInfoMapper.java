package com.tjch.token_demo.dao;

import com.tjch.token_demo.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {

    Users getUserInfo(String username);

}
