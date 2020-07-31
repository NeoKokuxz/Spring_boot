package com.kokuxz.demo.service;

import com.kokuxz.demo.entity.Item;
import com.kokuxz.demo.exceptions.ItemNotFoundException;
import com.kokuxz.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements ItemInterface {
    //Call ItemRepo to get data from
    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> retrieveItems() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public List<Item> retrieveItemNames() {
        return itemRepository.retrieveItemNames();
    }

    @Override
    public Item retrieveItemById(Long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        Item i = optionalItem.orElseThrow(ItemNotFoundException::new);
        return i;
    }

    @Override
    public List<Item> retrieveItemByName (String name) {

//        Optional <List<Item>> itemList = Optional.ofNullable(itemRepository.retrieveItemByName(name));
//        List<Item> i = itemList.orElseThrow(ItemNotFoundException::new);
//        return i;
        List<Item> newList = new ArrayList<>();
        List<Item> i = (List<Item>) itemRepository.findAll();
        for(Item x : i){
            if(x.getName().equals(name)){
                newList.add(x);
            }
        }

        if(!newList.isEmpty()){
            return newList;
        } else {
            throw new ItemNotFoundException("Item Not Found!");
        }


    }



    @Override
    public List<String> retrieveItemTypes() {
        return itemRepository.retrieveItemTypes();
    }
}
