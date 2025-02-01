/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.user.web;

import com.example.demo.infrastructure.web.ValidationGroupOne;
import com.example.demo.infrastructure.web.ValidationGroupTwo;
import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

/**
 *
 * @author stephensonpetit-homme
 */

@GroupSequence({Default.class, ValidationGroupOne.class, ValidationGroupTwo.class})
public interface EditUserValidationGroupTwo {
    
}
