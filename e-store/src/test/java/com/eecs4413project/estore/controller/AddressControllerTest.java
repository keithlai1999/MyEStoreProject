package com.eecs4413project.estore.controller;

import com.eecs4413project.estore.entity.Address;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        // Perform any setup or initialization if needed
    }

    @Test
    public void testGetAllAddresses() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/addresses"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCreateAddress() throws Exception {
        Address address = new Address("123 Main St", "ON", "Canada", "M1C 2K5", "416-123-4567");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/addresses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(address)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAddressById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/addresses/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateAddress() throws Exception {
        Address address = new Address("456 Elm St", "BC", "Canada", "V6E 1B8", "604-987-6543");
        mockMvc.perform(MockMvcRequestBuilders.put("/api/addresses/{id}", 7)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(address)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteAddress() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/addresses/{id}", 7))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void testGetAddressesByCountry() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/addresses/by-country/{country}", "Canada"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAddressesByProvince() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/addresses/by-province/{province}", "ON"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAddressesByZip() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/addresses/by-zip/{zip}", "M1C 2K5"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAddressesByPhone() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/addresses/by-phone/{phone}", "416-123-4567"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAddressesByStreet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/addresses/by-street/{street}", "123 Main St"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
