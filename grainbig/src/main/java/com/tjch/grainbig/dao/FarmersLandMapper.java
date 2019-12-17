package com.tjch.grainbig.dao;

import com.tjch.grainbig.pojo.FarmersLand;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Transactional(readOnly = true)
public interface FarmersLandMapper {
    int deleteByPrimaryKey(Integer gid);

    int insert(FarmersLand record);

    int insertSelective(FarmersLand record);

    FarmersLand selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(FarmersLand record);

    int updateByPrimaryKey(FarmersLand record);
}