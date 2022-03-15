package junglechess;

/**
 * The Landscape class is an abstract class which
 * consists of specific child classes such as the Den, Trap and River
 *
 * @author Navinder Singh*/
public abstract class Landscape {

    /** Constructor. */
    public Landscape() {
    }

    /** Abstract method*/
    public abstract String getLandscapeText();
}
