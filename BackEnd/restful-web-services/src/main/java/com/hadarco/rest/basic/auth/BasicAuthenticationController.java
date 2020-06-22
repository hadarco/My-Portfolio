package com.hadarco.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//allow requests from domains
@CrossOrigin(origins = "http://localhost:4200")
//Controller - we need to tell spring this class is a controller
@RestController//controller handles rest request
public class BasicAuthenticationController
{
    //we need to map a GET URI of /hello-world
    //GET
    //URI - /hello-world
    //method - "Hello World"

    //this bean is being converted to JSON and back
    //we will get to /basicauth page only if we send the basic authentication header
    //when somebody tries to log in we want to hit this url and if he has the right authority he will
    //get this response back
    //we want to use this service in our login page
    @GetMapping(path="/basicauth")
    public AuthenticationBean helloWorldBean()
    {
        //throw new RuntimeException("Some Error Has Occurred, Please Contact Support at ***-*******");
        return new AuthenticationBean("You are authenticated");
    }


}
