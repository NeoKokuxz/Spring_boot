package com.kokuxz.demo.controller;

import com.kokuxz.demo.entity.Item;
import com.kokuxz.demo.entity.Name;
import com.kokuxz.demo.entity.Type;
import com.kokuxz.demo.service.ItemService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@ApiResponses(value = {
//        @ApiResponse(code = 400, message = "Code 400 Bad Request. Please review API guideline to use proper format!"),
//        @ApiResponse(code = 200, message = "Code 200 OK Request!"),
//        @ApiResponse(code = 401, message = "Code 401 Security constrains! Please make sure request is authenticated!"),
//        @ApiResponse(code = 500, message = "Code 500 Server Error! Please make sure server is running!")
//})
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> itemList = itemService.retrieveItems();
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    @GetMapping("/items/id/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id){
        Item i = itemService.retrieveItemById(id);
        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    @GetMapping("/items/names/{name}")
    public ResponseEntity<List<Item>> getItemByName(@PathVariable String name){
        List<Item> i = itemService.retrieveItemByName(name);
        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    @GetMapping("/items/names")
    public ResponseEntity<List<Name>>getItemNames(){
        List<Name> names = itemService.retrieveItemNames();
        return new ResponseEntity<>(names, HttpStatus.OK);
    }

    @GetMapping("/items/types/string")
    public ResponseEntity<List<String>> getItemTypes(){
        List<String> types = itemService.retrieveItemTypeString();
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    @GetMapping("/items/types/list/{type}")
    public ResponseEntity<List<Item>> getItemByType(@PathVariable String type){
        List<Item> itemList = itemService.retrieveItemByType(type);
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    @GetMapping("/items/types/list")
    public ResponseEntity<List<Type>> getItemByType(){
        List<Type> itemList = itemService.retrieveItemTypes();
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }
}
