package soccerleague.util;

import java.util.List;
import java.util.function.Predicate;

import soccerleague.model.dto.Player;
import soccerleague.model.dto.Storable;
import soccerleague.model.dto.Team;

public class UtilSL {

	public static void printData(List<Storable> lst,Predicate pred) {
		if(lst != null && !lst.isEmpty()) { 
			Storable firstdata = lst.get(0);
			if(firstdata instanceof Player ) {
				System.out.println("===== JUGADORES =====");
				for (Storable storable : lst) {
					if(pred.test(storable)) {
						Player p = (Player) storable;
						System.out.println("NOMBRE (" + (p.getName() != null ? p.getName() : "N/A") + ")");
						System.out.println("NUMERO (" + (p.getNumber() != null ? p.getNumber() : "N/A") + ")");
						System.out.println("EDAD (" + (p.getAge() != null ? p.getAge() : "N/A") + ")");
						System.out.println("SALARIO (" + (p.getSalary()!= null ? p.getSalary() : "N/A") + ")");
						System.out.println("POSICION (" + (p.getPosition() != null ? p.getPosition().getDescription() : "N/A" )+ ")");
						System.out.println("TELEFONO (" + (p.getPhoneNumber()!= null ? p.getPhoneNumber() : "N/A") + ")");
						System.out.println("--------------------");
					}
				}
				System.out.println("====================");
			
			}else if(firstdata instanceof Team) {
				System.out.println("===== EQUIPOS =====");
				for (Storable storable : lst) {
					if(pred.test(storable)) {
						Team p = (Team) storable;
						System.out.println("NOMBRE EQUIPO(" + (p.getNameTeam() != null ? p.getNameTeam() : "N/A") + ")");
						System.out.println("CODIGO (" + (p.getCodeTeam() != null ? p.getCodeTeam() : "N/A") + ")");
						System.out.println("PROBABILIDAD ATAQUE (" + p.getProbabilityAttac() + ")");
						System.out.println("PROBABILIDAD DEFENSA (" + p.getProbabilityDefense() + ")");
						System.out.println("--------------------");
					}
				}
				System.out.println("====================");
			}else {
				System.out.println("===== EL TIPO DE DATO NO HA SIDO IMPLEMENTADO =====");
			}
			
		}
	}

}
