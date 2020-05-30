package soccerleague;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import soccerleague.constants.PlayerPosition;
import soccerleague.controller.Controller;
import soccerleague.controller.comparators.PlayerByPositionComparator;
import soccerleague.controller.comparators.PlayerCompositeComparator;
import soccerleague.controller.comparators.TeamByNameComparator;
import soccerleague.controller.finders.FindByAge;
import soccerleague.controller.finders.FindByAgeRange;
import soccerleague.controller.finders.PlayerFinder;
import soccerleague.model.Database;
import soccerleague.model.DatabaseException;
import soccerleague.model.dto.Player;
import soccerleague.model.dto.Storable;
import soccerleague.model.dto.Team;


/**
 * Class used only for test purposes
 */
public class Main {

    public static Database db;
    public static Controller controller;
            
    public static void main(String[] args) throws DatabaseException {
        
        String s = PlayerPosition.getDescriptionFromCode(1);
        if(s != null) {
            s.trim(); //Ayuda a eliminar los espacios dentro de un String
        }

        db = new Database();
        controller = new Controller();
/*       assert removeMethodShouldRemoveDto() : "The List of players is not empty.";
         assert saveMethodShouldThrowExceptionWhenDuplicateEntry() : "Oooops, saveMethodShouldThrowExceptionWhenDuplicateEntry()"; */
        
        // Crear usuarios.
        creacionJugadoresNicolas();
        // Ayuda organizar nombres en una lista
        guardarYOrganizarJugadores();
        // Crear usuario profesor Henry
        creacionJugadoresHenry();
        // Organizar usuarios Henry.
        Collections.sort(db.getAllPlayers(), new PlayerCompositeComparator());
        db.getAllPlayers().forEach(p -> System.out.println(p));
        System.out.println("----------");
        // Crear equipos.
        crearEquiposNicolas();
        // Crear equipos Henry.
        crearEquiposHenry();
        // Organizar equipos.
        Collections.sort(db.getAllTeams(), new TeamByNameComparator());
        db.getAllTeams().forEach(p -> System.out.println(p.getNameTeam()));
        System.out.println("----------");
        //Eliminar jugadores
        eliminarJuagdores();  
        db.getAllPlayers().forEach(p -> System.out.println(p));
        System.out.println("----------");
        //Eliminar equipos
        eliminarEquipos();  
        db.getAllTeams().forEach(p -> System.out.println(p.getNameTeam()));
        System.out.println("----------");
        // Uso de lamda e interfaz funcional
//        testMethodImplementationInsideAClass();
//        db.getAllTeams().forEach(p -> System.out.println(p.getNameTeam()));
//        System.out.println("*****");
//        db.getAllPlayers().forEach(p -> System.out.println(p));
//        System.out.println("*****");
//        // Uso de una interfaz con método por defecto "default"
//        Storable testPlayer = new Player("Juan", PlayerPosition.MD, 11);
//        testPlayer.printClassType();
        
        
    }

