///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.example.demo.user.web;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.http.HttpStatus;
//import org.springframework.orm.ObjectOptimisticLockingFailureException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// *
// * @author stephensonpetit-homme
// */
//
//@ControllerAdvice
//public class GlobalCOntrollerAdvice {
//    
//    @ResponseStatus(HttpStatus.CONFLICT)
//    @ExceptionHandler({DataIntegrityViolationException.class, ObjectOptimisticLockingFailureException.class})
//    public ModelAndView handleConflict(HttpServletRequest request, Exception e)
//    {
//        ModelAndView result = new ModelAndView("error/409");
//        result.addObject("url", request.getRequestURL());
//        return result;
//    }
//    
//}
