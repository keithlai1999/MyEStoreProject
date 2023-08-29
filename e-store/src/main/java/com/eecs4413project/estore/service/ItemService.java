package com.eecs4413project.estore.service;

import com.eecs4413project.estore.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();

    Item getItemByBid(String bid);

    Item createItem(Item item);

    Item updateItem(String bid, Item item);

    void deleteItem(String bid);

    List<Item> getItemsByName(String name);

    List<Item> getItemsByType(String type);

    List<Item> getItemsByBrand(String brand);
}
