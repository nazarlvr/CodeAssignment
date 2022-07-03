package main.Game;

import main.Visitors.IVisitor;

import java.util.HashMap;
import java.util.Map;

public abstract class Game {
    abstract HashMap<String, Integer> countRate(HashMap<String, Integer> rateByNickname, IVisitor visitor);

}
