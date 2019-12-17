package com.tjch.grainbig.service;

import com.tjch.grainbig.base.ResponseBase;

public interface CountyService {

    ResponseBase selectCounty(Integer id);

    ResponseBase selectTownByCid(Integer cid,Integer id);

    ResponseBase selectVillageByTid(Integer tid,Integer id);

}
