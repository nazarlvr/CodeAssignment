package main.Game;

import main.GameParametres.BasketballGameParametres;
import main.Visitors.IVisitor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BasketballGame extends Game{
private HashSet<BasketballGameParametres> basketballGameParametresHashSet;
    @Override
    public HashMap<String, Integer> countRate(HashMap<String, Integer> rateByNickname, IVisitor visitor) {
        HashMap<String, Integer> newMap = visitor.countBasketballRate(rateByNickname, this);
        return newMap;
    }

    public void setBasketballGameParametresHashSet(HashSet<BasketballGameParametres> basketballGameParametresHashSet) {
        this.basketballGameParametresHashSet = basketballGameParametresHashSet;
    }

    public HashSet<BasketballGameParametres> getBasketballGameParametresHashSet() {
        return basketballGameParametresHashSet;
    }
}
