/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LandKeyModel
 * Author:   Administrator
 * Date:     2019/5/13 11:41
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
 * @create 2019/5/13
 * @since 1.0.0
 */
public class LandKeyModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String zhenid;

    private String key;

    private String cunid;

    private Integer pageIndex;

    private Integer  pageSize;




    public String getZhenid() {
        return zhenid;
    }

    public void setZhenid(String zhenid) {
        this.zhenid = zhenid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCunid() {
        return cunid;
    }

    public void setCunid(String cunid) {
        this.cunid = cunid;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}