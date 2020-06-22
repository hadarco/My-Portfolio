package com.hadarco.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//allow requests from domains
@CrossOrigin(origins = "http://localhost:4200")
//Controller - we need to tell spring this class is a controller
@RestController//controller handles rest request
public class HelloWorldController
{
    //we need to map a GET URI of /hello-world
    //GET
    //URI - /hello-world
    //method - "Hello World"

    @GetMapping(path="/hello-world")
    public String helloWorld()
    {
        return "Hello World";
    }

    //this bean is being converted to JSON and back
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean()
    {
        //throw new RuntimeException("Some Error Has Occurred, Please Contact Support at ***-*******");
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path="/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
    {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

}
