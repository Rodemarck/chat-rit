package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@CrossOrigin(origins = "http://domain2.com", maxAge = 3600)
@RestController
public class IndecController {
    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }
}
