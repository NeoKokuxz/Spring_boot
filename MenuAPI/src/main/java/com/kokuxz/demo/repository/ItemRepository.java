package com.kokuxz.demo.repository;

import com.kokuxz.demo.entity.Item;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    /*
        Repository to retrieve data from database using CRUD interface
     */


//    @Query("SELECT i.id, i.name FROM Item i")
//    List<String> retrieveItemNames();


    @Query("SELECT i.id, i.type FROM Item i")
    List<String> retrieveItemTypeString();



}
