package soccerleague.controller.keeping;

import soccerleague.model.dto.Player;
import soccerleague.model.dto.Storable;;

public interface PlayerSave {

	boolean isValid(Player p);
}
