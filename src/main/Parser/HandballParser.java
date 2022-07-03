package main.Parser;

import main.Exceptions.FileIsIncorrectException;
import main.Game.Game;
import main.Game.HandballGame;
import main.GameParametres.HandballGameParametres;
import main.GameParametres.HandballGameParametres;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class HandballParser implements IParser{
    public HashSet<HandballGameParametres> Parse(String name) throws FileIsIncorrectException {
        HashSet<HandballGameParametres> handballGameParametresHashSet = new HashSet<>();
        try {
                BufferedReader csvReader = new BufferedReader(new FileReader(FileManager.pathtocsv + name));
                while (true) {

                    String row = csvReader.readLine();
                    if (row == null) break;
                    else {
                        if (row.contains(";")) {
                            String[] playerStats = row.split(";");
                            HandballGameParametres hgp;
                            if (playerStats.length != 6) {
                                throw new FileIsIncorrectException("MVP cannot be found because data is incorrect, please check your file extension or data structure");

                            } else {
                                hgp = new HandballGameParametres(playerStats);
                                handballGameParametresHashSet.add(hgp);
                            }
                        }
                    }
                }
                csvReader.close();

        } catch(IOException fe) {
            System.out.println(fe.getMessage());
            return null;
        }

        return handballGameParametresHashSet;
    }

    @Override
    public Game CreateGame (String path) {
        HandballGame handballGame = new HandballGame();
        try {
            handballGame.setHandballGameParametresHashSet(this.Parse(path));
        } catch (FileIsIncorrectException e) {
            System.out.println(e.getMessage());
        }
        return handballGame;
    }
}
