/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: farmersLandController
 * Author:   Administrator
 * Date:     2019/4/25 15:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.controller;


import com.tjch.grainbig.model.BarData;
import com.tjch.grainbig.model.DataResultModel;
import com.tjch.grainbig.model.ResultListModel;
import com.tjch.grainbig.service.FarmersLandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/4/25
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "farmersLand")
public class FarmersLandController {


    @Autowired
    private FarmersLandService farmersLandService;

    //模糊查询
    @ResponseBody
    @RequestMapping(value = "selectByKey",method = RequestMethod.GET)
    public ResultListModel selectByKey(String key,Integer pageIndex,Integer pageSize){
        ResultListModel model = new ResultListModel();
        model.setFarmersLandList(farmersLandService.selectByKey(key,pageIndex,pageSize));
        return model;
    }

//    饼状图
    @ResponseBody
    @RequestMapping(value = "selectBing",method = RequestMethod.GET)
    public DataResultModel selectBing(){
        DataResultModel model = new DataResultModel();
        model.setData(farmersLandService.selectBing());
        return model;
    }

//    镇面积柱状图
    @RequestMapping(value = "selectBar")
    public BarData selectBar(){
        BarData model = farmersLandService.countByTownArea();
        return model;
    }

// 村面积柱状图

    @ResponseBody
    @RequestMapping(value = "selectBarVill",method = RequestMethod.GET)
    public BarData selectBarVill(String key){
        BarData model = farmersLandService.areaCountByTown(key);
        return model;
    }
//

}