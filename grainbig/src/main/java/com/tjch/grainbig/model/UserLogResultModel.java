/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserLogResultModel
 * Author:   Administrator
 * Date:     2019/8/27 14:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.model;

import com.tjch.grainbig.pojo.UserLog;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/8/27
 * @since 1.0.0
 */
public class UserLogResultModel extends BaseResultModel{

    List<UserLog> list;

    public List<UserLog> getList() {
        return list;
    }

    public void setList(List<UserLog> list) {
        this.list = list;
    }
}