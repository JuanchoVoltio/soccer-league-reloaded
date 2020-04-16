package model;


public class Player implements Storable{
    private String  name;
    private Integer number;
    private String  position; //TODO: [2] Estos deben ser: GK, DF, MF, FW.

    public Player(String name, Integer number, String position){
        this.name = name;
        this.number = number;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    @Override
    public String toString(){
        return "Name: " + this.getName() + "(" + this.getNumber() + ") - [" + this.getPosition() + "]";
    }

    @Override
    public boolean equals(Object o){

        boolean answer = false;

        if(o instanceof Player){
            Player obj = (Player) o;
            answer = (obj.getNumber().intValue() == this.getNumber().intValue()
                && obj.getPosition().equals(this.getPosition())
                && obj.getName().equals(this.getName()));
        }

        return answer;
    }
}
