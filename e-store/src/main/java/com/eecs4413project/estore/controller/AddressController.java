package com.eecs4413project.estore.controller;

import com.eecs4413project.estore.entity.Address;
import com.eecs4413project.estore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Address address = addressService.getAddressById(id);
        if (address != null) {
            return ResponseEntity.ok(address);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address createdAddress = addressService.createAddress(address);
        return ResponseEntity.ok(createdAddress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address address) {
        Address updatedAddress = addressService.updateAddress(id, address);
        if (updatedAddress != null) {
            return ResponseEntity.ok(updatedAddress);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-country/{country}")
    public ResponseEntity<List<Address>> getAddressesByCountry(@PathVariable String country) {
        List<Address> addresses = addressService.getAddressesByCountry(country);
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/by-province/{province}")
    public ResponseEntity<List<Address>> getAddressesByProvince(@PathVariable String province) {
        List<Address> addresses = addressService.getAddressesByProvince(province);
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/by-zip/{zip}")
    public ResponseEntity<List<Address>> getAddressesByZip(@PathVariable String zip) {
        List<Address> addresses = addressService.getAddressesByZip(zip);
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/by-phone/{phone}")
    public ResponseEntity<List<Address>> getAddressesByPhone(@PathVariable String phone) {
        List<Address> addresses = addressService.getAddressesByPhone(phone);
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/by-street/{street}")
    public ResponseEntity<List<Address>> getAddressesByStreet(@PathVariable String street) {
        List<Address> addresses = addressService.getAddressesByStreet(street);
        return ResponseEntity.ok(addresses);
    }
}
