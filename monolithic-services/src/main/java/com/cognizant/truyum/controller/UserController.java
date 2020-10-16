package com.cognizant.truyum.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.UserAlreadyExistsException;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.serivce.UserService;

@RestController
@RequestMapping("/truyum")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

//	@Autowired
//	InMemoryUserDetailsManager inMemoryUserDetailsManager;

	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	public void signUp(@RequestBody @Valid User user) throws UserAlreadyExistsException {
		LOGGER.info("signUp() --- Starting");
		LOGGER.debug("Sign Up");
		userService.signup(user);
//		if (inMemoryUserDetailsManager.userExists(user.getUserName())) {
//			throw new UserAlreadyExistsException("User already exist");
//		} else {
//			inMemoryUserDetailsManager
//					.createUser(org.springframework.security.core.userdetails.User.withUsername(user.getUserName())
//							.password(passwordEncoder().encode(user.getPassword())).roles("USER").build());
//		}
		LOGGER.info("signUp() --- Ending");
	}

	public PasswordEncoder passwordEncoder() {
		LOGGER.info("passwordEncoder() --- Goes Through");
		return new BCryptPasswordEncoder();
	}
}
