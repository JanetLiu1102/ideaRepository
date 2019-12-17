/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ResultList
 * Author:   Administrator
 * Date:     2019/7/22 15:56
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
 * @create 2019/7/22
 * @since 1.0.0
 */
public class ResultList extends BaseResultModel{

    List<SelectItemGroup> list;

    public List<SelectItemGroup> getList() {
        return list;
    }

    public void setList(List<SelectItemGroup> list) {
        this.list = list;
    }
}