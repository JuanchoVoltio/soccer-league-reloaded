package test;

import static constants.PlayerPosition.FW;
import static constants.PlayerPosition.GK;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import soccerleague.controller.Controller;
import soccerleague.model.DatabaseException;
import soccerleague.model.dto.Player;



public class Main {

    public static void main(String[] args) {
       
     System.out.println("hola");
        try {
            testMethodImplementationInsideAClass();
        } catch (DatabaseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
    }
      
    public static void testMethodImplementationInsideAClass() throws DatabaseException{
        Controller controller = new Controller();
       
              
        Controller.db.save(new Player("Ronaldo",GK,1,25,2000));
        Controller.db.save(new Player("Falcao",FW,1,25,3000));
        Controller.db.save(new Player("Mesi",FW,1,25,5000));
             
        Integer maxSalary = 1000;
        Integer minSalary = 3000;
        Integer desiredAge = 22;
             
        controller.findPlayers( p -> p.getSalary() >= minSalary).forEach(x -> System.out.println(x));

       // result.forEach(p -> System.out.println(p));
    }
}
