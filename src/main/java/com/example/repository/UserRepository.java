package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.*;
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	
	List<User> findByName(String name);
	
	
	
	
	
	
	
	
	
	
	
	
	List<User> findBynameLike(String string);

	List<User> findAllByNameIsNotNull();

	//List<User> findAllByNameIsNotNull(String name);

	

//	List<User> findByName(String string);
//	
//	
//	@Query("select u From User u")
//	public List<User> getAllUser();
//	
//	
//
	//@Query("select u From User u WHERE u.name =: n")
	@Query("SELECT u FROM User u WHERE u.name = :x")
	public List<User> getUserByName(@Param("x")String name);
	
	@Query(value ="select * from user", nativeQuery = true)
	public List<User> getAllUser();
}
