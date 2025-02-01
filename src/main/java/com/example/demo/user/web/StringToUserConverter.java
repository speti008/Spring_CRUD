/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.user.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.example.demo.user.UserId;
import java.util.UUID;

/**
 *
 * @author stephensonpetit-homme
 */

@Component
public class StringToUserConverter implements Converter<String, UserId> {
    //@Override
    public UserId convert(String s)
    {
        return new UserId(UUID.fromString(s));
    }
}
