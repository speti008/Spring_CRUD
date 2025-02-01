/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.user;

import java.util.Objects;
import com.google.common.base.MoreObjects;
import org.springframework.util.Assert;

/**
 *
 * @author stephensonpetit-homme
 */
public class Email {
    private String email;
    
    protected Email()
    {
    }
    
    public Email(String email)
    {
        Assert.hasText(email, "email cannot be blank");
        Assert.isTrue(email.contains(("@")), "email should contain @ symbol");
        this.email = email;
    }
    public String asString()
    {
        return email;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(o == null || getClass()!=o.getClass())
        {
            return false;
        }
        Email that = (Email) o;
        return Objects.equals(email, that.email);
    }
    
    @Override
    public int hashCode(){
        return Objects.hashCode(email);
    }
    
    @Override 
    public String toString()
    {
        return MoreObjects.toStringHelper(this)
                .add("email", email)
                .toString();
    }
}
