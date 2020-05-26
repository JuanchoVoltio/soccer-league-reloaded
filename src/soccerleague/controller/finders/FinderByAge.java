package soccerleague.controller.finders;

//import com.sun.tools.classfile.Dependency;
import soccerleague.model.dto.Player;

import java.util.List;

public class FinderByAge implements PlayerFinder {

    private int referenceAge;

    public FinderByAge(int referenceAge){
        this.referenceAge = referenceAge;
    }

    @Override
    public boolean isValid(Player p){
        return p.getAge().intValue() == referenceAge;
    }
}
