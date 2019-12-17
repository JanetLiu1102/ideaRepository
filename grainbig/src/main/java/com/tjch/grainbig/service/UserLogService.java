package com.tjch.grainbig.service;

import com.tjch.grainbig.base.ResponseBase;


public interface UserLogService {
    ResponseBase selectAll(Integer pageIndex, Integer pageSize);
}
