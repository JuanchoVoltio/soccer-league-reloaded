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
import java.util.function.BiPredicate;
import java.util.function.Predicate;


public class Controller {

	private Database db = new Database();

	public boolean validateStorable(Storable subjectToValidate) {
		//Use generics here.

		throw new UnsupportedOperationException("Method not supported yet");
	}

	public List<Player> findPlayers(PlayerFinder finder) {
		List<Player> result = new ArrayList<>();

		for (Player current : db.getAllPlayers()) { // Obtener todos los jugadores de la base de datos
			if (finder.isValid(current)) {  // Aplicar criterio de selección establecido en el lambda
				result.add(current);
			}
		}

		return result; // Retornar los jugadores que coincidían con el criterio de selección.
	}

	public List<Player> findPlayersUsingPredicate(Predicate<Player> criteria) {
		List<Player> result = new ArrayList<>();

		for (Player current : db.getAllPlayers()) { //Obtener todos los jugadores de la base de datos
			if (criteria.test(current)) { //Aplicar criterio de selección establecido en el lambda
				result.add(current);
			}
		}

		return result; // Retornar los jugadores que coincidían con el criterio de selección.
	}

	public void toUpperCasePlayerNames(Predicate<Player> p) {
		db.getAllPlayers().stream().filter(p).forEach(pl -> System.out.println(pl.getName().toUpperCase()));
	}

    /**
     * Este método nalida el equipo en función de la reglas de negocio (predicates) entregadas como parametros
     * @param team
     * @param teamSizeRule
     * @param fixedPositionRules
     * @param exclusivePlayerRule
     * @return
     */

	public boolean validateTeam(Team team, Predicate<Team> teamSizeRule, Predicate<Team> fixedPositionRules, BiPredicate<Team, Collection<Team>> exclusivePlayerRule) {
		return teamSizeRule.test(team) && fixedPositionRules.test(team) && exclusivePlayerRule.test(team, db.getAllTeams());
	}


}