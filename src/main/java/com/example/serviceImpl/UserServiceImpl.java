package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;
	private List<User> users;

	@Override
	public List<User> getUserByName(String userName) {
		//kalyan 
		return userRepository.findBynameLike("%"+userName+"%");
		
	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
		//return userRepository.findAllByNameIsNotNull();
	}

	@Override
	public User updateUser(User user) {
		Optional<User> optUser=userRepository.findById(user.getId());
		if(optUser.isPresent()) {
			User  oldUser=optUser.get();
			 oldUser.setStatus(user.getStatus());
			return userRepository.save(oldUser);
		}
		else 
			return null;
	}

	@Override
	public List<User> deleteById(Long id) {
		Optional<User> optUser= userRepository.findById(id);
		List<User> users;
		if(optUser.isPresent()) {	
			userRepository.deleteById(id);
			 users= userRepository.findByName(optUser.get().getName());
			return users;
		}
		else 
			return null;
	}

	@Override
	public List<User> addUsers(List<User> users) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}
	
	
}
