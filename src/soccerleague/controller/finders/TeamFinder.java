/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccerleague.controller.finders;

import soccerleague.model.dto.Team;

/**
 *
 * @author Nicolas
 */
public interface TeamFinder {
    boolean valido(Team t);
}
