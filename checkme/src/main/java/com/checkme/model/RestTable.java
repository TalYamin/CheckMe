package com.checkme.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

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
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.checkme.utils.DateConverterUtil;

@Component
@Entity
public class RestTable {

	private long id; 
	
	private boolean active;
	
	private LocalDate tableDate;
	
	private Map<Long, Customer> customers = new HashMap<Long, Customer>();
	
	private Restaurant restaurant;
	
	private Map<Long, MenuElement> menuElements = new HashMap<Long, MenuElement>();
	
	@Transient
	private String customDate;
	
	public RestTable() {
		
	}
	
	public RestTable(boolean active, String tableDate, Restaurant restaurant) {
		
		setActive(active);
		setTableDate(DateConverterUtil.convertStringDate(tableDate));
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
	
	@Basic(optional = false)
	@Column(nullable = false)
	public LocalDate getTableDate() {
		return tableDate;
	}

	public void setTableDate(LocalDate tableDate) {
		this.tableDate = tableDate;
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
	public String toString() {
		
		customDate = DateConverterUtil.DateStringFormat(this.tableDate);
		
		return "RestTable [id=" + id + ", active=" + active + ", tableDate=" + customDate + ", restaurant=" + restaurant
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((customDate == null) ? 0 : customDate.hashCode());
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((menuElements == null) ? 0 : menuElements.hashCode());
		result = prime * result + ((restaurant == null) ? 0 : restaurant.hashCode());
		result = prime * result + ((tableDate == null) ? 0 : tableDate.hashCode());
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
		if (customDate == null) {
			if (other.customDate != null)
				return false;
		} else if (!customDate.equals(other.customDate))
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
		if (tableDate == null) {
			if (other.tableDate != null)
				return false;
		} else if (!tableDate.equals(other.tableDate))
			return false;
		return true;
	}

	

	



	

	

	
	
	
	
	
	
	

}
