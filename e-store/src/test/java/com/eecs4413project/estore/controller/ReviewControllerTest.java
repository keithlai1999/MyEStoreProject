package com.eecs4413project.estore.controller;

import com.eecs4413project.estore.entity.Item;
import com.eecs4413project.estore.entity.Review;
import com.eecs4413project.estore.service.ReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ReviewService reviewService;

    @Test
    public void testGetAllReviews() throws Exception {
        Review review1 = new Review(new Item("b001", "Little Prince", "a book for all ages", "book", "Penguin", 20, 100), "Great book! Highly recommend.", 5);
        Review review2 = new Review(new Item("c001", "iPad", "a device for personal use", "computer", "Apple", 500, 100), "Awesome device, love it.", 4);

        List<Review> reviews = Arrays.asList(review1, review2);

        when(reviewService.getAllReviews()).thenReturn(reviews);

        mockMvc.perform(get("/api/reviews"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(reviews.size()));
    }

    @Test
    public void testCreateReview() throws Exception {
        Item item = new Item("b001", "Little Prince", "a book for all ages", "book", "Penguin", 20, 100);
        Review newReview = new Review(item, "Great product!", 4);

        when(reviewService.createReview(any(Review.class))).thenReturn(newReview);

        mockMvc.perform(post("/api/reviews")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newReview)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.item.bid").value(newReview.getItem().getBid()))
                .andExpect(jsonPath("$.reviewText").value(newReview.getReviewText()))
                .andExpect(jsonPath("$.rating").value(newReview.getRating()));
    }

    @Test
    public void testDeleteReview() throws Exception {
        Long reviewIdToDelete = 1L;

        mockMvc.perform(delete("/api/reviews/{id}", reviewIdToDelete))
                .andExpect(status().isNoContent());

        verify(reviewService, times(1)).deleteReview(reviewIdToDelete);
    }

    @Test
    public void testGetReviewsByItemBid() throws Exception {
        String itemBid = "b001";
        Review review1 = new Review(new Item(itemBid, "Little Prince", "a book for all ages", "book", "Penguin", 20, 100), "Great book! Highly recommend.", 5);
        Review review2 = new Review(new Item(itemBid, "Little Prince", "a book for all ages", "book", "Penguin", 20, 100), "Not satisfied with the quality.", 2);

        List<Review> reviews = Arrays.asList(review1, review2);

        when(reviewService.getReviewsByItemBid(itemBid)).thenReturn(reviews);

        mockMvc.perform(get("/api/reviews/by-item-bid/{bid}", itemBid))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(reviews.size()));
    }
}