///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.example.demo.infrastructure;
//
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *
// * @author stephensonpetit-homme
// */
//
//@Controller
////@RequestMapping("/users")
////@RestController
//public class RootController {
//    
//    @GetMapping("/") // <,>
//    public String index(Model model)
//    {
//        
//        model.addAttribute("pageTitle", "Taming Thymeleaf");
//        model.addAttribute("scientists", List.of("Albert Einstein",
//                                                  "Marie Curie",
//                                                  "Niels Bohr",
//                                                  "James Clerk Maxwell"));
//        
//        return "redirect:/users"; // <,> 
//    }
//    
//}
