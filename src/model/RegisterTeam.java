/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Java11
 */
public class RegisterTeam {
    
    
    ArrayList<Team> teamsFinal = new ArrayList<Team>();
    
    public boolean createdTeam(ArrayList<Team> teamsIdto){
        for (Team team : teamsIdto) {
            //validate(team);
            //vlidaciones
            teamsFinal.add(team);
            
   //     System.out.println(team.getNameTeam()+" "+team.getCodeTeam());
            
        }
        return true;
    }

    
}