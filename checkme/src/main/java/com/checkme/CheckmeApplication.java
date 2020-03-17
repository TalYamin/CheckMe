package com.checkme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.checkme.model.Owner;
import com.checkme.model.Restaurant;
import com.checkme.repository.OwnerRepository;
import com.checkme.repository.RestaurantRepository;

@SpringBootApplication
@ComponentScan({ "com.checkme" })
public class CheckmeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(CheckmeApplication.class,
				args);
		
		OwnerRepository ownerRepository = applicationContext.getBean(OwnerRepository.class);
		Owner owner = new Owner("Tal", "0522222222222", "talcheck@gmail.com", "TalYam");
		ownerRepository.save(owner);
		RestaurantRepository resRepository = applicationContext.getBean(RestaurantRepository.class);
		resRepository.save(new Restaurant("Hamesila", "09952745", "hamesila@office.com", true, owner));
		
	} 

}
