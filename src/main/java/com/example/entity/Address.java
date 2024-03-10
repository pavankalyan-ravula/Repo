package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {
	@Id
	private int id;
	private String street;
	private String city;
	private String contry;
	
	@ManyToOne
	@JoinColumn(name ="user_id")
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getContry() {
		return contry;
	}
	public void setContry(String contry) {
		this.contry = contry;
	}
	public Address(int id, String street, String city, String contry) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.contry = contry;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
