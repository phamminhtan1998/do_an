package com.phamtan.do_an.configurations;

import com.phamtan.do_an.filters.JwtAuthencationFilter;
import com.phamtan.do_an.services.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@EnableWebSecurity
@ComponentScan("com.phamtan.do_an.services")
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
     CustomerUserDetailsService customerUserDetailsService ;

    @Bean
    public JwtAuthencationFilter jwtAuthencationFilter(){
        return new JwtAuthencationFilter();
    }



    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean() ;
    }

    @Bean
    public  PasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /* config the properties of authencation manager  eg : userdetails for object to check
    * userdetailsService to get the infomation of the userdetails
    * password endcoder for the encoder using by authencation manager
    *
    */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customerUserDetailsService)
                .passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable()
                .authorizeRequests().antMatchers("/login").permitAll()
                .anyRequest().authenticated();
        //add the filter of the jwt befor the  username and password authenticate
        http.addFilterBefore(jwtAuthencationFilter(), UsernamePasswordAuthenticationFilter.class);


    }

}

