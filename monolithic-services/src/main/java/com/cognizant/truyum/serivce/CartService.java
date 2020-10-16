package com.cognizant.truyum.serivce;

import java.util.Set;

import com.cognizant.truyum.dao.CartDaoCollectionImpI;
import com.cognizant.truyum.dto.CartDTO;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public interface CartService {
	CartDaoCollectionImpI cartDao = null;

	public void addCartItem(String username, int menuItemId);

	public CartDTO getAllCartItems(String userId) throws CartEmptyException;

	public Set<MenuItem> removeCartItem(String user, int menuItemId);
}
