package soccerleague;

import soccerleague.constants.BusinessRules;
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
import soccerleague.model.dto.Storable;
import soccerleague.model.dto.Team;


import java.util.*;
import java.util.function.Predicate;

/**
 * Class used only for test purposes
 */
public class Main {

    public static void main(String... args) {

        Controller controller = new Controller();

        Player testPlayer1 = new Player("Buffon", PlayerPosition.GK, 1, 22, 310000);
        Player testPlayer2 = new Player("Thiago Silva", PlayerPosition.DF, 3, 22, 320000);
        Player testPlayer3 = new Player("J. Cuadrado", PlayerPosition.DF, 4, 22, 330000);
        Player testPlayer4 = new Player("Hummels", PlayerPosition.DF, 2, 22, 130000);
        Player testPlayer5 = new Player("Marcelo", PlayerPosition.DF, 5, 22, 530000);
        Player testPlayer6 = new Player("Tony Kross", PlayerPosition.MD, 8, 22, 830000);
        Player testPlayer7 = new Player("Messi", PlayerPosition.MD, 10, 22, 630000);
        Player testPlayer8 = new Player("Kantè", PlayerPosition.MD, 6, 22, 730000);
        Player testPlayer9 = new Player("Ronaldo", PlayerPosition.MD, 7, 22, 300070);
        Player testPlayer10 = new Player("R. Lewandowski", PlayerPosition.FW, 9, 22, 370000);
        Player testPlayer11 = new Player("Griezmann", PlayerPosition.FW, 11, 22, 300600);

        Player testPlayer01 = new Player("Buffon", PlayerPosition.GK, 1, 22, 310000);
        Player testPlayer02 = new Player("Thiago Silva", PlayerPosition.DF, 3, 22, 320000);
        Player testPlayer03 = new Player("J. Cuadrado", PlayerPosition.DF, 4, 22, 330000);
        Player testPlayer04 = new Player("Hummels", PlayerPosition.DF, 2, 22, 130000);
        Player testPlayer05 = new Player("Marcelo", PlayerPosition.FW, 5, 22, 530000);
        Player testPlayer06 = new Player("Tony Kross", PlayerPosition.MD, 8, 22, 830000);
        Player testPlayer07 = new Player("Messi", PlayerPosition.MD, 10, 22, 630000);
        Player testPlayer08 = new Player("Kantè", PlayerPosition.MD, 6, 22, 730000);
        Player testPlayer09 = new Player("Ronaldo", PlayerPosition.MD, 7, 22, 300070);
        Player testPlayer010 = new Player("R. Lewandowski", PlayerPosition.FW, 9, 22, 370000);
        Player testPlayer011 = new Player("Griezmann", PlayerPosition.FW, 11, 22, 300600);

        List<Player> players = new ArrayList<>();

        players.add(testPlayer1);
        players.add(testPlayer2);
        players.add(testPlayer3);
        players.add(testPlayer4);
        players.add(testPlayer5);
        players.add(testPlayer6);
        players.add(testPlayer7);
        players.add(testPlayer8);
        players.add(testPlayer9);
        players.add(testPlayer10);
        players.add(testPlayer11);

        List<Player> players1 = new ArrayList<>();

        players1.add(testPlayer01);
        players1.add(testPlayer02);
        players1.add(testPlayer03);
        players1.add(testPlayer04);
        players1.add(testPlayer05);
        players1.add(testPlayer06);
        players1.add(testPlayer07);
        players1.add(testPlayer08);
        players1.add(testPlayer09);
        players1.add(testPlayer010);
        players1.add(testPlayer011);

        controller.validateTeam(new Team(1, "Real Madrid"), BusinessRules.teamSizeRule, BusinessRules.fixedPositionRules, BusinessRules.exclusivePlayerRule);


    }
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
//       
//
//        Storable testPlayer = new Player("Juan", PlayerPosition.DF, 10);
//        testPlayer.printClassType();
//
//   }

    public static boolean testMetodoSaveIsOk(){
        Database db = new Database();

                
        Player testPlayer = new Player("Juan", PlayerPosition.DF, 10,20,200);
        Player testPlayer1 = new Player("Pedro", PlayerPosition.DF, 15,22,300);
        Player testPlayer2 = new Player("Nombre", PlayerPosition.FW, 10,21,65000);
        Player testPlayer3 = new Player("ZNombre", PlayerPosition.GK, 11,28,74000);
        Player testPlayer4 = new Player("HNombre", PlayerPosition.MD, 15,27,47000);
        Player testPlayer5 = new Player("LNombre", PlayerPosition.DF, 5,41,241000);
        Player testPlayer6 = new Player("QNombre", PlayerPosition.FW, 1,24,478323);
        
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

        Player testPlayer = new Player("Juan", PlayerPosition.DF, 10,23,500);

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

        Player testPlayer = new Player("Nombre", PlayerPosition.DF, 10,25,500);

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
        
        PlayerPosition posicionInicial = PlayerPosition.DF;
        
        Player testPlayer = new Player("Juan", posicionInicial, 23,24,500);
        Player updatedTestPlayer = new Player("Juan", PlayerPosition.FW, 30,47,450);

        try {
            db.save(testPlayer);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        db.update(updatedTestPlayer);

        return testPlayer.getPosition().equals(updatedTestPlayer.getPosition());

    }

    public static void shouldOrderThePlayersByNumber(){

        Player testPlayer = new Player("Juan", PlayerPosition.DF, 10,20,200);
        Player testPlayer1 = new Player("Pedro", PlayerPosition.DF, 15,22,300);
        Player testPlayer2 = new Player("Nombre", PlayerPosition.FW, 10,21,65000);
        Player testPlayer3 = new Player("ZNombre", PlayerPosition.GK, 11,28,74000);
        Player testPlayer4 = new Player("HNombre", PlayerPosition.MD, 15,27,47000);
        Player testPlayer5 = new Player("LNombre", PlayerPosition.DF, 5,41,241000);

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
    }
    
    public static void objToAdd() throws DatabaseException {

            Controller controller = new Controller();

            List<Storable> listTest = new ArrayList<>();

            Player testPlayer = new Player("Juan", PlayerPosition.DF, 10, 20, 200);
            Player testPlayer1 = new Player("Pedro", PlayerPosition.DF, 15, 22, 300);
            Player testPlayer2 = new Player("Nombre", PlayerPosition.FW, 10, 21, 65000);
            Player testPlayer3 = new Player("ZNombre", PlayerPosition.GK, 11, 28, 74000);
            Player testPlayer4 = new Player("HNombre", PlayerPosition.MD, 15, 27, 47000);
            Player testPlayer5 = new Player("LNombre", PlayerPosition.DF, 5, 41, 241000);


    }
}


