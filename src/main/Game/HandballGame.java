package main.Game;

import main.GameParametres.HandballGameParametres;
import main.Visitors.IVisitor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HandballGame extends Game{
    HashSet<HandballGameParametres> handballGameParametresHashSet;


    @Override
    void countRate(HashMap<String, Integer> rateByNickname, IVisitor visitor)
    {
        visitor.countHandballRate(rateByNickname,this);
    }

    public void setHandballGameParametresHashSet(HashSet<HandballGameParametres> handballGameParametresHashSet) {
        this.handballGameParametresHashSet = handballGameParametresHashSet;
    }

    public HashSet<HandballGameParametres> getHandballGameParametresHashSet() {
        return handballGameParametresHashSet;
    }
}
