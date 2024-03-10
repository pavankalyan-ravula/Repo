package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.entity.User;
import com.example.repository.UserRepository;

@SpringBootApplication
public class DataBaseStudy1Application {

	public static void main(String[] args) {
//	ApplicationContext context =	
				SpringApplication.run(DataBaseStudy1Application.class, args);
//				
//		UserRepository userRepository=context.getBean(UserRepository.class);
//		User user =new User();
//		user.setName("mani");
//		user.setCity("chi");
//		User user2 =new User();
//		user2.setName("teja");
//		user2.setCity("Bang");
////		
////		//create save and saveAll List of Objects 
////		
////		List<User> listUser = List.of(user2,user);
////		
////		
//////		User returnUser =userRepository.save(user);
//////		System.out.println(returnUser.getId());
////		
////		
////		List<User> newlistUser =userRepository.saveAll(listUser);
////		newlistUser.forEach(e->System.out.println(e.getId()));
////		
////		
//		//update find the data and use save method
//		
//		Optional<User> OptionalUser=userRepository.findById(152l);
////		User newUser=OptionalUser.get();
////		newUser.setStatus("updated");;
////		userRepository.save(newUser);
////		
////		List<User> listOfUser =userRepository.findAll();
////		listOfUser.forEach(System.out::println);
////		
////		
//		
//		
////		List<User> listOfUser =userRepository.findByName("kalyan");
////		listOfUser.forEach(System.out::println);
//		
//		
//		
//		
//		userRepository.getAllUser().forEach(e->System.out.println(e.getId()));
//	
//		
//		//System.out.println(user1.getId());
//		
////		userRepository.getUserByName("pavan").forEach(e->System.out.println(e.getId()));
//
//		
		
	}

}
