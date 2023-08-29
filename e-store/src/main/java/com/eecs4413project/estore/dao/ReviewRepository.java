package com.eecs4413project.estore.dao;

import com.eecs4413project.estore.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Add custom query methods here if needed
    List<Review> findByItemBid(String bid);
}
