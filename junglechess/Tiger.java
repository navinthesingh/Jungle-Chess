package junglechess;

/**
 * The Tiger class is a child class of the Animal class
 *
 * @author Navinder Singh*/
public class Tiger extends Animal {
    private String color;

    /** Constructor. */
    public Tiger(String color) {
        super(6, true, false, false);
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
        return this.color + ".Tiger";
    }
}
