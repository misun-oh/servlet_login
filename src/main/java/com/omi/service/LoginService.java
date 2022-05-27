package com.omi.service;

import com.omi.dao.UserDao;
import com.omi.dto.UserDto;

public class LoginService {
	private UserDao dao;
	
	public UserDto login(UserDto user) {
		user = dao.login(user);
		
		return user;
		
	}
}
