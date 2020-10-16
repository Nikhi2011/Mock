package com.cognizant.menuItem.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.menuItem.dto.CartDTO;
import com.cognizant.menuItem.exception.CartEmptyException;
import com.cognizant.menuItem.model.MenuItem;
import com.cognizant.menuItem.service.CartService;


@RestController
@RequestMapping("/truyum")
public class CartController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);
	long userId = 1;
	@Autowired
	CartService cartService;

	@PostMapping("/cart-items/{user}/{menuItemId}")
	public void addCartItems(@PathVariable String user, @PathVariable int menuItemId) {
		LOGGER.info("addCartItems() --- Starting");
		cartService.addCartItem(user, menuItemId);
		LOGGER.info("addCartItems() --- Ending");
	}
	
	@GetMapping("/cart-items/{user}")
	public CartDTO getAllCartItem(@PathVariable String user) throws CartEmptyException {
		LOGGER.info("getAllCartItem() --- Starting and Ending");
		return cartService.getAllCartItems(user);
	}

	@DeleteMapping("/cart-items/{user}/{menuItemId}")
	public Set<MenuItem> deleteCartItem(@PathVariable String user, @PathVariable int menuItemId) {
		LOGGER.info("deleteCartItem() --- Starting and Ending");
		return cartService.removeCartItem(user, menuItemId);
	}
}
