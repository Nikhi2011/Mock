package com.cognizant.menuItem.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.menuItem.model.MenuItem;



@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer>{
	public List<MenuItem> findAllByActiveTrueAndDateOfLaunchBefore(Date date);
	
	@Query(value = "SELECT sum(me_price) FROM menu_item m JOIN cart c WHERE c.ct_me_id = m.me_id  AND c.ct_us_id = ?1", nativeQuery = true)
	double findTotal(int id);

}
