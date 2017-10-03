package com.niit.collaborate.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.collaborate.Model.UserForm;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	
	@Override
	public boolean registerUser(UserForm user) {
		return userDao.registerUser(user);
		
	}

	@Override
	public boolean isUsernameValid(String username) {
		return userDao.isUsernameValid(username);
	}

	@Override
	public boolean isEmailValid(String email) {

		return userDao.isEmailValid(email);
	}

}
