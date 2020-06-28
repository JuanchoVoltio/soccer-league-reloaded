package soccerleague.simulator.model;

public interface MatchResume {
    //Información relacionada con el resumen del partido simulado

    String getEventForMinute(int minute);
    int getLocalScore();
    int getVisitorScore();
    String getFullResume();
}
