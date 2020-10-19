package com.phamtan.do_an.services;

import com.phamtan.do_an.dao.entities.AppUser;
import com.phamtan.do_an.dao.entities.CustomerUserDetails;
import com.phamtan.do_an.dao.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    private AppUserRepository appUserRepository ;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser user = appUserRepository.findByUsername(username);
        if(user!=null){
            System.out.println(user);
            return new CustomerUserDetails(user);
        }
        else return null;
    }
}
