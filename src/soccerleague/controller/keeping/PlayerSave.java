package soccerleague.controller.keeping;

import java.util.List;

import soccerleague.model.dto.Player;
import soccerleague.model.dto.Storable;;

public interface PlayerSave {

	boolean isValid(List<Player> p);
}
