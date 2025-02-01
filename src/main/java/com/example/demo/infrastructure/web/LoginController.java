/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.infrastructure.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author stephensonpetit-homme
 */

@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String login(@AuthenticationPrincipal UserDetails userDetails)
    {
        if(userDetails == null)
        {
            return "login";
        }
        else 
            return "redirect:/";
    }
}
