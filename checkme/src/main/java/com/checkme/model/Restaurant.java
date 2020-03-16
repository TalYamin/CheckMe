package com.checkme.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.NonNull;

@Component
@Entity
public class Restaurant {
	
	private @NonNull long id;
	private @NonNull String restName;
	private @NonNull String firstName;
	private @NonNull String lastName;
	private @NonNull int phone;
	private @NonNull String email;
	
	
	public Restaurant() {
		
	}

	
	public Restaurant(@NonNull String restName, @NonNull String firstName, @NonNull String lastName,
			@NonNull int phone	,@NonNull String email) {
		
		setRestName(restName);
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setEmail(email);
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
	public String getRestName() {
		return restName;
	}



	public void setRestName(String restName) {
		this.restName = restName;
	}


	@Basic(optional = false)
	@Column(nullable = false)
	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	@Basic(optional = false)
	@Column(nullable = false)
	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	@Basic(optional = false)
	@Column(nullable = false)
	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	@Basic(optional = false)
	@Column(nullable = false)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Restaurant [id=" + this.id + ", restName=" + this.restName + ", firstName=" + this.firstName + ", lastName=" + this.lastName
				+ ", phone=" + this.phone + ", email=" + this.email + "]";
	}

	

}
