package main.main;

import main.Exceptions.FileIsIncorrectException;
import main.Parser.FileManager;

import java.io.File;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws FileIsIncorrectException{
        HashMap<String, Integer> finalRate = new HashMap<>();
        Tournament tournament = new Tournament(finalRate);
        File folderWithData = new File(FileManager.pathtocsv + "Data");
        tournament.processFilesFromFolder(folderWithData);
        Pair pair = tournament.GetMvp();
        System.out.println("MVP of the Tucan Tournament is player with nickname " + pair.getNick().toUpperCase() +
                " with rate " + pair.getRate() + " points! Congratulations!!!");
    }



}
