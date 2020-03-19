package com.checkme.model;

public enum IncomeType {
	
	CUSTOMER_CHECK("customerCheck"), REST_NEW_MENU("restaurantNewMenu"), REST_UPDATE_MENU(
			"restaurantUpdateMenu");

	private String description;

	private IncomeType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
