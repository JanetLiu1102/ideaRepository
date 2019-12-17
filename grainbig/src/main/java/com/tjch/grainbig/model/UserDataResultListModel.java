/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserDataResultListModel
 * Author:   Administrator
 * Date:     2019/7/16 16:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.model;

import com.tjch.grainbig.pojo.UserData;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/7/16
 * @since 1.0.0
 */
public class UserDataResultListModel extends BaseResultModel{

    private List<UserData> dataList;

    public List<UserData> getDataList() {
        return dataList;
    }

    public void setDataList(List<UserData> dataList) {
        this.dataList = dataList;
    }


}