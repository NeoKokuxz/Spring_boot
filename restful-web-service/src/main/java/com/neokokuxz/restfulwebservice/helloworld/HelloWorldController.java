package com.neokokuxz.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.*;

//Controller - handle the HTTP requests
@RestController

//Allow some domain to use this service
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {

    //Get
    //URI - /hello-world
    //Method - "Hello World"

    //@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    //This can be replace by:
    @GetMapping(path = "/hello-world") //Mapping GET request to hello-world
    public String helloworld(){
        return "Hello World";
    }

    //Create hello world bean
    @GetMapping(path = "/hello-world-bean") //Mapping GET request to hello-world
    public Helloworldbean helloworldbean(){
        //throw new RuntimeException("Runtime Error happened!");
        //Pass input into bean's constructor
        return new Helloworldbean("Hello world");
    }

    //Create path variable
    //  localhost/hello-world/path-variable/{name}
    // @PathVariable
    @GetMapping(path = "/hello-world/{name}") //Mapping GET request to hello-world
    public Helloworldbean helloworldPV(@PathVariable String name){

        //Pass input into bean's constructor
        return new Helloworldbean(String.format("Hello World, %s", name) );
    }
}
