package junglechess;

/**
 * The Rat class is a child class of the Animal class
 *
 * @author Navinder Singh*/
public class Rat extends Animal {
    private String color;

    /** Constructor. */
    public Rat(String color) {
        super(1, false, false, true);
        this.color = color;
    }

    /**
     * Obtains the color of the animal
     * @return String   -   returns the String value of the color*/
    public String getColor() {
        return color;
    }

    /**
     * Gets the text display of the animal
     * @return String   -   returns the animal name in text*/
    @Override
    public String getAnimalText() {
        return this.color + ".Rat";
    }
}
