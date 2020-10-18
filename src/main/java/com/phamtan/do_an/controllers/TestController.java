package com.phamtan.do_an.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello ";
    }

    @GetMapping(value = "/home")
    public String test(){
        return "Hello ///";
    }
    @GetMapping(value = "/")
    public String test1(){
        return "Hel/";
    }


}
