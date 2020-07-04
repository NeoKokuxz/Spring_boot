# Spring boot @annotations

## @SpringBootApplication
- Spring Boot @SpringBootApplication annotation is used to mark a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning. 
- It’s same as declaring a class with @Configuration, @EnableAutoConfiguration and @ComponentScan annotations.

## @RestController
- The creation of RESTful web services
- @RestController is a specialized version of the controller. 
- It includes the @Controller and @ResponseBody annotations and as a result, simplifies the controller implementation:

## @CrossOrigin
- is a mechanism that allows restricted resources on a web page to be requested from another domain outside the domain from which the first resource was served
```
@CrossOrigin(origins = "http://localhost:4200") //This allows localhost 4200 to access service
```

## @GetMapping
- Annotation for mapping HTTP GET requests onto specific handler methods.
- inside () is the route that direct to the page contain bean info. 
```java
@GetMapping(path = "/hello-world") //Mapping GET request to hello-world
@GetMapping("/users/{username}/todos")
http://localhost:8080/users/naoki/todos //This return the json file below
```
```json
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

```java
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
- this variable is enclosed with cuirly braces {}
```java
Usage: 
//Create path variable
//  localhost/hello-world/path-variable/{name}
// @PathVariable
@GetMapping(path = "/hello-world/{name}") //Mapping GET request to hello-world
public Helloworldbean helloworldPV(@PathVariable String name){
    //Pass input into bean's constructor
    return new Helloworldbean(String.format("Hello World, %s", name) );
} //the String name is a PathVariable will be pass into /hello-world/{name}
```

## @Service
- Service Components are the class file which contains @Service annotation
- @Service annotates classes at the service layer
- We mark beans with @Service to indicate that it's holding the business logic
```java
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
}
```

## @Autowired
- This annotation allows Spring to resolve and inject collaborating beans into your bean.
- Once annotation injection is enabled, autowiring can be used on properties, setters, and constructors.
- Spring Team recommends: "Always use constructor based dependency injection in your beans. Always use assertions for mandatory dependencies"
```java
@Autowired
private TodoHardCodedService todoService; //Without autowired, the todoService can't be injected with TodoHardCodedService
```


## @Repository
- annotates classes at the persistence layer, which will act as a database repository
