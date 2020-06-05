package soccerleague.controller;


import soccerleague.constants.PlayerPosition;
import soccerleague.controller.finders.PlayerFinder;
import soccerleague.model.Database;
import soccerleague.model.DatabaseException;
import soccerleague.model.dto.Player;
import soccerleague.model.dto.Storable;
import soccerleague.model.dto.Team;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;


public class Controller {


	Database db = new Database();

	public boolean validateStorable(Storable subjectToValidate) {
		//Use generics here.

		throw new UnsupportedOperationException("Method not supported yet");
	}

	public boolean validateTeam(List<Player> players, Predicate<Player> p) {

		int df = 0, fw = 0, md = 0, gk = 0;
		int sumPosition = df + fw;
		for(Player current : players){
			if (players.size() == 11 && p.test(current)) {
				if(current.getPosition().getCode().intValue() == 1){
					df++;
				}else if(current.getPosition().getCode().intValue() == 2){
					gk++;
				}else if(current.getPosition().getCode().intValue() == 3) {
					md++;
				}else if(current.getPosition().getCode().intValue() == 4) {
					fw++;
				}
			}
		}

		if (sumPosition == 6 && gk == 1 && md == 4 && df > 0 && fw > 0);{
			if (df == 4 && fw == 2) {
				System.out.print("Formación: " + gk + "-" + df + "-" + md + "-" + fw);
			}else if (df == 3 && fw == 3) {
					System.out.print("Formación: " + gk + "-" + df + "-" + md + "-" + fw);
			}
		}

		return false;

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

	
