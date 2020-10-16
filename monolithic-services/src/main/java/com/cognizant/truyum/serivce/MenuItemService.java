package com.cognizant.truyum.serivce;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemService {
	public List<MenuItem> getMenuItemListAdmin();

	public List<MenuItem> getMenuItemListCustomer();
//
	public MenuItem modifyMenuItem(MenuItem menuItem);
//
	public MenuItem getMenuItem(int menuItemId);
}
