package com.eecs4413project.estore.controller;

import com.eecs4413project.estore.entity.User;
import com.eecs4413project.estore.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserService userService; // Inject the UserService

    @BeforeEach
    public void setUp() {
        // Initialize your test data here before each test method

        // Create and save some users for testing
        User user1 = new User();
        user1.setUsername("alice");
        user1.setPassword("hashed_password");
        user1.setEmail("alice@example.com");
        user1.setRole("USER");
        userService.createUser(user1);

        User user2 = new User();
        user2.setUsername("bob");
        user2.setPassword("hashed_password");
        user2.setEmail("bob@example.com");
        user2.setRole("USER");
        userService.createUser(user2);

        User adminUser = new User();
        adminUser.setUsername("admin");
        adminUser.setPassword("hashed_password");
        adminUser.setEmail("admin@example.com");
        adminUser.setRole("ADMIN");
        userService.createUser(adminUser);
    }

    @Test
    public void testGetAllUsers() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // You can parse the JSON response using objectMapper and assert the data
    }

    @Test
    public void testGetUserById() throws Exception {
        Long userId = 1L; // Adjust the user ID as needed

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/users/" + userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // You can parse the JSON response using objectMapper and assert the data
    }

    // Implement other test methods (create, update, delete, getByUsername, getByEmail) similarly

    @Test
    public void testCreateUser() throws Exception {
        User newUser = new User();
        newUser.setUsername("newUser");
        newUser.setPassword("newPassword");
        newUser.setEmail("newuser@example.com");
        newUser.setRole("USER");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // You can parse the JSON response using objectMapper and assert the created user's details
    }

    @Test
    public void testUpdateUser() throws Exception {
        Long userId = 1L; // Adjust the user ID as needed
        User updatedUser = new User();
        updatedUser.setUsername("updatedUser");
        updatedUser.setPassword("updatedPassword");
        updatedUser.setEmail("updateduser@example.com");
        updatedUser.setRole("USER");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/api/users/" + userId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedUser)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // You can parse the JSON response using objectMapper and assert the updated user's details
    }

    @Test
    public void testDeleteUser() throws Exception {
        Long userId = 1L; // Adjust the user ID as needed

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/users/" + userId))
                .andExpect(status().isNoContent());

        // Verify that the user has been deleted
        User deletedUser = userService.getUserById(userId);
        assertNull(deletedUser);
    }
}
