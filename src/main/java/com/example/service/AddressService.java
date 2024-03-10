package com.example.service;

import java.util.List;

import com.example.entity.Address;

public interface AddressService {

	void deleteAddress(int id);

	Address updateAddress(int id, Address address);

	Address createAddress(Address address);

	Address getAddressById(int id);

	List<Address> getAllAddresses();
	 List<Address> getAddressesByStreetName(String streetName);

}
