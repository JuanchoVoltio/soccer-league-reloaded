package soccerleague;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import soccerleague.constants.PlayerPosition;
import soccerleague.controller.Controller;
import soccerleague.model.Database;
import soccerleague.model.DatabaseException;
import soccerleague.model.dto.Player;
import soccerleague.model.dto.Storable;
import soccerleague.util.UtilSL;

/**
 * Class used only for test purposes
 */
public class Main {

	public static void main(String... args) {
		/*
		 * if(updateMethodShouldReturnOk()){ System.out.println("Pass"); }else{
		 * System.out.println("Ooops!!"); }
		 */
		cargar();

	}

	private static void cargar() {
		Database db = new Database();
		Player testPlayer = new Player("matias",PlayerPosition.GK,1,20,6500800,2000000);
		Player testPlayer1 = new Player("Juan",PlayerPosition.DF,1,27,6500801,2100000);
		Player testPlayer2 = new Player("pedro",PlayerPosition.MD,1,40,6500802,3000000);
		Player testPlayer3 = new Player("marcos",PlayerPosition.FW,1,30,6500800,1800000);
		Player testPlayer4 = new Player("lucas",PlayerPosition.GK,1,20,6500800,2000000);
		try {
			db.save(testPlayer);
			db.save(testPlayer1);
			db.save(testPlayer2);
			db.save(testPlayer3);
			db.save(testPlayer4);
		//	db.getAllPlayers().forEach(p -> System.out.println("Nombre ("  + p.getName() + ") -  Edad (" + p.getAge() + ")"));
			System.out.println("----------------------------------------------");
			/**  */
			Controller c = new Controller(db);

			
			Predicate<Player>  allvotingPlayer = p -> p.getAge() >= 21;
			
			//Predicate<Storable>  p = p -> p. >= 21 ;
			List<Player> jugadores = db.getAllPlayers();
			List<Storable> lst = new ArrayList<Storable>();
			for (Player player : jugadores) {
				Storable s = player;
				lst.add(s);
			}
			UtilSL.printData(lst, allvotingPlayer);
			
			System.exit(0);
			
			c.removeByCriterion(lst, allvotingPlayer);
			c.getDb().getAllPlayers().forEach(p -> System.out.println("Nombre ("  + p.getName() + ") -  Edad (" + p.getAge() + ")"));
			
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}

	public static boolean testMetodoSaveIsOk(){
		Database db = new Database();

		Player testPlayer = new Player("Juan");
		Player testPlayer2 = new Player("Pedro");

		try {
			db.save(testPlayer);
			db.save(testPlayer2);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}

		return true;

	}

	public static boolean saveMethodShouldThrowExceptionWhenDuplicateEntry(){
		Database db = new Database();

		Player testPlayer = new Player("Juan");

		try {
			db.save(testPlayer);
			db.save(testPlayer);
		} catch (DatabaseException e) {
			return true;
		}

		return false;

	}

	public static boolean removeMethodShouldRemoveDto(){
		Database db = new Database();

		Player testPlayer = new Player("Juan");

		db.remove(testPlayer);

		db.remove(testPlayer);

		return db.playersListSize() == 0;

	}

	/**
	public static boolean updateMethodShouldReturnOk(){
		Database db = new Database();
		String initalPosition = Player.POSITION_GK;
		String newPosition = Player.POSITION_DF;

		Player testPlayer = new Player("Juan", initalPosition, 23);
		Player updatedTestPlayer = new Player("Juan", newPosition, null);

		try {
			db.save(testPlayer);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}

		db.update(updatedTestPlayer);

		return testPlayer.getPosition().equals(newPosition);

	}*/

}