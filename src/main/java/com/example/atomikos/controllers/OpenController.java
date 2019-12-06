package com.example.atomikos.controllers;

import com.example.atomikos.db1.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @data 2019/12/6
 * @time 9:52
 */
@RestController
@RequestMapping("open")
public class OpenController {

    @Autowired
    private UserService userService;

    @GetMapping("index")
    public String index(){
        return "hello world";
    }

    @PostMapping("test")
    public String testAtomikos(String name1){
        return userService.testAtomikos(name1);
    }
}
