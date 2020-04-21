package soccerleague.model.dto;

public class Team implements Storable {
    private Integer codeTeam;
    private String nameTeam;
    private double probabilityAttac;
    private double probabilityDefense;
    private Player[] lineup;

    public Team(int codeTeam, String nameTeam ) {
        this.codeTeam = codeTeam;
        this.nameTeam = nameTeam;
        this.lineup   = new Player[11];
    }

    public Team(int codeTeam, String nameTeam, Player[] lineup) {
        this(codeTeam, nameTeam);
        //TODO: [1] Validar que el arreglo que llegue tenga 11 jugadores, con la distribución para las formaciones: 4-4-2 y 3-4-3
        this.lineup = lineup;
    }

    public void validate (Team team ){

    }

    // KD
    public Player[] getPlayers()
    {
        return lineup;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public double getProbabilityAttac() {
        return probabilityAttac;
    }

    public void setProbabilityAttac(double probabilityAttac) {
        this.probabilityAttac = probabilityAttac;
    }

    public double getProbabilityDefense() {
        return probabilityDefense;
    }

    public void setProbabilityDefense(double probabilityDefense) {
        this.probabilityDefense = probabilityDefense;
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
        return "Name Team : " + this.getNameTeam() + " , Probability Atack :" + this.getProbabilityAttac() + " , Probability Defense: " + this.getProbabilityDefense() + "\r"+
                "Players : " + "\r" + this.lineup[0]+this.lineup[1]+this.lineup[2]+this.lineup[3]+this.lineup[4]+this.lineup[5]+this.lineup[6]+this.lineup[7]+this.lineup[8]+this.lineup[9]+this.lineup[10]+ "\r";

        //+ this.getNumber() + ") - [" + this.getPosition() + "]";
    }
}
