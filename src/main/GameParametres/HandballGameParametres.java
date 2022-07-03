package main.GameParametres;

import main.Exceptions.FileIsIncorrectException;
import org.apache.commons.lang.math.NumberUtils;

public class HandballGameParametres extends GameParametres{


    private final int goalsMade;
    private final int goalsReceived;

    public HandballGameParametres(String[] playerInfo) throws FileIsIncorrectException {
        this.setPlayerName(playerInfo[0]);
        this.setNickName(playerInfo[1]);
        this.setTeamName(playerInfo[3]);
        if (NumberUtils.isNumber(playerInfo[4])&&NumberUtils.isNumber(playerInfo[5])&&NumberUtils.isNumber(playerInfo[2])) {
            if (Integer.parseInt(playerInfo[4]) >= 0 && Integer.parseInt(playerInfo[5]) >= 0 && Integer.parseInt(playerInfo[2]) >= 0) {
                this.setNumber(Integer.parseInt(playerInfo[2]));
                this.goalsMade = Integer.parseInt(playerInfo[4]);
                this.goalsReceived = Integer.parseInt(playerInfo[5]);
            }
            else throw new FileIsIncorrectException("Check your data please!");
        }
        else throw new FileIsIncorrectException("Check your data please!");
    }

    public int getGoalsMade() {
        return goalsMade;
    }



    public int getGoalsReceived() {
        return goalsReceived;
    }

}
