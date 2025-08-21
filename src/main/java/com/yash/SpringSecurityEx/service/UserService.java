package com.yash.SpringSecurityEx.service;

import com.yash.SpringSecurityEx.model.Users;
import com.yash.SpringSecurityEx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepo repo ;

    @Autowired
    private AuthenticationManager authManager ;

    @Autowired
    private JWTService jwtService ;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12) ;

    public Users register ( Users user ){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user) ;

    }

    public List<Users> getUsers() {
        return repo.findAll();
    }

    public String verify(Users users) {
        Authentication authentication = authManager.
                authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(),users.getPassword()) );

        if (authentication.isAuthenticated()){
            return jwtService.generateToken(users.getUsername()) ;
        }
        return "failure" ;
    }
}
