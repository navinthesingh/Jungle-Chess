package junglechess;

/**
 * The Trap Class inherits the Landscape
 *
 * @author Navinder Singh*/
public class Trap extends Landscape {

    private String color;

    /** Constructor. */
    public Trap(String color) {
        this.color = color;
    }

    /**
     * This method gets the color of the Trap
     * @return String   -   Returns the color(R or B)*/
    public String getColor() {
        return color;
    }

    /**
     * This method gets the text display of the Trap
     * @return String   -   Returns the landscape text*/
    @Override
    public String getLandscapeText() {
        return "XXX";
    }

}
