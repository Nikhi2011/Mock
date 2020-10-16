package com.cognizant.authentication.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.authentication.exception.UserAlreadyExistsException;
import com.cognizant.authentication.model.Role;
import com.cognizant.authentication.model.User;
import com.cognizant.authentication.repository.UserRepository;




@Service
public class UserServiceImpl implements UserService{
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder bCryptPasswordEncoder;
	
	@Override
	@Transactional
	public User findUser(String name) {
		LOGGER.info("findUser() --- Going Through");
		return userRepository.findByUserName(name);
	}
	@Override
	@Transactional
	public void signup(User user) throws UserAlreadyExistsException {
		LOGGER.info("signup() --- Going Through");
		if(userRepository.findByUserName(user.getUserName()) == null) {
			User newUser = new User();
			newUser.setUserName(user.getUserName());
			newUser.setFirstName(user.getFirstName());
			newUser.setLastName(user.getLastName());
			newUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			Set<Role> roleList = new HashSet<Role>();
			Role role = new Role();
			role.setId(2);
			role.setRole("USER");
			roleList.add(role);
			newUser.setRoleList(roleList);
			userRepository.save(newUser);
		} else {
			throw new UserAlreadyExistsException("User already Exist");
		}
	}
}
