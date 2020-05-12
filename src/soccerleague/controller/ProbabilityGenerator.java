package soccerleague.controller;

import soccerleague.model.dto.Team;

public interface ProbabilityGenerator {
    void generateProbability(Team t);
}
