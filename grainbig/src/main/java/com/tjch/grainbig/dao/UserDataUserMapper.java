package com.tjch.grainbig.dao;


import com.tjch.grainbig.model.SelectItem;
import com.tjch.grainbig.model.SelectItemArea;
import com.tjch.grainbig.model.SelectItemGroup;
import com.tjch.grainbig.model.SelectParam;
import com.tjch.grainbig.pojo.UserData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Mapper
@Transactional(readOnly = true)
public interface UserDataUserMapper {

    List<UserData> selectUserDataByKey(SelectParam param);

    Long selectCount(SelectParam param);

    List<SelectItemGroup> selectGroupByJd(@Param(value = "year") String  year);

    List<String> selectJdName(@Param(value = "year") String  year);

    List<SelectItemGroup> selectGroupByCun(String jdName,@Param(value = "year") String  year);

    List selectCunName(String jdName,@Param(value = "year") String  year);

    Integer selectUserDataCount(@Param(value = "cunId") String  cunId, @Param(value = "zhenId") String zhenId, @Param(value = "userCode") String userCode,@Param(value = "year") String  year);

    double selectSCMJ(@Param(value = "cunId") String  cunId,@Param(value = "zhenId") String zhenId,@Param(value = "userCode") String userCode,@Param(value = "year") String  year);

    double selectHTMJ(@Param(value = "cunId") String  cunId,@Param(value = "zhenId") String zhenId,@Param(value = "userCode") String userCode,@Param(value = "year") String  year);


    //根据镇统计
    List<SelectItem> countByAllTown(@Param(value = "year") String  year);
    //镇名集合
    List<String> countName(@Param(value = "year") String  year);
    //根据村统计
    List<SelectItem> countByAllVillage(@Param(value = "year") String  year);

    //某各镇根据村统计
    List<SelectItem> countByVillage(String tId,@Param(value = "year") String  year);

    //某个村统计大户
    List<SelectItem> countByDH(String vId,@Param(value = "year") String  year);

    //镇统计面积
    List<SelectItemArea> countByTownArea(@Param(value = "year") String  year);


    //根据镇id统计村中合同面积
    List<SelectItemArea> areaCountByTown(@Param(value="tId") String tId,@Param(value = "year") String  year);
    //根据村id统计村民合同面积
    List<SelectItemArea> areaCountByVillage(@Param(value="vId") String vId,@Param(value="year") String  year);
    //村名集合
    List<String> countByTownNames(@Param(value="tId") String tId,@Param(value = "year")String  year);



}
