/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.team;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author stephensonpetit-homme
 */
@Controller
@RequestMapping("/teams")
public class TeamController {
    
    private final TeamService service;
    
    public TeamController(TeamService service)
    {
        this.service = service;
    }
    
    @GetMapping
    public String index(Model model)
    {
        //List<Team> teams = service.getTeams();
        //model.addAttribute("teams", teams);
        return "teams/list";
    }
    
}
