package com.checkme.service;

import java.util.List;

import com.checkme.model.Owner;
import com.checkme.utils.StatusInfo;;

public interface AdminService {

	public StatusInfo addOwner(Owner owner) throws Exception;

	public StatusInfo removeOwner(String phone) throws Exception;

	public StatusInfo updateOwner(String phone, String newName, String newPhone,
			String newEmail, String newPassword) throws Exception;

	public List<Owner> getAllOwners() throws Exception;
	
	public Owner getOwner(String phone) throws Exception;
	
//	public StatusInfo addCustomer(Customer customer) throws Exception;
//
//	public StatusInfo removeCustomer(String phone) throws Exception;
//
//	public StatusInfo updateCustomer(String phone, String newFirstName, String newLastName, String newPhone,
//			String newEmail, String newPassword) throws Exception;
//
//	public Set<Customer> getAllCustomers() throws Exception;
//	
//	public Owner getCustomer(String phone) throws Exception;
	
}
