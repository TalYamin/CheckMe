package com.checkme.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checkme.model.RestTable;

@Repository
public interface RestTabelRepository extends JpaRepository<RestTable, Long>{

	public List<RestTable> findAllByRestaurantIdAndActive(long restaurantId, boolean active);
	
	public List<RestTable> findAllByRestaurantIdAndTableDateLessThanEqual(long restaurantId, LocalDate untilDate);
	
	
}
