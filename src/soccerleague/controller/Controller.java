package soccerleague.controller;

import soccerleague.controller.finders.PlayerFinder;
import soccerleague.model.Database;
import soccerleague.model.dto.Player;
import soccerleague.model.dto.Storable;
import soccerleague.model.dto.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Controller{

	private Database db = new Database();

	public Controller(){

	}

	public Controller(Database db){
		this.db = db;
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

	public Boolean addPlayer(Player player, Team team) {
		Boolean almaceno = false;
		if(!playerInTeam(player)) {
			//Proceso para adicionar
		}
		
		return almaceno;
	}

	public boolean playerInTeam(Player playerIn) {
		Boolean alreadyInTeam = false;
		List<Team> equipos = db.getAllTeams();
		for (Team equipo : equipos) {
			Player[] players =  equipo.getPlayers();
			Predicate<Player>  PlayerName = p -> p.getName().equals(playerIn.getName());
					
			//Ejemplo con findAny
			//Arrays.asList(players).stream().findAny().filter(PlayerName);
			
			//Busca con equals
			//alreadyInTeam = Arrays.asList(players).stream().equals(playerIn);
			
			int contador = (int) Arrays.asList(players).stream().filter(PlayerName).count();
			if(contador > 0) {
				alreadyInTeam = true;
				break;
			}
			
		}
		
		return alreadyInTeam;
	}
	
	
	public void removeByCriterion(List<Storable> lstdto, Predicate pred){
		
		if(lstdto != null && !lstdto.isEmpty()) {
			for (Storable storable : lstdto) {
				if(pred.test(storable)) {
					db.remove((storable));
				}
			}
			
		}
	}

	public Database getDb(){ return this.db;}
}
