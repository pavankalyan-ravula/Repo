package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/getUserByName/{userName}")
	public ResponseEntity<List<User>> getUserByName(@PathVariable(name ="userName",required =true) String UserName){
		
		List<User> responseList=null;
		try {
			responseList=userService.getUserByName(UserName);
			return new ResponseEntity<>(responseList,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(responseList,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(name ="id",required =true) Long id){
		
		Optional<User> response=null;
		User result=null;
		try {
			response=userService.getUserById(id);
			 result= response.get();
			return new ResponseEntity<>(result,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(result,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getUsers(){
		
		List<User> responseList=null;
		try {
			responseList=userService.getUsers();
			if(responseList.isEmpty())
				return new ResponseEntity<>(responseList,HttpStatus.NO_CONTENT);
			return new ResponseEntity<>(responseList,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(responseList,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User updatedUser = userService.updateUser(user);
		if (updatedUser==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(updatedUser,HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<User>> deleteById(@PathVariable("id")Long id)
	{
		List<User> responce = userService.deleteById(id);
		if (responce ==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return  new ResponseEntity<>(responce,HttpStatus.OK);
	}	
	@PostMapping
	public ResponseEntity<List<User>> addUsers(@RequestBody List<User> users){
		List<User> response =null;
		try {
		response =userService.addUsers(users);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
