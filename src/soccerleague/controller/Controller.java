package soccerleague.controller;

import soccerleague.controller.finders.PlayerFinder;
import soccerleague.model.Database;
import soccerleague.model.dto.Player;
import soccerleague.model.dto.Storable;
import soccerleague.model.dto.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import soccerleague.Main;
import soccerleague.controller.finders.TeamFinder;
import soccerleague.model.DatabaseException;

public class Controller{

    public boolean validateStorable(Storable subjectToValidate){
       //Use generics here.

        throw new UnsupportedOperationException("Method not supported yet");
    }

    public List<Player> findPlayers(PlayerFinder finder){
        List<Player> result = new ArrayList<>();

        for(Player current : Main.getDb().getAllPlayers()){ //Obtener todos los jugadores de la base de datos
            if(finder.validacion(current)){ //Aplicar criterio de selección establecido en el lambda
                result.add(current);
            }
        }

        return result; // Retornar los jugadores que coincidían con el criterio de selección.
    }
    
    public List<Team> findTeams(TeamFinder buscador){
        List<Team> lista = new ArrayList();
        for(Team equipo: Main.getDb().getAllTeams()){
            if(buscador.valido(equipo)){
                lista.add(equipo);
            }
        } 
        return lista;
    }
    
    public void guardarJugadores(Predicate<Player> selector, List<Player> ingreso) throws DatabaseException{
        for(Player jugador: ingreso){
            if(selector.test(jugador)){
                Main.db.save(jugador);
            }
        } 
    }
    
    public void guardarEquipos(Predicate<Team> selector, List<Team> ingreso) throws DatabaseException{
        for(Team equipo: ingreso){
            if(selector.test(equipo)){
                Main.db.save(equipo);
            }
        } 
    }

}