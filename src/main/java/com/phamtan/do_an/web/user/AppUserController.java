package com.phamtan.do_an.web.user;

import com.phamtan.do_an.dao.entities.AppUser;
import com.phamtan.do_an.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AppUserController {

    @Autowired
    private UserServiceImpl userService ;

    @GetMapping(path = "/user")
    public String hello(){
       AppUser user =  userService.findUser(1);
        return user.getUsername();
    }
}