package junglechess;

/**
 * The Cat class is a child class of the Animal class
 *
 * @author Navinder Singh*/
public class Cat extends Animal {

    //private variable
    private String color;

    /** Constructor. */
    public Cat(String color) {
        super(2, false, false, false);
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
        return this.color  + ".Cat";
    }
}
