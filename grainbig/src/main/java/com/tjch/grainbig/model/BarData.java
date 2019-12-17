/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BarData
 * Author:   Administrator
 * Date:     2019/5/13 14:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.model;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/5/13
 * @since 1.0.0
 */
public class BarData extends BaseResultModel{

    private List<String> barName;

    private List<SelectItemArea> data;

    public List<String> getBarName() {
        return barName;
    }

    public void setBarName(List<String> barName) {
        this.barName = barName;
    }

    public List<SelectItemArea> getData() {
        return data;
    }

    public void setData(List<SelectItemArea> data) {
        this.data = data;
    }
}