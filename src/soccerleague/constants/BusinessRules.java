package soccerleague.constants;

import soccerleague.model.Database;
import soccerleague.model.dto.Constants;
import soccerleague.model.dto.Player;
import soccerleague.model.dto.Team;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BusinessRules{
    public static BiPredicate<Team, Collection<Team>> exclusivePlayerRule = (team, list) -> {

      List<String> namePlayers= new ArrayList<>();
       for (Team t : list) {
            for (Player p : t.getPlayers()) {
                namePlayers.add(p.getName());
            }
       }
        List repeatPlayers = Arrays.asList(team.getPlayers()).stream().filter(p -> p.getName().equals(p.getName())).collect(Collectors.toList());

        return repeatPlayers.isEmpty();
    };


    public static Predicate<Team> fixedPositionRules = t -> {
        List gk = Arrays.asList(t.getPlayers()).stream().filter(p -> p.getPosition().equals(PlayerPosition.GK)).collect(Collectors.toList());
        List md = Arrays.asList(t.getPlayers()).stream().filter(p -> p.getPosition().equals(PlayerPosition.MD)).collect(Collectors.toList());
        List df = Arrays.asList(t.getPlayers()).stream().filter(p -> p.getPosition().equals(PlayerPosition.DF)).collect(Collectors.toList());
        List fw = Arrays.asList(t.getPlayers()).stream().filter(p -> p.getPosition().equals(PlayerPosition.FW)).collect(Collectors.toList());
        List sumPosition = Arrays.asList(t.getPlayers()).stream().filter(p -> p.getPosition().equals(PlayerPosition.FW) && p.getPosition().equals(PlayerPosition.DF)).collect(Collectors.toList());
        return gk.size() == 1 && md.size() == 4 && df.size() > 0 && fw.size() > 0 && sumPosition.size() == 6;
    };

    public static Predicate<Team> teamAlignmentRules = t -> {
        return false;
    };

    public static Predicate<Team> teamSizeRule = t -> {
        List result = Arrays.asList(t.getPlayers()).stream().filter(p -> p != null).collect(Collectors.toList());
        return result.size() == Constants.TEAM_SIZE;
    };

}