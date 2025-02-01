/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.team;

import java.util.HashSet;
import java.util.Set;


public class Team {

    private String name;
    private int id;

    /**
     * Default constructor for JPA
     */
    protected Team() {
    }

    public Team(int id,
                String name
                ) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}