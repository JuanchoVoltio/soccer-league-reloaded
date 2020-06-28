package soccerleague.simulator;

import soccerleague.model.dto.Team;
import soccerleague.simulator.model.MatchResume;
import soccerleague.simulator.model.MatchResumeClass;

public class SimulatorClass implements Simulator{
    
    MatchResumeClass Match1 = new MatchResumeClass();
    
       
    @Override
    public MatchResume simulateMatch(Team visitor, Team local) {
       
        int pAttackLocal = local.getAttackProbability();
        int pAttackVisitor = visitor.getAttackProbability();
        int pDefenseLocal = local.getDefenseProbability();
        int pDefenseVisitor = visitor.getDefenseProbability();
        
        Match1.setNameLocal(local.getNameTeam());
        Match1.setNameVisitor(visitor.getNameTeam());
        
        int maxProbabilityAttack = (pAttackVisitor + pAttackLocal);
               
        for (int i =0; i<90;i++){
            
            int raffleAttackTeam = (int) Math.floor(Math.random()*(399)+1);
            int raffleArchery = (int) Math.floor(Math.random()*(99)+1);
                       
            if (maxProbabilityAttack < 100) {
                
                if(raffleAttackTeam < pAttackLocal){
                    
                    if (raffleArchery > pDefenseVisitor) 
                      Match1.localAnotation(i);
                    
                }else if (raffleAttackTeam < maxProbabilityAttack){
                    
                    if (raffleArchery > pDefenseLocal){ 
                      Match1.visitorAnotation(i);
                    }
                }
            }else if (raffleAttackTeam < 50){
                    
                        if (raffleArchery > pDefenseVisitor)
                            Match1.localAnotation(i);
                        
                  }else if (raffleArchery > pDefenseLocal) 
                            Match1.visitorAnotation(i);  
        
          Match1.setEventForMinute(i);
        }
        return Match1;
    }
    
}
