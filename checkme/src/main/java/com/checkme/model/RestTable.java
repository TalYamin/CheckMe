package com.checkme.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;

import org.springframework.stereotype.Component;

@Component
@Entity
public class RestTable {

	private long id; 
	
	private boolean active;
	
	private Map<Long, Customer> customers = new HashMap<Long, Customer>();
	
	private Restaurant restaurant;
	
	private Map<Long, MenuElement> menuElements = new HashMap<Long, MenuElement>();
	
	
	public RestTable() {
		
	}
	
	public RestTable(boolean active, Restaurant restaurant) {
		
		setActive(active);
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
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@ManyToMany(mappedBy = "tables")
	@MapKey(name="id")
	public Map<Long, Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Map<Long, Customer> customers) {
		this.customers = customers;
	}

	@ManyToOne
	public Restaurant getRestaurant() {
		return restaurant;
	}


	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	
	@Override
	public String toString() {
		return "RestTable [id=" + id + ", active=" + active + "]";
	}

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@MapKey(name = "id")
	@JoinTable(name = "Menu_Table", joinColumns = { @JoinColumn(name = "menu_id") }, inverseJoinColumns = {
			@JoinColumn(name = "table_id") })
	public Map<Long, MenuElement> getMenuElements() {
		return menuElements;
	}

	public void setMenuElements(Map<Long, MenuElement> menuElements) {
		this.menuElements = menuElements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((menuElements == null) ? 0 : menuElements.hashCode());
		result = prime * result + ((restaurant == null) ? 0 : restaurant.hashCode());
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
		RestTable other = (RestTable) obj;
		if (active != other.active)
			return false;
		if (customers == null) {
			if (other.customers != null)
				return false;
		} else if (!customers.equals(other.customers))
			return false;
		if (id != other.id)
			return false;
		if (menuElements == null) {
			if (other.menuElements != null)
				return false;
		} else if (!menuElements.equals(other.menuElements))
			return false;
		if (restaurant == null) {
			if (other.restaurant != null)
				return false;
		} else if (!restaurant.equals(other.restaurant))
			return false;
		return true;
	}

	



	

	

	
	
	
	
	
	
	

}
