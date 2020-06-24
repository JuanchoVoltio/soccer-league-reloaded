package soccerleague.constants;

import soccerleague.model.Database;
import soccerleague.model.dto.Constants;
import soccerleague.model.dto.Player;
import soccerleague.model.dto.Storable;
import soccerleague.model.dto.Team;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BusinessRules{
    public static BiPredicate<Team, Collection<Team>> exclusivePlayerRule = (team, list) -> {

        Boolean result = false;

        for (Team t : list) {
            for (Player p : t.getPlayers()) {
                Boolean repeatPlayers = Arrays.asList(team.getPlayers()).stream().noneMatch(pl -> pl.getName().equalsIgnoreCase(p.getName()));
                result = repeatPlayers;
            }
       }

//        List players = Arrays.asList(list.stream().map(l -> (team.getPlayers())).collect(Collectors.toList()));
//        List namePlayers = Arrays.asList(players.stream().map(p -> ((Player) p).getName()).collect(Collectors.toList()));
//        Boolean repeatPlayers = Arrays.asList(team.getPlayers()).stream().noneMatch(p -> p.getName().equals(namePlayers));

        return result;
    };


    public static Predicate<Team> fixedPositionRules = t -> {
        List gk = Arrays.asList(t.getPlayers()).stream().filter(p -> p.getPosition().equals(PlayerPosition.GK)).collect(Collectors.toList());
        List md = Arrays.asList(t.getPlayers()).stream().filter(p -> p.getPosition().equals(PlayerPosition.MD)).collect(Collectors.toList());
        List df = Arrays.asList(t.getPlayers()).stream().filter(p -> p.getPosition().equals(PlayerPosition.DF)).collect(Collectors.toList());
        List fw = Arrays.asList(t.getPlayers()).stream().filter(p -> p.getPosition().equals(PlayerPosition.FW)).collect(Collectors.toList());
        List sumPosition = Arrays.asList(t.getPlayers()).stream().filter(p -> p.getPosition().equals(PlayerPosition.FW) && p.getPosition().equals(PlayerPosition.DF)).collect(Collectors.toList());
        return gk.size() == 1 && md.size() == 4 && df.size() > 0 && fw.size() > 0 && sumPosition.size() == 6;
    };

    public static Function teamAlignmentRules = t -> {

        
        return false;
    };

    public static Predicate<Team> teamSizeRule = t -> {
        List result = Arrays.asList(t.getPlayers()).stream().filter(p -> p != null).collect(Collectors.toList());
        return result.size() == Constants.TEAM_SIZE;



    };

}