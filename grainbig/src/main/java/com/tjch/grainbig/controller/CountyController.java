/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CountyController
 * Author:   Administrator
 * Date:     2019/7/30 10:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.controller;

import com.tjch.grainbig.base.ResponseBase;
import com.tjch.grainbig.service.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/7/30
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "county")
public class CountyController {


    @Autowired
    private CountyService countyService;

    @RequestMapping("/getCounty")
    public ResponseBase getCounty(Integer id,HttpServletRequest request)  {
        return countyService.selectCounty(id);
    }

    @RequestMapping("/getTown")
    public ResponseBase getTown(Integer cid ,Integer id,HttpServletRequest request)  {
        return countyService.selectTownByCid(cid,id);
    }

    @RequestMapping("/getVillage")
    public ResponseBase getVillage(Integer tid ,Integer id,HttpServletRequest request)  {
        return countyService.selectVillageByTid(tid,id);
    }
}