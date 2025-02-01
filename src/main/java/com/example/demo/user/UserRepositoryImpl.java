/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.user;

import io.github.wimdeblauwe.jpearl.UniqueIdGenerator;
import java.util.UUID;

/**
 *
 * @author stephensonpetit-homme
 */


public class UserRepositoryImpl implements UserRepositoryCustom{
    private final UniqueIdGenerator<UUID> generator;
    
    public UserRepositoryImpl(UniqueIdGenerator<UUID> generator)
    {
        this.generator = generator;
    }
    
    @Override
    public UserId nextId()
    {
        return new UserId(generator.getNextUniqueId());
    }
}
