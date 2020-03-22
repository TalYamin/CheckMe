package com.checkme.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checkme.model.MenuElement;
import com.checkme.model.MenuType;

@Repository
public interface MenuElementRepository extends JpaRepository<MenuElement, Long> {

	public MenuElement findByRestaurantIdAndName(long restaurantId, String name);
	
	public List<MenuElement> findAllByRestaurantIdAndMenuType(long restaurantId, MenuType menuType);
	
	public List<MenuElement> findAllByRestaurantIdAndPriceLessThanEqual(long restaurantId, double priceTop);
	
	public List<MenuElement> findAllByRestaurantIdAndUpdateDateLessThanEqual(long restaurantId, LocalDate untilDate );
	
	public List<MenuElement> findAllByRestaurantIdAndActive (long restaurantId, boolean active);
		
	
}
