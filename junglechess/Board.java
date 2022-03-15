package junglechess;

/**
 * The Board class displays the board of the game
 * and consists fo the dimensions of the board.
 *
 * @author Navinder Singh*/
public class Board {

    //Private Variables
    private final int row;
    private final int column;

    /** Constructor. */
    public Board(){
        this.row = 9;
        this.column = 7;
    }

    /**
     * This method gets the number of rows of the board
     * @return int  -   Returns the number of rows.
     * */
    public int getRow() {
        return row;
    }

    /**
     * This method gets the number of columns of the board
     * @return int  -   Returns the number of columns
     * */
    public int getColumn() {
        return column;
    }

    /**
     * This method initializes the board and adds
     * the animal pieces alongside the landscape pieces into the board
     * @param grid          -   Takes in the 2d array grid which consists of animals
     * @param landscape     -   Takes int the 2d array landscape which consists of
     *                          Traps, Dens and the River
     **/
    public void initializeBoard(Animal[][] grid, Landscape[][] landscape){
        System.out.println("\t-------------------------------------------------------------------------------------");
        for(int i = 0;i<this.row;i++) {
            System.out.print("\t|");
            for (int j = 0; j < this.column; j++) {
                if(grid[i][j] != null){
                    System.out.printf("%10s",grid[i][j].getAnimalText()+ "\t|");
                }else if(landscape[i][j] != null){
                    System.out.printf("%10s",landscape[i][j].getLandscapeText()+ "\t|");
                }else{
                    System.out.printf("%10s","" + "\t|");
                }

            }
            System.out.println("\n\t-------------------------------------------------------------------------------------");
        }

    }

}
