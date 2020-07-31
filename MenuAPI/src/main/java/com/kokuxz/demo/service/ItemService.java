package com.kokuxz.demo.service;

import com.kokuxz.demo.entity.Item;
import com.kokuxz.demo.exceptions.ItemNotFoundException;
import com.kokuxz.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements ItemInterface {
    //Call ItemRepo to get data from
    @Autowired
    ItemRepository itemRepository;


    //Question #1
    @Override
    public List<Item> retrieveItems() {
        return (List<Item>) itemRepository.findAll();

        //This code below not working
        //return itemRepository.retrieveItems();
    }

    //Question #2
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

    //Question #3
    @Override
    public List<Item> retrieveItemByName (String name) {
        //Working Code:
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
