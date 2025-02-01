/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.user;

import com.google.common.collect.ImmutableSet;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author stephensonpetit-homme
 */
public interface UserService {
    User createUser(CreateUserParameters parameters);
    //Page<User> getUsers(Pageable pageable);
    boolean userWithEmailExists(Email email);
    //ImmutableSet<User> getAllUsers();
    Page<User> getUsers(Pageable pageable);
    User editUser(UserId userId, EditUserParameters parameters);
    Optional<User> getUser(UserId userId);
    void deleteUser(UserId userId);
    
    //infinite scrolling
    //Page<User> getUsers(int page, int size);
    
}

//public interface UserService {
//    
//        User createUser(CreateUserParameters parameters);
//        //Iterable<User> saveAllUsers(List<User> users);
//        //User createUser(CreateUserParameters parameters);
//        Page<User> getUsers(Pageable pageable);
//}
