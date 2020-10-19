package com.phamtan.do_an.jwt.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {

    private String username ;
    private String password ;
}
