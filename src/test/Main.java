package test;

import constants.BusinessRules;
import static constants.PlayerPosition.*;
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
       
        testSaveValidateTeam();
     
    }
    
    public static void testSaveValidateTeam(){
        
        Controller controller = new Controller();
        
        Player [] team1 = {new Player("Messi",GK,1,25,2000),new Player("Makaka",DF,1,25,2000)
                            ,new Player("Makaka",DF,1,25,2000),new Player("Makaka",DF,1,25,2000)
                            ,new Player("Makaka",MD,1,25,2000),new Player("Makaka",MD,1,25,2000)
                            ,new Player("Makaka",MD,1,25,2000),new Player("Makaka",MD,1,25,2000)
                            ,new Player("Makaka",FW,1,25,2000),new Player("Makaka",FW,1,25,2000)
                            ,new Player("Makaka",FW,1,25,2000)};
        
        Team t1 = new Team(10,"Milan",team1);
        
        controller.saveValidateTeam(t1, BusinessRules.teamSizeRule, BusinessRules.fixedPositionRules, BusinessRules.exclusivePlayerRule);
        
        System.out.println("Defense probability: "+t1.getNameTeam()+" "+controller.defenseProbabilityTeam(t1));
        System.out.println("Attack probability: "+t1.getNameTeam()+" "+controller.attackProbabilityTeam(t1));
        controller.getDb().getTeam().forEach(y -> System.out.println(y));
        
    }
    
    
    public static void testMethodtoAddStorable2() throws DatabaseException{
        Controller controller = new Controller();
                    
        Player j1 = new Player("Ronaldo",GK,1,25,2000);
        Player j2 = new Player("Messi",GK,1,25,2000);
        
        Player [] team1 = {new Player("Messi",GK,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",FW,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",FW,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",FW,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",FW,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("ADRIAN",GK,8,25,2000)};
        
        Team t1 = new Team(10,"Milan",team1);
        
        
        List<Storable> result = new ArrayList();
        
        result.addAll(List.of(j1,j2,t1));
        
        System.out.println(t1.getClass());
        
        //controller.addStorable(result, p -> p.getClass().isNestmateOf(Player);                                                    }); 
        
        //controller.getDb().getJugadores().forEach(x -> System.out.println(x));
        //controller.getDb().getTeam().forEach(y -> System.out.println(y));
        
    }
    
    
    
    
    
    public static void testMethodtoAddStorable() throws DatabaseException{
        Controller controller = new Controller();
                    
        Player j1 = new Player("Ronaldo",GK,1,25,2000);
        Player j2 = new Player("Messi",GK,1,25,2000);
        
        Player [] team1 = {new Player("Messi",GK,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",FW,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",FW,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",FW,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",FW,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("ADRIAN",GK,8,25,2000)};
        
        Team t1 = new Team(10,"Milan",team1);
        
        
        List<Storable> result = new ArrayList<>();
        
        result.addAll(List.of(j1,j2,t1));
                        
        controller.addStorable(result, p -> p.equals(t1) || p.equals(j1)); 
        
        controller.getDb().getJugadores().forEach(x -> System.out.println(x));
        controller.getDb().getTeam().forEach(y -> System.out.println(y));
        
    }
    
    
    
    
       
    public static void testMethodtoAddPlayer() throws DatabaseException{
        Controller controller = new Controller();
            
        List<Player> result = new ArrayList<>();
        
        result.addAll(List.of(new Player("Ronaldo",GK,1,25,2000),
                   new Player("Messi",GK,1,25,2000),
                   new Player("Makaka",GK,1,25,2000),
                   new Player("Cuadrado",GK,1,25,2000),
                   new Player("Falcao",GK,1,25,2000)));
                        
        controller.addPlayer(result, p -> p.getName().contains("M")|| p.getName().contains("C")); 
        
        controller.getDb().getJugadores().forEach(x -> System.out.println(x));
    }
    
    public static void testMethodtoAddTeam() throws DatabaseException{
        Controller controller = new Controller();
            
        Player [] team1 = {new Player("Messi",GK,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",GK,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",GK,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",GK,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",GK,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",GK,1,25,2000)};
        
        Player [] team2 = {new Player("Messi",GK,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",GK,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",GK,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",GK,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("Makaka",GK,1,25,2000),new Player("Makaka",GK,1,25,2000)
                            ,new Player("adrian",GK,1,25,2000)};
        
        List<Team> result = new ArrayList<>();
        result.addAll(List.of(new Team(21,"Milan",team1),new Team(22,"Juventus",team2)));
                        
        controller.addTeam(result, p -> p.getNameTeam().equals("Milan")||p.getNameTeam().equals("Juventus")); 
        
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
