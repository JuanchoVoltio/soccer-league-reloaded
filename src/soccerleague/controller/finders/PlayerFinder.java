package soccerleague.controller.finders;

import soccerleague.model.dto.Player;
import soccerleague.model.dto.Storable;

public interface PlayerFinder {
    boolean isValid(Player p);
}
