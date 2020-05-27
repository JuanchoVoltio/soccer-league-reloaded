package soccerleague.controller;

import soccerleague.controller.finders.PlayerFinder;
import soccerleague.controller.keeping.PlayerSave;
import soccerleague.model.Database;
import soccerleague.model.dto.Player;
import soccerleague.model.dto.Storable;
import soccerleague.model.dto.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller{

    Database db = new Database();

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
    
	public List<Player> saveByPosition(Collections playerToAdd, PlayerSave savePosition) {
		
		List<Player> result = new ArrayList<>();
						
		for(Player current : playerToAdd()) {
			if(savePosition.isValid(current)) {
				result.add(current);								
			}
		}
		
		db.saveAll(result);
		
		throw new UnsupportedOperationException();
	
	}
	
}
