package soccerleague;
import soccerleague.model.* ; 




//  Database;
import soccerleague.model.DatabaseSet;
import soccerleague.model.dto.*;

import java.util.*;
import java.util.function.*;

import soccerleague.constants.PlayerPosition;
import soccerleague.controller.Controller;
import soccerleague.controller.comparators.PlayersByNameComparator;
import soccerleague.controller.comparators.PlayersByPositionComparator;
import soccerleague.controller.comparators.PlayersCompositeComparator;
import soccerleague.controller.finders.FinderByAge;
import soccerleague.controller.finders.FinderByAgeRange;
import soccerleague.controller.finders.PlayerFinder;
import soccerleague.model.Database;
import soccerleague.model.DatabaseException;
import soccerleague.model.dto.Player;
import soccerleague.model.dto.Storable;

/**
 * Class used only for test purposes
 */
public class Main {
   // public DatabaseSet db = new DatabaseSet();

	
    public static void main(String... args) {
    
    	testMethodValidate();
    	/*
        if(updateMethodShouldReturnOk()){
            System.out.println("Pass");
        }else{
            System.out.println("Ooops!!");
        }
        */
 
    //  testMetodoSaveIsOk();
    }

    public static boolean testMetodoSaveIsOk(){
        DatabaseSet db = new DatabaseSet();
       /* 
        TreeSet<Player> jugadoresSet ;
        jugadoresSet = new TreeSet<>();
        */
    	
   //     Database db = new Database();
   //     List<Player> jugadores ;
   //     jugadores = new ArrayList<>();
     
        System.out.println("Diferente equals ...") ;
        
        List<String> lista = new ArrayList<>() ;    // para prueba
        lista.add ("Uno");     // para prueba

        
        Player Player1 = new Player("Pepe", PlayerPosition.DF,1);
        Player Player2 = new Player("Lucas",PlayerPosition.DF,2);
        Player Player3 = new Player("Lucas-G",PlayerPosition.DF,3);
        Player Player4 = new Player("Guerrero", PlayerPosition.GK,4);
        Player Player5 = new Player("Ronaldo",PlayerPosition.DF,5);
        Player Player6 = new Player("Batistuta",PlayerPosition.DF,6);
        Player Player7 = new Player("Silva", PlayerPosition.GK,7);
        Player Player8 = new Player("Perales",PlayerPosition.DF,8);
        Player Player9 = new Player("Gomez",PlayerPosition.DF,9);
        Player Player10 = new Player("Schweinsteiger", PlayerPosition.GK,10);
        Player Player11 = new Player("Ozil",PlayerPosition.DF,11);

        /*
        Player Player12 = new Player("Becker",PlayerPosition.DF,12);
        Player Player13 = new Player("Muller",PlayerPosition.DF,13);
        Player Player14 = new Player("Beckenbauer", PlayerPosition.GK,14);
        Player Player15 = new Player("Ballack",PlayerPosition.DF,15);
        Player Player16 = new Player("Klose",PlayerPosition.DF,16);
        Player Player17 = new Player("Neuer", PlayerPosition.GK,17);
        Player Player18 = new Player("Metzger",PlayerPosition.DF,18);
        Player Player19 = new Player("Gomez",PlayerPosition.DF,19);
        Player Player20 = new Player("Schweinsteiger",PlayerPosition.GK ,20);
        Player Player21 = new Player("Ozil",PlayerPosition.DF,21);       
        */
        
        try {
            
            db.saveAll(Arrays.asList(Player1, Player2,Player3,Player4,Player5,Player6,Player7,Player8,Player9,Player10,Player11));         
            //db.saveAll(Arrays.asList(Player12, Player13, Player14,Player15,Player16,Player17,Player18,Player19,Player20,Player21  ));
      
            
        } catch (DatabaseException e) {
            e.printStackTrace();
        } finally { 
        	System.out.println ( "last called ...."); 
        
        }
        
        testMethodValidate();
        db.showPlayers() ;
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
        PlayerPosition initalPosition = PlayerPosition.GK;
        PlayerPosition newPosition = PlayerPosition.DF;

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

    // --------------------------
    // preguntar por este metodo
    // --------------------------
  
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

        List<Player> result = controller.findPlayers((Player p) -> (p.getSalary().intValue() >= minSalary) && (p.getAge() == desiredAge)); //3. Simplificar la solución planteada en  2.

        List<Player> result2 = controller.findPlayers((Player p) -> { int tmpAge = p.getAge() - 2;
                                                                      return (tmpAge <= desiredAge);}); //3. Simplificar la solución planteada en  2.

        List<Player> result3 = controller.findPlayersUsingPredicate((Player p) -> { int tmpAge = p.getAge() - 2;
                                                                                    return (tmpAge <= desiredAge);}); //4. Usar una interfaz funcional nativa de Java para no crear una nueva, tal cual pasó en 3.



        result.forEach(p -> System.out.println(p));
    }
    
