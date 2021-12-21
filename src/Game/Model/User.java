package Game.Model;

import java.io.Serializable;

/**
 * A representation of a logged in user. The user has user name and a score.
 *
 * @author Robert Rosencrantz, Adel Sabanovic, Sonja Peric, Yasir Kakar, Joakim
 *         Tell
 * @version 4.0
 */
public class User implements Serializable {
    private String userName;
    private String password;
    private int totalPoints;
    private int gameScore;

    /**
     * Constructor
     *
     * @param userName User input
     * @param password User password
     */
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getGameScore() {
        return gameScore;
    }

    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
