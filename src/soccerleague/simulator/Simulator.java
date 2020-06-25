package soccerleague.simulator;

import soccerleague.model.dto.Team;
import soccerleague.simulator.model.MatchResume;

public interface Simulator {

    MatchResume simulateMatch(Team visitor, Team local);

}
