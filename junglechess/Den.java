package junglechess;

/**
 * The Den Class inherits the Landscape
 *
 * @author Navinder Singh*/
public class Den extends Landscape {
    private String color;

    /** Constructor. */
    public Den(String color) {
        this.color = color;
    }

    /**
     * This method gets the color of the Den
     * @return String   -   Returns the color(R or B)*/
    public String getColor() {
        return color;
    }

    /**
     * This method gets the text display of the Den
     * @return String   -   Returns the landscape text*/
    @Override
    public String getLandscapeText() {
        return "$DEN$";
    }

}
