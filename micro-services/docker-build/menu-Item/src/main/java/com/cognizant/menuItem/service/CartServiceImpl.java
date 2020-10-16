package com.cognizant.menuItem.service;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.menuItem.dto.CartDTO;
import com.cognizant.menuItem.exception.CartEmptyException;
import com.cognizant.menuItem.model.MenuItem;
import com.cognizant.menuItem.model.User;
import com.cognizant.menuItem.repository.MenuItemRepository;
import com.cognizant.menuItem.repository.UserRepository;



@Component
@Service
public class CartServiceImpl implements CartService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);
	
//	@Autowired
//	CartDao cartDao;
	
	@Autowired
	MenuItemRepository menuItemRepository;

	@Autowired
	UserRepository userRepository;
	
//	@Override
//	public void addCartItem(String user, long menuItemId) {
//		LOGGER.info("addCartItem() --- Starting");
//		this.cartDao.addCartItem(user, menuItemId);
//		LOGGER.info("addCartItem() --- Ending");
//	}
	
	@Override
	@Transactional
	public void addCartItem(String username, int menuItemId) {
		LOGGER.info("addCartItem() --- Starting");
		//this.cartDao.addCartItem(user, menuItemId);
		
		User user = userRepository.findByUserName(username);
		MenuItem menuItem = menuItemRepository.findById(menuItemId).get();
		Set<MenuItem> menuItemList = user.getMenuItemList();
		menuItemList.add(menuItem);
		user.setMenuItemList(menuItemList);
		userRepository.save(user);
		
		LOGGER.info("addCartItem() --- Ending");
	}

	@Override
	public CartDTO getAllCartItems(String username) throws CartEmptyException {
		LOGGER.info("getAllCartItem() --- Going Through");
		User user = userRepository.findByUserName(username);
		CartDTO cartDto = new CartDTO();
		cartDto.setMenuItemList(user.getMenuItemList());
		if(cartDto.getMenuItemList().isEmpty()) {
			System.out.println("dsajklflkhdskhfdskjhjkdfl");
			throw new CartEmptyException("Cart is Empty");
		}else {
			cartDto.setTotal(menuItemRepository.findTotal(user.getId()));
		}
		return cartDto;
	//	return this.cartDao.getAllCartItems(user);
	}

	@Override
	public Set<MenuItem> removeCartItem(String username, int menuItemId) {
		LOGGER.info("removeCartItem() --- Going Through");
		//return this.cartDao.removeCartItem(user, menuItemId);
		User user = userRepository.findByUserName(username);
		MenuItem menuItem = menuItemRepository.findById(menuItemId).get();
		user.getMenuItemList().remove(menuItem);
		userRepository.save(user);
		return user.getMenuItemList();
	}
}
