package main.Visitors;

import main.Game.BasketballGame;
import main.Game.HandballGame;

public interface IVisitor {
    void countBasketballRate(BasketballGame Game);
    void countHandballRate(HandballGame Game);
}
