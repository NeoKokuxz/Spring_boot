package com.kokuxz.demo.service;

import com.kokuxz.demo.entity.Item;
import com.kokuxz.demo.entity.Name;
import com.kokuxz.demo.entity.Type;
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


    //Question #1
    @Override
    public List<Item> retrieveItems() {
        return (List<Item>) itemRepository.findAll();
    }

    //Question #2 - Not Working!
    @Override
    public List<Name> retrieveItemNames() {
        List<Name> newList = new ArrayList<>();
        List<Item> i = (List<Item>) itemRepository.findAll();
        for(Item x : i){
            Name newItem = new Name();
            newItem.setName(x.getName());
            newList.add(newItem);
        }
        if(!newList.isEmpty()){
            return newList;
        } else {
            throw new ItemNotFoundException("No name found!");
        }
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
    public List<String> retrieveItemTypeString() {
        return itemRepository.retrieveItemTypeString();
    }

    public List<Item> retrieveItemByType(String type){
        List<Item> newList = new ArrayList<>();
        List<Item> i = (List<Item>) itemRepository.findAll();
        for(Item x : i){
            System.out.println(x.getType());
            if(x.getType().equals(type)){
                newList.add(x);
            }
        }

        if(!newList.isEmpty()){
            return newList;
        } else {
            throw new ItemNotFoundException("Type Not Found!");
        }
    }

    public List<Type> retrieveItemTypes(){
        System.out.println("Here!");
        boolean contain = false;
        List<Item> stringList = (List<Item>) itemRepository.findAll();
        List<Type> newList = new ArrayList<>();
        for(Item item : stringList){
            Type type = new Type(item.getType());
            if(newList.size() == 0 ){
                newList.add(type);
            } else {
                for(int i = 0; i < newList.size(); i++){
                    if(newList.get(i).getName().equals(type.getName())){
                        contain = true;
                    }
                }
                if(!contain){
                    newList.add(type);
                }
            }

        }

        if(!newList.isEmpty()) {
            return newList;
        } else {
            throw new ItemNotFoundException("Types not found!");
        }
    }
}
