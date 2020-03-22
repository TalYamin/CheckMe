package com.checkme.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkme.exception.ClientNotFoundException;
import com.checkme.exception.PhoneDuplicationException;
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
				throw new PhoneDuplicationException("Admin failed to add Owner - phone number already in use: ",
						owner.getPhone());
			}

			ownerRepository.save(owner);
			System.out.println("Admin added new owner: " + owner.toString());
			statusInfo.setSuccess(true);
			statusInfo.setMessage("success, Admin added new owner: " + owner.getName());
			return statusInfo;

		} catch (PhoneDuplicationException e) {
			System.err.println(e.getMessage());
			statusInfo.setSuccess(false);
			statusInfo.setMessage(e.getMessage());
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Admin failed to add owner. ownerPhone: " + owner.getPhone());
		}

		return statusInfo;
	}

	@Override
	public StatusInfo removeOwner(String phone) throws Exception {

		try {

			if (!ownerRepository.existsByPhone(phone)) {
				throw new ClientNotFoundException("Owner does not exist in system", phone);
			}

			ownerRepository.deleteByPhone(phone);
			statusInfo.setSuccess(true);
			statusInfo.setMessage("success, Admin removed owner successfully. ownerPhone: " + phone);
			System.out.println("Admin removed owner successfully. ownerPhone: " + phone);
			return statusInfo;

		} catch (ClientNotFoundException e) {
			System.err.println(e.getMessage());
			statusInfo.setSuccess(false);
			statusInfo.setMessage(e.getMessage());
		} catch (Exception e) {
			throw new Exception("Admin failed to remove owner. ownerPhone: " + phone);

		}

		return statusInfo;
	}

	@Override
	public StatusInfo updateOwner(String phone, String newFirstName, String newLastName, String newPhone,
			String newEmail, String newPassword) throws Exception {

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

}
