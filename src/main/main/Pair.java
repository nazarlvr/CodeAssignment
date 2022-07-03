package main.main;

public class Pair {
    private final String nick;
    private final int rate;

    public Pair(String nick, int rate) {
        this.nick = nick;
        this.rate = rate;
    }

    public String getNick() {
        return nick;
    }
    public int getRate() {
        return rate;
    }

}
