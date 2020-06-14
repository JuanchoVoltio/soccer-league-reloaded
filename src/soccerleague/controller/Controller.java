package soccerleague.controller;

import constants.PlayerPosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import soccerleague.model.Database;
import soccerleague.model.DatabaseException;
import soccerleague.model.dto.Player;
import soccerleague.model.dto.Storable;
import soccerleague.model.dto.Team;
import static constants.PlayerPosition.*;

public class Controller{
    
      private Database db = new Database();
      
      private Function<Team, Integer> defenseProbability = t -> {
                                                                List df = Arrays.asList(t.getLineup()).stream().filter(p -> p.getPosition() == DF).collect(Collectors.toList());
                                                                return (df.size()*25)-50;
                                                            };
    
      private Function<Team, Integer> attackProbability = t -> {
                                                                List gk = Arrays.asList(t.getLineup()).stream().filter(p -> p.getPosition() == FW).collect(Collectors.toList());
                                                                return (gk.size()*25);
                                                            };
    
//Get and SET methods----------------------------------------------------
    
    public void setDb(Database db){
        this.db = db;
    }
    
    public Database getDb(){
        return db;
    }
    
       
//Other Methods---------------------------------------------------------------  
    
    public void saveValidateTeam(Team team, Predicate<Team> teamSizeRule, Predicate<Team> fixedPositionRules, BiPredicate<Team, Collection<Team>> exclusivePlayerRule) {
	
        if (teamSizeRule.test(team) && fixedPositionRules.test(team) && exclusivePlayerRule.test(team, db.getTeam())){
            try {
                db.save(team);       
            } catch (DatabaseException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            System.out.println("FELICIDADES! el equipo esta inscrito\n");
                
            team.setDefenseProbability(defenseProbability.apply(team));
            team.setAttackProbability(attackProbability.apply(team));
                
            System.out.println("Defense probability: "+team.getNameTeam()+" "+team.getDefenseProbability()+"%");
            System.out.println("Attack probability: "+team.getNameTeam()+" "+team.getAttackProbability()+"%");

        }else{
            System.out.println("El equipo no es valido porqué:");
            if (!teamSizeRule.test(team))
                System.out.println("Faltan jugadores");
            if (!fixedPositionRules.test(team))
                System.out.println("La alineación no es permitida");
            if (!exclusivePlayerRule.test(team, db.getTeam()))
                System.out.println("Hay jugadores repetidos");
        }
        
     db.getTeam().forEach(y -> System.out.println(y));
    
    }
    
    public void toUpperCasePlayerNames2(Predicate<Player> p){
        
        db.getJugadores().stream().filter(p).forEach( pl -> System.out.println(pl.getName().toUpperCase()));
    
    }

    
    public boolean validateTeam(Team team, Predicate<Team> teamSizeRule, Predicate<Team> fixedPositionRules, BiPredicate<Team, Collection<Team>> exclusivePlayerRule) {
	
        return teamSizeRule.test(team) && fixedPositionRules.test(team) || exclusivePlayerRule.test(team, db.getTeam());
    
    }
     
    
    public void addStorable2(Collection<Storable> list, Predicate<Storable> p){
        list.stream().filter(p).forEach(pl -> {
            try {
                db.save(pl);
            } catch (DatabaseException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        db.getJugadores().forEach(x -> System.out.println(x));
        db.getTeam().forEach(y -> System.out.println(y));
    }
        
    
    public void addStorable(Collection<Storable> list, Predicate<Storable> p){
        list.stream().filter(p).forEach(pl -> {
            try {
                db.save(pl);
            } catch (DatabaseException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
         db.getJugadores().forEach(x -> System.out.println(x));
         db.getTeam().forEach(y -> System.out.println(y));
    }
    
    
    
    public void addPlayer(Collection<Player> list, Predicate<Player> p){
        list.stream().filter(p).forEach(pl -> {
            try {
                db.save(pl);
            } catch (DatabaseException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public void addTeam(Collection<Team> list, Predicate<Team> p){
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
            if(finder.test(current)){ //Aplicar criterio de selecci�n establecido en el lambda
                result.add(current);
            }
        }

        return result; // Retornar los jugadores que coincid�an con el criterio de selecci�n.
    }   
}