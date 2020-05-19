package soccerleague;

import soccerleague.constants.PlayerPosition;
import soccerleague.controller.comparators.PlayersByNameComparator;
import soccerleague.controller.comparators.PlayersByPositionComparator;
import soccerleague.controller.comparators.PlayersCompositeComparator;
import soccerleague.model.Database;
import soccerleague.model.DatabaseException;
import soccerleague.model.dto.Player;
import soccerleague.model.dto.Storable;

import java.util.*;

/**
 * Class used only for test purposes
 */
public class Main {

    public static void main(String... args) {
//        if(true){
//            System.out.println("Pass");
//        }else{
//            System.out.println("Ooops!!");
//        }
//
//        Player p = new Player("Nombre", PlayerPosition.DF, 10);
//        Player p2 = new Player("Nombre", PlayerPosition.FW, 10);
//
//        String s = PlayerPosition.getDescriptionFromCode(1);
//        if(s != null) {
//            s.trim();
//        }
//
//        assert removeMethodShouldRemoveDto() : "The List of players is not empty.";
//        assert saveMethodShouldThrowExceptionWhenDuplicateEntry() : "Oooops, saveMethodShouldThrowExceptionWhenDuplicateEntry()";
        shouldOrderThePlayersByNumber();

//        Storable testPlayer = new Player("Juan", PlayerPosition.DF, 10);
//        testPlayer.printClassType();
    }

    public static boolean testMetodoSaveIsOk(){
        Database db = new Database();

        Player testPlayer = new Player("Juan", PlayerPosition.DF, 10);
        Player testPlayer2 = new Player("Pedro", PlayerPosition.DF, 15);

        try {
            db.save(new Player("Juan", PlayerPosition.DF, 10));
            db.save(testPlayer2);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        return true;

    }

    public static boolean saveMethodShouldThrowExceptionWhenDuplicateEntry(){
        Database db = new Database();

//        Player testPlayer = new Player("Juan", PlayerPosition.DF, 10);
//
//        try {
//            db.save(testPlayer);
//            db.save(testPlayer);
//        } catch (DatabaseException e) {
//            return true;
//        }

        return false;

    }

    public static boolean removeMethodShouldRemoveDto(){
        Database db = new Database();

        Player testPlayer = new Player("Juan");

        db.remove(testPlayer);

        db.remove(testPlayer);

        return db.playersListSize() == 0;

    }

    public static void removeMethodShouldRemoveDtoWithAssertions(){
        Database db = new Database();

        Player testPlayer = new Player("Nombre", PlayerPosition.DF, 10);

        db.remove(testPlayer);

        db.remove(testPlayer);

        try {
            db.save(testPlayer);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        assert db.playersListSize() == 0 : "The List of players is not empty, is " + db.playersListSize();

    }

    //TODO: Corregir este método usando los enums.
//    public static boolean updateMethodShouldReturnOk(){
//        Database db = new Database();
//        String initalPosition = Player.POSITION_GK;
//        String newPosition = Player.POSITION_DF;
//
//        Player testPlayer = new Player("Juan", initalPosition, 23);
//        Player updatedTestPlayer = new Player("Juan", newPosition, null);
//
//        try {
//            db.save(testPlayer);
//        } catch (DatabaseException e) {
//            e.printStackTrace();
//        }
//
//        db.update(updatedTestPlayer);
//
//        return testPlayer.getPosition().equals(newPosition);
//
//    }

    public static void shouldOrderThePlayersByNumber(){
        Player testPlayer1 = new Player("Nombre", PlayerPosition.DF, 10);
        Player testPlayer2 = new Player("ZNombre", PlayerPosition.GK, 11);
        Player testPlayer3 = new Player("HNombre", PlayerPosition.DF, 15);
        Player testPlayer4 = new Player("LNombre", PlayerPosition.DF, 5);
        Player testPlayer5 = new Player("QNombre", PlayerPosition.FW, 1);

        List<Player> unsortedPlayers = new ArrayList<>();
        unsortedPlayers.add(testPlayer1);
        unsortedPlayers.add(testPlayer2);
        unsortedPlayers.add(testPlayer3);
        unsortedPlayers.add(testPlayer4);
        unsortedPlayers.add(testPlayer5);

        List test = Arrays.asList("A", "B", "C");

        Collections.sort(unsortedPlayers, new PlayersByPositionComparator());

        unsortedPlayers.forEach(p -> System.out.println(p));
        System.out.println("----------");

        Collections.sort(test, new PlayersCompositeComparator());

        unsortedPlayers.forEach(p -> System.out.println(p));

        return;
    }

}