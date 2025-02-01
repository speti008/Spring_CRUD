/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.user;

import io.github.wimdeblauwe.jpearl.AbstractEntityId;
import java.util.UUID;

/**
 *
 * @author stephensonpetit-homme
 */
public class UserId extends AbstractEntityId<UUID> { 
    
    protected UserId(){ 
        
    }
    public UserId(UUID id) 
    {
        // <,>
        super(id);
    }
}
