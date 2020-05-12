package soccerleague.model;

//import java.time.LocalDate;
import soccerleague.model.dto.Player;
import soccerleague.model.dto.Storable;
import soccerleague.model.dto.Team;

import java.util.*;

public class Database {
    //Arreglo para almacenar jugadores
    private List<Player> jugadores;
    //Arreglo para almacenar Equipos
    private List<Team> equipos;

    public Database(){
        this.init();
    }


    public void init(){
        this.jugadores = new ArrayList<>();
        this.equipos = new ArrayList<>();
    }

    /**
     *
     * @param dto Data Transfer Object
     */
    public void save(Storable dto) throws DatabaseException{
        if(dto instanceof Player){
            if(findById((Player) dto) == null) {
                this.jugadores.add((Player) dto);
            }else{
                throw new DatabaseException(DatabaseException.ITEM_ALREADY_EXISTS, "The player has been added to database");
            }
        }else if(dto instanceof Team){
            if(findById((Team) dto) == null) {
                this.equipos.add((Team) dto);;
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
                         System.out.println("se ha modificado la posición [" + playerDto.getPosition()+ "] por la posición [" + playerFound.getPosition()+"]");
                         playerFound.setPosition(playerDto.getPosition());
                     }
                     if(playerDto.getNumber() != null){
                         System.out.println("se ha modificado el número [" + playerDto.getNumber()+ "] por el número [" + playerFound.getNumber()+"]");
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

    public Storable findById (Storable dto) {

        Storable result = null;
        String  nameId = "";
        Integer code = -1;

        if (dto instanceof Player) {
            for (Player current : jugadores) {
                nameId = current.getName();
                if (((Player) dto).getName().equals(null)){
                    // lanzar exception
                }else if (nameId.equalsIgnoreCase(((Player) dto).getName())) {  //convierte el tipo de dato de storable a objeto y trae el atributo con el get
                    this.jugadores.indexOf(current);
                    result = current;
                }
            }
        }else if(dto instanceof Team){
            Team teamDto = (Team) dto;
            for (Team current : equipos) {
                code = current.getCodeTeam();
                if (teamDto.getCodeTeam() != null || ((Team) dto).getCodeTeam() < 0 ){
                    // lanzar exception
                }else if (code == teamDto.getCodeTeam()) {
                    this.equipos.indexOf(current);
                    result = current;
                }
            }
        }

        return result;
    }

    public int playersListSize(){
        return this.jugadores.size();
    }

}