    public static boolean creacionJugadoresNicolas(){
        //Crear usuarios
        Player p2 = new Player("Sammy", PlayerPosition.FW, 12);

        try {
            db.save(new Player("JuanDa", PlayerPosition.DF, 9));
            db.save(p2);
            db.getAllPlayers().forEach(p -> System.out.println(p));
            System.out.println("----------");
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        return true;
    }
    
    public static void guardarYOrganizarJugadores() throws DatabaseException{
        //Creación juadores individuales.
        Player jugador1 = new Player("Nicolás", PlayerPosition.DF, 10);
        Player jugador2 = new Player("Daniela", PlayerPosition.GK, 11);
        Player jugador3 = new Player("Lelia",   PlayerPosition.DF, 15);
        Player jugador4 = new Player("Camilo",  PlayerPosition.DF, 5);
        Player jugador5 = new Player("Armando", PlayerPosition.FW, 1);
        //Añadir a Base de Datos.
        db.save(jugador1);
        db.save(jugador2);
        db.save(jugador3);
        db.save(jugador4);
        db.save(jugador5);
        //Recorrer e imprimir la lista.
        db.getAllPlayers().forEach(p -> System.out.println(p));
        System.out.println("----------");
        //Organizar los jugadores.
        Collections.sort(db.getAllPlayers(), new PlayerCompositeComparator());
        //Recorrer e imprimir la lista.
        db.getAllPlayers().forEach(p -> System.out.println(p));
        System.out.println("----------");
    }
    
    public static void creacionJugadoresHenry() throws DatabaseException{    
        //Crear usuarios
        Player p1  = new Player("Henry"     ,  PlayerPosition.DF, 7);
        Player p2  = new Player("NoviaHenry",  PlayerPosition.FW, 13);
        List<Player> listaIngresos = new ArrayList();
        listaIngresos.add(p1);
        listaIngresos.add(p2);
        //Condicionales de ingreso
        String nombreA = "Henry";
        String nombreB = "Andres";
        //Condicional de ingreso
        controller.guardarJugadores(((Player p) -> (p.getName().equals(nombreA)) || (p.getName().equals(nombreB))), listaIngresos);
        db.getAllPlayers().forEach(p -> System.out.println(p));
        System.out.println("----------");
    }
    
    public static boolean crearEquiposNicolas(){
        //Crear equipos
        Team t2 = new Team(2, "Grupo A");
        try {
            db.save(new Team(1, "Grupo B"));
            db.save(t2);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        return true;
    }
    
    public static void crearEquiposHenry() throws DatabaseException{
        //Crear equipos
        Team t1 = new Team(2, "Grupo C");
        Team t2 = new Team(2, "Grupo D");
        List<Team> listaIngresos = new ArrayList();
        listaIngresos.add(t1);
        listaIngresos.add(t2);
        //Condicionales de ingreso
        String nombreA = "Grupo A";
        String nombreB = "Grupo C";
        //Condicional de ingreso
        controller.guardarEquipos(((Team t) -> (t.getNameTeam().equals(nombreA)) || (t.getNameTeam().equals(nombreB))), listaIngresos);
        db.getAllTeams().forEach(p -> System.out.println(p.getNameTeam()));
        System.out.println("----------");
    }

    public static void eliminarJuagdores(){
        //Condicional
        String nombreA = "Daniela";
        Predicate<Player> condicional = p -> p.getName().equals(nombreA);
        List<Player> lista = new ArrayList();
        List<Player> lista2 = new ArrayList();
        lista = db.getAllPlayers();
        lista.stream().filter(condicional).forEach(p -> lista2.add(p));
        for(Player jugador: lista2){
            db.remove(jugador);
        }
    }
    
    public static void eliminarEquipos(){
        //Condicional
        String nombreA = "Grupo A";
        Predicate<Team> condicional = p -> p.getNameTeam().equals(nombreA);
        List<Team> lista = new ArrayList();
        List<Team> lista2 = new ArrayList();
        lista = db.getAllTeams();
        lista.stream().filter(condicional).forEach(p -> lista2.add(p));
        for(Team equipo: lista2){
            db.remove(equipo);
        }
    }

//    public static void removeMethodShouldRemoveDtoWithAssertions(){
//        Database db = new Database();
//
//        Player testPlayer = new Player("Nombre", PlayerPosition.DF, 10);
//
//        db.remove(testPlayer);
//
//        db.remove(testPlayer);
//
//        try {
//            db.save(testPlayer);
//        } catch (DatabaseException e) {
//            e.printStackTrace();
//        }
//
//        assert db.playersListSize() == 0 : "The List of players is not empty, is " + db.playersListSize();
//
//    }

    //TODO: Corregir este método usando los enums. ¡Hecho!
    public static boolean updateMethodShouldReturnOk(){
        String initalPosition = Player.POSITION_GK;
        String newPosition = Player.POSITION_DF;

        Player testPlayer = new Player("Juan", PlayerPosition.DF, 23);
        Player updatedTestPlayer = new Player("Juan", PlayerPosition.FW, null);

        try {
            db.save(testPlayer);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        db.update(updatedTestPlayer);

        return testPlayer.getPosition().equals(PlayerPosition.FW);

    }

    

    /* Expresión Lamda - Interfaz Funcional */

    public static void testMethodImplementationInsideAClass(){

        String nombreA = "Nicolás";
        String nombreB=  "Daniela";
        String existe =  "Grupo A";
        String noExiste= "GRupo C";
        //1. Usando objetos para inyectar la lógica
        PlayerFinder finder1 = new FindByAgeRange(20, 25);
        PlayerFinder finder2 = new FindByAge(25);
        controller.findPlayers(finder1); 
        //2. Usando una clase anónima para evitar el problema de 1.
        controller.findPlayers(new PlayerFinder(){ 
                                        @Override
                                        public boolean validacion(Player p) {
                                            return p.getName().equals(nombreA);
                                        }});
        //3. Simplificar la solución planteada en  2.
        List<Player> result = controller.findPlayers((Player p) -> (p.getName().equals(nombreA)) || (p.getName().equals(nombreB)));
        //a. Siempre se neceista una interfaz funcional la cual lamda sobreescriba.
        //b. La función destino "controller.findPlayers()" debe usar el método abstracto definido en la interfaz funcional.
        //c. El inicio de la expresión lamda debe tener la misma entrada de parámetros definidos en el método abastracto.
//        List<Team> lista = controller.findTeams((Team t) -> (t.getNameTeam().equals(existe)));
//        List<Team> lista2 = controller.findTeams((Team t) -> (t.getNameTeam().equals(noExiste)));
        result.forEach(p -> System.out.println(p));
        System.out.println("/////////");
//        lista.forEach(p -> System.out.println(p));
//        System.out.println("/////////");
//        lista2.forEach(p -> System.out.println(p));
//        System.out.println("/////////");
    }

    public static Database getDb() {
        return db;
    }

    public static void setDb(Database db) {
        Main.db = db;
    }


}
