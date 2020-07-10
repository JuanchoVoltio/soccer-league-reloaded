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
import soccerleague.simulator.Simulator;
import soccerleague.simulator.SimulatorMatch;
import soccerleague.simulator.model.Resume;


import java.util.*;

/**
 * Class used only for test purposes
 */
public class Main {

    public static void main(String... args) {

        testSaveValidateTeam();
    }

    public static void testSaveValidateTeam() {

        Controller controller = new Controller();

        Player[] team1 = {new Player("Alisson", PlayerPosition.GK, 1, 22, 310000),
                new Player("A. Robertson", PlayerPosition.DF, 3, 22, 320000),
                new Player("Alexander-Arnold", PlayerPosition.DF, 4, 22, 330000),
                new Player("V. Van Dijk", PlayerPosition.DF, 5, 22, 530000),
                new Player("Fabinho", PlayerPosition.MD, 8, 22, 830000),
                new Player("J. Henderson", PlayerPosition.MD, 10, 22, 630000),
                new Player("N. Keïta", PlayerPosition.MD, 6, 22, 730000),
                new Player("G. Wijnaldum", PlayerPosition.MD, 7, 22, 300070),
                new Player("M. Salah", PlayerPosition.FW, 9, 22, 370000),
                new Player("S. Mané", PlayerPosition.FW, 2, 22, 130000),
                new Player("R. Firmino", PlayerPosition.FW, 11, 22, 300600)};

        Player[] team2 = {new Player("G. Buffon", PlayerPosition.GK, 1, 22, 310000),
                new Player("Alex Sandro", PlayerPosition.DF, 3, 22, 320000),
                new Player("G. Chiellini", PlayerPosition.DF, 4, 22, 330000),
                new Player("L. Bonucci", PlayerPosition.DF, 2, 22, 130000),
                new Player("Danilo", PlayerPosition.DF, 5, 22, 530000),
                new Player("J. Cuadrado", PlayerPosition.MD, 8, 22, 830000),
                new Player("B. Matuidi", PlayerPosition.MD, 10, 22, 630000),
                new Player("M. Pjanić", PlayerPosition.MD, 6, 22, 730000),
                new Player("P. Dybala", PlayerPosition.MD, 9, 22, 300070),
                new Player("C. Ronaldo", PlayerPosition.FW, 7, 22, 370000),
                new Player("G. Higuaín", PlayerPosition.FW, 11, 22, 300600)};

        Player[] team3 = {new Player("Thibaut Courtois", PlayerPosition.GK, 1, 22, 310000),
                new Player("Dani Carvajal", PlayerPosition.DF, 3, 22, 320000),
                new Player("Marcelo", PlayerPosition.DF, 4, 22, 330000),
                new Player("Sergio Ramos", PlayerPosition.DF, 2, 22, 130000),
                new Player("Raphaël Varane", PlayerPosition.DF, 5, 22, 530000),
                new Player("Toni Kroos", PlayerPosition.MD, 8, 22, 830000),
                new Player("James Rodríguez", PlayerPosition.MD, 10, 22, 630000),
                new Player("Federico Valverde", PlayerPosition.MD, 6, 22, 730000),
                new Player("Casemiro", PlayerPosition.MD, 9, 22, 300070),
                new Player("Karim Benzema", PlayerPosition.FW, 7, 22, 370000),
                new Player("Eden Hazard", PlayerPosition.FW, 11, 22, 300600)};

        Player[] team4 = {new Player("Jan Oblak", PlayerPosition.GK, 1, 22, 310000),
                new Player("Santiago Arias", PlayerPosition.DF, 3, 22, 320000),
                new Player("José Giménez", PlayerPosition.DF, 4, 22, 330000),
                new Player("Stefan Savić", PlayerPosition.DF, 2, 22, 130000),
                new Player("Renan Lodi", PlayerPosition.DF, 5, 22, 530000),
                new Player("Šime Vrsaljko", PlayerPosition.DF, 8, 22, 830000),
                new Player("Koke", PlayerPosition.MD, 10, 22, 630000),
                new Player("Saúl", PlayerPosition.MD, 6, 22, 730000),
                new Player("Thomas Partey", PlayerPosition.MD, 9, 22, 300070),
                new Player("Yannick Carrasco", PlayerPosition.MD, 7, 22, 370000),
                new Player("Diego Costa", PlayerPosition.FW, 11, 22, 300600)};

        Team t1 = new Team(10, "Liverpool", team1);
        Team t2 = new Team(11, "Juventus", team2);
        Team t3 = new Team(12, "Real Madrid", team3);
        Team t4 = new Team(13, "Atlético de Madrid", team4);

        controller.saveValidateTeam(t1, BusinessRules.teamSizeRule, BusinessRules.fixedPositionRules, BusinessRules.exclusivePlayerRule);
        controller.saveValidateTeam(t2, BusinessRules.teamSizeRule, BusinessRules.fixedPositionRules, BusinessRules.exclusivePlayerRule);
        controller.saveValidateTeam(t3, BusinessRules.teamSizeRule, BusinessRules.fixedPositionRules, BusinessRules.exclusivePlayerRule);
        controller.saveValidateTeam(t4, BusinessRules.teamSizeRule, BusinessRules.fixedPositionRules, BusinessRules.exclusivePlayerRule);

        // controller.printTeams();


            Simulator sim1 = new SimulatorMatch();

            System.out.println(sim1.simulateMatch(t2, t1).getFullResume());
            System.out.println(sim1.simulateMatch(t3, t4).getFullResume());
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

//        PlayerFinder finder1 = new FinderByAgeRange(20, 25);
//        PlayerFinder finder2 = new FinderByAge(25);
//        controller.findPlayers(finder1); //1. Usando objetos para inyectar la lógica

//        controller.findPlayers(new PlayerFinder(){ //2. Usando una clase anónima para evitar el problema de 1.
//                                        @Override
//                                        public boolean isValid(Player p) {
//                                            return p.getSalary().intValue() <= maxSalary;
//                                        }});

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


