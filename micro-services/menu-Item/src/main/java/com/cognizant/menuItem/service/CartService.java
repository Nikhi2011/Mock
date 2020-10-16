package com.cognizant.menuItem.service;

import java.util.Set;

import com.cognizant.menuItem.dto.CartDTO;
import com.cognizant.menuItem.exception.CartEmptyException;
import com.cognizant.menuItem.model.MenuItem;



public interface CartService {

	public void addCartItem(String username, int menuItemId);

	public CartDTO getAllCartItems(String userId) throws CartEmptyException;

	public Set<MenuItem> removeCartItem(String user, int menuItemId);
}
