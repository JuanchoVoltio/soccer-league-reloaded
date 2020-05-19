package soccerleague.controller.comparators;

import soccerleague.model.dto.Player;

import java.util.Comparator;

/**
 * Esta clase se encarga de aplicar dos criterios de comparación para objetos tipo Player
 */
public class PlayersCompositeComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        int result;
        result = o1.getPosition().getCode()
                        .compareTo(o2.getPosition().getCode());
        if(result == 0){
            result = (-1) * o1.getName().compareTo(o2.getName());
        }
        return result;
    }
}
