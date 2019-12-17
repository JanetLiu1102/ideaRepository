/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: JdNameResultList
 * Author:   Administrator
 * Date:     2019/7/22 16:32
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
public class JdNameResultList extends BaseResultModel{

    List<String> dataList;

    public List<String> getDataList() {
        return dataList;
    }

    public void setDataList(List<String> dataList) {
        this.dataList = dataList;
    }
}