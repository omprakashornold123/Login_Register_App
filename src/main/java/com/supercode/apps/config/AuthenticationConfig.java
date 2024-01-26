package com.supercode.apps.config;

import com.supercode.apps.services.UsereSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class AuthenticationConfig extends WebSecurityConfigurerAdapter {

    private final UsereSevice usereSevice;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(usereSevice).passwordEncoder( passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
     http.csrf().disable()
             .authorizeRequests()
             .antMatchers( "/api/v*/authentication/**" )
             .permitAll().anyRequest().authenticated().and().formLogin();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new  BCryptPasswordEncoder();
    }

}
