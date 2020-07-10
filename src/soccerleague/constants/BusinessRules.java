package soccerleague.constants;


import soccerleague.model.dto.Constants;
import soccerleague.model.dto.Team;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BusinessRules{



    public static BiPredicate<Team, Collection<Team>> exclusivePlayerRule = (team, list) ->
    {
        return Arrays.asList(team.getLineup()).stream().allMatch(s-> list.stream().allMatch(p -> Arrays.asList(p.getLineup()).stream().noneMatch(t-> t.getName().equals(s.getName()))));
    };


    public static Predicate<Team> fixedPositionRules = t -> {
        List gk = Arrays.asList(t.getLineup()).stream().filter(p -> p.getPosition().equals(PlayerPosition.GK)).collect(Collectors.toList());
        List md = Arrays.asList(t.getLineup()).stream().filter(p -> p.getPosition().equals(PlayerPosition.MD)).collect(Collectors.toList());
        List df = Arrays.asList(t.getLineup()).stream().filter(p -> p.getPosition().equals(PlayerPosition.DF)).collect(Collectors.toList());
        List fw = Arrays.asList(t.getLineup()).stream().filter(p -> p.getPosition().equals(PlayerPosition.FW)).collect(Collectors.toList());

        return gk.size() == 1 && md.size() == 4 && df.size() > 0 && fw.size() > 0 && df.size() + fw.size() == 6;
    };

    public static Predicate<Team> teamSizeRule = t -> {
        List result = Arrays.asList(t.getLineup()).stream().filter(p -> p != null).collect(Collectors.toList());
        return result.size() == Constants.TEAM_SIZE;



    };

}