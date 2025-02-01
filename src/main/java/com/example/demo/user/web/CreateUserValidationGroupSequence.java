/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.user.web;
import com.example.demo.infrastructure.web.ValidationGroupOne;
import com.example.demo.infrastructure.web.ValidationGroupTwo;
import jakarta.validation.groups.Default;
import jakarta.validation.GroupSequence;

/**
 *
 * @author stephensonpetit-homme
 */
@GroupSequence({Default.class, ValidationGroupOne.class, ValidationGroupTwo.class})
public interface CreateUserValidationGroupSequence {
    
}
