package soccerleague.controller.finders;

import soccerleague.model.dto.Player;

public interface PlayerFinder {
    boolean isValid(Player p);
}
