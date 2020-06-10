package soccerleague.model.dto;

import constants.PlayerPosition;

public final class Player implements Storable {

    private String name;
    private PlayerPosition position;
    private Integer number;
    private Integer age;
    private Integer salary;
   
    
// Contructor--------------------------------------------------------
    
    public Player(String name, PlayerPosition position, Integer number, Integer age, Integer salary){
        this.name = name;
        this.position = position;
        this.number = number;
        this.age = age;
        this.salary = salary;
    }
    
// get y set-----------------------------------------------------------
    

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
    
     public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
     public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

// Override Methods -------------------------------------------------

     @Override
    public String toString(){
        return " Name: " + this.getName() + "(" + this.getNumber() + ") - [" + this.getPosition().getDescription() + "]";
    }

    @Override
    public boolean equals(Object o){

        //TODO: Agregar comparaci�n para los nuevos atributos

        boolean answer = false;
        if(o != null && o instanceof Player) {
            Player obj = (Player) o;
            answer = (obj.name.equals(this.name))
                    && (obj.number.intValue() == this.number.intValue())
                    && (obj.position.equals(this.position));
        }
        return answer;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() * this.position.hashCode() + this.number;
    } 
}
