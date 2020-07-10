package soccerleague.threadtest.classic;

import soccerleague.constants.BusinessRules;
import soccerleague.constants.PlayerPosition;
import soccerleague.controller.Controller;
import soccerleague.model.dto.Player;
import soccerleague.model.dto.Team;
import soccerleague.simulator.Simulator;
import soccerleague.simulator.SimulatorMatch;

public class RunnableExample implements Runnable {

    private String name;

    public RunnableExample(String name) {
        this.name = name;
    }

    @Override
    public void run() {


            Controller controller = new Controller();

            Player[] team1 = {new Player("Alisson", PlayerPosition.GK, 1, 22, 310000),
                    new Player("A. Robertson", PlayerPosition.DF, 3, 22, 320000),
                    new Player("Alexander-Arnold", PlayerPosition.DF, 4, 22, 330000),
                    new Player("V. Van Dijk", PlayerPosition.DF, 5, 22, 530000),
                    new Player("Fabinho", PlayerPosition.MD, 8, 22, 830000),
                    new Player("J. Henderson", PlayerPosition.MD, 10, 22, 630000),
                    new Player("N. Keïta", PlayerPosition.MD, 6, 22, 730000),
                    new Player("G. Wijnaldum", PlayerPosition.MD, 7, 22, 300070),
                    new Player("M. Salah", PlayerPosition.FW, 9, 22, 370000),
                    new Player("S. Mané", PlayerPosition.FW, 2, 22, 130000),
                    new Player("R. Firmino", PlayerPosition.FW, 11, 22, 300600)};

            Player[] team2 = {new Player("G. Buffon", PlayerPosition.GK, 1, 22, 310000),
                    new Player("Alex Sandro", PlayerPosition.DF, 3, 22, 320000),
                    new Player("G. Chiellini", PlayerPosition.DF, 4, 22, 330000),
                    new Player("L. Bonucci", PlayerPosition.DF, 2, 22, 130000),
                    new Player("Danilo", PlayerPosition.DF, 5, 22, 530000),
                    new Player("J. Cuadrado", PlayerPosition.MD, 8, 22, 830000),
                    new Player("B. Matuidi", PlayerPosition.MD, 10, 22, 630000),
                    new Player("M. Pjanić", PlayerPosition.MD, 6, 22, 730000),
                    new Player("P. Dybala", PlayerPosition.MD, 9, 22, 300070),
                    new Player("C. Ronaldo", PlayerPosition.FW, 7, 22, 370000),
                    new Player("G. Higuaín", PlayerPosition.FW, 11, 22, 300600)};

            Player[] team3 = {new Player("Thibaut Courtois", PlayerPosition.GK, 1, 22, 310000),
                    new Player("Dani Carvajal", PlayerPosition.DF, 3, 22, 320000),
                    new Player("Marcelo", PlayerPosition.DF, 4, 22, 330000),
                    new Player("Sergio Ramos", PlayerPosition.DF, 2, 22, 130000),
                    new Player("Raphaël Varane", PlayerPosition.DF, 5, 22, 530000),
                    new Player("Toni Kroos", PlayerPosition.MD, 8, 22, 830000),
                    new Player("James Rodríguez", PlayerPosition.MD, 10, 22, 630000),
                    new Player("Federico Valverde", PlayerPosition.MD, 6, 22, 730000),
                    new Player("Casemiro", PlayerPosition.MD, 9, 22, 300070),
                    new Player("Karim Benzema", PlayerPosition.FW, 7, 22, 370000),
                    new Player("Eden Hazard", PlayerPosition.FW, 11, 22, 300600)};

            Player[] team4 = {new Player("Jan Oblak", PlayerPosition.GK, 1, 22, 310000),
                    new Player("Santiago Arias", PlayerPosition.DF, 3, 22, 320000),
                    new Player("José Giménez", PlayerPosition.DF, 4, 22, 330000),
                    new Player("Stefan Savić", PlayerPosition.DF, 2, 22, 130000),
                    new Player("Renan Lodi", PlayerPosition.DF, 5, 22, 530000),
                    new Player("Šime Vrsaljko", PlayerPosition.DF, 8, 22, 830000),
                    new Player("Koke", PlayerPosition.MD, 10, 22, 630000),
                    new Player("Saúl", PlayerPosition.MD, 6, 22, 730000),
                    new Player("Thomas Partey", PlayerPosition.MD, 9, 22, 300070),
                    new Player("Yannick Carrasco", PlayerPosition.MD, 7, 22, 370000),
                    new Player("Diego Costa", PlayerPosition.FW, 11, 22, 300600)};

            Team t1 = new Team(10, "Liverpool", team1);
            Team t2 = new Team(11, "Juventus", team2);
            Team t3 = new Team(12, "Real Madrid", team3);
            Team t4 = new Team(13, "Atlético de Madrid", team4);

            controller.saveValidateTeam(t1, BusinessRules.teamSizeRule, BusinessRules.fixedPositionRules, BusinessRules.exclusivePlayerRule);
            controller.saveValidateTeam(t2, BusinessRules.teamSizeRule, BusinessRules.fixedPositionRules, BusinessRules.exclusivePlayerRule);
//            controller.saveValidateTeam(t3, BusinessRules.teamSizeRule, BusinessRules.fixedPositionRules, BusinessRules.exclusivePlayerRule);
//            controller.saveValidateTeam(t4, BusinessRules.teamSizeRule, BusinessRules.fixedPositionRules, BusinessRules.exclusivePlayerRule);

            Simulator sim1 = new SimulatorMatch();
            System.out.println(name + sim1.simulateMatch(t2, t1).getFullResume());

        }
    }
