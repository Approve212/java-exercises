package name.cmkimberlin.exercises;

import java.util.Scanner;

/**
 * Author: Caleb Kimberlin
 * Date: 6/28/20
 *
 * This program reads in a time input and gives a new time that is 45 minutes earlier
 */

public class StarterClass {
    static Scanner scan = new Scanner(System.in);
    static int H, M;

    /**
     * Prompts user for the time they are getting out of bed
     */
    public static void prompt() {
        System.out.println("At what hour are you getting out of bed?");
        H = scan.nextInt();
        System.out.println("At what minute of the hour are you getting out of bed?");
        M = scan.nextInt();
    }
    /**
     * Checks to see if time provided does not contain any unusual values
     */
    public static boolean checkValid() {
        return H >= 0 && M >= 0 && H <= 23 && M <= 59;
    }

    public static void main(String[] args) {
        boolean validInput;

        prompt();
        validInput = checkValid();

        while (!validInput) {
            System.out.println("This is an invalid time. Please try again.");
            prompt();
            validInput = checkValid();
        }

        M -= 45;

        if (M < 0) {
            H--;
            M = 60 + M;
        }
        if (H < 0) {
            H = 24 + H;
        }

        System.out.println("You will set your alarm to " + H + ":" + M);

        scan.close();
    }
}