    public static void testFiltersAndStreams(){
        Controller controller = new Controller();
        
        int maxSalary = 1000;
        int minSalary = 500;
        int desiredAge = 22;

        Predicate<Player> predicate = (Player p) -> p.getSalary() < maxSalary ;

        controller.toUpperCasePlayerNames(predicate);
    }
    
        
    
    public static void testMethodValidate() {
    	Controller controller = new Controller();
      	Database db = new Database();   
  
      	//List<Player> Listap = new ArrayList();
    	
    	   Player Player1 = new Player("Pepe", PlayerPosition.DF,1);
           Player Player2 = new Player("Lucas",PlayerPosition.DF,2);
           Player Player3 = new Player("Lucas-G",PlayerPosition.DF,3);
           Player Player4 = new Player("Guerrero", PlayerPosition.MD,4);
           Player Player5 = new Player("Ronaldo",PlayerPosition.MD,5);
           Player Player6 = new Player("Batistuta",PlayerPosition.MD,6);
           Player Player7 = new Player("Silva", PlayerPosition.MD,7);
           Player Player8 = new Player("Perales",PlayerPosition.FW,8);
           Player Player9 = new Player("Gomez",PlayerPosition.FW,9);
           Player Player10 = new Player("Schweinsteiger", PlayerPosition.GK,10);
           Player Player11 = new Player("Ozil",PlayerPosition.GK,11);

               
           try {
               
               db.saveAll(Arrays.asList(Player1, Player2,Player3,Player4,Player5,Player6,Player7,Player8,Player9,Player10,Player11));         
               
           } catch (DatabaseException e) {
               e.printStackTrace();
           } finally { 
           	        
           }
           	
      
       //  List<Player> result4 =        
     
           controller.validatePositionPlayers((List<Player> p) -> {  int tmpDF=0 , tmpMD =0, tmpFW=0, tmpGK=0;
        										
        															for( Player current : db.getAllPlayers() )		  
    																	{  switch (current.getPosition()) {
  												     
    															            case DF : tmpDF ++; System.out.println ( tmpDF); 
    																	           break;
    															            case GK: tmpGK ++;  System.out.println ( tmpGK);
    															                   break;
    															            case MD: tmpMD ++; System.out.println ( tmpMD); 
    															               		break;         
    															            case FW: tmpFW ++;  System.out.println ( tmpFW); 
    															                    break;
    															           }           
    																	}
        															      System.out.println ( "Alineamiento : " + tmpDF + tmpMD + tmpFW + tmpGK)   ;
    																      if ( tmpDF ==0 || tmpMD==0 || tmpFW==0 || tmpGK==0) 
    																         { System.out.println ("Error en alineacion de jugadores ....");
    																    	  return false;
    																         }
    																      if ((tmpDF + tmpFW) != 6 || tmpMD != 4 || tmpGK != 1 )
    																         { System.out.println ("Error en alineacion de jugadores ....");
    																		   return false;
    																         }
    													    																      
    	                                                                 return true;
    																  } ) ;
       
    }
}