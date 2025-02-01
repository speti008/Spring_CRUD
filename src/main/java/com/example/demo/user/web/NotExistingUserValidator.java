/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.user.web;

import com.example.demo.user.Email;
import com.example.demo.user.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
/**
 *
 * @author stephensonpetit-homme
 */
class NotExistingUserValidator implements ConstraintValidator<NotExistingUser, CreateUserFormData>{

        private final UserService userService;
        
        @Autowired
        public NotExistingUserValidator(UserService userService)
        {
            this.userService = userService;
        }
        public void initialize(NotExistingUser constraint)
        {
            
        }
        
        public boolean isValid(CreateUserFormData formData, ConstraintValidatorContext context)
        {
            if (!StringUtils.isEmpty(formData.getEmail())
                && userService.userWithEmailExists(new Email(formData.getEmail()))) { //<.>
            context.disableDefaultConstraintViolation(); //<.>
            context.buildConstraintViolationWithTemplate("{UserAlreadyExisting}") //<.>
                   .addPropertyNode("email") //<.>
                   .addConstraintViolation(); //<.>

            return false; //<.>
        }

        return true;
        }
}
