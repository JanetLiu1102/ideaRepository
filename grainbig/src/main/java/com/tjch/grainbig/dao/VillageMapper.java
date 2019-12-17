package com.tjch.grainbig.dao;

import com.tjch.grainbig.pojo.Village;

public interface VillageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Village record);

    int insertSelective(Village record);

    Village selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Village record);

    int updateByPrimaryKey(Village record);
}