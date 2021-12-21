package Game.Model;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import Game.Controller.*;

/**
 * This class handles the textfile highscores.txt.
 * @author Jenny
 * @version 1.0
 * @since 2021-12-08
 * 
 */

public class Highscore {
    private int N, MAX;  //N is amount of highscores in the file, MAX is the maximum allowed amount of highscores to be stored.
    private int lowest; // Lowest score in the file.
    private ArrayList<Integer> scores; 
    private ArrayList<String> names;
    private Controller controller;

    public Highscore(Controller controller) {
        this.controller = controller;
        MAX = 10;
        createLists();
        N = scores.size();
        lowest = getLowest();
        System.out.println("N "+ N + " lowest "+ lowest );
    }


    private int getLowest() {
        int temp = 500;
        for (Integer i : scores) {
            if (i < temp) {
                temp = i;
            }
        }
        return temp;
    }
    /**
     * Reads all the lines from the highscores.txt file and splits each line and separates them into
     * an arraylist for usernames and an arraylist for scores. 
     */

    private void createLists() {
        scores = new ArrayList<>();
        names = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("textfiles/highscores.txt"), StandardCharsets.UTF_8))) {
            String nextLine;
            while ((nextLine = reader.readLine()) != null) {
                System.out.println(nextLine);
                String[] temp = nextLine.split(" ");
                names.add(temp[1]);
                scores.add(Integer.parseInt(temp[0]));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Checks if the score and username should be added to the highscore file.
     *
     * @param name Username of the player.
     * @param points Amount of points scored by the player.
     */

    public void addScore(String name, int points) {
        /** If there are less than the maximum amount of values or the points are higher than
        the lowest highscore currently, the score is inserted into the score arraylist and the name into 
        the names arraylist. */
        if (N == 0){
            scores.add(points);
            names.add(name);
            N++;
            updateFile();
            lowest = getLowest();

        }
        else if (points > lowest || N < MAX) {

            for (int i = 0; i < N; i++) {
                if (scores.get(i) < points) {
                    scores.add(i, points);
                    names.add(i, name);
                    break;
                }
            }
            for (Integer i : scores) {
                System.out.println(i);
            }
            /**
             * If the amount of values stored alreay exceeded MAX, the lowest score and belonging username are removed.
             * Otherwise, N is incremented. 
             */
            
            if (N == MAX) {
                scores.remove(N);
                names.remove(N);
            }
            else N++;
            /**
             * Since the highscore list has been modified, the file is updated with the new information.
             * Since the lowest value might have changed, the variable lowest is updated.
             */

            updateFile();
            lowest = getLowest(); 

        } else
            System.out.println("sorry");
    }
    /**
     * Writes the values from the names arraylist and the scores attaylist into the highscores.txt file.
     */


    private void updateFile() {
        StringBuilder sb;
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("textfiles/highscores.txt", false))) {

            for (int i = 0; i < N; i++) {
                sb = new StringBuilder();
                sb.append(scores.get(i));
                sb.append(' ');
                sb.append(names.get(i));
                writer.append(sb.toString());
                writer.newLine();
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * Creates a String representation of the data in the highscores file.
     */

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i  < N; i++){
           
            sb.append(i+1);      
            sb.append(".         "); 
            if (i+1 < 10) sb.append("  ");
            sb.append(scores.get(i));
            if (scores.get(i) < 10) sb.append(" ");
            sb.append("             ");
            sb.append(names.get(i));
            sb.append("\n");
        }
        return sb.toString();

    }

    // public static void main(String[] args) {
    //     Highscore highscore = new Highscore();
    //     highscore.addScore("S", 99);
    

    // }

}
