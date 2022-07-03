package main.Visitors;

import main.Game.BasketballGame;
import main.Game.HandballGame;
import main.GameParametres.BasketballGameParametres;
import main.GameParametres.HandballGameParametres;

import java.util.HashMap;
import java.util.HashSet;

public class Visitor implements IVisitor{
    @Override
    public HashMap<String, Integer> countBasketballRate(HashMap<String, Integer> rateByNickname, BasketballGame game) {
        HashSet<BasketballGameParametres> bgp = game.getBasketballGameParametresHashSet();
        HashMap<String, Integer> teamsResult = new HashMap<>();
        for (BasketballGameParametres baskGameParam : bgp){
            if (teamsResult.containsKey(baskGameParam.getTeamName()))
            {
                Integer result = teamsResult.get(baskGameParam.getTeamName());
                teamsResult.put(baskGameParam.getTeamName(), (result + baskGameParam.getScoredPoints()));
            }else{
                teamsResult.put(baskGameParam.getTeamName(), baskGameParam.getScoredPoints());
            }

            int playerRate = baskGameParam.getScoredPoints() * 2 + baskGameParam.getAssists() + baskGameParam.getRebounds();
            if (rateByNickname.containsKey(baskGameParam.getNickName())){
                playerRate += rateByNickname.get(baskGameParam.getNickName());
                rateByNickname.put(baskGameParam.getNickName(), playerRate);
            }
            else{
                rateByNickname.put(baskGameParam.getNickName(), playerRate);
            }
        }
        String teamWinner = ""; int max = -1;
        for(String key : teamsResult.keySet()){
            if (teamsResult.get(key) > max){
                max = teamsResult.get(key);
                teamWinner = key;
            }
        }
        for (BasketballGameParametres baskGameParam : bgp){
            if (baskGameParam.getTeamName().equals(teamWinner)){
                int rate = rateByNickname.get(baskGameParam.getNickName());
                rateByNickname.put(baskGameParam.getNickName(), rate + 10);
            }

        }
        return rateByNickname;
    }

    @Override
    public HashMap<String, Integer> countHandballRate(HashMap<String, Integer> rateByNickname, HandballGame game) {
        HashSet<HandballGameParametres> hgp = game.getHandballGameParametresHashSet();
        HashMap<String, Integer> teamsResult = new HashMap<>();
        for (HandballGameParametres handGameParam : hgp){
            if (teamsResult.containsKey(handGameParam.getTeamName())) {
                Integer result = teamsResult.get(handGameParam.getTeamName());
                teamsResult.put(handGameParam.getTeamName(), (result + handGameParam.getGoalsMade()));
            } else {
                teamsResult.put(handGameParam.getTeamName(), handGameParam.getGoalsMade());
            }

            int playerRate = handGameParam.getGoalsMade() * 2 - handGameParam.getGoalsReceived();
            if (rateByNickname.containsKey(handGameParam.getNickName())){
                playerRate += rateByNickname.get(handGameParam.getNickName());
                rateByNickname.put(handGameParam.getNickName(), playerRate);
            }
            else{
                rateByNickname.put(handGameParam.getNickName(), playerRate);
            }
        }
        String teamWinner = ""; int max = -1;
        for(String key : teamsResult.keySet()){
            if (teamsResult.get(key) > max){
                max = teamsResult.get(key);
                teamWinner = key;
            }
        }
        for (HandballGameParametres handGameParam : hgp){
            if (handGameParam.getTeamName().equals(teamWinner)){
                Integer rate = rateByNickname.get(handGameParam.getNickName());
                rateByNickname.put(handGameParam.getNickName(), rate + 10);
            }
        }
        return rateByNickname;
    }
}
