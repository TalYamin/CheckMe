package com.checkme.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;

import org.springframework.stereotype.Component;

@Component
@Entity
public class RestTable {

	private long id; 
	
	private Set<Customer> customers = new HashSet<Customer>();
	
	private Restaurant restaurant;
	
	
	public RestTable() {
		
	}
	
	public RestTable(Set<Customer> customers,Restaurant restaurant) {

		setCustomers(customers);
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


	@ManyToMany(mappedBy = "tables")
	@MapKey(name="id")
	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
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
		return "Table [id=" + id + ", customers=" + customers + ", restaurant=" + restaurant + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		if (customers == null) {
			if (other.customers != null)
				return false;
		} else if (!customers.equals(other.customers))
			return false;
		if (id != other.id)
			return false;
		if (restaurant == null) {
			if (other.restaurant != null)
				return false;
		} else if (!restaurant.equals(other.restaurant))
			return false;
		return true;
	}

	

	
	
	
	
	
	
	

}
