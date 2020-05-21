package soccerleague.controller.finders;

import soccerleague.model.dto.Player;

public class FinderByAgeRange  implements PlayerFinder {

    private int minAge;
    private int maxAge;

    public FinderByAgeRange(int minAge, int maxAge){
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Override
    public boolean isValid(Player p){
        return (p.getAge().intValue() >= minAge) && (p.getAge().intValue() <= maxAge);
    }
}
