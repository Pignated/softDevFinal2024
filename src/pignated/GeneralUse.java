/*
 * Course: CS1011 - 111
 * Spring 2024
 * Software Dev Final
 * Name: Nathan Cobb
 * Created: 4/19/2024
 */
package pignated;

import java.io.Serializable;
import java.util.Scanner;
/**
 * General use methods
 */
public class GeneralUse implements Serializable {
    /**
     * The number five because magic number is the worst
     */
    public static final int FIVE = 5;
    /**
     * The number six because magic number is the worst
     */
    public static final int SIX = 6;
    /**
     * The number seven because magic number is the worst
     */
    public static final int SEVEN = 7;
    private static final Scanner SCANNER = new Scanner(System.in);
    /**
     * Get a string from the user
     * @param request what to ask the user for
     * @return the string the user entered
     */
    public static String getStringWithSpaces(String request) {
        System.out.println("Enter " + request + ": ");
        return SCANNER.nextLine();
    }

    /**
     * Get a Y or N string from the user
     * @return true if the user entered Y, false if the user entered N
     */
    public static boolean getYN(){
        String yN;
        while(true){
            yN = SCANNER.nextLine();
            if(yN.equalsIgnoreCase("Y")||yN.equalsIgnoreCase("N")){
                return yN.equalsIgnoreCase("Y");
            } else {
                System.out.println("Invalid response: Enter Y for yes or N for no: ");
            }


        }
    }
    /**
     * Get an integer from the user
     * @param request what to ask the user for
     * @return the integer the user entered
     */
    public static int getInt(String request){
        System.out.println("Enter " + request + ": ");
        while(true) {
            try {
                return Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
    /**
     * Format a cost string
     * @param cost cost to format
     * @return formatted cost
     */
    public static String formatCost(String cost){
        if(!cost.isEmpty()) {
            return "{" + cost + "}";
        }
        return "";
    }
    /**
     * Format a cost integer
     * @param cost cost to format
     * @return formatted cost
     */
    public static String formatCost(int cost){
        if(!(cost == 0)) {
            return "{" + cost + "}";
        }
        return "";
    }
    /**
     * Create a string of colored mana symbols
     * @param color the color of the mana
     * @param amt the amount of mana
     * @return the string of mana symbols
     */
    public static String toColorCost(String color, int amt){
        //was longer/more complex, thank you intellij for improving it
        return formatCost(String.valueOf(color).repeat(Math.max(0, amt)));
    }
}
