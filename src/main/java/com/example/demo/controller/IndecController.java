package com.example.demo.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@CrossOrigin(origins = "http://domain2.com", maxAge = 3600)
@RestController
public class IndecController {
    @RequestMapping("/{token}")
    public ModelAndView index(@PathVariable(value="token") String token){
        System.out.println("meu token é [" + token + "]");
        return new ModelAndView("index");
    }
}
