package com.checkme;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoOperations;

import com.checkme.model.Income;
import com.checkme.model.IncomeType;
import com.checkme.model.Owner;
import com.checkme.model.Restaurant;
import com.checkme.mongoconfig.SequenceGeneratorService;
import com.checkme.repository.IncomeRepository;
import com.checkme.repository.OwnerRepository;
import com.checkme.repository.RestaurantRepository;
import com.checkme.service.AdminService;
import com.checkme.service.AdminServiceImpl;

@SpringBootApplication
@ComponentScan({ "com.checkme" })
public class CheckmeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(CheckmeApplication.class, args);

		try {

			// Repo Test
			// OwnerRepository ownerRepository =
			// applicationContext.getBean(OwnerRepository.class);
//			Owner owner = new Owner("Tal", "0522222222", "talcheck@gmail.com", "TalYam");
			Owner owner2 = new Owner("Peleg", "0522222222", "pelegcheck@gmail.com", "PelegYam");

			AdminService adminService = applicationContext.getBean(AdminServiceImpl.class);
//			adminService.addOwner(owner);
//			adminService.addOwner(owner2);
			
			
			adminService.updateOwner("0522222222", "Peleg", "0522222221", "Peleg@checkpliz.com", "PelegCheck");
			
			

//		ownerRepository.save(owner);
//		ownerRepository.save(owner2);
//		
//		System.out.println("---------------------------------------------");
//		
//		Owner ownerFound = ownerRepository.findByPhone("0524000000");
//		System.out.println(ownerFound);
//		
//		System.out.println("---------------------------------------------");
//		
//		System.out.println(ownerRepository.existsByPhone("0522222222"));
//		
//		Owner ownerByPass = ownerRepository.findByPhoneAndPassword("0524000000", "PelegYam");
//		System.out.println(ownerByPass);

//		RestaurantRepository resRepository = applicationContext.getBean(RestaurantRepository.class);
//		resRepository.save(new Restaurant("Hamesila", "09952745", "hamesila@office.com", true, owner));

			// Mongo test
//		IncomeRepository incomeRepository = applicationContext.getBean(IncomeRepository.class);
//		SequenceGeneratorService sequenceGeneratorService = applicationContext.getBean(SequenceGeneratorService.class);
//		Income income = new Income(owner.getName(), owner.getId(), owner.getPhone(), "19/3/2020", IncomeType.REST_UPDATE_MENU, 100);
			// income.setIncomeId(sequenceGeneratorService.generateSequence(income.SEQUENCE_NAME));;
//		incomeRepository.save(income);
//		System.out.println(incomeRepository.findAll());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
