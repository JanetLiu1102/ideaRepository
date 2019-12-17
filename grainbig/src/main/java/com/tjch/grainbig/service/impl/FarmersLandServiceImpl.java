/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FarmersLandServiceImpl
 * Author:   Administrator
 * Date:     2019/5/13 10:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.service.impl;

import com.tjch.grainbig.dao.FarmersLandUserMapper;
import com.tjch.grainbig.model.*;
import com.tjch.grainbig.pojo.FarmersLand;
import com.tjch.grainbig.service.FarmersLandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
@Service(value="farmersLandService")
@Transactional(readOnly = true)
public class FarmersLandServiceImpl implements FarmersLandService {

    @Autowired
    private FarmersLandUserMapper farmersLandUserMapper;

    @Override
    public List<FarmersLand> selectByKey(String key,Integer pageIndex,Integer pageSize) {
        return farmersLandUserMapper.selecetByKey(key,pageIndex,pageSize);
    }

    @Override
    public DataModel selectBing() {
        DataModel model = new DataModel();
        List<SelectItem> town = farmersLandUserMapper.countByAllTown();
        List<SelectItem> village = farmersLandUserMapper.countByAllVillage();
        List<String> name = farmersLandUserMapper.countName();
            model.setLeft(name);
            model.setTown(town);
            model.setVillage(village);
        return model;
    }

    @Override
    public BarData countByTownArea() {

        BarData barData = new BarData();

        List<SelectItemArea> areas = farmersLandUserMapper.countByTownArea();

        List<String> names  = farmersLandUserMapper.countName();

        if(areas.size()>0&&names.size()>0){
            barData.setBarName(names);
            barData.setData(areas);
        }else{
        }
        return barData;
    }

    @Override
    public BarData areaCountByTown(String key) {
        BarData barData = new BarData();
        List<SelectItemArea> areas  = farmersLandUserMapper.areaCountByTown(key);
        List<String> names = farmersLandUserMapper.countByTownNames(key);
        if(names.size()>0&&areas.size()>0){
            barData.setBarName(names);
            barData.setData(areas);
        }
        return barData;
    }

    @Override
    public ResultListModel selectAll(LandKeyModel model) {
        ResultListModel list = new ResultListModel();
        Integer pageIndex = model.getPageSize()*(model.getPageIndex()-1);
        model.setPageIndex(pageIndex);
        List<FarmersLand> farmers = farmersLandUserMapper.selectAll(model);
        if(farmers.size()>0){
            list.setFarmersLandList(farmers);
            if(model.getPageIndex()!=null&&model.getPageSize()!=null){
                list.setPageIndex(pageIndex);
                list.setPageSize(model.getPageSize());
            }
        }
        return list;
    }
}