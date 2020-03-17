package com.checkme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checkme.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	public Restaurant findByPhone(String phone);

	public boolean existsByPhone(String phone);
}
