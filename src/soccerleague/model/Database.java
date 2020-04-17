package model;

public class Database {

    public void save(Storable e){
        if(e instanceof Player){
            this.jugadores.add((Player)e);
        }else if(e instanceof Team){
            this.equipos.add((Team)e);
        }
    }
}
