package com.cognizant.authentication.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/truyum")
public class AuthenticateController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticateController.class);

	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		LOGGER.info("authenticate() --- Starting");
		Map<String, String> data = new HashMap<>();
		data.put("token", generateJwt(getUser(authHeader)));
		String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
		data.put("role", role);
		data.put("user", getUser(authHeader));
		LOGGER.info("authenticate() --- Ending");
		return data;
	}

	private String getUser(String authHeader) {
		LOGGER.info("getUser() --- Starting");
		String encodedCredentials = authHeader.split(" ")[1];
		String decodedCredentials = new String(Base64.getDecoder().decode(encodedCredentials));
		LOGGER.info("getUser() --- Ending");
		return decodedCredentials.split(":")[0];
	}

	private String generateJwt(String user) {
		LOGGER.info("generateJwt() --- Starting");
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);

		// Set the token issue time as current time
		builder.setIssuedAt(new Date());

		// Set the token expiry as 20 minutes from now
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");

		String token = builder.compact();
		LOGGER.info("generateJwt() --- Ending");
		return token;
	}
}
