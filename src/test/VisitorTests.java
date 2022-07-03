package test;

import main.Exceptions.FileIsIncorrectException;
import main.Game.BasketballGame;
import main.Game.HandballGame;
import main.GameParametres.BasketballGameParametres;
import main.GameParametres.HandballGameParametres;
import main.Parser.BasketballParser;
import main.Parser.HandballParser;
import main.Visitors.*;
import main.main.Tournament;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class VisitorTests {
    BasketballParser bp = new BasketballParser();
    HashSet<BasketballGameParametres> basketballGameParametresHashSet;

    HandballParser hp = new HandballParser();
    HashSet<HandballGameParametres> handballGameParametresHashSet;

    @Test
    public void testVisitorMethods()
    {
        {
            try {
                handballGameParametresHashSet = hp.Parse("test2.csv");
                basketballGameParametresHashSet = bp.Parse("test1.csv");
                HandballGame hg = new HandballGame();
                BasketballGame bg = new BasketballGame();
                hg.setHandballGameParametresHashSet(handballGameParametresHashSet);
                bg.setBasketballGameParametresHashSet(basketballGameParametresHashSet);
                HashMap<String, Integer> playersRate = new HashMap<>();
                Tournament tournament1 = new Tournament(playersRate);
                Visitor visitor = new Visitor();
                HashMap<String, Integer> newMap = hg.countRate(tournament1.getRate(), visitor);
                tournament1.setRate(newMap);
                assertThat(newMap.get("nick1")).isEqualTo(25);
                playersRate = new HashMap<>();
                Tournament tournament2 = new Tournament(playersRate);
                HashMap<String, Integer> newMap1 = bg.countRate(tournament2.getRate(), visitor);
                tournament1.setRate(newMap1);
                assertThat(newMap1.get("nick1")).isEqualTo(29);
            } catch (FileIsIncorrectException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
