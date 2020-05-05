package soccerleague.model.dto;

public final class Player implements Storable {

    public static final String POSITION_GK = "GK";
    public static final String POSITION_DF = "DF";

    private String name;
    private String position;
    private Integer number;

    public Player(String name){
        this.setName(name);
    }

    public Player(String name, String position, Integer number){
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
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
        return " Name: " + this.getName() + "(" + this.getNumber() + ") - [" + this.getPosition() + "]";
    }

    @Override
    public boolean equals(Object o){

        boolean answer = false;
        if(o != null) {
            Player obj = (Player) o;
            answer = (obj.name == this.name || obj.name.equals(this.name))
                    && (obj.number == this.number || obj.number.intValue() == this.number.intValue())
                    && (obj.position == this.position || obj.position.equals(this.position));
        }
        return answer;
    }
}
