package com.tjch.grainbig.service;

import com.tjch.grainbig.model.BarData;
import com.tjch.grainbig.model.DataModel;
import com.tjch.grainbig.model.LandKeyModel;
import com.tjch.grainbig.model.ResultListModel;
import com.tjch.grainbig.pojo.FarmersLand;

import java.util.List;

public interface FarmersLandService {

    List<FarmersLand> selectByKey(String key,Integer pageIndex,Integer pageSize);

    DataModel selectBing();

    BarData countByTownArea();

    BarData areaCountByTown( String key);

    ResultListModel selectAll(LandKeyModel model);

}
