/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.user;

import io.github.wimdeblauwe.jpearl.AbstractEntity;
//import io.github.wimdeblauwe.jpearl.AbstractVersionedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
//import javax.persistence.Entity;

/**
 *
 * @author stephensonpetit-homme
 */
@Entity
@Table(name = "tt_user")
public class User extends AbstractEntity<UserId> {

    @NotNull
    private UserName userName;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @NotNull
    private LocalDate birthday;
    
    @NotNull
    private Email email;
    @NotNull
    private PhoneNumber phoneNumber;

    protected User() {
    }

//    public User(UserId id) {
//        // <,>
//        super(id);
//    }

    public User(UserId id,
            UserName userName,
            Gender gender,
            LocalDate birthday,
            Email email,
            PhoneNumber phoneNumber) {
        super(id);
        this.userName = userName;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public UserName getUserName() {
        return userName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Email getEmail() {
        return email;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setUserName(UserName userName)
    {
        this.userName = userName;
    }
    
    public void setGender(Gender gender)
    {
        this.gender = gender;
    }
    
    public void setBirthday(LocalDate birthday)
    {
        this.birthday = birthday;
    }
    
    public void setEmail(Email email)
    {
        this.email = email;
    }
    
    public void setPhonenumber(PhoneNumber phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
}
