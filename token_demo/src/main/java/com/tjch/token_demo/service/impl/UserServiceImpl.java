package com.tjch.token_demo.service.impl;

import java.util.Map;
import java.util.UUID;

import com.tjch.token_demo.base.BaseApiService;
import com.tjch.token_demo.base.ResponseBase;
import com.tjch.token_demo.dao.UserInfoMapper;
import com.tjch.token_demo.entity.dto.TokenInfo;
import com.tjch.token_demo.entity.dto.UserModel;
import com.tjch.token_demo.pojo.Users;
import com.tjch.token_demo.service.UserService;
import com.tjch.token_demo.utils.ProductToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends BaseApiService implements UserService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private ProductToken productToken;

	@Override
	public ResponseBase UserLogin(String username, String password) {
		//1.校验登陆是否成功
		Users user = userInfoMapper.getUserInfo(username);
		//2.如果不成功返回提示
		if (user == null ) {
			return setResultError("用户名密码错误");
		}else if(!user.getUserPassword().equals(password)){
			return setResultError("用户名密码错误");
		}else {
			//3.如果成功，生产一个token
			String token = UUID.randomUUID().toString().replaceAll("-", "");
			Map<String, String> mapInfo = productToken.productToken( user.getName(),token);
			//3.返回token信息（有效期50分钟）
			TokenInfo info = new TokenInfo();
			info.setUsername(user.getName());
			info.setToken(token);
			info.setRealname(user.getRealName());
			return setResultSuccess((Object)info);
		}
	}

	@Override
	public ResponseBase getUserInfo(String userName) {
		Users user = userInfoMapper.getUserInfo(userName);
		if(user != null) {
			UserModel info = new UserModel();
			info.setUsername(user.getName());
			info.setRealName(user.getRealName());
			return setResultSuccess((Object)info);
		} else {
			return setResultSuccess("无此用户");
		}
	}
	

	
}
