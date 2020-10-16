package com.cognizant.menuItem.dto;

import java.util.Set;

import com.cognizant.menuItem.model.MenuItem;



public class CartDTO {
	private Set<MenuItem> menuItemList;
	private double total;

	public CartDTO() {	
	}
	
	public CartDTO(Set<MenuItem> menuItemList, double total) {
		super();
		this.menuItemList = menuItemList;
		this.total = total;
	}

	public Set<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(Set<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
