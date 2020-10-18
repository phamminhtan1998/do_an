package com.phamtan.do_an.jwt.response;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginResponse {
   private String  accessToken ;
   private String tokenType = "Bearer ";
   public  LoginResponse(String accessToken){
       this.accessToken = tokenType+accessToken ;
   }

}
