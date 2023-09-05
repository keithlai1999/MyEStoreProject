package com.eecs4413project.estore.dao;

import com.eecs4413project.estore.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, String> {
    // Add custom query methods here if needed
    List<Item> findByName(String name);

    List<Item> findByType(String type);

    List<Item> findByBrand(String brand);

}
