package com.phamtan.do_an.web.user;

import com.phamtan.do_an.dao.entities.CustomerUserDetails;
import com.phamtan.do_an.jwt.JwtProvider;
import com.phamtan.do_an.jwt.request.LoginRequest;
import com.phamtan.do_an.jwt.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager ;
    @Autowired
    private JwtProvider jwtProvider ;
    @PostMapping(value = "/login",produces = MediaType.APPLICATION_JSON_VALUE)
    public  LoginResponse authenticateUser( @RequestBody LoginRequest loginRequest){

        System.out.println("running in the controller ");

      Authentication authencation =   authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));

      SecurityContextHolder.getContext().setAuthentication(authencation);
        String jwt = jwtProvider.generateJwtToken((CustomerUserDetails) authencation.getPrincipal());
        return new LoginResponse(jwt);
    }

}
