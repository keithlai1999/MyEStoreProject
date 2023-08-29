package com.eecs4413project.estore.controller;

import com.eecs4413project.estore.entity.Item;
import com.eecs4413project.estore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{bid}")
    public ResponseEntity<Item> getItemByBid(@PathVariable String bid) {
        Item item = itemService.getItemByBid(bid);
        if (item != null) {
            return ResponseEntity.ok(item);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item createdItem = itemService.createItem(item);
        return ResponseEntity.ok(createdItem);
    }

    @PutMapping("/{bid}")
    public ResponseEntity<Item> updateItem(@PathVariable String bid, @RequestBody Item item) {
        Item updatedItem = itemService.updateItem(bid, item);
        if (updatedItem != null) {
            return ResponseEntity.ok(updatedItem);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{bid}")
    public ResponseEntity<Void> deleteItem(@PathVariable String bid) {
        itemService.deleteItem(bid);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<List<Item>> getItemsByName(@PathVariable String name) {
        List<Item> items = itemService.getItemsByName(name);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/by-type/{type}")
    public ResponseEntity<List<Item>> getItemsByType(@PathVariable String type) {
        List<Item> items = itemService.getItemsByType(type);
        return ResponseEntity.ok(items);
    }

    @GetMapping("/by-brand/{brand}")
    public ResponseEntity<List<Item>> getItemsByBrand(@PathVariable String brand) {
        List<Item> items = itemService.getItemsByBrand(brand);
        return ResponseEntity.ok(items);
    }
}
