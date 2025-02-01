/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.user;

import java.time.LocalDate;

/**
 *
 * @author stephensonpetit-homme
 */
public class EditUserParameters extends CreateUserParameters{
    //private final long version;
    
    public EditUserParameters(UserName userName, Gender gender, LocalDate birthday, Email email, PhoneNumber phoneNumber)
    {
        super(userName, gender, birthday, email, phoneNumber);     
    }
    
    public void update(User user)
    {
        user.setUserName(getUserName());
        user.setGender(getGender());
        user.setBirthday(getBirthday());
        user.setEmail(getEmail());
        user.setPhonenumber(getPhoneNumber());
    }
}
