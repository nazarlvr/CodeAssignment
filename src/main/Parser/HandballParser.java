package main.Parser;

import main.Game.Game;
import main.Game.HandballGame;
import main.GameParametres.HandballGameParametres;

import java.util.HashSet;

public class HandballParser implements IParser{
    private final String pathtocsv = "D:\\Code Assignment\\CodeAssignment\\GamesInfoCSV\\";
    public HashSet<HandballGameParametres> Parse(String path) {
        HashSet<HandballGameParametres>  handballGameParametresHashSet = new HashSet<>();

        return handballGameParametresHashSet;
    }

    @Override
    public Game CreateGame (String path) {
        HandballGame handballGame = new HandballGame();
        handballGame.setHandballGameParametresHashSet(this.Parse(path));
        return handballGame;
    }
}
