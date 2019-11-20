package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndecController {
    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
