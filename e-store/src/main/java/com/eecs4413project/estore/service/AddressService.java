package com.eecs4413project.estore.service;

import com.eecs4413project.estore.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();

    Address getAddressById(Long id);

    Address createAddress(Address address);

    Address updateAddress(Long id, Address address);

    void deleteAddress(Long id);

    List<Address> getAddressesByCountry(String country);

    List<Address> getAddressesByProvince(String province);

    List<Address> getAddressesByZip(String zip);

    List<Address> getAddressesByPhone(String phone);

    List<Address> getAddressesByStreet(String street);

}
