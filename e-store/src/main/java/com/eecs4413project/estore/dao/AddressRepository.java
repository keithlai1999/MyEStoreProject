package com.eecs4413project.estore.dao;

import com.eecs4413project.estore.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    // Add custom query methods here if needed
    List<Address> findByStreet(String street);

    List<Address> findByCountry(String country);

    List<Address> findByProvince(String province);

    List<Address> findByZip(String zip);

    List<Address> findByPhone(String phone);
}
