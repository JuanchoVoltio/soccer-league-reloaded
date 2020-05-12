package soccerleague.model.dto;

import soccerleague.constants.PlayerPosition;

public final class Player implements Storable {

    public static final String POSITION_GK = "A";
    public static final String POSITION_DF = "B";

    private String name;
    private PlayerPosition position;
    private Integer number;

    public Player(String name){
        this.setName(name);
    }

//    public Player(String name, String position, Integer number){
//        this(name);
//        this.position = position;
//        this.number = number;
//    }

    public Player(String name, PlayerPosition position, Integer number){
        this(name);
        this.position = position;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public void setPosition(PlayerPosition position) {
        this.position = position;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString(){
        return " Name: " + this.getName() + "(" + this.getNumber() + ") - [" + this.getPosition().getDescription() + "]";
    }

    @Override
    public boolean equals(Object o){

        boolean answer = false;
        if(o != null) {
            Player obj = (Player) o;
            answer = (obj.name == this.name || obj.name.equals(this.name))
                    && (obj.number == this.number || obj.number.intValue() == this.number.intValue())
                    && (obj.position.equals(this.position));
        }
        return answer;
    }

    @Override
    public void printClassType() {
        System.out.println(this.getClass().getCanonicalName() + " - From subclass" + " - " + this.toString());
    }
}
