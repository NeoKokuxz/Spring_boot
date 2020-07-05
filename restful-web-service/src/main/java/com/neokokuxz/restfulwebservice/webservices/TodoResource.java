package com.neokokuxz.restfulwebservice.webservices;

import com.neokokuxz.restfulwebservice.webservices.todo.Todo;
import com.neokokuxz.restfulwebservice.webservices.todo.TodoHardCodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResource {

    @Autowired
    private TodoHardCodedService todoService;

    //Retrieve Todos
    @GetMapping(path = "/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id){
        return todoService.findById(id);
    }

    @GetMapping(path = "/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        return todoService.findAll();
    }

    //Delete Todos
    @DeleteMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
        Todo todo = todoService.deleteTodoById(id);

        if(todo != null ){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
