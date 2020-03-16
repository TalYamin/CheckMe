package com.checkme.model;

import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.checkme.utils.DateConverterUtil;

import lombok.NonNull;

@Component
@Entity
public class MenuElement {

	private @NonNull long id;
	private @NonNull String name;
	private @NonNull MenuType menuType;
	private @NonNull int price;
	private @NonNull LocalDate updateDate;
	private @NonNull boolean active;
	
	@Transient
	private String customeDate;
	
	public MenuElement() {
		
	}

	
	public MenuElement(@NonNull String name, @NonNull MenuType menuType, @NonNull int price,
			@NonNull String updateDate) {
		
		setName(name);
		setMenuType(menuType);
		setPrice(price);
		setUpdateDate(DateConverterUtil.convertStringDate(updateDate));
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
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
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


	@Override
	public String toString() {
		
		customeDate = DateConverterUtil.DateStringFormat(this.updateDate);

		
		return "MenuElement [id=" + this.id + ", name=" + this.name + ", menuType=" + this.menuType + ", price=" + this.price
				+ ", updateDate=" + this.customeDate + ", active=" + this.active + " ]";
	}
	
	
	
	
}
