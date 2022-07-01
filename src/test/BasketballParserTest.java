package test;

import main.Exceptions.FileIsIncorrectException;
import main.GameParametres.BasketballGameParametres;
import main.Parser.BasketballParser;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import java.util.HashSet;

public class BasketballParserTest {
    BasketballParser bp = new BasketballParser();
    HashSet<BasketballGameParametres> basketballGameParametresHashSet;

    @Test
    public void testBasketballParser()
    {
        {
            try {
                HashSet<String> teamNames = new HashSet<>();
                basketballGameParametresHashSet = bp.Parse("test1.csv");
                assertThat(basketballGameParametresHashSet).isNotEmpty();
                for (BasketballGameParametres bgp : basketballGameParametresHashSet) {
                    assertThat(bgp.getAssists()).isGreaterThanOrEqualTo(0);
                    assertThat(bgp.getRebounds()).isGreaterThanOrEqualTo(0);
                    assertThat(bgp.getScoredPoints()).isGreaterThanOrEqualTo(0);
                    if (bgp.getNickName().equals("nick1")){
                        assertThat(bgp.getPlayerName().equals("player 1"));
                    }
                    teamNames.add(bgp.getTeamName());
                }
                assertThat(teamNames.size()).isEqualTo(2);
                System.out.println("BasketballParser Tests Passed!");
            } catch (FileIsIncorrectException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
