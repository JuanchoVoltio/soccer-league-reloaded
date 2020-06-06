package test;

import static constants.PlayerPosition.FW;
import static constants.PlayerPosition.GK;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import soccerleague.controller.Controller;
import soccerleague.model.DatabaseException;
import soccerleague.model.dto.Player;
import soccerleague.model.dto.Storable;
import soccerleague.model.dto.Team;

public class Main {

    public static void main(String[] args) {
       
        try {
            testMethodtoAddStorable();
        } catch (DatabaseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
    }
     public static void testMethodtoAddStorable() throws DatabaseException{
        Controller controller = new Controller();
            
        Player [] team1 = {new Player("Messi",GK,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",GK,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",GK,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",GK,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",GK,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",GK,1,25,2000)};
        
        List<Storable> result = new ArrayList<>();
        result.addAll(List.of(new Player("Ronaldo",GK,1,25,2000),
                   new Player("Messi",GK,1,25,2000),
                   new Player("Makaka",GK,1,25,2000),
                   new Player("Cuadrado",GK,1,25,2000),
                   new Player("Falcao",GK,1,25,2000),
                   new Team(21,"Milan",team1)));
                        
        controller.addStorable(result, p -> p.getName().equals("Messi")|| p.getName().equals("Milan")); 
        
        controller.getDb().getJugadores().forEach(x -> System.out.println(x));
        controller.getDb().getTeam().forEach(y -> System.out.println(y));
    }
    
    
    public static void testMethodtoUpperCase() throws DatabaseException{
        Controller controller = new Controller();
       
        controller.getDb().saveAll(List.of(new Player("Ronaldo",GK,1,25,2000),
                                            new Player("Messi",GK,1,25,2000),
                                            new Player("Makaka",GK,1,25,2000),
                                            new Player("Cuadrado",GK,1,25,2000),
                                            new Player("Falcao",GK,1,25,2000),
                                            new Player("Iniesta",GK,1,25,2000)));
                        
        controller.toUpperCasePlayerNames(p -> p.getName().contains("d")|| p.getName().contains("l")); //3. Simplificar la soluci�n planteada en
    }
    
   
      
    public static void testMethodImplementationStream() throws DatabaseException{
        Controller controller = new Controller();
       
        controller.getDb().saveAll(List.of(new Player("Ronaldo",GK,1,25,2000),
                                            new Player("Messi",GK,1,25,2000),
                                            new Player("Makaka",GK,1,25,2000),
                                            new Player("Cuadrado",GK,1,25,2000),
                                            new Player("Falcao",GK,1,25,2000),
                                            new Player("Iniesta",GK,1,25,2000)));
        
        controller.findPlayers(p -> p.getName().contains("d")|| p.getName().contains("l"))
                               .stream().forEach(p -> System.out.println(p.getName())); //3. Simplificar la soluci�n planteada en
    }
    
    
    public static void testMethodImplementationInsideAClass() throws DatabaseException{
        Controller controller = new Controller();
       
        controller.getDb().saveAll(List.of(new Player("Ronaldo",GK,1,25,2000),
                                            new Player("Messi",GK,1,25,2000),
                                            new Player("Makaka",GK,1,25,2000),
                                            new Player("Cuadrado",GK,1,25,2000),
                                            new Player("Falcao",GK,1,25,2000),
                                            new Player("Iniesta",GK,1,25,2000)));
             
        Integer maxSalary = 1000;
        Integer minSalary = 3000;
        Integer desiredAge = 22;
             
        controller.findPlayers(p -> p.getName().contains("d")|| p.getName().contains("l"))
                               .stream().forEach(p -> System.out.println(p.getName())); //3. Simplificar la soluci�n planteada en
    }
}
