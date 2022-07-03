package test;

import main.Exceptions.FileIsIncorrectException;
import main.GameParametres.HandballGameParametres;
import main.Parser.HandballParser;
import org.junit.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class HandballParserTest {
    HandballParser hp = new HandballParser();
    HashSet<HandballGameParametres> handballGameParametresHashSet;

    @Test
    public void testHandballParser()
    {
        {
            try {
                HashSet<String> teamNames = new HashSet<>();
                handballGameParametresHashSet = hp.Parse("test2.csv");
                assertThat(handballGameParametresHashSet).isNotEmpty();
                for (HandballGameParametres hgp : handballGameParametresHashSet) {
                    assertThat(hgp.getGoalsMade()).isGreaterThanOrEqualTo(0);
                    assertThat(hgp.getGoalsReceived()).isGreaterThanOrEqualTo(0);
                    if (hgp.getNickName().equals("nick1")){
                        assertThat(hgp.getPlayerName().equals("player 1"));
                    }
                    teamNames.add(hgp.getTeamName());
                }
                assertThat(teamNames.size()).isEqualTo(2);
                System.out.println("HandballParser Tests Passed!");
            } catch (FileIsIncorrectException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
