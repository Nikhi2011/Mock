package com.cognizant.menuItem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.menuItem.model.User;
import com.cognizant.menuItem.repository.UserRepository;


@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		UserDetails appUser = null;
		appUser = new AppUser(user);
		return appUser;
	}

}
