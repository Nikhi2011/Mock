package com.cognizant.menuItem.service;

import com.cognizant.menuItem.exception.UserAlreadyExistsException;
import com.cognizant.menuItem.model.User;

public interface UserService {

	public User findUser(String name);
	public void signup(User user) throws UserAlreadyExistsException;
}
