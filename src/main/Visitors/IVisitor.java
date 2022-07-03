package main.Visitors;

import main.Game.BasketballGame;
import main.Game.HandballGame;

import java.util.HashMap;
import java.util.Map;

public interface IVisitor {
    HashMap<String, Integer> countBasketballRate(HashMap<String, Integer> rateByNickname, BasketballGame Game);
    HashMap<String, Integer> countHandballRate(HashMap<String, Integer> rateByNickname, HandballGame Game);
}
