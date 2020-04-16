/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Java11
 */
public class SoccerGame {

    private Team idTeamLocal;
    private Team idTeamVisited;

    /**
     * @return the idTeamLocal
     */
    public Team getIdTeamLocal() {
        return idTeamLocal;
    }

    /**
     * @param idTeamLocal the idTeamLocal to set
     */
    public void setIdTeamLocal(Team idTeamLocal) {
        this.idTeamLocal = idTeamLocal;
    }

    /**
     * @return the idTeamVisited
     */
    public Team getIdTeamVisited() {
        return idTeamVisited;
    }

    /**
     * @param idTeamVisited the idTeamVisited to set
     */
    public void setIdTeamVisited(Team idTeamVisited) {
        this.idTeamVisited = idTeamVisited;
    }

}