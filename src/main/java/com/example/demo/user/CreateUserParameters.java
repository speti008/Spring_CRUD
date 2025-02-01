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
public class CreateUserParameters {
    private final UserName userName;
    private final Gender gender;
    private final LocalDate birthday;
    private final Email email;
    private final PhoneNumber phoneNumber;
    
   public CreateUserParameters(UserName userName,
                        Gender gender,
                        LocalDate birthday,
                        Email email,
                        PhoneNumber phoneNumber)
   {
       this.birthday = birthday;
       this.gender = gender;
       this.phoneNumber = phoneNumber;
       this.userName = userName;
       this.email = email;
   }
   
   public UserName getUserName()
   {
       return userName;
   }
   public Gender getGender()
   {
       return gender;
   }
   
   public Email getEmail()
   {
       return email;
   }
   public PhoneNumber getPhoneNumber()
   {
       return phoneNumber;
   }
   public LocalDate getBirthday()
   {
       return birthday;
   }
}
