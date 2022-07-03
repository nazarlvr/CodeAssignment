package main.Game;

import main.GameParametres.BasketballGameParametres;
import main.Visitors.IVisitor;

import java.util.HashMap;
import java.util.HashSet;

public class BasketballGame extends Game{
private HashSet<BasketballGameParametres> basketballGameParametresHashSet;
    @Override
    public HashMap<String, Integer> countRate(HashMap<String, Integer> rateByNickname, IVisitor visitor) {
        return visitor.countBasketballRate(rateByNickname, this);
    }

    public void setBasketballGameParametresHashSet(HashSet<BasketballGameParametres> basketballGameParametresHashSet) {
        this.basketballGameParametresHashSet = basketballGameParametresHashSet;
    }

    public HashSet<BasketballGameParametres> getBasketballGameParametresHashSet() {
        return basketballGameParametresHashSet;
    }
}
