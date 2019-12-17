/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SelectItemArea
 * Author:   Administrator
 * Date:     2019/5/13 11:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/5/13
 * @since 1.0.0
 */
public class SelectItemArea implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nname;
//合同面积
    private BigDecimal actualarea;
//实测面积
    private BigDecimal contractarea;
//镇id
    private String vid;



    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }

    public BigDecimal getActualarea() {
        return actualarea;
    }

    public void setActualarea(BigDecimal actualarea) {
        this.actualarea = actualarea;
    }

    public BigDecimal getContractarea() {
        return contractarea;
    }

    public void setContractarea(BigDecimal contractarea) {
        this.contractarea = contractarea;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }
}