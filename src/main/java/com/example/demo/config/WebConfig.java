package com.example.demo.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                    .permitAll()
            .and()
                .anonymous()
                    .disable()
                        .exceptionHandling()
                            .authenticationEntryPoint(new Http401AuthenticationEntryPoint("headerValue"))
            .and()
                .csrf()
                    .disable();
    }
}