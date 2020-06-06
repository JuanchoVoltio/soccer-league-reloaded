package soccerleague.constants;

import soccerleague.model.dto.Team;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BusinessRules {
    public static BiPredicate<Team, Collection<Team>> exclusivePlayerRule = (team, list) -> {return false;};


    public static Predicate<Team> fixedPositionRules = t -> {
                                                                List gk = Arrays.asList(t.getPlayers()).stream().filter(p -> p == null).collect(Collectors.toList());
                                                                List md = Arrays.asList(t.getPlayers()).stream().filter(p -> p == null).collect(Collectors.toList());
                                                                return gk.size() == 1 && md.size() == 4;
                                                            };

    public static Predicate<Team> teamSizeRule = t -> {
                                                        List result = Arrays.asList(t.getPlayers()).stream().filter(p -> p == null).collect(Collectors.toList());
                                                        return result.size() == 0;
                                                    };

}
