package soccerleague.model.dto;

import soccerleague.constants.PlayerPosition;

public final class Player implements Storable, Comparable<Player>{



    private String name;
    private PlayerPosition position;
    private Integer number;
    private Integer age;
    private Integer phoneNumber;
    private Integer salary;

    public Player(String name){
        this.setName(name);
    }

//    public Player(String name, String position, Integer number){
//        this(name);
//        this.position = position;
//        this.number = number;
//    }

//    public Player(String name, PlayerPosition position, Integer number){
//        this(name);
//        this.position = position;
//        this.number = number;
//    }

    public Player(String name, PlayerPosition position, Integer number, Integer age, Integer salary){
        this(name);
        this.position = position;
        this.number = number;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
        return " Name: " + this.getName() + " Number: (" + this.getNumber() + ")  Position: [" + this.getPosition().getDescription() + "] "
                + "Edad: " + this.getAge() + " Salary: "+ this.getSalary();
    }

    @Override
    public boolean equals(Object o){

        //TODO: Agregar comparación para los nuevos atributos

        boolean answer = false;
        if(o != null) {
            Player obj = (Player) o;
            answer = (obj.name.equals(this.name))
                    && (obj.number.intValue() == this.number.intValue())
                    && (obj.position.equals(this.position))
                    && (obj.age.intValue() == this.age.intValue())
                    && (obj.phoneNumber.intValue() == this.phoneNumber.intValue())
                    && (obj.salary.intValue() == this.salary.intValue());
        }
        return answer;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() * this.position.hashCode() + this.number + this.age + this.salary;
    }

    @Override
    public void printClassType() {
        System.out.println(this.getClass().getCanonicalName() + " - From subclass" + " - " + this.toString());
    }

	@Override
	public int compareTo(Player dto) {
		
		
		
		return 0;
	}
}
