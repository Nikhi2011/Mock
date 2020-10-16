package com.cognizant.truyum.serivce;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

@Component
public class MenuItemServiceImpl implements MenuItemService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemServiceImpl.class);
//	@Autowired
//	MenuItemDao menuItemdao;
	
	@Autowired
	MenuItemRepository menuItemRepository;

//	public List<MenuItem> getMenuItemListCustomer() {
//		LOGGER.info("getMenuItemListCustomer() --- Going Through");
//		return this.menuItemdao.getMenuItemListCustomer();
//	}
	
	@Transactional
	public List<MenuItem> getMenuItemListCustomer() {
		LOGGER.info("getMenuItemListCustomer() --- Going Through");
		return this.menuItemRepository.findAllByActiveTrueAndDateOfLaunchBefore(new Date());
	}

//	public List<MenuItem> getMenuItemListAdmin() {
//		LOGGER.info("getMenuItemListAdmin() --- Going Through");
//		return this.menuItemdao.getMenuItemListAdmin();
//	}
	
	@Transactional
	public List<MenuItem> getMenuItemListAdmin() {
		LOGGER.info("getMenuItemListAdmin() --- Going Through");
		return this.menuItemRepository.findAll();
	}
	
//	@Override
//	public MenuItem modifyMenuItem(MenuItem menuItem) {
//		LOGGER.info("modifyMenuItem() --- Going Through");
//		return this.menuItemdao.modifyMenuItem(menuItem);
//
//	}
	
	@Transactional
	public MenuItem modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("modifyMenuItem() --- Going Through");
		return this.menuItemRepository.save(menuItem);

	}
//
//	@Override
//	public MenuItem getMenuItem(long menuItemId) {
//		LOGGER.info("getMenuItem() --- Going Through");
//		return this.menuItemdao.getMenuItem(menuItemId);
//	}
	
	@Transactional
	public MenuItem getMenuItem(int menuItemId) {
		LOGGER.info("getMenuItem() --- Going Through");
		return this.menuItemRepository.findById(menuItemId).get();
	}
}
