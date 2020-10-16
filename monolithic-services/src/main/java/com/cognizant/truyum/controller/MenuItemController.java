package com.cognizant.truyum.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.serivce.MenuItemService;

@RestController
@RequestMapping("/truyum")
public class MenuItemController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
	@Autowired
	MenuItemService menuItemService;

//	@Autowired
//	InMemoryUserDetailsManager inMemoryUserDetailsManager;
	
	@Autowired
	UserDetailsService userDetailsService; 

	@GetMapping("/menu-items")
	public List<MenuItem> getMenuItems() {
		LOGGER.info("getMenuItems() --- Goes Through");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		if (user.equals("anonymousUser")) {
			return menuItemService.getMenuItemListCustomer();
		} else {
			UserDetails userDetails = userDetailsService.loadUserByUsername(user);
			String role = userDetails.getAuthorities().toArray()[0].toString();
			if (role.equals("ADMIN")) {
				return menuItemService.getMenuItemListAdmin();
			} else {
				return menuItemService.getMenuItemListCustomer();
			}
		}
	}

	@GetMapping("/menu-items/{id}")
	public MenuItem getMenuItem(@PathVariable int id) {
		LOGGER.info("getMenuItems(id) --- Goes Through");
		return this.menuItemService.getMenuItem(id);
	}

	@PutMapping("/menu-items")
	public MenuItem updateMenuItem(@RequestBody @Valid MenuItem menuItem) {
		LOGGER.info("updateMenuItems(id) --- Goes Through");
		return this.menuItemService.modifyMenuItem(menuItem);
	}
}
