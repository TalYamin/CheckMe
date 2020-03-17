package com.checkme.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkme.model.Customer;
import com.checkme.model.Owner;
import com.checkme.repository.OwnerRepository;
import com.checkme.utils.StatusInfo;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private StatusInfo statusInfo;
	

	@Override
	public StatusInfo addOwner(Owner owner) throws Exception {
		
		try {
			
			if (ownerRepository.existsByPhone(owner.getPhone())) {
				throw new Exception("Admin failed to add Owner - phone number already in use");
			}
			
			ownerRepository.save(owner);
			System.out.println("Admin added new owner: " + owner.toString());
			statusInfo.setSuccess(true);
			statusInfo.setMessage("success, Admin added new owner: " + owner.getFirstName() + " " + owner.getLastName());
			return statusInfo;
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			statusInfo.setSuccess(false);
			statusInfo.setMessage(e.getMessage());
			
		}
		
		return statusInfo;
	}

	@Override
	public StatusInfo removeOwner(String phone) throws Exception {
		
		try {
			
			if (!ownerRepository.existsByPhone(phone)) {
				throw new Exception("Owner does not exist in system");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
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
