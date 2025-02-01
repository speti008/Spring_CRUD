/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.infrastructure.web;

import jakarta.validation.groups.Default;
import jakarta.validation.GroupSequence;

/**
 *
 * @author stephensonpetit-homme
 */

@GroupSequence({Default.class, ValidationGroupOne.class, ValidationGroupTwo.class})
public interface ValidationGroupSequence {
    
}
