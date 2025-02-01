/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.infrastructure.security;




/**
 *
 * @author stephensonpetit-homme
 */




import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;




@Configuration
@EnableWebSecurity()
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfiguration  { 

    //private final PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder autb = http.getSharedObject(AuthenticationManagerBuilder.class);
        autb.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
        return autb.build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        
        http
                .csrf().disable()
                .authorizeHttpRequests(requests ->
                requests
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                    .requestMatchers("/img/*").permitAll()
                    .requestMatchers("/users/create", "/users/*/delete", "/users/*").hasRole("ADMIN")
                    .anyRequest().authenticated()  // Authenticate all other paths
            ).formLogin(form -> form
                .loginPage("/login")  // Custom login page
                .permitAll()          // Allow unauthenticated access to the login page
                .defaultSuccessUrl("/users", true) // Redirect to a default URL after login
            ).logout(logout -> logout
                    .permitAll()
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
            )
             ;

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username ->
//        {
//            if("admin".equals(username))
//            {
//                return User
//                        .withUsername("admin")
//                        .password(passwordEncoder().encode("evenmoresecure"))
//                        .roles("ADMIN").build();
//            }
//            else {
//                return User
//                        .withUsername("user")
//                        .password(passwordEncoder().encode("verysecure"))
//                        .roles("USER")
//                        .build();
//            }
//            
//        };
//    }
    
    @Bean 
    public UserDetailsService userDetailsService()
    {
        
        return new InMemoryUserDetailsManager(
               
                User.withUsername("user")
                .password(passwordEncoder().encode("password"))
                        .roles("USER")
                        .build(),
                
                User.withUsername("admin")
                .password(passwordEncoder().encode("thepassword"))
                        .roles("ADMIN")
                        .build()
        
        );
    }

    private String passwordEncoder(String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

//        return new InMemoryUserDetailsManager(
//            User.withUsername("user")
//                .password(passwordEncoder().encode("verysecure"))
//                .roles("USER")
//                .build(),
//            User.withUsername("admin")
//                .password(passwordEncoder().encode("evenmoresecure"))
//                .roles("USER", "ADMIN")
//                .build()
//        );















