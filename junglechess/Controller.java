package junglechess;

import java.util.ArrayList;

/**
 * The controller class is the class that obtains all the code from other classes
 * and controls the main functions of the game.
 *
 * @author Navinder Singh*/
public class Controller {

    Board board = new Board();
    Player player = new Player("R");

    Animal[][] grid = new Animal[board.getRow()][board.getColumn()];
    Landscape[][] landscape = new Landscape[board.getRow()][board.getColumn()];

    // static variable
    public static ArrayList<String> dead_animal = new ArrayList<String>();

    //============Constructor================//
    public Controller() {
        grid[0][0] = new Lion("R");
        grid[8][6] = new Lion("B");

        grid[2][0] = new Rat("R");
        grid[6][6] = new Rat("B");

        grid[1][5] = new Cat("R");
        grid[7][1] = new Cat("B");

        grid[2][4] = new Wolf("R");
        grid[6][2] = new Wolf("B");

        grid[1][1] = new Dog("R");
        grid[7][5] = new Dog("B");

        grid[2][2] = new Leopard("R");
        grid[6][4] = new Leopard("B");

        grid[0][6] = new Tiger("R");
        grid[8][0] = new Tiger("B");

        grid[2][6] = new Elephant("R");
        grid[6][0] = new Elephant("B");


        landscape[8][3] = new Den("B");
        landscape[0][3] = new Den("R");

        landscape[0][2] = new Trap("R");
        landscape[0][4] = new Trap("R");
        landscape[1][3] = new Trap("R");
        landscape[8][2] = new Trap("B");
        landscape[8][4] = new Trap("B");
        landscape[7][3] = new Trap("B");

        // River
        for(int i = 0;i < board.getRow();i++) {
            for (int j = 0; j < board.getColumn(); j++) {
                if(i>=3 && i<=5 && j!=3 && j>0 && j< board.getColumn()-1)
                    landscape[i][j] = new River();
            }
        }

    }

