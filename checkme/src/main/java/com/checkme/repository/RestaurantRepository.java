package com.checkme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checkme.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	public Restaurant findByPhone(String phone);

	public boolean existsByPhone(String phone);
	
	public boolean existsByName(String name);
	
	public void deleteByPhone(String phone);
	
	public List<Restaurant> findAllByOwnerId(long ownerId);
	
	public List<Restaurant> findAllByActiveTrue();
	
	public List<Restaurant> findAllByActiveFalse();
	
	public List<Restaurant> findAllByOwnerIdAndActive(long ownerId, boolean active);

	
}
