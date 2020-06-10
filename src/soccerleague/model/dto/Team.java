package soccerleague.model.dto;

import java.util.Arrays;

public class Team implements Storable {
   private Integer codeTeam;
    private String nameTeam;
    private Player[] lineup;
    
// Contructors----------------------------------------------------------
    
    public Team(int codeTeam, String nameTeam, Player[] lineup) {
        
        this.codeTeam = codeTeam;
        this.nameTeam = nameTeam;
        this.lineup = lineup;
    }
    
// Get and SET ---------------------------------------------------------
    public Integer getCodeTeam(){
        return codeTeam;
    }
    
    public void setCodeTeam(Integer codeTeam){
        this.codeTeam = codeTeam;
    }
    
 
    public String getNameTeam(){
        return nameTeam;
    }
    
    public void setNameTeam(String nameTeam){
        this.nameTeam = nameTeam;
    }
    
    public Player[] getLineup (){
        return lineup;
    }
    
    public void setLineup(Player[] lineup){
        this.lineup = lineup;
    }
     
    
// override metods---------------------------------------------------------------------    
     @Override
    public String toString(){
        return "Name Team : " + this.getNameTeam()+ "\r" + "Players : " + "\r" 
                + this.lineup[0]+ "\r"+this.lineup[1]+ "\r"+this.lineup[2]+ "\r"+this.lineup[3]+ "\r"
                +this.lineup[4]+ "\r"+this.lineup[5]+ "\r"+this.lineup[6]+ "\r"+this.lineup[7]+ "\r"
                +this.lineup[8]+ "\r"+this.lineup[9]+ "\r"+this.lineup[10]+ "\r";

        //+ this.getNumber() + ") - [" + this.getPosition() + "]";
    } 
    
     @Override
    public boolean equals(Object o){

        //TODO: Agregar comparaci�n para los nuevos atributos

        boolean answer = false;
        if(o != null && o instanceof Team) {
            Team obj = (Team) o;
            answer = (obj.nameTeam.equals(this.nameTeam))
                    && (obj.codeTeam.intValue() == this.codeTeam.intValue())
                    && (Arrays.equals(obj.lineup, this.lineup));
        }
        return answer;
    }

    @Override
    public int hashCode() {
        return this.nameTeam.hashCode() * this.codeTeam.hashCode() + this.codeTeam;
    } 
}
