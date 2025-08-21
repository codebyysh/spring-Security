package com.yash.SpringSecurityEx.service;


import com.yash.SpringSecurityEx.model.UserPrincial;
import com.yash.SpringSecurityEx.model.Users;
import com.yash.SpringSecurityEx.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo ;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username) ;

        if ( user == null ){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("UserNotFound") ;
        }

        return new UserPrincial(user);
    }
}
