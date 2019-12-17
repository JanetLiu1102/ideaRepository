package com.tjch.grainbig.dao;

import com.tjch.grainbig.pojo.UserLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserLogUserMapper {

    List<UserLog> selectAll(@Param(value = "pageIndex")Integer pageIndex, @Param(value = "pageSize")Integer pageSize);

    Long selectAllCount();
}
