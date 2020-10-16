package com.cognizant.truyum.serivce;

import com.cognizant.truyum.exception.UserAlreadyExistsException;
import com.cognizant.truyum.model.User;

public interface UserService {

	public User findUser(String name);
	public void signup(User user) throws UserAlreadyExistsException;
}
