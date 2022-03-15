package junglechess;

/**
 * The River Class inherits the Landscape
 *
 * @author Navinder Singh*/
public class River extends Landscape {

    /** Constructor. */
    public River() {
    }

    /**
     * This method gets the text display of the River
     * @return String   -   Returns the landscape text*/
    @Override
    public String getLandscapeText() {
        return "~~~";
    }

}
