package model;

//import java.time.LocalDate;
import java.util.*;

public class DataBase {
    //Arreglo para almacenar jugadores
    List<Player> jugadores;
    //Arreglo para almacenar Equipos
    List<Team> equipos;


    public void init(){
        this.jugadores = new ArrayList<>();
        this.equipos = new ArrayList<>();
    }


    public void save(Storable e){

        if(e instanceof Player){
            this.jugadores.add((Player)e);
        }else if(e instanceof Team){
            this.equipos.add((Team)e);
        }
    }

    public void saveAll(List<Storable> e){
        for(Storable current : e){
            save(current);
        }
    }

    public void remove(Storable e){
        if (e instanceof Player){
            this.jugadores.remove((Player)e);
        }else if(e instanceof Team){
            this.equipos.remove((Team)e);
        }
    }

    public void removeAll(List<Storable> e){
        for(Storable current : e){
            remove(current);
        }
    }

    public void update(Storable e){

        findById (e);
        if (e instanceof Player){
            ((Player) e).setName("");
            
        }else if(e instanceof Team){
            this.equipos.set(1, (Team)e);
        }
    }

    public Storable find (Storable e){

        Storable result = null;
        int index = -1;

        if (e instanceof Player){
            Player p = (Player)e;
            index = this.jugadores.indexOf(p);
            if(index >= 0){
                result = this.jugadores.get(index);
            }
        }else if(e instanceof Team){
            Team t = (Team)e;
            index = this.equipos.indexOf(t);
            if(index >= 0){
                result = this.equipos.get(index);
            }
        }

        return result;
    }

    public Storable findById (Storable e) {

        Storable result = null;
        String  nameId = "";
        Integer code = -1;

        if (e instanceof Player) {
            for (Player i : jugadores) {
                nameId = i.getName();
                if (((Player) e).getName().equals(null)){
                    // lanzar exception
                }else if (nameId.equalsIgnoreCase(((Player) e).getName())) {  //convierte el tipo de dato de storable a objeto y trae el atributo con el get
                    this.jugadores.indexOf(i);
                    result = i;
                    System.out.println(result);
                }
            }
        }else if(e instanceof Team){
            for (Team t : equipos) {
                code = t.getCodeTeam();
                if (((Team) e).getCodeTeam().equals(null) || ((Team) e).getCodeTeam() == 0 ){
                    // lanzar exception
                }else if (code == ((Team) e).getCodeTeam()) {
                    this.equipos.indexOf(t);
                    result = t;
                    System.out.println(result);
                }
            }
        }
        return result;
    }

}