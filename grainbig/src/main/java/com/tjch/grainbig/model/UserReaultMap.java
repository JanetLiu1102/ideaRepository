/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserReaultMap
 * Author:   Administrator
 * Date:     2019/7/29 15:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.model;


import com.tjch.grainbig.pojo.County;
import com.tjch.grainbig.pojo.Town;
import com.tjch.grainbig.pojo.Users;
import com.tjch.grainbig.pojo.Village;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/7/29
 * @since 1.0.0
 */
public class UserReaultMap extends Users {

    //乡镇街道
    private Town town;
    //县市区
    private County county;
    //村
    private Village village;

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }
}