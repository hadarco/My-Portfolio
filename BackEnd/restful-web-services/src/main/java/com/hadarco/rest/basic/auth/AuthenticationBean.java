package com.hadarco.rest.basic.auth;

public class AuthenticationBean {

    private String message;

    public AuthenticationBean(String message)
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

