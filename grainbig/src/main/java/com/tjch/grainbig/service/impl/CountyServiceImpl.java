/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CountyServiceImpl
 * Author:   Administrator
 * Date:     2019/7/30 10:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.service.impl;

import com.tjch.grainbig.base.ResponseBase;
import com.tjch.grainbig.dao.CountyUserMapper;
import com.tjch.grainbig.pojo.County;
import com.tjch.grainbig.pojo.Town;
import com.tjch.grainbig.pojo.Village;
import com.tjch.grainbig.service.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
@Service(value = "countyService")
@Transactional(readOnly = true)
public class CountyServiceImpl  implements CountyService {

    @Autowired
    private CountyUserMapper countyUserMapper;
/*
区列表
 */
    @Override
    public ResponseBase selectCounty(Integer id) {
        ResponseBase res = new ResponseBase();
        List<County> list = countyUserMapper.selectCounty(id);
        if(list!=null&&list.size()>0){
            res.setCode(200);
            res.setMsg("查询成功");
            res.setData(list);
        }else {
            res.setCode(200);
            res.setMsg("查询成功");
        }
        return res;
    }
/*
镇列表（区id）
 */
    @Override
    public ResponseBase selectTownByCid(Integer cid,Integer id) {
        ResponseBase res = new ResponseBase();
        List<Town> list = countyUserMapper.selectTownByCid(cid,id);
        if(list!=null&&list.size()>0){
            res.setCode(200);
            res.setMsg("查询成功");
            res.setData(list);
        }else {
            res.setCode(200);
            res.setMsg("查询成功");
        }
        return res;
    }
/*
村列表（镇id）
 */
    @Override
    public ResponseBase selectVillageByTid(Integer tid,Integer id) {
        ResponseBase res = new ResponseBase();
        List<Village> list = countyUserMapper.selectVillageByTid(tid,id);
        if(list!=null&&list.size()>0){
            res.setCode(200);
            res.setMsg("查询成功");
            res.setData(list);
        }else {
            res.setCode(200);
            res.setMsg("查询成功");
        }
        return res;
    }
}