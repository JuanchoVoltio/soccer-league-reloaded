package soccerleague.simulator;

import soccerleague.model.dto.Team;
import soccerleague.simulator.model.MatchResume;
import soccerleague.simulator.model.Resume;

public class SimulatorMatch implements Simulator{

    Resume Match1 = new Resume();


    @Override
    public MatchResume simulateMatch(Team visitor, Team local) {

        double PPORCENT = 0.3;
        int pAttackLocal = (int)(local.getAttackProbability()*PPORCENT);
        int pAttackVisitor = (int)(visitor.getAttackProbability()*PPORCENT);
        int pDefenseLocal = (int)(local.getDefenseProbability()*PPORCENT);
        int pDefenseVisitor = (int)(visitor.getDefenseProbability()*PPORCENT);

        Match1.setNameLocal(local.getNameTeam());
        Match1.setNameVisitor(visitor.getNameTeam());

        int maxProbabilityAttack = (int)((pAttackVisitor + pAttackLocal));

        for (int i =0; i<90;i++){

            int raffleAttackTeam = (int) Math.floor(Math.random()*(99)+1);
            int raffleArchery = (int) Math.floor(Math.random()*((int)(99*PPORCENT))+1);

            if (maxProbabilityAttack < (int)(100*PPORCENT)) {

                if(raffleAttackTeam < pAttackLocal){

                    if (raffleArchery > pDefenseVisitor)
                        Match1.localAnotation(i);

                }else if (raffleAttackTeam < maxProbabilityAttack){

                    if (raffleArchery > pDefenseLocal){
                        Match1.visitorAnotation(i);
                    }
                }
            }else if (raffleAttackTeam < (int)(100*PPORCENT/2)){

                if (raffleArchery > pDefenseVisitor)
                    Match1.localAnotation(i);

            }else if (raffleArchery > pDefenseLocal)
                Match1.visitorAnotation(i);

            Match1.setEventForMinute(i);
        }
        return Match1;
    }

}