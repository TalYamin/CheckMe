package com.checkme.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkme.exception.ClientNotFoundException;
import com.checkme.exception.NoDetailsFoundException;
import com.checkme.exception.PhoneDuplicationException;
import com.checkme.model.Admin;
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
						Admin.getId(), owner.getId(), owner.getPhone());
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
				throw new ClientNotFoundException("Owner does not exist in system", Admin.getId(), phone);
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
	public StatusInfo updateOwner(String phone, String newName, String newPhone, String newEmail, String newPassword)
			throws Exception {

		try {

			if (!ownerRepository.existsByPhone(phone)) {
				throw new ClientNotFoundException("Owner does not exist in system", Admin.getId(), phone);
			}

			Owner ownerToUpdate = ownerRepository.findByPhone(phone);

			if (ownerRepository.existsByPhone(newPhone)) {
				throw new PhoneDuplicationException("Admin failed to update Owner, the newPhone already in use: ",
						Admin.getId(), ownerToUpdate.getId(), newPhone);
			}

			ownerToUpdate.setName(newName);
			ownerToUpdate.setPhone(newPhone);
			ownerToUpdate.setEmail(newEmail);
			ownerToUpdate.setPassword(newPassword);
			ownerRepository.save(ownerToUpdate);
			statusInfo.setSuccess(true);
			statusInfo.setMessage("success, Admin updated owner successfully. ownerPhone: " + phone);
			System.out.println("Admin updated owner successfully. ownerPhone: " + phone);
			return statusInfo;

		} catch (ClientNotFoundException e) {
			System.err.println(e.getMessage());
			statusInfo.setSuccess(false);
			statusInfo.setMessage(e.getMessage());
		} catch (PhoneDuplicationException e) {
			System.err.println(e.getMessage());
			statusInfo.setSuccess(false);
			statusInfo.setMessage(e.getMessage());
		} catch (Exception e) {
			throw new Exception("Admin failed to update owner. ownerPhone: " + phone);
		}

		return statusInfo;
	}

	@Override
	public List<Owner> getAllOwners() throws Exception {

		try {

			List<Owner> owners = ownerRepository.findAll();

			if (owners.isEmpty()) {
				throw new NoDetailsFoundException("Admin failed to get all owners - no details found", Admin.getId(),
						ClientType.ADMIN);
			}

			return owners;

		} catch (NoDetailsFoundException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			throw new Exception("Admin failed to get all owners");
		}

		return null;
	}

	@Override
	public Owner getOwner(String phone) throws Exception {

		try {

			if (!ownerRepository.existsByPhone(phone)) {
				throw new ClientNotFoundException("ownerPhone does not exist in system", Admin.getId(), phone);
			}

			Owner owner = ownerRepository.findByPhone(phone);
			return owner;

		} catch (ClientNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			throw new Exception("Admin failed to get an owner. ownerPhone: " + phone);
		}

		return null;
	}

}
