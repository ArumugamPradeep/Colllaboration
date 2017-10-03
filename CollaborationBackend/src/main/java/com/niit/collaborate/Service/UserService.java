package com.niit.collaborate.Service;

import com.niit.collaborate.Model.UserForm;

public interface UserService {

	boolean registerUser(UserForm user);

	boolean isUsernameValid(String username);

	boolean isEmailValid(String email);

}
