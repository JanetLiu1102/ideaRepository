/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ResultListModel
 * Author:   Administrator
 * Date:     2019/4/25 15:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.model;


import com.tjch.grainbig.pojo.FarmersLand;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/4/25
 * @since 1.0.0
 */
public class ResultListModel extends BaseResultModel{

    private List<FarmersLand> farmersLandList;


    public List<FarmersLand> getFarmersLandList() {
        return farmersLandList;
    }

    public void setFarmersLandList(List<FarmersLand> farmersLandList) {
        this.farmersLandList = farmersLandList;
    }

}