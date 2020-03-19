package com.checkme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.checkme.model.Income;

public interface IncomeRepository extends MongoRepository<Income, Long>{

	
}
