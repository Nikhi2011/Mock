package com.cognizant.authentication.service;

import com.cognizant.authentication.exception.UserAlreadyExistsException;
import com.cognizant.authentication.model.User;

public interface UserService {

	public User findUser(String name);
	public void signup(User user) throws UserAlreadyExistsException;
}
