package name.cmkimberlin.exercises.hydra;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Caleb Kimberlin
 * Runs a game where player chooses 1 of 4 actions to try and defeat a Hydra of their own creation in as few turns as possible
 */
public class HydraFight {
    public static void main(String[] args) {
        System.out.println("Lets fight the Hydra that kidnapped Princess Perly!");
        boolean playAgain = true;

        while (playAgain) {
            int[] hydraSetup = hydraUserInput();
            Hydra hydra = new Hydra(hydraSetup[0], hydraSetup[1]);
            System.out.println("The Hydra has " + hydra.getHeads() + " heads and " + hydra.getTails() + " tails.");

            int minMoves = hydra.minMovesCalc(hydra);
            int totalMoves = 0;
            if(minMoves == -1){
                System.out.println("The Hydra is unbeatable!");
            }
            else{System.out.println("The Hydra can be defeated with " + minMoves + " action(s). Good luck!");
                totalMoves = playGame(hydra);}
            if(minMoves > 0){System.out.println("Minimum actions needed to win from the start: " + minMoves);
                System.out.println("Total actions used so far: " + totalMoves);}

            playAgain = playAgain();
        }
    }
    //Runs the game aspect of the program
    public static int playGame(Hydra hydra) {
        boolean proceed = true;
        boolean hydraDefeated = false;
        int attackNum;
        int currentMoves = 0;
        int initialMinMoves = 0;

        while (!hydraDefeated && proceed) {
            while (proceed) {
                attackNum = userTurn(hydra);

                if (attackNum == 5) {
                    proceed = false;
                    System.out.println("You gave up?! How could you......");
                }

                if (proceed) {
                    updateHydra(hydra, attackNum);
                    currentMoves++;
                    hydra.minMovesCalc(hydra);

                    if (hydra.getHeads() == 0 && hydra.getTails() == 0) {
                        proceed = false;
                        hydraDefeated = true;
                    }
                    if ((hydra.getHeads() % 2) == 1 && hydra.getTails() == 0) {
                        proceed = false;
                        hydraDefeated = false;
                        System.out.println("The Hydra is unbeatable!");
                    }
                }
            }
        }
        if (hydraDefeated) {
            System.out.println("The Hydra has been slain!");
            System.out.println("Minimum actions needed to win from the start: " + initialMinMoves);
            System.out.println("Total actions used to win this round: " + currentMoves);
            System.out.println();
        }
        return currentMoves;

    }
    //Updates the Hydra's current status
    public static void updateHydra(Hydra hydra, int attackNum) {
        switch (attackNum) {
            case 1: {
                break;
            }
            case 2: {
                hydra.setTails(hydra.getTails() + 1);
                break;
            }
            case 3: {
                hydra.setHeads(hydra.getHeads() - 2);
                break;
            }
            case 4: {
                hydra.setHeads(hydra.getHeads() + 1);
                hydra.setTails(hydra.getTails() - 2);
                break;
            }
        }
        System.out.println("After your current action #" + attackNum + ", the Hydra has " + hydra.getHeads() + " heads and " + hydra.getTails() + " tails.");
    }
    //Handles what happens on each of the user's turns
    public static int userTurn(Hydra hydra) {
        int attackNum = 0;
        boolean validEntry = false;
        boolean validMove = false;
        while (!validMove) {
            while (!validEntry) {
                try {
                    System.out.println("Which action would you like to use? Pick a number between 1 and 4.");
                    System.out.println("NOTE: If you wish to give up, enter the number 5.");
                    Scanner scanner = new Scanner(System.in);
                    attackNum = scanner.nextInt();
                    if (attackNum > 0 && attackNum <= 5) {
                        validEntry = true;
                    } else {
                        System.out.println("This is an invalid input. Please try again!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("This is an invalid input. Please try again!");
                }
            }

            switch (attackNum) {
                case 1: {
                    if (hydra.getHeads() >= 1) {
                        validMove = true;
                    }
                    break;
                }
                case 2: {
                    if (hydra.getTails() >= 1) {
                        validMove = true;
                    }
                    break;
                }
                case 3: {
                    if (hydra.getHeads() >= 2) {
                        validMove = true;
                    }
                    break;
                }
                case 4: {
                    if (hydra.getTails() >= 2) {
                        validMove = true;
                    }
                    break;
                }
            }

            if (attackNum == 5) {
                validMove = true;
            }
            if (!validMove) {
                System.out.println("You can't use that action! The Hydra doesn't have enough heads/tails!");
                validEntry = false;
            }
        }
        return attackNum;
    }
    //Allows the user to start a new game
    public static boolean playAgain() {
        boolean playAgain = true;
        boolean validEntry = false;

        while (!validEntry) {
            try {
                System.out.println("Would you like to play again? Enter 1 for Yes or 0 for No");
                Scanner scanner = new Scanner(System.in);
                int userInput = scanner.nextInt();
                if (userInput == 0) {
                    playAgain = false;
                    validEntry = true;
                } else if (userInput == 1) {
                    validEntry = true;
                } else {
                    System.out.println("This is an invalid input. Please try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("This is an invalid input. Please try again!");
            }
        }
        return playAgain;
    }
    //Prompts the user for the amounts of heads and tails at the start of the game
    public static int[] hydraUserInput() {
        boolean validEntry = false;
        int[] array = {0, 0};

        while(array[0] == 0 && array[1] == 0){
            while (!validEntry) {
                try {
                    System.out.println("How many heads should the Hydra start with? ");
                    Scanner scanner = new Scanner(System.in);
                    array[0] = scanner.nextInt();
                    if (array[0] >= 0) {
                        validEntry = true;
                    } else {
                        System.out.println("This is an invalid input. Please try again!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("This is an invalid input. Please try again!");
                    validEntry = false;
                }
            }
            validEntry = false;
            while (!validEntry) {
                try {
                    System.out.println("How many tails should the Hydra start with? ");
                    Scanner scanner = new Scanner(System.in);
                    array[1] = scanner.nextInt();
                    if (array[1] >= 0) {
                        validEntry = true;
                    } else {
                        System.out.println("This is an invalid input. Please try again!");
                        validEntry = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("This is an invalid input. Please try again!");
                    validEntry = false;
                }
            }
            if(array[0] == 0 && array[1] == 0) {
                System.out.println("Both heads and tails of the Hydra cannot start at 0. Please try again!");
                validEntry = false;
            }
        } return array;
    }
}