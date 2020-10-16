package com.cognizant.truyum;

import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cognizant.truyum.exception.UserAlreadyExistsException;
import com.cognizant.truyum.model.Role;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.repository.UserRepository;
import com.cognizant.truyum.serivce.UserService;

@SpringBootTest
public class truyumApplicationTests {

	@MockBean
	UserRepository userRepository;
	
	@Autowired
	UserService userService;

	@Test
	public void testSignupTestForNewUser() throws UserAlreadyExistsException {
		User user = createUserWithoutRole();
		when(userRepository.findByUserName("user")).thenReturn(null);
		when(userRepository.save(user)).thenReturn(createUserWithRole());
		userService.signup(user);
		Assertions.assertEquals("USER", createUserWithRole().getRoleList().iterator().next().getRole());		
	}
	
	@Test
	public void testSignupTestForNewUserException() {
		User user = createUserWithoutRole();
		when(userRepository.findByUserName("user")).thenReturn(user);
		Assertions.assertThrows(UserAlreadyExistsException.class, () -> {
			userService.signup(user);
		});		
	}
	
	
	public User createUserWithRole() {
		User user = new User();
		user.setId(1);
		user.setPassword("$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK");
		user.setUserName("user");
		user.setFirstName("userTest");
		user.setLastName("userTest");
		Role role = new Role();
		role.setId(1);
		role.setRole("USER");
		Set<Role> roleList = new HashSet<Role>();
		roleList.add(role);
		user.setRoleList(roleList);
		return user;
	}

	public User createUserWithoutRole() {
		User user = new User();
		user.setId(1);
		user.setPassword("$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK");
		user.setUserName("user");
		user.setFirstName("userTest");
		user.setLastName("userTest");
		return user;
	}
}
