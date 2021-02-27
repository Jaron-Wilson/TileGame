package io.github.tilegame.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Utils {

    public static String loadFileAsString(String path) throws IOException{


        return Files.readString(Path.of(path));
//        StringBuilder builder = new StringBuilder();
//        try{
//            BufferedReader br = new BufferedReader(new FileReader(path));
//            String line;
//            while ((line = br.readLine()) != null)
//            builder.append(line +"/n");
//
//            br.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//        return builder.toString();
    }

    public static int parseInt(String number){
        try{
            return Integer.parseInt(number);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }

}
