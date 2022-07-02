package main.Visitors;

import main.Game.BasketballGame;
import main.Game.HandballGame;

import java.util.HashMap;
import java.util.Map;

public interface IVisitor {
    void countBasketballRate(HashMap<String, Integer> rateByNickname, BasketballGame Game);
    void countHandballRate(HashMap<String, Integer> rateByNickname, HandballGame Game);
}
