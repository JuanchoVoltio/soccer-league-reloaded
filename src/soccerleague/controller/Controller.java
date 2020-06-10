package soccerleague.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import soccerleague.model.Database;
import soccerleague.model.dto.Player;

public class Controller{
    
      public static Database db = new Database();
    
//Get and SET methods----------------------------------------------------
    
    public void setDb(Database db){
        this.db = db;
    }
    
    public Database getDb(){
        return db;
    }
    
//Other Methods---------------------------------------------------------------
    
    public List<Player> findPlayers(Predicate<Player> finder){
        List<Player> result = new ArrayList();

        for(Player current : db.getJugadores()){ //Obtener todos los jugadores de la base de datos
            if(finder.test(current)){ //Aplicar criterio de selección establecido en el lambda
                result.add(current);
            }
        }

        return result; // Retornar los jugadores que coincidían con el criterio de selección.
    }
    
    
}
