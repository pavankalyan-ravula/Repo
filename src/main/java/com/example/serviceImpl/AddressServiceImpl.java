package com.example.serviceImpl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Address;
import com.example.repository.AddressRepository;
import com.example.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
    private AddressRepository addressRepository;

    // Get all addresses
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    // Get address by ID
    public Address getAddressById(int id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        return optionalAddress.orElse(null);
    }

    // Create a new address
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    // Update an existing address
    public Address updateAddress(int id, Address updatedAddress) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()) {
            Address existingAddress = optionalAddress.get();
            existingAddress.setStreet(updatedAddress.getStreet());
            existingAddress.setCity(updatedAddress.getCity());
            existingAddress.setContry(updatedAddress.getContry());
            return addressRepository.save(existingAddress);
        }
        return null;
    }

    // Delete an address by ID
    public void deleteAddress(int id) {
        addressRepository.deleteById(id);
    }
    public List<Address> getAddressesByStreetName(String streetName) {
        return addressRepository.findByStreet(streetName);
    }
}
