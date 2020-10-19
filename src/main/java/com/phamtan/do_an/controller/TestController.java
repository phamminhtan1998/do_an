package com.phamtan.do_an.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello ";
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String test(){

        System.out.println("====================home part");
        return "Hello ///";
    }
    @GetMapping(value = "/")
    public String test1(){
        return "Hel/";
    }


}
