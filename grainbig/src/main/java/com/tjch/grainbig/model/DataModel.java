/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DataModel
 * Author:   Administrator
 * Date:     2019/5/10 16:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.model;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/5/10
 * @since 1.0.0
 */
public class DataModel  implements Serializable {
    private static final long serialVersionUID = 1L;
    //镇名
    List<String> left;
    //镇数据
    List<SelectItem> town;
//村数据
    List<SelectItem> village;

    public List<String> getLeft() {
        return left;
    }

    public void setLeft(List<String> left) {
        this.left = left;
    }

    public List<SelectItem> getTown() {
        return town;
    }

    public void setTown(List<SelectItem> town) {
        this.town = town;
    }

    public List<SelectItem> getVillage() {
        return village;
    }

    public void setVillage(List<SelectItem> village) {
        this.village = village;
    }
}