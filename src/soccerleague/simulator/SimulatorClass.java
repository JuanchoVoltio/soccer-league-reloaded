package soccerleague.simulator;

import soccerleague.model.dto.Team;
import soccerleague.simulator.model.MatchResume;
import soccerleague.simulator.model.MatchResumeClass;

public class SimulatorClass implements Simulator{
    
    MatchResumeClass Match1 = new MatchResumeClass();
    
       
    @Override
    public MatchResume simulateMatch(Team visitor, Team local) {
       
        int pAttackVisitor = visitor.getAttackProbability();
        int pAttackLocal = local.getAttackProbability();
        int pDefenseVisitor = visitor.getAttackProbability();
        int pDefenseLocal = local.getAttackProbability();
        
        Match1.setNameLocal(local.getNameTeam());
        Match1.setNameVisitor(visitor.getNameTeam());
        
        int totalProbabilityAttack = (pAttackVisitor + pAttackLocal)-50;
        
        for (int i =0; i<90;i++){
            
            int raffleAttackTeam = (int) Math.floor(Math.random()*(99)+1);
            int archery = (int) Math.floor(Math.random()*(99)+1);
            if (totalProbabilityAttack < 100) {
                
                if(raffleAttackTeam < totalProbabilityAttack){
                    
                    switch(raffleAttackTeam){
                        case 6:
                            Match1.localAnotation(i);
                        case 7:
                            Match1.localAnotation(i);
                        default:
                            Match1.localAnotation(i);
                                
                    }
                        if (pAttackVisitor > pAttackLocal){

                            if (raffleAttackTeam < pAttackLocal){

                                if (archery > pDefenseVisitor) 
                                     Match1.localAnotation(i);

                            }else 
                                
                                if (archery > pDefenseLocal){ 
                                     Match1.visitorAnotation(i);
                            }

                        }else if (raffleAttackTeam < pAttackVisitor){
                                    if (archery > pDefenseLocal) 
                                        Match1.visitorAnotation(i);
                                }else{
                                    if (archery > pDefenseVisitor)
                                        Match1.localAnotation(i);
                            }   
                }
            }else{     
            
                 if (raffleAttackTeam < pAttackLocal){

                     if (archery > pDefenseVisitor) 
                           Match1.localAnotation(i);

                     }else if (archery > pDefenseLocal){ 
                           Match1.visitorAnotation(i);
                     }  
                    
            }
          Match1.setEventForMinute(i);
        }
        
        return Match1;
    }
    
}
