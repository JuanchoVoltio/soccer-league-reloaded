package soccerleague.model.dto;

public interface Storable {
	
	  default void printClassType() {
	        System.out.println(this.getClass().getCanonicalName() + " - From default method");
	    }

}