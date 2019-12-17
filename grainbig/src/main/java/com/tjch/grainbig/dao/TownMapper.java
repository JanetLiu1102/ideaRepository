package com.tjch.grainbig.dao;

import com.tjch.grainbig.pojo.Town;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface TownMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Town record);

    int insertSelective(Town record);

    Town selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Town record);

    int updateByPrimaryKey(Town record);
}