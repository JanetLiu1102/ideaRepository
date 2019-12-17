/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CountyUserMapper
 * Author:   Administrator
 * Date:     2019/7/30 9:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.dao;

import com.tjch.grainbig.pojo.County;
import com.tjch.grainbig.pojo.Town;
import com.tjch.grainbig.pojo.Village;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/7/30
 * @since 1.0.0
 */
@Mapper
@Transactional(readOnly = true)
public interface CountyUserMapper {


    List<County> selectCounty(@Param("id") Integer id);

    List<Town> selectTownByCid(@Param("cid") Integer cid, @Param("id") Integer id);

    List<Village> selectVillageByTid(@Param("tid")Integer tid, @Param("id") Integer id);

}