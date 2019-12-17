package com.tjch.grainbig.service;

import com.tjch.grainbig.base.ResponseBase;
import com.tjch.grainbig.model.*;
import com.tjch.grainbig.pojo.UserData;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserDataService {

    List<UserData> selectByKey(SelectParam param);

    Long selectCount(SelectParam param);

    List<SelectItemGroup> selectGroupByJd(String year);

    List selectJdName(String year);

    List<SelectItemGroup> selectGroupByCun(String jdName,String year);


    ResponseBase selectUserDataCount(String  username);

    ResponseBase selectSCMJ(String  username);

    ResponseBase selectHTMJ(String  username);

    XSSFWorkbook exportTable(SelectParam param,HttpServletRequest request) throws Exception;

    DataModel selectBing(String year);
    //区级统计镇的合同面积和实测面积
    ResponseBase countByTownArea(String year);
    //镇级统计合同面积和实测面积
    ResponseBase areaCountByTown( String tId,String year);
//村级统计用户的合同面积和实测面积
    ResponseBase areaCountByVillage( String vId,String year);

    ResponseBase selCunBing(String vid,String year);

    ResponseBase selZhenBing(String tid,String year);

}
