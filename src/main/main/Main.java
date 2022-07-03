package main.main;

import main.Exceptions.FileIsIncorrectException;
import main.Game.BasketballGame;
import main.Game.HandballGame;
import main.GameParametres.BasketballGameParametres;
import main.Parser.BasketballParser;
import main.Parser.FileManager;
import main.Parser.HandballParser;
import main.Visitors.Visitor;

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws FileIsIncorrectException{
        HashMap<String, Integer> finalRate = new HashMap<>();
        Tournament tournament = new Tournament(finalRate);
        File folderWithData = new File(FileManager.pathtocsv + "Data");
        tournament = processFilesFromFolder(folderWithData, tournament);
    }

    public static Tournament processFilesFromFolder(File folder, Tournament tournament)
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


                                    BasketballParser bp = new BasketballParser();
                                    BasketballGame bg = new BasketballGame();
                                    bg.setBasketballGameParametresHashSet(bp.Parse("Data\\" + entry.getName()));
                                    tournament.setRate(bg.countRate(tournament.getRate(), visitor));



                                    HandballParser hp = new HandballParser();
                                    HandballGame hg = new HandballGame();
                                    hg.setHandballGameParametresHashSet(hp.Parse("Data\\" + entry.getName()));
                                    tournament.setRate(hg.countRate(tournament.getRate(), visitor));

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }else{
                        throw new FileIsIncorrectException("File is not exist or file Extension is not \"csv\" please check it out!");
                    }
                }

            }
            return tournament;
        }catch (FileIsIncorrectException | FileNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
