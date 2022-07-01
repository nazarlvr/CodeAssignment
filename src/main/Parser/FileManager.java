package main.Parser;

import java.io.File;

public class FileManager {
    public static final String pathtocsv = "D:\\Code Assignment\\CodeAssignment\\GamesInfoCSV\\";
    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);

        else return "";
    }

}
