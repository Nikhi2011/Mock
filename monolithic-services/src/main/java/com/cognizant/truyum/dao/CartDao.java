package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public interface CartDao {
	CartDaoCollectionImpI cartDao = null;

	public void addCartItem(String user, long menuItemId);

	public Cart getAllCartItems(String user) throws CartEmptyException;

	public List<MenuItem> removeCartItem(String user, long menuItemId);

}
