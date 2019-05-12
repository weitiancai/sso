package com.techprimers.security.springsecurityauthserver.service;

import com.techprimers.security.springsecurityauthserver.UsersRepository.UsersRepository;
import com.techprimers.security.springsecurityauthserver.model.CustomerUserDetail;
import com.techprimers.security.springsecurityauthserver.model.Users;

import org.hibernate.service.UnknownServiceException;
import org.omg.CORBA.portable.UnknownException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.xml.ws.ServiceMode;

@Service
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> usersOptional = usersRepository.findByName(username);
        usersOptional.orElseThrow(()->new UsernameNotFoundException("Username not found"));
        return usersOptional.map(CustomerUserDetail::new).get();
    }
}
