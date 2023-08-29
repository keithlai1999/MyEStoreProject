package com.eecs4413project.estore.service;

import com.eecs4413project.estore.dao.ItemRepository;
import com.eecs4413project.estore.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemByBid(String bid) {
        Optional<Item> item = itemRepository.findById(bid);
        return item.orElse(null);
    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(String bid, Item item) {
        Optional<Item> existingItem = itemRepository.findById(bid);
        if (existingItem.isPresent()) {
            item.setBid(bid);
            return itemRepository.save(item);
        }
        return null;
    }

    @Override
    public void deleteItem(String bid) {
        itemRepository.deleteById(bid);
    }

    @Override
    public List<Item> getItemsByName(String name) {
        return itemRepository.findByName(name);
    }

    @Override
    public List<Item> getItemsByType(String type) {
        return itemRepository.findByType(type);
    }

    @Override
    public List<Item> getItemsByBrand(String brand) {
        return itemRepository.findByBrand(brand);
    }
}
