package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Component
public class CartDaoCollectionImpI implements CartDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(CartDaoCollectionImpI.class);
	static HashMap<String, Cart> userCarts = null;

	public static HashMap<String, Cart> getUserCarts() {
		LOGGER.info(" getUserCarts() --- Going through");
		return userCarts;
	}

	public static void setUserCarts(HashMap<String, Cart> userCarts) {
		LOGGER.info(" setUserCarts() --- Starting");
		CartDaoCollectionImpI.userCarts = userCarts;
		LOGGER.info(" setUserCarts() --- Ending");
	}

	public CartDaoCollectionImpI() {
		if (userCarts == null) {
			userCarts = new HashMap<String, Cart>();
		}
	}

	public void addCartItem(String user, long menuItemId) {
		LOGGER.info(" addCartItem() --- Starting");
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		if (!userCarts.containsKey(user)) {
			List<MenuItem> menuItemList = new ArrayList<MenuItem>();
			userCarts.put(user, new Cart(menuItemList, 0.0));
		}

		Cart cartItems = userCarts.get(user);
		cartItems.getMenuItemList().add(menuItem);
		LOGGER.info(" addCartItem() --- Ending");
	}

	public Cart getAllCartItems(String user) throws CartEmptyException {
		LOGGER.info(" getAllCartItems() --- Starting");
		double total = 0;
		List<MenuItem> menuItemList = null;
		if (userCarts.containsKey(user)) {
			Cart cartItems = userCarts.get(user);
			menuItemList = cartItems.getMenuItemList();

			if (menuItemList.isEmpty()) {
				throw new CartEmptyException("Cart is Empty");

			} else {
				for (MenuItem i : menuItemList) {
					total = total + i.getPrice();
				}
				cartItems.setTotal(total);
			}
		} else {
			throw new CartEmptyException("Cart is Empty");
		}
		Cart cart = new Cart(menuItemList, total);
		LOGGER.info("getAllCartItems() --- Ending");
		return cart;
	}

	public List<MenuItem> removeCartItem(String user, long menuItemId) {
		LOGGER.info("removeCartItem() --- Starting");
		List<MenuItem> menuItemList = null;
		Cart cartItems = userCarts.get(user);
		menuItemList = cartItems.getMenuItemList();
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemId == menuItemList.get(i).getId()) {
				menuItemList.remove(i);
				break;
			}
		}
		LOGGER.info("removeCartItem() --- Ending");
		return menuItemList;
	}
}
