import model.DataBase;
import model.Player;
import model.Storable;
import model.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SoccerLeagueTest{

    public static void main(String... args){
        DataBase db = new DataBase();
        db.init();
        Player Team1[]  = new Player[11];
        Player Team2[]  = new Player[11];
        Player Team3[]  = new Player[11];
 
   
        Player Player1 = new Player("Pepe", 1, "GK");
        Player Player2 = new Player("Lucas",11,"DF");
        Player Player3 = new Player("Lucas-G",9,"DF");
        Player Player4 = new Player("Guerrero", 10, "GK");
        Player Player5 = new Player("Ronaldo",13,"DF");
        Player Player6 = new Player("Batistuta",8,"DF");
        Player Player7 = new Player("Silva", 1, "GK");
        Player Player8 = new Player("Perales",11,"DF");
        Player Player9 = new Player("Gomez",9,"DF");
        Player Player10 = new Player("Schweinsteiger", 10, "GK");
        Player Player11 = new Player("Ozil",13,"DF");

        Player Player12 = new Player("Becker",11,"DF");
        Player Player13 = new Player("Muller",9,"DF");
        Player Player14 = new Player("Beckenbauer", 10, "GK");
        Player Player15 = new Player("Ballack",13,"DF");
        Player Player16 = new Player("Klose",8,"DF");
        Player Player17 = new Player("Neuer", 1, "GK");
        Player Player18 = new Player("Metzger",11,"DF");
        Player Player19 = new Player("Gomez",9,"DF");
        Player Player20 = new Player("Schweinsteiger", 10, "GK");
        Player Player21 = new Player("Ozil",13,"DF");       
        
       
        
        Team1[0] = new Player("Heinz", 1, "GK");
        Team1[1] = new Player("Becker",11,"DF");
        Team1[2] = new Player("Muller",9,"DF");
        Team1[3] = new Player("Beckenbauer", 10, "GK");
        Team1[4] = new Player("Ballack",13,"DF");
        Team1[5] = new Player("Klose",8,"DF");
        Team1[6] = new Player("Neuer", 1, "GK");
        Team1[7] = new Player("Metzger",11,"DF");
        Team1[8] = new Player("Gomez",9,"DF");
        Team1[9] = new Player("Schweinsteiger", 10, "GK");
        Team1[10] = new Player("Ozil",13,"DF");       
        
        
        Team2[0] = new Player("Rojas", 1, "GK");
        Team2[1] = new Player("Simoen",2,"DF");
        Team2[2] = new Player("Thomas",3,"DF");
        Team2[3] = new Player("Villa", 4, "GK");
        Team2[4] = new Player("Ronaldinho",5,"DF");
        Team2[5] = new Player("Castro",8,"DF");
        Team2[6] = new Player("Falcao", 7, "GK");
        Team2[7] = new Player("Mendoza",11,"DF");
        Team2[8] = new Player("Faro",9,"DF");
        Team2[9] = new Player("Iker", 10, "GK");
        Team2[10] = new Player("Omar",15,"DF");       
        
   /*     
        Team3[0] = new Player("Santiago Menor", 1, "GK");
        Team3[1] = new Player("Felipe",2,"DF");
        Team3[2] = new Player("Thomas",3,"DF");
        Team3[3] = new Player("Judas Izcariote", 4, "GK");
        Team3[4] = new Player("Bartolome",5,"DF");
        Team3[5] = new Player("Simon",8,"DF");
        Team3[6] = new Player("Judas Tadeo", 7, "GK");
        Team3[7] = new Player("Juan",11,"DF");
        Team3[8] = new Player("Santiago",9,"DF");
        Team3[9] = new Player("Andres", 10, "GK");
        Team3[10] = new Player("Pedro",15,"DF");      
        */
        
        System.out.println (" ========================================== ");
        db.saveAll(Arrays.asList(Player1, Player2,Player3,Player4,Player5,Player6,Player7,Player8,Player9,Player10,Player11));
        db.saveAll(Arrays.asList(Player12, Player13, Player14,Player15,Player16,Player17,Player18,Player19,Player20,Player21  ));
        
        if ( ! db.findPlayer (Team1) )
        	 db.save(new Team(1, "Los Cósmicos", Team1));
        if ( ! db.findPlayer (Team2) )
        	db.save(new Team(2, "Los Galacticos", Team2));    
 /*       if ( ! db.findPlayer (Team3) )
        	db.save(new Team(3, "Los Pastores", Team3));    
        
  */    
       
        db.showPlayers() ;
        db.showTeamPlayers() ;
        
        
        
      

    }

}