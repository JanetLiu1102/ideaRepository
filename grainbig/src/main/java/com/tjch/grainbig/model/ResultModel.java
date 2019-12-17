/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ResultModel
 * Author:   Administrator
 * Date:     2019/4/25 13:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.model;

import com.tjch.grainbig.pojo.Users;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/4/25
 * @since 1.0.0
 */
public class ResultModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;

    private Users model;

    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Users getModel() {
        return model;
    }

    public void setModel(Users model) {
        this.model = model;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}