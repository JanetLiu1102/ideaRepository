package com.tjch.token_demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.tjch.token_demo.base.ResponseBase;
import com.tjch.token_demo.entity.dto.TokenInfo;
import com.tjch.token_demo.entity.dto.UserDto;
import com.tjch.token_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
public class UserController {


	@RequestMapping("/login")
	public ResponseBase UserLogin(@RequestBody @Valid UserDto userDto, HttpServletRequest request) {
		return userService.UserLogin(userDto.getUserName(), userDto.getPassword());
	}
	
	/**
	 * 查看用户的基本信息
	 * @param username
	 * @return
	 */
	@RequestMapping("/getUserInfo")
	public ResponseBase getUserInfo(String  username) {
		return userService.getUserInfo(username);
	}
	
	@Autowired
	private UserService userService;
}
