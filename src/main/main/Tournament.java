package main.main;

import main.Game.Game;

import java.util.HashMap;
import java.util.HashSet;

public class Tournament {
    private HashSet<Game> tournament;
    private HashMap<String, Integer> rate;

    public Tournament(HashMap<String, Integer> rate) {
        this.rate = rate;
    }

    public HashSet<Game> getTournament() {
        return tournament;
    }

    public void setTournament(HashSet<Game> tournament) {
        this.tournament = tournament;
    }

    public HashMap<String, Integer> getRate() {
        return rate;
    }

    public void setRate(HashMap<String, Integer> rate) {
        this.rate = rate;
    }
}
