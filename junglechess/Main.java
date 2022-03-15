package junglechess;

import java.util.Scanner;

/**
 * main class
 *
 * @author Navinder Singh */
public class Main {

    public static void animal_option(){
        System.out.println("\nPick one piece to move:");
        System.out.println("");
        System.out.print("1.Rat");
        System.out.print("\t\t2.Cat");
        System.out.println("\t\t\t3.Dog");
        System.out.print("4.Wolf");
        System.out.print("\t\t5.Leopard");
        System.out.println("\t\t6.Tiger");
        System.out.print("7.Lion");
        System.out.println("\t\t8.Elephant");
    }
    public static void move_direction(){
        System.out.println("Pick which direction to move: ");
        System.out.println("1. Up");
        System.out.println("2. Down");
        System.out.println("3. Left");
        System.out.println("4. Right");
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Controller controller = new Controller();
        boolean running = true;
        boolean option = false;

        do{
            try{
                System.out.println("====================");
                System.out.println("|   JUNGLE CHESS   |");
                System.out.println("====================");
                System.out.print("Enter player option(R or B):");
                String playerTurn = input.nextLine();
                if(playerTurn.equalsIgnoreCase("R") || playerTurn.equalsIgnoreCase("B")){
                    controller.setCurrPlayer(playerTurn.toUpperCase());
                    option = true;
                }
                else{
                    System.out.println("Invalid input!! Please try again");
                }
            }catch(Exception ignored){

            }
        }while(!option);

        System.out.println("It is " + controller.getCurrPlayer() + " player's turn!");
        while(running) {
            try{
                controller.displayBoard();
                animal_option();
                int animal = input.nextInt();// The animal numbering is based on their rank

                move_direction();
                int direction = input.nextInt();
                int[] previous_location = controller.findAnimalLocation(animal);
                if(!controller.move(previous_location[0], previous_location[1], direction)){
                    do{
                        controller.displayBoard();
                        System.out.println("Dead animals:" + Controller.dead_animal);
                        animal_option();
                        animal = input.nextInt();
                        move_direction();
                        direction = input.nextInt();
                        previous_location = controller.findAnimalLocation(animal);
                    }while(!controller.move(previous_location[0], previous_location[1], direction));

                }

                int[] new_location = controller.findAnimalLocation(animal);

                if(controller.checkWinner(new_location[0], new_location[1])){
                    System.out.println("Player " + controller.getCurrPlayer() + " Wins");
                    controller.displayBoard();
                    running = false;
                }else if(!controller.checkWinner(new_location[0], new_location[1])){
                    controller.switchPlayer();
                    System.out.println("It is "+ controller.getCurrPlayer() + " player's turn!");
                }else{
                    System.out.println("Invalid move option. Please try again!!!");
                }
            }catch (Exception e){
                input.nextLine();
                System.out.println("Invalid option please try again");
            }


        }
    }
}
