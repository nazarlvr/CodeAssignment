package main.GameParametres;
import main.Exceptions.FileIsIncorrectException;
import org.apache.commons.lang.math.NumberUtils;
public class BasketballGameParametres extends GameParametres{
    private final int scoredPoints;
    private final int rebounds;
    private final int assists;

    public BasketballGameParametres(String[] playerInfo) throws FileIsIncorrectException {
        this.setPlayerName(playerInfo[0]);
        this.setNickName(playerInfo[1]);
        this.setTeamName(playerInfo[3]);
        if (NumberUtils.isNumber(playerInfo[2]) && NumberUtils.isNumber(playerInfo[4]) && NumberUtils.isNumber(playerInfo[5]) && NumberUtils.isNumber(playerInfo[6])) {
            if (Integer.parseInt(playerInfo[2]) >= 0 && Integer.parseInt(playerInfo[4]) >= 0 && Integer.parseInt(playerInfo[5]) >= 0 && Integer.parseInt(playerInfo[6]) >= 0) {
                this.setNumber(Integer.parseInt(playerInfo[2]));
                this.scoredPoints = Integer.parseInt(playerInfo[4]);
                this.rebounds = Integer.parseInt(playerInfo[5]);
                this.assists = Integer.parseInt(playerInfo[6]);
            }
            else throw new FileIsIncorrectException("Check your data please!");
        }
        else throw new FileIsIncorrectException("Check your data please!");
    }

    public int getScoredPoints() {
        return scoredPoints;
    }


    public int getRebounds() {
        return rebounds;
    }


    public int getAssists() {
        return assists;
    }

}
