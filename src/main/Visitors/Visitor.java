package main.Visitors;

import main.Game.BasketballGame;
import main.Game.HandballGame;
import main.GameParametres.BasketballGameParametres;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Visitor implements IVisitor{
    @Override
    public void countBasketballRate(HashMap<String, Integer> rateByNickname, BasketballGame game) {
        HashMap<String, HashSet<String>> playersByTeams = new HashMap<>();
        HashSet<BasketballGameParametres> bgp = game.getBasketballGameParametresHashSet();
        for (BasketballGameParametres baskGameParam : bgp){
            if (playersByTeams.containsKey(baskGameParam.getTeamName())){
                HashSet<String> players = playersByTeams.get(baskGameParam.getTeamName());
                players.add(baskGameParam.getNickName());
                playersByTeams.replace(baskGameParam.getTeamName(), players);
            }
            else {
                HashSet<String> players = new HashSet<>();
                players.add(baskGameParam.getNickName());
                playersByTeams.put(baskGameParam.getTeamName(), players);
            }
            int playerRate = baskGameParam.getScoredPoints() * 2 + baskGameParam.getAssists() + baskGameParam.getRebounds();
            if (rateByNickname.containsKey(baskGameParam.getNickName())){
                playerRate += rateByNickname.get(baskGameParam.getNickName());
                rateByNickname.replace(baskGameParam.getNickName(), playerRate);
            }
        }
    }

    @Override
    public void countHandballRate(HashMap<String, Integer> rateByNickname, HandballGame game) {

    }
}
