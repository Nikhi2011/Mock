package com.cognizant.truyum.dao;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Calendar;

import java.util.Iterator;

import com.cognizant.truyum.model.MenuItem;

@Component
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemDaoCollectionImpl.class);
	List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() {
		ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
		menuItemList = context.getBean("menuItemList", ArrayList.class);
	}

	public List<MenuItem> getMenuItemListAdmin() {
		LOGGER.info(" getMenuItemListAdmin() --- Going through");
		return menuItemList;
	}

	public List<MenuItem> getMenuItemListCustomer() {
		LOGGER.info(" getMenuItemListCustomer() --- Starting");
		List<MenuItem> arl = new ArrayList<MenuItem>();
		Iterator itr = (Iterator) menuItemList.iterator();
		while (itr.hasNext()) {
			MenuItem e = (MenuItem) itr.next();
			Date day = e.getDateOfLaunch();
			Date today = Calendar.getInstance().getTime();
			if ((day.compareTo(today) <= 0) && (e.isActive() == true)) {
				arl.add(e);
			}
		}
		LOGGER.info(" getMenuItemListCustomer() --- Ending");
		return arl;
	}

	public MenuItem modifyMenuItem(MenuItem menuItem) {
		LOGGER.info(" modifyMenuItem() --- Starting");
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItem.getId() == menuItemList.get(i).getId()) {
				menuItemList.set(i, menuItem);
			}
		}
		LOGGER.info(" modifyMenuItem() --- Ending");
		return menuItem;
	}

	public MenuItem getMenuItem(long menuItemId) {
		LOGGER.info(" getMenuItem() --- Starting");
		MenuItem menu = null;
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemId == menuItemList.get(i).getId()) {
				menu = menuItemList.get(i);
			}
		}
		LOGGER.info(" getMenuItem() --- Starting");
		return menu;
	}
}