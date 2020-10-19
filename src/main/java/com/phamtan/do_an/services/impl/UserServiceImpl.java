package com.phamtan.do_an.services.impl;


import com.phamtan.do_an.dao.entities.AppUser;
import com.phamtan.do_an.dao.repositories.AppUserRepository;
import com.phamtan.do_an.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AppUserRepository appUserRepository ;

    @Override
    public long saveUser(AppUser appUser) {
         appUserRepository.save(appUser);
         return appUser.getId();
    }

    @Override
    public long updateUser(AppUser appUser) {
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