    //====================Public Methods===================//
    /**
     *  This method returns whether the move is successful or not.
     * @param startRow takes in the initial x position of the piece
     * @param startColumn takes in the y position of the piece
     * @param direction takes in the direction which the piece wants to move
     * @return boolean a true or false.
     * */
    public boolean move(int startRow, int startColumn, int direction) {
        if(direction == 1){// up
            if(ownDen(startRow,startColumn,direction)){
                System.out.println("You cannot enter your own Den");
                return false;
            }else if(ownTrap(startRow,startColumn,direction)){
                System.out.println("You cannot enter your own Trap");
                return false;
            }else if(jump(startRow,startColumn,direction)){
                this.grid[startRow-4][startColumn] = this.grid[ startRow][ startColumn ];
                this.grid[startRow][startColumn] = null;
                return true;
            }else if(inRiver(startRow,startColumn,direction)){
                System.out.println("The chosen piece cannot enter the River");
                return false;
            }else if(canEat(startRow,startColumn,direction)){
                dead_animal.add(this.grid[startRow-1][startColumn].getAnimalText());
                this.grid[startRow-1][startColumn] = this.grid[ startRow][ startColumn ];
                this.grid[startRow][startColumn] = null;
                return true;
            }else if(this.grid[startRow-1][startColumn] == null){
                this.grid[startRow-1][startColumn] = this.grid[ startRow][ startColumn ];
                this.grid[startRow][startColumn] = null;
                return true;
            }else{
                System.out.println("Unable to make movement");
            }

        }else if(direction==2) {
            if(ownDen(startRow,startColumn,direction)){
                System.out.println("You cannot enter your own Den");
                return false;
            }else if(ownTrap(startRow,startColumn,direction)) {
                System.out.println("You cannot enter your own Trap");
                return false;
            }else if(jump(startRow,startColumn,direction)){
                this.grid[startRow+4][startColumn] = this.grid[ startRow][ startColumn ];
                this.grid[startRow][startColumn] = null;
                return true;
            }else if(inRiver(startRow,startColumn,direction)){
                System.out.println("You cannot enter the River");
                return false;
            }else if(canEat(startRow,startColumn,direction)){
                dead_animal.add(this.grid[startRow+1][startColumn].getAnimalText());
                this.grid[startRow + 1][startColumn] = this.grid[startRow][startColumn];
                this.grid[startRow][startColumn] = null;
                return true;
            }else if(this.grid[startRow+1][startColumn] == null){
                this.grid[startRow+1][startColumn] = this.grid[ startRow][ startColumn ];
                this.grid[startRow][startColumn] = null;
                return true;
            }else{
                System.out.println("Unable to make movement.");
            }
        }
        else if(direction==3) { // left
            if(ownDen(startRow,startColumn,direction)){
                System.out.println("You cannot enter your own Den");
                return false;
            }else if(ownTrap(startRow,startColumn,direction)) {
                System.out.println("You cannot enter your own Trap");
                return false;
            }else if(jump(startRow,startColumn,direction)){
                this.grid[startRow][startColumn-3] = this.grid[ startRow][ startColumn ];
                this.grid[startRow][startColumn] = null;
                return true;
            }else if(inRiver(startRow,startColumn,direction)){
                System.out.println("You cannot enter the River");
                return false;
            }else if(canEat(startRow,startColumn,direction)){
                dead_animal.add(this.grid[startRow][startColumn-1].getAnimalText());
                this.grid[startRow][startColumn - 1] = this.grid[startRow][startColumn];
                this.grid[startRow][startColumn] = null;
                return true;
            }else if(this.grid[startRow][startColumn-1] == null){
                this.grid[startRow][startColumn-1] = this.grid[ startRow][ startColumn ];
                this.grid[startRow][startColumn] = null;
                return true;
            }else{
                System.out.println("Unable to make movement.");
            }
        }
        else if(direction==4) { //right
            if(ownDen(startRow,startColumn,direction)){
                System.out.println("You cannot enter your own Den");
                return false;
            }else if(ownTrap(startRow,startColumn,direction)) {
                System.out.println("You cannot enter your own Trap");
                return false;
            }else if(jump(startRow,startColumn,direction)){
                this.grid[startRow][startColumn+3] = this.grid[ startRow][ startColumn ];
                this.grid[startRow][startColumn] = null;
                return true;
            }else if(inRiver(startRow,startColumn,direction)){
                System.out.println("You cannot enter the River");
                return false;
            }else if(canEat(startRow,startColumn,direction)){
                dead_animal.add(this.grid[startRow][startColumn+1].getAnimalText());
                this.grid[startRow][startColumn + 1] = this.grid[startRow][startColumn];
                this.grid[startRow][startColumn] = null;
                return true;
            }else if(this.grid[startRow][startColumn+1] == null){
                this.grid[startRow][startColumn+1] = this.grid[ startRow][ startColumn ];
                this.grid[startRow][startColumn] = null;
                return true;
            }else{
                System.out.println("Unable to make movement.");
            }
        }
        return false;
    }

    /**
     * This method displays the board
     * */
    public void displayBoard(){
        board.initializeBoard(grid, landscape);
    }

    /**
     * This method obtains the location of the animal piece
     * @param rank takes in the rank of the animal
     * @return int[] the location of the animal piece
     * */
    public int[] findAnimalLocation(int rank) {
        int[] location = new int[2];
        for(int i = 0;i < board.getRow();i++){
            for(int j =0;j < board.getColumn();j++){
                if(grid[i][j]!=null && grid[i][j].getRank() == rank && grid[i][j].getColor().equals(player.getPlayer())){
                    location[0] = i;
                    location[1] = j;
                    return location;
                }
            }
        }
        return null;
    }

    /**
     * This method checks whether the player has won the game
     * @param row takes in the row at which the animal piece is at
     * @param column takes in the column at which the animal piece is at
     * @return boolean a true or false*/
    public boolean checkWinner(int row, int column){
        boolean result = false;
        if(landscape[row][column] == null){
            result=false;
        }
        else if(landscape[row][column] != null){
            if(landscape[row][column].getLandscapeText().equals("$DEN$")){
                result = true;
            }
            if(landscape[row][column].getLandscapeText().equals("XXX")){
                dead_animal.add(grid[row][column].getAnimalText());
                grid[row][column].setRank(0);
                grid[row][column] = null;
                landscape[row][column] = null;
                result = false;
            }
        }
        return result;
    }

