/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DataResultModel
 * Author:   Administrator
 * Date:     2019/5/13 9:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.model;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/5/13
 * @since 1.0.0
 */
public class DataResultModel extends BaseResultModel{

    private DataModel data;

    public DataModel getData() {
        return data;
    }

    public void setData(DataModel data) {
        this.data = data;
    }
}