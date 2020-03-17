package com.checkme.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checkme.model.MenuElement;
import com.checkme.model.MenuType;

@Repository
public interface MenuElementRepository extends JpaRepository<MenuElement, Long> {

	
	
	public Set<MenuElement> findAllByMenuTypeAndRestaurantId(MenuType menuType, long restaurantId);
	
	public boolean existsByNameAndRestaurantId(String name, long restaurantId);
	
	
}
