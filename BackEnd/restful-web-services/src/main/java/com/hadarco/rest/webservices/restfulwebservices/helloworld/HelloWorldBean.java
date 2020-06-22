package com.hadarco.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {

    private String message;

    public HelloWorldBean(String message)
    {
        this.message=message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }

    //the automatic conversion will not work if there is no getter
    public String getMessage() {
        return message;
    }

}

