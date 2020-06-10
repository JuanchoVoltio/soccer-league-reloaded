package soccerleague.model;

//import java.time.LocalDate;
import soccerleague.model.dto.Player;
import soccerleague.model.dto.Storable;
import soccerleague.model.dto.Team;

import java.util.*;

public class Database {
    //Arreglo para almacenar jugadores
    private Set<Player> jugadores;
    //Arreglo para almacenar Equipos
    private Set<Team> equipos;

    public Database(){
        this.init();
    }


    public void init(){
        this.jugadores = new TreeSet<Player>();
        this.equipos = new TreeSet<Team>();
    }

    /**
     *
     * @param dto Data Transfer Object
     */
    public void save(Storable dto) throws DatabaseException{
        if(dto instanceof Player){
        	Player p = (Player) dto;
            if(findById(p) == null) {
                this.jugadores.add(p);
            }else{
                throw new DatabaseException(DatabaseException.ITEM_ALREADY_EXISTS, "The player has been added to database");
            }
        }else if(dto instanceof Team){
        	Team t = (Team) dto;
            if(findById(t) == null) {
                this.equipos.add(t);;
            }else{
                throw new DatabaseException(DatabaseException.ITEM_ALREADY_EXISTS, "The team has been added to database");
            }
        }
    }

    public void saveAll(List<Storable> e) throws DatabaseException {
        for(Storable current : e){
            save(current);
        }
    }

    public void remove(Storable dto){
        if(dto != null) {
            if (dto instanceof Player) {
                this.jugadores.remove((Player) dto);
            } else if (dto instanceof Team) {
                this.equipos.remove((Team) dto);
            }
        }
    }

    public void removeAll(List<Storable> e){
        for(Storable current : e){
            remove(current);
        }
    }

    public void update(Storable dto){
        if(dto != null) {
            Storable searchResult = findById (dto);
            if(searchResult != null) {
                if (dto instanceof Player) {
                    Player playerFound = (Player) searchResult;
                    Player playerDto = (Player) dto;
                     if(playerDto.getPosition() != null){
                         System.out.println("se ha modificado la posici�n [" + playerDto.getPosition()+ "] por la posici�n [" + playerFound.getPosition()+"]");
                         playerFound.setPosition(playerDto.getPosition());
                     }
                     if(playerDto.getNumber() != null){
                         System.out.println("se ha modificado el n�mero [" + playerDto.getNumber()+ "] por el n�mero [" + playerFound.getNumber()+"]");
                         playerFound.setNumber(playerDto.getNumber());
                     }
                } else if (dto instanceof Team) {
                    Team teamFound = (Team)searchResult;
                    Team teamDto = (Team)dto;
                        if(teamDto.getNameTeam() != null){
                            System.out.println("se ha modificado el nombre [" + teamDto.getNameTeam()+ "] por el nombre [" + teamFound.getNameTeam()+"]");
                            teamFound.setNameTeam(teamDto.getNameTeam());
                        }

                }
            }
        }
    }

    public Storable find (Storable e){

        Storable result = null;
        

        if (e instanceof Player){
            Player p = (Player)e;
            if(this.jugadores.contains(p)){
                result = ((TreeSet<Player>) this.jugadores).first();
            }
        }else if(e instanceof Team){
            Team t = (Team)e;
            if(this.equipos.contains(t)){
                result = ((TreeSet<Team>) this.equipos).first();
            }
        }

        return result;
    }

    public Storable findById (Storable dto) {

        Storable result = null;
        String  nameId = "";
        Integer code = -1;

        if (dto instanceof Player) {
        	Player p = (Player) dto;
            for (Player current : jugadores) {
                nameId = current.getName();
                if ((p).getName().equals(null)){
                    // lanzar exception
                }else if (nameId.equalsIgnoreCase((p).getName())) {  //convierte el tipo de dato de storable a objeto y trae el atributo con el get
                    this.jugadores.contains(current);
                    result = current;
                }
            }
        }else if(dto instanceof Team){
            Team t = (Team) dto;
            for (Team current : equipos) {
                code = current.getCodeTeam();
                if (t.getCodeTeam() != null || ((Team) dto).getCodeTeam() < 0 ){
                    // lanzar exception
                }else if (code == t.getCodeTeam()) {
                    this.equipos.contains(current);
                    result = current;
                }
            }
        }

        return result;
    }

    public int playersListSize(){
        return this.jugadores.size();
    }

    public Set<Player> getAllPlayers() {
        return this.jugadores;
    }

    public Collection<Team> getAllTeams() { return this.equipos; }
}