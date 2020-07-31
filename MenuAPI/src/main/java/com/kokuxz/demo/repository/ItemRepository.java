package com.kokuxz.demo.repository;

import com.kokuxz.demo.entity.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    /*
        Repository to retrieve data from database using CRUD interface
     */

    @Query("SELECT i.id, i.type, i.name, i.price FROM Item i")
    List<Item> retrieveItems();

    @Query("SELECT i.id, i.name FROM Item i")
    List<Item> retrieveItemNames();

    @Query("SELECT i.id, i.type, i.name, i.price FROM Item i WHERE i.id=:id")
    Item retrieveItemById(Long id);

    @Query("SELECT i.id, i.type, i.name, i.price FROM Item i WHERE i.name=:name")
    List<Item> retrieveItemByName(String name);

    @Query("SELECT i.id, i.type FROM Item i")
    List<String> retrieveItemTypes();


}