    /**
     * This methods sets the current player of the game
     * @param playerTurn    -   takes in the player turn(R or B)
     */
    public void setCurrPlayer(String playerTurn){
        player.setPlayer(playerTurn);
    }

    /**
     * This method gets the current player
     * @return String   -   returns RED or BLUE*/
    public String getCurrPlayer(){
        if(player.getPlayer().equals("R")){
            return "RED";
        }else if(player.getPlayer().equals("B")){
            return "BLUE";
        }
        return " ";
    }

    /**
     * This method switches the player turn
     * from Red to Blue or vice versa*/
    public void switchPlayer(){
        if(player.getPlayer().equals("R")){
            player.setPlayer("B");
        }else if(player.getPlayer().equals("B")){
            player.setPlayer("R");
        }
    }

    //==================Private methods======================//
    /**This private method checks whether the animal piece is in its own DEN
     * @param startRow takes in the row of the piece
     * @param startColumn takes in the column of the piece
     * @param direction takes in the direction the piece would like to move
     * @return boolean a true or false*/
    private boolean ownDen(int startRow, int startColumn, int direction) {
        if (direction == 1) {
            return landscape[startRow - 1][startColumn] != null &&
                    landscape[startRow - 1][startColumn] instanceof Den &&
                    this.grid[startRow][startColumn].getColor().equals(((Den) landscape[startRow - 1][startColumn]).getColor());
        } else if (direction == 2) {
            return landscape[startRow+1][startColumn] != null &&
                    landscape[startRow+1][startColumn] instanceof Den &&
                    this.grid[startRow][startColumn].getColor().equals(((Den) landscape[startRow+1][startColumn]).getColor());
        } else if (direction == 3) {
            return landscape[startRow][startColumn-1] != null &&
                    landscape[startRow][startColumn-1] instanceof Den &&
                    this.grid[startRow][startColumn].getColor().equals(((Den) landscape[startRow][startColumn-1]).getColor());
        } else if (direction == 4) {
            return landscape[startRow][startColumn+1] != null &&
                    landscape[startRow][startColumn+1] instanceof Den &&
                    this.grid[startRow][startColumn].getColor().equals(((Den) landscape[startRow][startColumn+1]).getColor());
        }
        return false;
    }

    /**This private method checks whether the animal piece is in its own Trap
     * @param startRow takes in the row of the piece
     * @param startColumn takes in the column of the piece
     * @param direction takes in the direction the piece would like to move
     * @return boolean a true or false*/
    private boolean ownTrap(int startRow, int startColumn, int direction) {
        if (direction == 1) {
            return landscape[startRow - 1][startColumn] != null &&
                    landscape[startRow - 1][startColumn] instanceof Trap &&
                    this.grid[startRow][startColumn].getColor().equals(((Trap) landscape[startRow - 1][startColumn]).getColor());
        } else if (direction == 2) {
            return landscape[startRow+1][startColumn] != null &&
                    landscape[startRow+1][startColumn] instanceof Trap &&
                    this.grid[startRow][startColumn].getColor().equals(((Trap) landscape[startRow+1][startColumn]).getColor());
        } else if (direction == 3) {
            return landscape[startRow][startColumn-1] != null &&
                    landscape[startRow][startColumn-1] instanceof Trap &&
                    this.grid[startRow][startColumn].getColor().equals(((Trap) landscape[startRow][startColumn-1]).getColor());
        } else if (direction == 4) {
            return landscape[startRow][startColumn+1] != null &&
                    landscape[startRow][startColumn+1] instanceof Trap &&
                    this.grid[startRow][startColumn].getColor().equals(((Trap) landscape[startRow][startColumn+1]).getColor());
        }
        return false;
    }

