/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FarmersLandUserMapper
 * Author:   Administrator
 * Date:     2019/5/13 10:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.dao;

import com.tjch.grainbig.model.LandKeyModel;
import com.tjch.grainbig.model.SelectItem;
import com.tjch.grainbig.model.SelectItemArea;
import com.tjch.grainbig.pojo.FarmersLand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/5/13
 * @since 1.0.0
 */
@Mapper
@Transactional(readOnly = true)
public interface FarmersLandUserMapper {
//关键字查询
    List<FarmersLand> selecetByKey(@Param(value="key") String key,Integer pageIndex,Integer pageSize);

//根据镇统计
    List<SelectItem> countByAllTown();
//镇名集合
    List<String> countName();
//根据村统计
    List<SelectItem> countByAllVillage();

//镇统计面积
    List<SelectItemArea> countByTownArea();


//根据镇id统计村中地块面积
    List<SelectItemArea> areaCountByTown(@Param(value="key") String key);
//村名集合
    List<String> countByTownNames(@Param(value="key") String key);
//数据集合，条件查询
    List<FarmersLand> selectAll(LandKeyModel model);

}