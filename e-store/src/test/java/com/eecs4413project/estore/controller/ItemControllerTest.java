package com.eecs4413project.estore.controller;

import com.eecs4413project.estore.entity.Item;
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
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        // You can initialize test data here if needed
    }

    @Test
    public void testGetAllItems() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/items"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        // You can add more assertions for response content if needed
    }

    @Test
    public void testCreateItem() throws Exception {
        Item newItem = new Item("e001", "Test Item", "Description", "Type", "Brand", 10, 100);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newItem)))
                .andExpect(MockMvcResultMatchers.status().isOk());
        // You can add more assertions for the response content or database changes if needed
    }

    @Test
    public void testGetItemByBid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/items/{bid}", "b001"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        // You can add more assertions for response content if needed
    }

    @Test
    public void testUpdateItem() throws Exception {
        Item updatedItem = new Item("e001", "Updated Item", "Updated Description", "Updated Type", "Updated Brand", 20, 200);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/items/{bid}", "e001")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedItem)))
                .andExpect(MockMvcResultMatchers.status().isOk());
        // You can add more assertions for the response content or database changes if needed
    }

    @Test
    public void testDeleteItem() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/items/{bid}", "e001"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
        // You can add more assertions for database changes if needed
    }

    @Test
    public void testGetItemsByName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/items/by-name/{name}", "Little Prince"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        // You can add more assertions for response content if needed
    }

    @Test
    public void testGetItemsByType() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/items/by-type/{type}", "book"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        // You can add more assertions for response content if needed
    }

    @Test
    public void testGetItemsByBrand() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/items/by-brand/{brand}", "Apple"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        // You can add more assertions for response content if needed
    }
}
