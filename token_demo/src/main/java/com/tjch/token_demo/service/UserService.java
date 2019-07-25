package com.tjch.token_demo.service;


import com.tjch.token_demo.base.ResponseBase;

public interface UserService {

	/**
	 * 用户登录
	 * @param username
	 * @param passwrod
	 * @return
	 */
	public ResponseBase UserLogin(String username, String passwrod);
	
	/**
	 * 获取用户基本信息
	 * @param  username
	 * @return
	 */
	public ResponseBase getUserInfo(String username);
}
