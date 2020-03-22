package com.checkme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checkme.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

	public Owner findByPhone (String phone);
	
	public boolean existsByPhone(String phone);
	
	public Owner findByPhoneAndPassword(String phone, String password);
	
	public void deleteByPhone(String phone);
	
}
