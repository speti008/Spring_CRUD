/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.user.web;
import com.example.demo.user.*;

/**
 *
 * @author stephensonpetit-homme
 */
public class EditUserFormData extends CreateUserFormData {
    
    private String id;
    
    public static EditUserFormData fromUser(User user)
    {
        EditUserFormData result = new EditUserFormData();
        result.setId(user.getId().asString());
        result.setFirstName(user.getUserName().getFirstName());
        result.setLastName(user.getUserName().getLastName());
        result.setGender(user.getGender());
        result.setBirthday(user.getBirthday());
        result.setEmail(user.getEmail().asString());
        result.setPhoneNumber(user.getPhoneNumber().asString());
        
        return result;
    }
    
    
    @Override
    public EditUserParameters toParameters()
    {
            return new EditUserParameters(
                                      new UserName(getFirstName(), getLastName()),
                                      getGender(),
                                      getBirthday(),
                                      new Email(getEmail()),
                                      new PhoneNumber(getPhoneNumber()));
    }
    
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
}
