package com.phamtan.do_an.web.user;

import com.phamtan.do_an.dao.entities.AppUser;
import com.phamtan.do_an.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class AppUserController {

    @Autowired
    private UserServiceImpl userService ;

    @GetMapping("/{id}")
    public AppUser hello(@PathVariable(name = "id") long id){
       AppUser user =  userService.findUser( id );
        return user;
    }

    @GetMapping("name/{name}")
    public AppUser hello(@PathVariable(name = "name") String name){
        AppUser user =  userService.findUserByUserName( name );
        return user;
    }
    @GetMapping()
    public List<AppUser> getAllUser(){
        List<AppUser> user =  userService.findALlUser();
        return user;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public long addUser(@RequestBody AppUser user){
       long id =  userService.saveUser(user);
        return id ;
    }
    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public long updateUser(@RequestBody AppUser user){
        long id = userService.updateUser(user);
        return id;
    }
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public long deleteUser(@RequestBody AppUser user){
        long id = userService.deleteUser(user);
        return id;
    }

}
