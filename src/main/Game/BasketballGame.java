package main.Game;

import main.GameParametres.BasketballGameParametres;
import main.Visitors.IVisitor;

import java.util.HashSet;

public class BasketballGame extends Game{
HashSet<BasketballGameParametres> basketballGameParametresHashSet;
    @Override
    void countRate(IVisitor visitor) {
        visitor.countBasketballRate(this);
    }

    public void setBasketballGameParametresHashSet(HashSet<BasketballGameParametres> basketballGameParametresHashSet) {
        this.basketballGameParametresHashSet = basketballGameParametresHashSet;
    }
}
