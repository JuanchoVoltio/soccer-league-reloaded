package soccerleague;

import soccerleague.constants.PlayerPosition;
import soccerleague.controller.Controller;
import soccerleague.controller.comparators.PlayersByPositionComparator;
import soccerleague.controller.comparators.PlayersCompositeComparator;
import soccerleague.controller.finders.FinderByAge;
import soccerleague.controller.finders.FinderByAgeRange;
import soccerleague.controller.finders.PlayerFinder;
import soccerleague.model.Database;
import soccerleague.model.DatabaseException;
import soccerleague.model.dto.Player;
import soccerleague.controller.keeping.PlayerSave;

import java.util.*;

/**
 * Class used only for test purposes
 */
public class Main {

    public static void main(String... args) {
    	  
        if(testMetodoSaveIsOk()){
            System.out.println("Pass");
        }else{
            System.out.println("Ooops!!");
        }
        
        testMethodImplementationInsideAClass();
    }

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
       

//        Storable testPlayer = new Player("Juan", PlayerPosition.DF, 10);
//        testPlayer.printClassType();

//   }

    public static boolean testMetodoSaveIsOk(){
        Database db = new Database();

                
        Player testPlayer = new Player("Juan", PlayerPosition.DF, 10);
        Player testPlayer1 = new Player("Pedro", PlayerPosition.DF, 15);
        Player testPlayer2 = new Player("Nombre", PlayerPosition.FW, 10);
        Player testPlayer3 = new Player("ZNombre", PlayerPosition.GK, 11);
        Player testPlayer4 = new Player("HNombre", PlayerPosition.MD, 15);
        Player testPlayer5 = new Player("LNombre", PlayerPosition.DF, 5);
        Player testPlayer6 = new Player("QNombre", PlayerPosition.FW, 1);
        
        List<Player> unsortedPlayers = new ArrayList<>();
        
        unsortedPlayers.add(testPlayer);
        unsortedPlayers.add(testPlayer1);
        unsortedPlayers.add(testPlayer2);
        unsortedPlayers.add(testPlayer3);
        unsortedPlayers.add(testPlayer4);
        unsortedPlayers.add(testPlayer5);
        unsortedPlayers.add(testPlayer6);
        
        try {
        	
            db.save(testPlayer);
            db.save(testPlayer1);
            db.save(testPlayer2);
            db.save(testPlayer3);
            db.save(testPlayer4);
            db.save(testPlayer5);
            db.save(testPlayer6);
         
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        return true;

    }

    public static boolean saveMethodShouldThrowExceptionWhenDuplicateEntry(){
        Database db = new Database();

        Player testPlayer = new Player("Juan", PlayerPosition.DF, 10);

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
    // Verificar con Henry si quisiera asignar player position que tipo de variable es (int, string?)
    
    public static boolean updateMethodShouldReturnOk(){
        Database db = new Database();
        
        Player testPlayer = new Player("Juan", PlayerPosition.DF, 23);
        Player updatedTestPlayer = new Player("Juan", PlayerPosition.FW, 30);

        try {
            db.save(testPlayer);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        db.update(updatedTestPlayer);

        return testPlayer.getPosition().equals(updatedTestPlayer.getPosition());

    }

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

        Collections.sort(unsortedPlayers, new PlayersByPositionComparator());

        unsortedPlayers.forEach(p -> System.out.println(p));
        System.out.println("----------");

        Collections.sort(unsortedPlayers, new PlayersCompositeComparator());

        unsortedPlayers.forEach(p -> System.out.println(p));

        return;
    }

    /*--- TEST FUNCTIONAL INTERFACES AND LAMBDA EXPRESSIONS  -----*/

    public static void testMethodImplementationInsideAClass(){
        Controller controller = new Controller();

        int maxSalary = 1000;
        int minSalary = 500;
        int desiredAge = 22;

        PlayerFinder finder1 = new FinderByAgeRange(20, 25);
        PlayerFinder finder2 = new FinderByAge(25);
        controller.findPlayers(finder1); //1. Usando objetos para inyectar la lógica

        controller.findPlayers(new PlayerFinder(){ //2. Usando una clase anónima para evitar el problema de 1.
                                        @Override
                                        public boolean isValid(Player p) {
                                            return p.getSalary().intValue() <= maxSalary;
                                        }});

        List<Player> result1 = controller.findPlayers((Player p) -> (p.getSalary().intValue() >= minSalary) && (p.getAge() == desiredAge)); //3. Simplificar la solución planteada en  2.

        result1.forEach(p -> System.out.println(p));
        
        List<Player> result = controller.SaveByPosition((Player p) -> (p.getPosition() == PlayerPosition.DF));
        result.forEach(p -> System.out.println(p));
    }


}