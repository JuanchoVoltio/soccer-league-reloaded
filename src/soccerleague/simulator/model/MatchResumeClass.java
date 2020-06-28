
package soccerleague.simulator.model;

public class MatchResumeClass implements MatchResume {
    
    private int eventForMinute[][]= new int[2][90];
    private int localScore;
    private int visitorScore;
    private int fullResume[] = new int[2];
    private String nameLocal;
    private String nameVisitor;
    
    

    @Override
    public String getEventForMinute(int minute) {
        return "\n Minute: "+minute+"\n Local Score: "+ nameLocal +": "+ eventForMinute[0][minute]+"\n Visitor Score: "+ nameVisitor +": " + eventForMinute[1][minute];
    }


    @Override
    public int getLocalScore() {
       return localScore;
    }

   
    @Override
    public int getVisitorScore() {
       return visitorScore;
    }


    @Override
    public String getFullResume() {
                    
          if (eventForMinute[0][89] > eventForMinute[1][89]){
             return "\nGanó el Local: "+ nameLocal+" "+localScore+"-"+visitorScore;
          }else if(eventForMinute[0][89] == eventForMinute[1][89]){
             return "\nEmpate: "+localScore+"-"+visitorScore;
          }else{
             return "\nGanó el visitante: "+ nameVisitor+" "+visitorScore+"-"+localScore;
          }
    }
    
    
    
    public void setEventForMinute(int min) {
        
       // this.eventForMinute = eventForMinute;
         eventForMinute[0][min] = localScore;
         eventForMinute[1][min] = visitorScore;
    }


    public void setLocalScore(int localScore) {
        this.localScore = localScore;
    }

   
    public void setVisitorScore(int visitorScore) {
        this.visitorScore = visitorScore;
    }


    public void setFullResume(int[] fullResume) {
        
        this.fullResume = fullResume;
    }
    public void setNameLocal(String nameLocal){
        this.nameLocal = nameLocal;
    }
    
    public void setNameVisitor(String nameVisitor){
        this.nameVisitor = nameVisitor;
    }  
    
    
    public void localAnotation(int min){
        localScore = localScore +1;
       
       
    }
    
    public void visitorAnotation(int min){
        visitorScore = visitorScore +1;
       
    }
    
}
