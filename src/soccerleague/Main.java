package soccerleague;

import soccerleague.model.Database;
import soccerleague.model.DatabaseException;
import soccerleague.model.dto.Player;

/**
 * Class used only for test purposes
 */
public class Main {

    public static void main(String... args) {
        if(updateMethodShouldReturnOk()){
            System.out.println("Pass");
        }else{
            System.out.println("Ooops!!");
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

    public static boolean updateMethodShouldReturnOk(){
        Database db = new Database();
        String initalPosition = "GK";
        String newPosition = "DF";

        Player testPlayer = new Player("Juan", initalPosition, 23);
        Player updatedTestPlayer = new Player("Juan", newPosition, null);

        try {
            db.save(testPlayer);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        db.update(updatedTestPlayer);

        return testPlayer.getPosition().equals(newPosition);

    }

}