package main.GameParametres;

public class BasketballGameParametres extends GameParametres{
    private int scoredPoints;
    private int rebounds;
    private int assists;

    public BasketballGameParametres(String[] playerInfo) {
        this.setPlayerName(playerInfo[0]);
        this.setNickName(playerInfo[1]);
        this.setNumber(Integer.parseInt(playerInfo[2]));
        this.setTeamName(playerInfo[3]);
        this.scoredPoints = Integer.parseInt(playerInfo[4]);
        this.rebounds = Integer.parseInt(playerInfo[5]);
        this.assists = Integer.parseInt(playerInfo[6]);
    }

    public int getScoredPoints() {
        return scoredPoints;
    }

    public void setScoredPoints(int scoredPoints) {
        this.scoredPoints = scoredPoints;
    }

    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }
}
