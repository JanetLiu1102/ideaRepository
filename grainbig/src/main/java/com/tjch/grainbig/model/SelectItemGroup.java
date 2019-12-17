/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SelectItemGroup
 * Author:   Administrator
 * Date:     2019/7/22 10:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.model;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/7/22
 * @since 1.0.0
 */
public class SelectItemGroup implements Serializable {
    private static final long serialVersionUID = 1L;

    private String jdName;

    private String cunName;

    private Long htmj;

    private Integer nus;

    public String getJdName() {
        return jdName;
    }

    public void setJdName(String jdName) {
        this.jdName = jdName;
    }

    public Long getHtmj() {
        return htmj;
    }

    public void setHtmj(Long htmj) {
        this.htmj = htmj;
    }

    public Integer getNus() {
        return nus;
    }

    public void setNus(Integer nus) {
        this.nus = nus;
    }

    public String getCunName() {
        return cunName;
    }

    public void setCunName(String cunName) {
        this.cunName = cunName;
    }
}