package com.eecs4413project.estore.service;

import com.eecs4413project.estore.dao.AddressRepository;
import com.eecs4413project.estore.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        return address.orElse(null);
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Long id, Address address) {
        Optional<Address> existingAddress = addressRepository.findById(id);
        if (existingAddress.isPresent()) {
            address.setId(id);
            return addressRepository.save(address);
        }
        return null;
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<Address> getAddressesByCountry(String country) {
        return addressRepository.findByCountry(country);
    }

    @Override
    public List<Address> getAddressesByProvince(String province) {
        return addressRepository.findByProvince(province);
    }

    @Override
    public List<Address> getAddressesByZip(String zip) {
        return addressRepository.findByZip(zip);
    }

    @Override
    public List<Address> getAddressesByPhone(String phone) {
        return addressRepository.findByPhone(phone);
    }

    @Override
    public List<Address> getAddressesByStreet(String street) {
        return addressRepository.findByStreet(street);
    }
}
