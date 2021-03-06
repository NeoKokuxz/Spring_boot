package com.neokokuxz.restfulwebservice.webservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardCodedService {

    private static List<Todo> todos = new ArrayList();

    private static int idCount = 0;

    static {
        todos.add(new Todo(idCount++, "kokxz", "I want to drink coffee", new Date(), false));
        todos.add(new Todo(idCount++, "Naoki", "I want to drink Soda", new Date(), false));
        todos.add(new Todo(idCount++, "Neo", "I want to drink milk", new Date(), false));
    }

    public List<Todo> findAll(){
        return todos;
    }

    public Todo deleteTodoById(long id){
        Todo todo = findById(id);
        if(todo == null){
            return null;
        }
        if( todos.remove(todo) ){
            return todo;
        }
        return null;
    }

    public Todo findById(long id) {
        for (Todo todo : todos) {
            if(todo.getId() == id){
                return todo;
            }
        }
        return null;
    }
}
