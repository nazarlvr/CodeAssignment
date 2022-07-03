package main.main;

import main.Exceptions.FileIsIncorrectException;
import main.Game.BasketballGame;
import main.Game.HandballGame;
import main.Parser.BasketballParser;
import main.Parser.FileManager;
import main.Parser.HandballParser;
import main.Visitors.Visitor;

import java.io.*;
import java.util.HashMap;

public class Tournament {
    private HashMap<String, Integer> rate;

    public Tournament(HashMap<String, Integer> rate) {
        this.rate = rate;
    }

    public HashMap<String, Integer> getRate() {
        return rate;
    }

    public void setRate(HashMap<String, Integer> rate) {
        this.rate = rate;
    }
    public void processFilesFromFolder(File folder)
    {
        Visitor visitor = new Visitor();
        try {
            File[] folderEntries = folder.listFiles();
            if (folderEntries == null) {
                throw new FileIsIncorrectException("Can't find MVP without data");
            }
            for (File entry : folderEntries) {
                if (entry.isDirectory()){
                    throw new FileIsIncorrectException("Directory is not \"csv\" format!");
                }else{
                    if (FileManager.getFileExtension(entry).equals("csv")){
                        String path = entry.getPath();
                        BufferedReader csvReader = new BufferedReader(new FileReader(path));
                        try {
                            String row = csvReader.readLine();
                            if (row.equals("BASKETBALL")) {
                                BasketballParser bp = new BasketballParser();
                                BasketballGame bg = new BasketballGame();
                                bg.setBasketballGameParametresHashSet(bp.Parse("Data\\" + entry.getName()));
                                this.setRate(bg.countRate(this.getRate(), visitor));
                            } else if (row.equals("HANDBALL")) {
                                HandballParser hp = new HandballParser();
                                HandballGame hg = new HandballGame();
                                hg.setHandballGameParametresHashSet(hp.Parse("Data\\" + entry.getName()));
                                this.setRate(hg.countRate(this.getRate(), visitor));
                            }else {
                                throw new FileIsIncorrectException("Wrong format of csv file, please check sport's name!");
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }else{
                        throw new FileIsIncorrectException("File is not exist or file Extension is not \"csv\" please check it out!");
                    }
                }

            }
        }catch (FileIsIncorrectException | FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public Pair GetMvp() {
        int max = -1, rateMVP = 0;
        String MVP = "";
        for (String key : rate.keySet()){
            if (rate.get(key) > max){
                max = rate.get(key);
                MVP = key;
                rateMVP = max;
            }
        }
        return new Pair(MVP, rateMVP);
    }
}
