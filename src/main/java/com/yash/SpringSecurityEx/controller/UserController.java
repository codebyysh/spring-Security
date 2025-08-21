package com.yash.SpringSecurityEx.controller;

import com.yash.SpringSecurityEx.model.Users;
import com.yash.SpringSecurityEx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service ;

    @PostMapping("/register")
    public Users register (@RequestBody Users user ){
        return service.register(user) ;

    }

    @GetMapping("/getUsers")
    public List<Users> getUsers(){
        return service.getUsers() ;
    }

    @PostMapping("/login")
    public String login ( @RequestBody Users users ){
//        System.out.println(users);
        return service.verify(users) ;
    }
}
