package junglechess;

/**
 * The Player class stores the player info
 *
 * @author Navinder Singh*/
public class Player {

    //private variable
    private String player;

    /** Constructor. */
    public Player(String player) {
        this.player = player;
    }

    /**
     * This method obtains the player of the game
     * @return String   -   Returns the player of type String*/
    public String getPlayer() {
        return player;
    }

    /**
     * This method sets the current player
     * @param player    -   Takes in the player type(R or B)*/
    public void setPlayer(String player) {
        this.player = player;
    }

}
