package com.phamtan.do_an.services;

import com.phamtan.do_an.dao.entities.AppUser;
import com.phamtan.do_an.dao.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



public interface UserService {
  public long saveUser(AppUser appUser);
  public long updateUser(AppUser appUser);
  public long deleteUser(AppUser appUser);
  public AppUser findUser(long id);
  public AppUser findUserByUserName(String username);


}
