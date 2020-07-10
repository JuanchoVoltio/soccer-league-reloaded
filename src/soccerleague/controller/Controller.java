package soccerleague.controller;


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
import static soccerleague.constants.PlayerPosition.*;

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



	public void saveValidateTeam(Team team, Predicate<Team> teamSizeRule, Predicate<Team> fixedPositionRules, BiPredicate<Team, Collection<Team>> exclusivePlayerRule) {

		if (teamSizeRule.test(team) && fixedPositionRules.test(team) && exclusivePlayerRule.test(team, db.getAllTeams())){

			try {
				db.save(team);
			} catch (DatabaseException ex) {
				Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
			}

			System.out.println("\nFELICIDADES! el equipo " + team.getNameTeam().toUpperCase() + " esta inscrito\n");

			team.setDefenseProbability(defenseProbability.apply(team));
			team.setAttackProbability(attackProbability.apply(team));

			System.out.println("Defense probability: "+team.getNameTeam()+" "+team.getDefenseProbability()+"%");
			System.out.println("Attack probability: "+team.getNameTeam()+" "+team.getAttackProbability()+"%");

		}else{
			System.out.println("\nERROR! el equipo " + team.getNameTeam().toUpperCase() + " no es valido porqué:");
			if (!teamSizeRule.test(team))
				System.out.println("Faltan jugadores");
			if (!fixedPositionRules.test(team))
				System.out.println("La alineación no es permitida");
			// if (!exclusivePlayerRule.test(team, ))
			if (!exclusivePlayerRule.test(team, db.getAllTeams()))
				System.out.println("Hay jugadores que están registrados en otros equipos");

		}



	}

	public void printTeams(){
		db.getAllTeams().forEach(y -> System.out.println(y));
	}

	public void toUpperCasePlayerNames2(Predicate<Player> p){

		db.getAllPlayers().stream().filter(p).forEach( pl -> System.out.println(pl.getName().toUpperCase()));

	}


	public boolean validateTeam(Team team, Predicate<Team> teamSizeRule, Predicate<Team> fixedPositionRules, BiPredicate<Team, Collection<Team>> exclusivePlayerRule) {

		return teamSizeRule.test(team) && fixedPositionRules.test(team) || exclusivePlayerRule.test(team, db.getAllTeams());

	}


	public void addStorable2(Collection<Storable> list, Predicate<Storable> p){
		list.stream().filter(p).forEach(pl -> {
			try {
				db.save(pl);
			} catch (DatabaseException ex) {
				Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
			}
		});

		db.getAllPlayers().forEach(x -> System.out.println(x));
		db.getAllTeams().forEach(y -> System.out.println(y));
	}


	public void addStorable(Collection<Storable> list, Predicate<Storable> p){
		list.stream().filter(p).forEach(pl -> {
			try {
				db.save(pl);
			} catch (DatabaseException ex) {
				Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
			}
		});

		db.getAllPlayers().forEach(x -> System.out.println(x));
		db.getAllTeams().forEach(y -> System.out.println(y));
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
		db.getAllPlayers().stream().filter(p).forEach(pl -> System.out.println(pl.getName().toUpperCase()));
	}


	public List<Player> findPlayers(Predicate<Player> finder){
		List<Player> result = new ArrayList<>();

		for(Player current : db.getAllPlayers()){ //Obtener todos los jugadores de la base de datos
			if(finder.test(current)){ //Aplicar criterio de selecci�n establecido en el lambda
				result.add(current);
			}
		}

		return result; // Retornar los jugadores que coincid�an con el criterio de selecci�n.
	}
}