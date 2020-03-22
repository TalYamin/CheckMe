package com.checkme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checkme.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	
	public Customer findByPhone(String phone);
	
	public boolean existsByPhone(String phone);
	
	public Customer findByPhoneAndPassword(String phone, String password);
	
}
