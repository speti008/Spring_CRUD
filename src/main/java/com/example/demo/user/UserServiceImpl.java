/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.user;
//import com.example.demo.user.

import com.google.common.collect.ImmutableSet;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.orm.ObjectOptimisticLockingFailureException;



/**
 *
 * @author stephensonpetit-homme
 */

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    
    public UserServiceImpl(UserRepository repository)
    {
        this.repository = repository;
    }
    
    @Override
    public User createUser(CreateUserParameters parameters)
    {
        if(repository.existsByEmail(parameters.getEmail()))
        {
            throw new IllegalArgumentException("Email already exists");
        }
        UserId userId = repository.nextId();
        User user = new User(userId,
                             parameters.getUserName(),
                             parameters.getGender(),
                             parameters.getBirthday(),
                             parameters.getEmail(),
                             parameters.getPhoneNumber());
        return repository.save(user);
    }
       
    @Override
    @Transactional(readOnly = true)
    public Page<User> getUsers(Pageable pageable)
    {
        return repository.findAll(pageable);
    }
    
    @Override
    public User editUser(UserId userId, EditUserParameters parameters)
    {
        User user = repository.findById(userId)
                                .orElseThrow(() -> new UserNotFoundException(userId));
        
//        if(parameters.getVersion() != user.getVersion())
//        {
//            throw new ObjectOptimisticLockingFailureException(User.class, user.getId().asString());
//        }
        parameters.update(user);
        return user;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUser(UserId userId)
    {
        return repository.findById(userId);
    }
    @Override
    public void deleteUser(UserId userId)
    {
        repository.deleteById(userId);
    }
//    @Override
//    public Page<User> getUsers(int page, int size)
//    {
//        Pageable pageable = PageRequest.of(page, size);
//        return repository.findAll(pageable);
//    }
    
//    @Override
//    public ImmutableSet<User> getAllUsers()
//    {
//        return ImmutableSet.copyOf(repository.findAll());
//    }
//    
    @Override
    public boolean userWithEmailExists(Email email)
    {
        return repository.existsByEmail(email);
    }
}
