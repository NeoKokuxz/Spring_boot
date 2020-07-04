# Spring boot components

## @SpringBootApplication
- Spring Boot @SpringBootApplication annotation is used to mark a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning. 
- It’s same as declaring a class with @Configuration, @EnableAutoConfiguration and @ComponentScan annotations.

## @RestController
- The creation of RESTful web services
- @RestController is a specialized version of the controller. 
- It includes the @Controller and @ResponseBody annotations and as a result, simplifies the controller implementation:

## @CrossOrigin
- is a mechanism that allows restricted resources on a web page to be requested from another domain outside the domain from which the first resource was served

## @GetMapping
- Annotation for mapping HTTP GET requests onto specific handler methods.
- inside () is the route that direct to the page contain bean info. 
```
@GetMapping(path = "/hello-world") //Mapping GET request to hello-world
@GetMapping("/users/{username}/todos")
http://localhost:8080/users/naoki/todos //This return the json file below
```
```
[
  {
    "id": 0,
    "username": "kokxz",
    "description": "I want to drink coffee",
    "targetDate": "2020-07-04T20:54:33.577+00:00",
    "done": false
  },
  {
    "id": 1,
    "username": "Naoki",
    "description": "I want to drink Soda",
    "targetDate": "2020-07-04T20:54:33.577+00:00",
    "done": false
  },
  {
    "id": 2,
    "username": "Neo",
    "description": "I want to drink milk",
    "targetDate": "2020-07-04T20:54:33.577+00:00",
    "done": false
  }
]
```
- 

## Bean
- In Spring, the objects that form the backbone of your application and that are managed by the Spring IoC container are called beans. A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container.
- Personal understanding: Bean is a customized class object that contains information, in order to access it needs getter() and setter()
- name of the data will be after getter / setter. 
  - Example: getMessage will result { "message" : "stored data" }

```
public class Helloworldbean {

    private String message;

    public Helloworldbean(String input){
        this.message = input;
    }

    public void setMessage(String newInput){
        this.message = newInput;
    }

    public String getMessage(){
        return this.message;
    }

    public String toString(){
        return String.format("HelloWorldBean [message=%s]", message);
    }
}
```

## @PathVariable

## @Service

## @Autowired
