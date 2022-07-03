package main.Parser;

import main.Exceptions.FileIsIncorrectException;
import main.Game.BasketballGame;
import main.Game.Game;
import main.GameParametres.BasketballGameParametres;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

public class BasketballParser implements IParser{
    public HashSet<BasketballGameParametres> Parse(String name) throws FileIsIncorrectException  {
        HashSet<BasketballGameParametres> basketballGameParametresHashSet = new HashSet<>();
        try {

                BufferedReader csvReader = new BufferedReader(new FileReader(FileManager.pathtocsv + name));
                while (true) {

                    String row = csvReader.readLine();
                    if (row == null) break;
                    else {
                        if (row.contains(";")) {
                            String[] playerStats = row.split(";");
                            BasketballGameParametres bgp;
                            if (playerStats.length != 7) {
                                throw new FileIsIncorrectException("MVP cannot be found because data is incorrect, please check your file extension or data structure");

                            } else {
                                bgp = new BasketballGameParametres(playerStats);
                                basketballGameParametresHashSet.add(bgp);
                            }
                        }
                    }
                }
                csvReader.close();
        } catch(IOException fe) {
            System.out.println(fe.getMessage());
            return null;
        }

        return basketballGameParametresHashSet;
    }

    @Override
    public Game CreateGame (String name) {
        BasketballGame basketballGame = new BasketballGame();
        try {
            basketballGame.setBasketballGameParametresHashSet(this.Parse(name));
        }catch (FileIsIncorrectException e) {
            System.out.println(e.getMessage());
        }
        return basketballGame;
    }
}
