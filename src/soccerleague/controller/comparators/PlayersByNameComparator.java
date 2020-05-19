package soccerleague.controller.comparators;

import soccerleague.model.dto.Player;

import java.util.Comparator;

public class PlayersByNameComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
