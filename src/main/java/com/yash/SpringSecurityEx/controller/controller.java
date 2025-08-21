package com.yash.SpringSecurityEx.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/hello")
    public String hello (HttpServletRequest request){

        return "hello this is in my project " + request.getSession().getId()  ;
    }
}
