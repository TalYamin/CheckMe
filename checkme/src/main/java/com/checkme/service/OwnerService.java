package com.checkme.service;

import java.time.LocalDate;
import java.util.List;

import com.checkme.model.MenuElement;
import com.checkme.model.MenuType;
import com.checkme.model.Restaurant;
import com.checkme.utils.StatusInfo;

public interface OwnerService {
	
	public StatusInfo addRestaurant(Restaurant restaurant) throws Exception;

	public StatusInfo removeRestaurant(String phone) throws Exception;
	
	public StatusInfo updateRestaurant(String phone, String newName, String newPhone, String newEmail, String newMenuLink) throws Exception;
	
	public StatusInfo deactivateRestaurant(String phone) throws Exception;
	
	public StatusInfo deactivateAllRestaurants() throws Exception;
	
	public List<Restaurant> getAllRestaurants() throws Exception;
	
	public Restaurant getRestaurant(String phone) throws Exception; 
	
	public StatusInfo addMenuElement(MenuElement menuElement) throws Exception;
	
	public StatusInfo removeMenuElement(String name) throws Exception;
	
	public StatusInfo updateMenuElement(String name, String newName, MenuType newMenuType, double newPrice, LocalDate newUpdateDate) throws Exception;
	
	public StatusInfo deactivateMenuElement(String name) throws Exception;
	
	public StatusInfo deactivateAllMenuElements() throws Exception;

	public List<MenuElement> getAllMenuElements() throws Exception;
	
	public MenuElement getMenuElement(String name) throws Exception;
	
	public List<MenuElement> getAllMenuElementsByType(MenuType menuType) throws Exception;

	public List<MenuElement> getAllMenuElementsByPrice(double priceTop) throws Exception;

	public List<MenuElement> getAllMenuElementsByDate(String untilDate) throws Exception;

	public List<MenuElement> getAllMenuElementsByActive(boolean active) throws Exception;
	
	
	
	
}
