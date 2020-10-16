package com.cognizant.menuItem.service;

import java.util.List;

import com.cognizant.menuItem.model.MenuItem;

public interface MenuItemService {
	public List<MenuItem> getMenuItemListAdmin();

	public List<MenuItem> getMenuItemListCustomer();
//
	public MenuItem modifyMenuItem(MenuItem menuItem);
//
	public MenuItem getMenuItem(int menuItemId);
}
