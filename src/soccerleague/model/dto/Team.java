package soccerleague.model.dto;

import java.util.Arrays;

public class Team implements Storable {
    private Integer codeTeam;
    private String nameTeam;
    private int defenseProbability;
    private int attackProbability;
    private Player[] lineup;

    public Team(int codeTeam, String nameTeam, Player[] lineup) {
        this.codeTeam = codeTeam;
        this.nameTeam = nameTeam;
        this.lineup   = lineup;

    }

//    public Team(int codeTeam, String nameTeam, Player[] lineup, double probabilityDefense,) {
//        this(codeTeam, nameTeam);
//        //TODO: [1] Validar que el arreglo que llegue tenga 11 jugadores, con la distribución para las formaciones: 4-4-2 y 3-4-3
//        this.lineup = lineup;
//        this.probabilityAttac = probabilityAttac;
//        this.probabilityDefense = probabilityDefense ;
//
//    }

    public void validate (Team team ){

    }

    // KD
    public Player[] getLineup(){return lineup;}

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public double getAttackProbability() {
        return attackProbability;
    }

    public void setAttackProbability(int d) {
        this.attackProbability = d;
    }

    public double getDefenseProbability() {
        return defenseProbability;
    }

    public void setDefenseProbability(int d) {
        this.defenseProbability = d;
    }

    public void setLineup(Player[] lineup){
        this.lineup = lineup;
    }

    /**
     * @return the codeTeam
     */
    public Integer getCodeTeam() {
        return codeTeam;
    }

    /**
     * @param codeTeam the codeTeam to set
     */
    public void setCodeTeam(int codeTeam) {
        this.codeTeam = codeTeam;
    }

    //KD
    @Override
    public String toString(){
        return "Name Team : " + this.getNameTeam() + " , Probability Atack :" + this.getAttackProbability() + " , Probability Defense: " + this.getDefenseProbability() + "\r"+
                "Players : " + "\r" + this.lineup[0]+this.lineup[1]+this.lineup[2]+this.lineup[3]+this.lineup[4]+this.lineup[5]+this.lineup[6]+this.lineup[7]+this.lineup[8]+this.lineup[9]+this.lineup[10]+ "\r";

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
