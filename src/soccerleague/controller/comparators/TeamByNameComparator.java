/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccerleague.controller.comparators;

import java.util.Comparator;
import soccerleague.model.dto.Team;

/**
 *
 * @author Nicolas
 */
public class TeamByNameComparator implements Comparator<Team>{
    @Override
    public int compare(Team o1, Team o2) {
        int result;
        result = o1.getNameTeam()
                        .compareTo(o2.getNameTeam());
        if(result == 0){
            result = (-1) * o1.getCodeTeam().compareTo(o2.getCodeTeam());
        }
        return result;
    }  
}
