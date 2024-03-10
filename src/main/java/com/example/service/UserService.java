package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.User;

public interface UserService {

	List<User> getUserByName(String userName);

	List<User> getUsers();

	User updateUser(User user);

	List<User> deleteById(Long id);

	List<User> addUsers(List<User> users);

	Optional<User> getUserById(Long id);

}
