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
        return "\nName Team : " + this.getNameTeam()
        
                + "\n" + "Players : " + "\n" 
                + this.lineup[0]+ "\n"+this.lineup[1]+ "\n"+this.lineup[2]+ "\n"+this.lineup[3]+ "\n"
                +this.lineup[4]+ "\n"+this.lineup[5]+ "\n"+this.lineup[6]+ "\n"+this.lineup[7]+ "\n"
                +this.lineup[8]+ "\n"+this.lineup[9]+ "\n"+this.lineup[10]+ "\n";

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
