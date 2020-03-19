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

		IncomeRepository incomeRepository = applicationContext.getBean(IncomeRepository.class);
		SequenceGeneratorService sequenceGeneratorService = applicationContext.getBean(SequenceGeneratorService.class);
		Income income = new Income(owner.getName(), owner.getId(), owner.getPhone(), "19/3/2020", IncomeType.REST_UPDATE_MENU, 100);
		//income.setIncomeId(sequenceGeneratorService.generateSequence(income.SEQUENCE_NAME));;
		incomeRepository.save(income);
//		System.out.println(incomeRepository.findAll());
	

	} 

}
