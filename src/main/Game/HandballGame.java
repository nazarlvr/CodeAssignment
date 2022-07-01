package main.Game;

import main.GameParametres.HandballGameParametres;
import main.Visitors.IVisitor;

import java.util.HashSet;

public class HandballGame extends Game{
    HashSet<HandballGameParametres> handballGameParametresHashSet;


    @Override
    void countRate(IVisitor visitor) {
        visitor.countHandballRate(this);
    }

    public void setHandballGameParametresHashSet(HashSet<HandballGameParametres> handballGameParametresHashSet) {
        this.handballGameParametresHashSet = handballGameParametresHashSet;
    }
}