    /**This private method checks whether the piece is qualified to swim in the River
     * @param startRow takes in the row of the piece
     * @param startColumn takes in the column of the piece
     * @param direction takes in the direction the piece would like to move
     * @return boolean a true or false*/
    private boolean inRiver(int startRow, int startColumn, int direction){
        if (direction == 1) {
            return landscape[startRow - 1][startColumn] != null &&
                    landscape[startRow - 1][startColumn] instanceof River &&
                    !grid[startRow][startColumn].isSwim();
        } else if (direction == 2) {
            return landscape[startRow+1][startColumn] != null &&
                    landscape[startRow+1][startColumn] instanceof River &&
                    !grid[startRow][startColumn].isSwim();
        } else if (direction == 3) {
            return landscape[startRow][startColumn-1] != null &&
                    landscape[startRow][startColumn-1] instanceof River &&
                    !grid[startRow][startColumn].isSwim();
        } else if (direction == 4) {
            return landscape[startRow][startColumn+1] != null &&
                    landscape[startRow][startColumn+1] instanceof River &&
                    !grid[startRow][startColumn].isSwim();
        }
        return false;
    }

    /**This private method checks whether the piece is qualified to jump across the River
     * Horizontally or vertically
     * @param startRow takes in the row of the piece
     * @param startColumn takes in the column of the piece
     * @param direction takes in the direction the piece would like to move
     * @return boolean a true or false*/
    private boolean jump(int startRow, int startColumn, int direction){
        if (direction == 1) {
            return landscape[startRow - 1][startColumn] != null &&
                    landscape[startRow - 1][startColumn] instanceof River &&
                    grid[startRow][startColumn].isVerticalJump() &&
                    landscape[startRow - 4][startColumn] == null;
        } else if (direction == 2) {
            return landscape[startRow + 1][startColumn] != null &&
                    landscape[startRow + 1][startColumn] instanceof River &&
                    grid[startRow][startColumn].isVerticalJump() &&
                    landscape[startRow + 4][startColumn] == null;
        } else if (direction == 3) {
            return landscape[startRow][startColumn-1] != null &&
                    landscape[startRow][startColumn-1] instanceof River &&
                    grid[startRow][startColumn].isHorizontalJump() &&
                    landscape[startRow][startColumn-3] == null;
        } else if (direction == 4) {
            return landscape[startRow][startColumn+1] != null &&
                    landscape[startRow][startColumn+1] instanceof River &&
                    grid[startRow][startColumn].isHorizontalJump() &&
                    landscape[startRow][startColumn+3] == null;
        }
        return false;
    }

    /**This private method checks whether the animal can eat the other animal
     * @param startRow takes in the row of the piece
     * @param startColumn takes in the column of the piece
     * @param direction takes in the direction the piece would like to move
     * @return boolean a true or false*/
    private boolean canEat(int startRow, int startColumn, int direction){ // Something wrong with the canEat function
        if (direction == 1) {
            return grid[startRow - 1][startColumn] != null &&
                    grid[startRow][startColumn].getRank() >= grid[startRow-1][startColumn].getRank() &&
                    !grid[startRow][startColumn].getColor().equals(grid[startRow-1][startColumn].getColor());
        } else if (direction == 2) {
            return grid[startRow + 1][startColumn] != null &&
                    grid[startRow][startColumn].getRank() >= grid[startRow+1][startColumn].getRank() &&
                    !grid[startRow][startColumn].getColor().equals(grid[startRow+1][startColumn].getColor());
        } else if (direction == 3) {
            return grid[startRow][startColumn - 1] != null &&
                    grid[startRow][startColumn].getRank() >= grid[startRow][startColumn-1].getRank() &&
                    !grid[startRow][startColumn].getColor().equals(grid[startRow][startColumn-1].getColor());
        } else if (direction == 4) {
            return grid[startRow][startColumn+1] != null &&
                    grid[startRow][startColumn].getRank() >= grid[startRow][startColumn+1].getRank() &&
                    !grid[startRow][startColumn].getColor().equals(grid[startRow][startColumn+1].getColor());
        }
        return false;
    }
}
