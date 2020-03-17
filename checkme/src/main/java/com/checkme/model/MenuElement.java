package com.checkme.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.checkme.utils.DateConverterUtil;

@Component
@Entity
public class MenuElement {

	private long id;
	private String name;
	private MenuType menuType;
	private double price;
	private LocalDate updateDate;
	private boolean active;
	private Restaurant restaurant;
	private Map<Long, Customer> customers = new HashMap<Long, Customer>();
	private Map<Long, RestTable> tables = new HashMap<Long, RestTable>();
	
	@Transient
	private String customeDate;

	public MenuElement() {

	}

	public MenuElement(String name, MenuType menuType, double price, String updateDate, Restaurant restaurant) {

		setName(name);
		setMenuType(menuType);
		setPrice(price);
		setUpdateDate(DateConverterUtil.convertStringDate(updateDate));
		setRestaurant(restaurant);
		
	}

	@Id
	@GeneratedValue
	@Basic(optional = false)
	@Column(nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Basic(optional = false)
	@Column(nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic(optional = false)
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	public MenuType getMenuType() {
		return menuType;
	}

	public void setMenuType(MenuType menuType) {
		this.menuType = menuType;
	}

	@Basic(optional = false)
	@Column(nullable = false)
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Basic(optional = false)
	@Column(nullable = false)
	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	@Basic(optional = false)
	@Column(nullable = false)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	@ManyToOne
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	@ManyToMany(mappedBy = "menuElements")
	@MapKey(name="id")
	public Map<Long, Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Map<Long, Customer> customers) {
		this.customers = customers;
	}

	@ManyToMany(mappedBy = "menuElements")
	@MapKey(name="id")
	public Map<Long, RestTable> getTables() {
		return tables;
	}

	public void setTables(Map<Long, RestTable> tables) {
		this.tables = tables;
	}

	@Override
	public String toString() {

		customeDate = DateConverterUtil.DateStringFormat(this.updateDate);

		return "MenuElement [id=" + this.id + ", name=" + this.name + ", menuType=" + this.menuType + ", price="
				+ this.price + ", updateDate=" + this.customeDate + ", active=" + this.active + " ]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((customeDate == null) ? 0 : customeDate.hashCode());
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((menuType == null) ? 0 : menuType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((restaurant == null) ? 0 : restaurant.hashCode());
		result = prime * result + ((tables == null) ? 0 : tables.hashCode());
		result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuElement other = (MenuElement) obj;
		if (active != other.active)
			return false;
		if (customeDate == null) {
			if (other.customeDate != null)
				return false;
		} else if (!customeDate.equals(other.customeDate))
			return false;
		if (customers == null) {
			if (other.customers != null)
				return false;
		} else if (!customers.equals(other.customers))
			return false;
		if (id != other.id)
			return false;
		if (menuType != other.menuType)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (restaurant == null) {
			if (other.restaurant != null)
				return false;
		} else if (!restaurant.equals(other.restaurant))
			return false;
		if (tables == null) {
			if (other.tables != null)
				return false;
		} else if (!tables.equals(other.tables))
			return false;
		if (updateDate == null) {
			if (other.updateDate != null)
				return false;
		} else if (!updateDate.equals(other.updateDate))
			return false;
		return true;
	}

	

	
	


	

	

}
