package soccerleague.controller.finders;

import soccerleague.model.dto.Player;

public class FindByAgeRange implements PlayerFinder {

    private int minAge;
    private int maxAge;

    public FindByAgeRange(int minAge, int maxAge){
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Override
    public boolean validacion(Player p){
        return (p.getAge().intValue() >= minAge) && (p.getAge().intValue() <= maxAge);
    }
}