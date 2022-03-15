package junglechess;

/**
 * The Animal class is an abstract class which consists of all the
 * methods that will be inherited by the child classes.
 *
 * @author Navinder Singh*/
public abstract class Animal {

    /** Private Variables. */
    private int rank;
    private final boolean verticalJump;
    private final boolean horizontalJump;
    private final boolean swim;


    /** Constructor. */
    public Animal(int rank, boolean verticalJump, boolean horizontalJump, boolean swim) {
        this.rank = rank;
        this.verticalJump = verticalJump;
        this.horizontalJump = horizontalJump;
        this.swim = swim;
    }

    /**
     * Get the rank of the animal
     * @return int  -   integer value of rank*/
    public int getRank() {
        return rank;
    }

    /**
     * Set the rank of the animal
     * @param rank  -   Takes in the rank of the animal*/
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * To check whether the animal is able to do
     * a vertical jump across the river
     * @return boolean  -   a true or false*/
    public boolean isVerticalJump() {
        return verticalJump;
    }

    /**
     * To check whether the animal is able to do
     * a horizontal jump across the river
     * @return boolean  -   a true or false*/
    public boolean isHorizontalJump() {
        return horizontalJump;
    }

    /**
     * To check whether the animal is able to swim
     * across the river
     * @return boolean  -   a true or false*/
    public boolean isSwim() {
        return swim;
    }
    

    //=============Abstract methods============//
    public abstract String getAnimalText();
    public abstract String getColor();
}

