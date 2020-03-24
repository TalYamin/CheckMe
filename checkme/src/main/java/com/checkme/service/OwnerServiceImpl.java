package com.checkme.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checkme.exception.ModelNotFoundException;
import com.checkme.exception.NameDuplicationException;
import com.checkme.exception.PhoneDuplicationException;
import com.checkme.model.MenuElement;
import com.checkme.model.MenuType;
import com.checkme.model.Owner;
import com.checkme.model.Restaurant;
import com.checkme.repository.MenuElementRepository;
import com.checkme.repository.OwnerRepository;
import com.checkme.repository.RestaurantRepository;
import com.checkme.utils.StatusInfo;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private MenuElementRepository menuElementRepository;

	@Autowired
	private StatusInfo statusInfo;

	private Owner owner;

	public OwnerServiceImpl() {

	}

	public OwnerServiceImpl(Owner owner) {
		this.owner = owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public StatusInfo addRestaurant(Restaurant restaurant) throws Exception {

		try {

			// need to check if getId is null cause it generated value
			if (restaurantRepository.existsByPhone(restaurant.getPhone())) {
				throw new PhoneDuplicationException("Owner failed to add restaurant - this phone is already in use",
						this.owner.getId(), restaurant.getId(), restaurant.getPhone());
			}

			if (restaurantRepository.existsByName(restaurant.getName())) {
				throw new NameDuplicationException("Owner failed to add restaurant - this name is already in use",
						this.owner.getId(), restaurant.getId(), restaurant.getName());
			}

			restaurant.setOwner(this.owner);
			List<Restaurant> restaurants = this.owner.getRestaurants();
			restaurants.add(restaurant);
			this.owner.setRestaurants(restaurants);
			restaurantRepository.save(restaurant);
			ownerRepository.save(this.owner);

			System.out.println("Owner " + this.owner.getName() + " added new Restaurant, restaurantPhone: "
					+ restaurant.getPhone());
			statusInfo.setSuccess(true);
			statusInfo.setMessage("Owner " + this.owner.getName() + " added new Restaurant, restaurantPhone: "
					+ restaurant.getPhone());
			return statusInfo;

		} catch (PhoneDuplicationException e) {
			System.err.println(e.getMessage());
			statusInfo.setSuccess(false);
			statusInfo.setMessage(e.getMessage());
		} catch (NameDuplicationException e) {
			System.err.println(e.getMessage());
			statusInfo.setSuccess(false);
			statusInfo.setMessage(e.getMessage());
		} catch (Exception e) {
			throw new Exception("Owner failed to add restaurant. restaurantPhone: " + restaurant.getPhone());

		}

		return statusInfo;
	}

	@Override
	public StatusInfo removeRestaurant(String phone) throws Exception {

		try {

			if (!restaurantRepository.existsByPhone(phone)) {
				throw new ModelNotFoundException("Restaurant does not exist in system", this.owner.getId(), phone);
			}

			// need to check - did cascade in Restaurant class to getOwner
			restaurantRepository.deleteByPhone(phone);
			this.owner.setRestaurants(restaurantRepository.findAllByOwnerId(this.owner.getId()));

//			couponRepository.deleteById(couponId);
//			List<Coupon> couponsList = couponRepository.findAllByCompanyCompanyId(this.company.getCompanyId());
//			this.company.setCoupons(couponsList);
//			companyRepository.save(this.company);

			System.out.println(
					"Owner " + this.owner.getName() + " removed restaurant successfully. restaurantPhone: " + phone);
			statusInfo.setSuccess(true);
			statusInfo.setMessage(
					"Owner " + this.owner.getName() + " removed restaurant successfully. restaurantPhone: " + phone);
			return statusInfo;

		} catch (ModelNotFoundException e) {
			System.err.println(e.getMessage());
			statusInfo.setSuccess(false);
			statusInfo.setMessage(e.getMessage());
		} catch (Exception e) {
			throw new Exception(
					"Owner " + this.owner.getName() + " failed to remove restaurant. restaurantPhone: " + phone);
		}

		return statusInfo;
	}

	@Override
	public StatusInfo updateRestaurant(String phone, String newName, String newPhone, String newEmail,
			String newMenuLink) throws Exception {
		
		try {
			
			if (!restaurantRepository.existsByPhone(phone)) {
				throw new ModelNotFoundException("Restaurant does not exist in system", this.owner.getId(), phone);
			}
			
			
			Restaurant restaurantToUpdate = restaurantRepository.findByPhone(phone);
			
			if (restaurantRepository.existsByPhone(newPhone)) {
				throw new PhoneDuplicationException("Owner failed to update Restaurant, the newPhone is already in use" , this.owner.getId(), restaurantToUpdate.getId(), newPhone);
			}
			
			
			
		} catch (ModelNotFoundException e) {
			System.err.println(e.getMessage());
			statusInfo.setSuccess(false);
			statusInfo.setMessage(e.getMessage());
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	@Override
	public StatusInfo deactivateRestaurant(String phone) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusInfo deactivateAllRestaurants() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> getAllRestaurants() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant getRestaurant(String phone) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusInfo addMenuElement(long restaurantId, MenuElement menuElement) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusInfo removeMenuElement(long restaurantId, String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusInfo updateMenuElement(long restaurantId, String name, String newName, MenuType newMenuType,
			double newPrice, LocalDate newUpdateDate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusInfo deactivateMenuElement(long restaurantId, String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusInfo deactivateAllMenuElements(long restaurantId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MenuElement> getAllMenuElements(long restaurantId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MenuElement getMenuElement(long restaurantId, String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MenuElement> getAllMenuElementsByType(long restaurantId, MenuType menuType) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MenuElement> getAllMenuElementsByPrice(long restaurantId, double priceTop) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MenuElement> getAllMenuElementsByDate(long restaurantId, String untilDate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MenuElement> getAllMenuElementsByActive(long restaurantId, boolean active) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
