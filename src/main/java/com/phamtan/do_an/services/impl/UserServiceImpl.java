package com.phamtan.do_an.services.impl;


import com.phamtan.do_an.dao.entities.AppUser;
import com.phamtan.do_an.dao.repositories.AppUserRepository;
import com.phamtan.do_an.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AppUserRepository appUserRepository ;
    @Autowired
    PasswordEncoder bcryptEncoder ;


    @Override
    public long saveUser(AppUser appUser) {
        appUser.setPassword(bcryptEncoder.encode(appUser.getPassword()));
         appUserRepository.save(appUser);
         return appUser.getId();
    }

    @Override
    public long updateUser(AppUser appUser) {
        appUser.setPassword(bcryptEncoder.encode(appUser.getPassword()));
        appUserRepository.save(appUser);
        return appUser.getId();
    }

    @Override
    public long deleteUser(AppUser appUser) {
        appUserRepository.delete(appUser);
        return appUser.getId();
    }

    @Override
    public AppUser findUser(long id) {
        AppUser appUser = appUserRepository.findById(id).get();
        return appUser ;
    }

    @Override
    public AppUser findUserByUserName(String username) {
        AppUser appUser = appUserRepository.findByUsername(username);
        return appUser ;
    }
}
