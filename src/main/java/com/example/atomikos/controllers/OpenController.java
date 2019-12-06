package com.example.atomikos.controllers;

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

    @GetMapping("index")
    public String index(){
        return "hello world";
    }
}
