/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.team;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author stephensonpetit-homme
 */

@Service
public class TeamServiceImpl implements TeamService {
    
    public TeamServiceImpl(){}
    
    @Override
    public List<Team> getTeams()
    {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team(1, "Initiates"));
        teams.add(new Team(2, "Knights"));
        teams.add(new Team(3, "Padawans"));
        teams.add(new Team(4, "Rookies"));
        teams.add(new Team(5, "Wizards"));
        
        return teams;
    }
}
