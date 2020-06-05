package soccerleague.controller;

import soccerleague.constants.PlayerPosition;

import soccerleague.controller.finders.PlayerFinder;

import soccerleague.model.Database;
import soccerleague.model.DatabaseException;
import soccerleague.model.dto.Player;
import soccerleague.model.dto.Storable;
import soccerleague.model.dto.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;



public class Controller{

   Database db = new Database(); // voruebergehend ....

   public void createPlayers(){
	   //Database db = new Database();
   	
	   Player Player1 = new Player("Pepe", PlayerPosition.DF,1);
       Player Player2 = new Player("Lucas",PlayerPosition.DF,2);
       Player Player3 = new Player("Lucas-G",PlayerPosition.DF,3);
       Player Player4 = new Player("Guerrero", PlayerPosition.GK,4);
       Player Player5 = new Player("Ronaldo",PlayerPosition.DF,5);
       Player Player6 = new Player("Batistuta",PlayerPosition.DF,6);
       Player Player7 = new Player("Silva", PlayerPosition.GK,7);
       Player Player8 = new Player("Perales",PlayerPosition.DF,8);
       Player Player9 = new Player("Gomez",PlayerPosition.DF,9);
       Player Player10 = new Player("Schweinsteiger", PlayerPosition.GK,10);
       Player Player11 = new Player("Ozil",PlayerPosition.DF,11);

       
       try {
           
           db.saveAll(Arrays.asList(Player1, Player2,Player3,Player4,Player5,Player6,Player7,Player8,Player9,Player10,Player11));         
           //db.saveAll(Arrays.asList(Player12, Player13, Player14,Player15,Player16,Player17,Player18,Player19,Player20,Player21  ));
     
           
       } catch (DatabaseException e) {
           e.printStackTrace();
       } finally { 
       	        
       }
       db.showPlayers();
	
   }
   
    public boolean validateStorable(Storable subjectToValidate){
       //Use generics here.

        throw new UnsupportedOperationException("Method not supported yet");
    }

    public List<Player> findPlayers(PlayerFinder finder){
        List<Player> result = new ArrayList<>();

        for(Player current : db.getAllPlayers()){ //Obtener todos los jugadores de la base de datos
            if(finder.isValid(current)){ //Aplicar criterio de selección establecido en el lambda
                result.add(current);
            }
        }

        return result; // Retornar los jugadores que coincidían con el criterio de selección.
    }

    
    public List<Player> findPlayersUsingPredicate(Predicate<Player> criteria){
        List<Player> result = new ArrayList<>();

        for(Player current : db.getAllPlayers()){ //Obtener todos los jugadores de la base de datos
            if(criteria.test(current)){ //Aplicar criterio de selección establecido en el lambda
                result.add(current);
            }
        }

        return result; // Retornar los jugadores que coincidían con el criterio de selección.
    }
    
    
    public void toUpperCasePlayerNames(Predicate<Player> p){
        db.getAllPlayers().stream().filter(p).forEach( pl -> System.out.println(pl.getName().toUpperCase()));
    }
    

    
    public boolean validatePositionPlayers ( Predicate<List<Player>> criteria ) 
    {
        return criteria.test(db.getAllPlayers()) ;
    }     

    
    
    
    /*
    public boolean validatePositionPlayers (Predicate<List<Player>> criteria) {
    	///  for(Player current : db.getAllPlayers()){ //Obtener todos los jugadores de la base de datos
        //      if (criteria.test(current))  //Aplicar criterio de selección establecido en el lambda
       //    	  return true;  
       //   }
          
    	 // for(Player current : ){ //Obtener todos los jugadores de la base de datos
            if (criteria.test(db.getAllPlayers() ))  //Aplicar criterio de selección establecido en el lambda
            	  return true;
          
    return true;
    }
   */ 
    
}

    