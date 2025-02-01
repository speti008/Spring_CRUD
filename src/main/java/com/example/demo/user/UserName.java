/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.user;

import org.springframework.util.Assert;
import com.google.common.base.MoreObjects;
//import com.google.common.base.Objects;
import jakarta.persistence.Embeddable;
import java.util.Objects;
/**
 *
 * @author stephensonpetit-homme
 */

@Embeddable
public class UserName {
    private String firstName;
    private String lastName;
    
    protected UserName(){}
    
    public UserName(String firstName, String lastName)
    {
        Assert.hasText(firstName, "firstName cannot be blank");
        Assert.hasText(lastName, "lastName cannot be blank");
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public String getFullName()
    {
        return String.format("%s %s",firstName, lastName);
    }
  
    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(getClass() !=o.getClass() || o == null)
            return false;
        UserName userName = (UserName) o;
        return Objects.equals(firstName, userName.firstName) &&
                Objects.equals(lastName, userName.lastName);
        
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("firstName", firstName)
                          .add("lastName", lastName)
                          .toString();
    }
    
}
