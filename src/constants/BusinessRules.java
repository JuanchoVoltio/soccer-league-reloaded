package constants;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import soccerleague.model.dto.Team;
import static constants.PlayerPosition.*;


public class BusinessRules {
    
    public static BiPredicate<Team, Collection<Team>> exclusivePlayerRule = (team, list) -> {return true;   };

  //  public static BiPredicate<Team, Collection<Team>> exclusivePlayerRule = (team, list) -> {Arrays.asList(team.getLineup()).get(0);
                                                                                           //  return true;   };

    public static Predicate<Team> fixedPositionRules = t -> {
                                                                List gk = Arrays.asList(t.getLineup()).stream().filter(p -> p.getPosition() == GK).collect(Collectors.toList());
                                                                List md = Arrays.asList(t.getLineup()).stream().filter(p -> p.getPosition() == MD).collect(Collectors.toList());
                                                                List fw = Arrays.asList(t.getLineup()).stream().filter(p -> p.getPosition() == FW).collect(Collectors.toList());
                                                                List df = Arrays.asList(t.getLineup()).stream().filter(p -> p.getPosition() == DF).collect(Collectors.toList());
                                                                return gk.size() == 1 && md.size() == 4 && (fw.size()+df.size()) == 6 && fw.size() > 0  && df.size()> 0;
                                                            };

    public static Predicate<Team> teamSizeRule = t -> {
                                                        List result = Arrays.asList(t.getLineup()).stream().filter(p -> p != null).collect(Collectors.toList());
                                                        return result.size() == 11;
                                                    };
    
    
    
}
