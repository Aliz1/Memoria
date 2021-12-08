package Game.Model;

import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Highscore {

    public String[][] getHighScores(){
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(
                    new FileInputStream("textfiles/highscore.txt"), StandardCharsets.UTF_8))) {
        String nextLine;
        while ((nextLine = reader.readLine()) != null) {
        //    list.add(nextLine);
        stringBuilder.append(nextLine);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;

    }


    
}
