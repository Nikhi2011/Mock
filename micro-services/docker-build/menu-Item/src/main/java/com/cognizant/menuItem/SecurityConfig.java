package com.cognizant.menuItem;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.menuItem.security.AppUserDetailsService;
import com.cognizant.menuItem.security.JwtAuthorizationFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	AppUserDetailsService appUserDetailsService;
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		LOGGER.info("configure(AuthenticationManagerBuilder auth) --- Starting and ending");
		auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
//		auth.userDetailsService(inMemoryUserDetailsManager());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("passwordEncoder() --- Starting and ending");
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//		LOGGER.info("inMemoryUserDetailsManager() --- Starting");
//		List<UserDetails> userDetailsList = new ArrayList<>();
//
//		userDetailsList.add(User.withUsername("user").password(passwordEncoder().encode("pwd")).roles("USER").build());
//
//		userDetailsList
//				.add(User.withUsername("admin").password(passwordEncoder().encode("pwd")).roles("ADMIN").build());
//
//		LOGGER.info("inMemoryUserDetailsManager() --- Ending");
//		return new InMemoryUserDetailsManager(userDetailsList);
//	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		LOGGER.info("configure(HttpSecurity httpSecurity) --- Starting");
		httpSecurity.cors();
		httpSecurity.csrf().disable().httpBasic().and().authorizeRequests().antMatchers("/truyum/menu-items")
				.anonymous().antMatchers("/truyum/menu-items").permitAll().antMatchers("/truyum/users").anonymous()
				.anyRequest().authenticated().and().addFilter(new JwtAuthorizationFilter(authenticationManager()));
		LOGGER.info("configure(HttpSecurity httpSecurity) --- Ending");
	}
}
