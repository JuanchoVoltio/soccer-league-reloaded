package soccerleague.controller;

import soccerleague.controller.finders.PlayerFinder;
import soccerleague.model.Database;
import soccerleague.model.DatabaseException;
import soccerleague.model.dto.Player;
import soccerleague.model.dto.Storable;
import soccerleague.model.dto.Team;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;


public class Controller{

    
	Database db = new Database();

    public boolean validateStorable(Storable subjectToValidate){
       //Use generics here.

        throw new UnsupportedOperationException("Method not supported yet");
    }

    public List<Player> findPlayers(PlayerFinder finder){
        List<Player> result = new ArrayList<>();

        for(Player current : db.getAllPlayers()){ // Obtener todos los jugadores de la base de datos
            if(finder.isValid(current)){  // Aplicar criterio de selección establecido en el lambda
                result.add(current);
            }
        }

        return result; // Retornar los jugadores que coincidían con el criterio de selección.
    }
    
	public List<Storable> saveWithFilter (List <Storable> objToAdd, Predicate<Storable> filterToAdd)throws DatabaseException {
		
		List<Storable> resultObjToAdd = new ArrayList<>();
						
			for(Storable current : objToAdd ) {
				if(filterToAdd.test(current)) {
					resultObjToAdd.add(current);								
				}
			}
		
			db.saveAll(resultObjToAdd);
		
		throw new UnsupportedOperationException();
	
	}

	public List<Storable> removeWithFilter (List <Storable> objToAdd, Predicate<Storable> filterToAdd){
		
		List<Storable> resultObjToRemove = new ArrayList<>();
						
			for(Storable current : objToAdd ) {
				if(filterToAdd.test(current)) {
					resultObjToRemove.remove(current);								
				}
			}
		

			db.removeAll(resultObjToRemove);
		
		throw new UnsupportedOperationException();
	
	}
}

	
