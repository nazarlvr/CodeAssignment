package main.Game;

import main.GameParametres.BasketballGameParametres;
import main.Visitors.IVisitor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BasketballGame extends Game{
private HashSet<BasketballGameParametres> basketballGameParametresHashSet;
    @Override
    void countRate(HashMap<String, Integer> rateByNickname, IVisitor visitor) {
        visitor.countBasketballRate(rateByNickname, this);
    }

    public void setBasketballGameParametresHashSet(HashSet<BasketballGameParametres> basketballGameParametresHashSet) {
        this.basketballGameParametresHashSet = basketballGameParametresHashSet;
    }

    public HashSet<BasketballGameParametres> getBasketballGameParametresHashSet() {
        return basketballGameParametresHashSet;
    }
}
