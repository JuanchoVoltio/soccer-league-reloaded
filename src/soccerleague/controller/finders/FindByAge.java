package soccerleague.controller.finders;

import soccerleague.model.dto.Player;


public class FindByAge implements PlayerFinder {

    private int referenceAge;

    public FindByAge(int referenceAge){
        this.referenceAge = referenceAge;
    }

    @Override
    public boolean validacion(Player p){
        return p.getAge().intValue() == referenceAge;
    }
}