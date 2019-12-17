/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SelectItem
 * Author:   Administrator
 * Date:     2019/5/10 16:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.model;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/5/10
 * @since 1.0.0
 */
public class SelectItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nname;

    private BigInteger nvalue;

    private String typeid;

    private String jname;

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }

    public BigInteger getNvalue() {
        return nvalue;
    }

    public void setNvalue(BigInteger nvalue) {
        this.nvalue = nvalue;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }
}