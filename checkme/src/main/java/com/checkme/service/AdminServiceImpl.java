package com.checkme.service;

import java.util.Set;

import com.checkme.model.Customer;
import com.checkme.model.Owner;
import com.checkme.utils.StatusInfo;

public class AdminServiceImpl implements AdminService{

	@Override
	public StatusInfo addOwner(Owner owner) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusInfo removeOwner(String phone) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusInfo updateOwner(String phone, String newFirstName, String newLastName, String newPhone,
			String newEmail, String newPassword) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Owner> getAllOwners() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Owner getOwner(String phone) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusInfo addCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusInfo removeCustomer(String phone) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusInfo updateCustomer(String phone, String newFirstName, String newLastName, String newPhone,
			String newEmail, String newPassword) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Customer> getAllCustomers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Owner getCustomer(String phone) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
