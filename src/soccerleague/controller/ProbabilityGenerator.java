package soccerleague.controller;

import soccerleague.controller.finders.PlayerFinder;
import soccerleague.model.dto.Team;

public interface ProbabilityGenerator extends PlayerFinder{
    void generateProbability(Team t);
}