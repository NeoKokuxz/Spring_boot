package com.kokuxz.demo.service;

import com.kokuxz.demo.entity.Item;

import java.util.List;

public interface ItemInterface {
    //Get all item data from the list
    List<Item> retrieveItems();

    //Get item data by it's id
    Item retrieveItemById(Long id);

    //Get item data by it's itemName
    List<Item> retrieveItemByName(String name);

    //Get all item types
    List<String> retrieveItemTypes();

    //Get all item names
    List<Item> retrieveItemNames();
}
