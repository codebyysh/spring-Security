package com.yash.SpringSecurityEx.service;

import com.yash.SpringSecurityEx.model.Users;
import com.yash.SpringSecurityEx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepo repo ;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12) ;

    public Users register ( Users user ){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user) ;

    }

    public List<Users> getUsers() {
        return repo.findAll();
    }
}
