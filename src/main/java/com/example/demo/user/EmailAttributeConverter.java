/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.user;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 *
 * @author stephensonpetit-homme
 */

@Converter(autoApply = true)
public class EmailAttributeConverter implements AttributeConverter<Email,String> {
    
    @Override
    public String convertToDatabaseColumn(Email attribute){
        return attribute.asString();
    }
    
    @Override
    public Email convertToEntityAttribute(String dbData)
    {
        return new Email(dbData);
    }    
}
