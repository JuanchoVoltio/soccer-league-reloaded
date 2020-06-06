package soccerleague.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import soccerleague.model.Database;
import soccerleague.model.DatabaseException;
import soccerleague.model.dto.Player;
import soccerleague.model.dto.Storable;

public class Controller{
    
      private Database db = new Database();
    
//Get and SET methods----------------------------------------------------
    
    public void setDb(Database db){
        this.db = db;
    }
    
    public Database getDb(){
        return db;
    }
    
//Other Methods---------------------------------------------------------------
    
    public void addStorable(Collection<Storable> list, Predicate<Storable> p){
        list.stream().filter(p).forEach(pl -> {
            try {
                db.save(pl);
            } catch (DatabaseException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    


    public void toUpperCasePlayerNames(Predicate<Player> p){
        db.getJugadores().stream().filter(p).forEach(pl -> System.out.println(pl.getName().toUpperCase()));
    }
    
           
    public List<Player> findPlayers(Predicate<Player> finder){
        List<Player> result = new ArrayList<>();

        for(Player current : db.getJugadores()){ //Obtener todos los jugadores de la base de datos
            if(finder.test(current)){ //Aplicar criterio de selección establecido en el lambda
                result.add(current);
            }
        }

        return result; // Retornar los jugadores que coincidían con el criterio de selección.
    }   
}