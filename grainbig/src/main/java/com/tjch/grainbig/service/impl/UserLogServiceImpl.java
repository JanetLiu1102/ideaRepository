/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserLogServiceImpl
 * Author:   Administrator
 * Date:     2019/8/27 9:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.tjch.grainbig.service.impl;

import com.tjch.grainbig.base.BaseApiService;
import com.tjch.grainbig.base.ResponseBase;
import com.tjch.grainbig.dao.UserLogUserMapper;
import com.tjch.grainbig.model.UserLogResultModel;
import com.tjch.grainbig.pojo.UserLog;
import com.tjch.grainbig.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/8/27
 * @since 1.0.0
 */
@Service(value="userLogService")
@Transactional
public class UserLogServiceImpl  extends BaseApiService implements UserLogService {

    @Autowired
    private UserLogUserMapper userLogUserMapper;

    @Override
    public ResponseBase selectAll(Integer pageIndex, Integer pageSize) {
        ResponseBase res = new ResponseBase();
        List<UserLog> list = userLogUserMapper.selectAll(pageIndex,pageSize);
        Long total = userLogUserMapper.selectAllCount();
        UserLogResultModel model = new UserLogResultModel();
        model.setPageIndex(pageIndex);
        model.setPageSize(pageSize);
        model.setList(list);
        model.setTotal(total);
        res.setCode(200);
        res.setMsg("查询成功");
        res.setData(model);
        return res;
    }
}