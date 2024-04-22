/*
* Course: CS1011 - 111
* Spring 2024
* Software Dev Final
* Name: Nathan Cobb
* Created: 4/19/2024
*/
package pignated;

import java.io.Serializable;

/**
 * Ability of a card
 */
public class AbilityCost implements Serializable {
    private String manaCostString = "";
    AbilityCost() {
        System.out.println("Cost Generator:\n----------------");
        System.out.println("Does the card tap to use the ability? (y/n)");

        if(GeneralUse.getYN()) {
            manaCostString += "{Tap}";
        }
        System.out.println("Is there a mana cost? (y/n)");
        String colorMana = "";
        String phyrexianMana = "";
        String snowMana = "";
        String hybridMana = "";
        if(GeneralUse.getYN()) {
            int colorless = GeneralUse.getInt("colorless mana cost ");
            manaCostString += GeneralUse.formatCost(colorless);
        }
        System.out.println("Is there colored mana? (y/n)");
        if(GeneralUse.getYN()) {
            int white = GeneralUse.getInt("white mana cost");
            int blue = GeneralUse.getInt("blue mana cost");
            int black = GeneralUse.getInt("black mana cost");
            int red = GeneralUse.getInt("red mana cost");
            int green = GeneralUse.getInt("green mana cost");
            colorMana += GeneralUse.toColorCost("W", white);
            colorMana += GeneralUse.toColorCost("U", blue);
            colorMana += GeneralUse.toColorCost("B", black);
            colorMana += GeneralUse.toColorCost("R", red);
            colorMana += GeneralUse.toColorCost("G", green);
        }
        manaCostString += colorMana;
        System.out.println("Is there a phyrexian mana cost? (y/n)");
        if(GeneralUse.getYN()){
            int white = GeneralUse.getInt("white phyrexian mana cost");
            int blue = GeneralUse.getInt("blue phyrexian mana cost");
            int black = GeneralUse.getInt("black phyrexian mana cost");
            int red = GeneralUse.getInt("red phyrexian mana cost");
            int green = GeneralUse.getInt("green phyrexian mana cost");
            phyrexianMana += GeneralUse.toColorCost("W/P", white);
            phyrexianMana += GeneralUse.toColorCost("U/P", blue);
            phyrexianMana += GeneralUse.toColorCost("B/P", black);
            phyrexianMana += GeneralUse.toColorCost("R/P", red);
            phyrexianMana += GeneralUse.toColorCost("G/P", green);
        }
        System.out.println("Is there a snow mana cost? (y/n)");
        if(GeneralUse.getYN()){
            int snow = GeneralUse.getInt("snow mana cost");
            snowMana += GeneralUse.toColorCost("S", snow);
        }
        System.out.println("Is there a hybrid mana cost? (y/n)");
        if(GeneralUse.getYN()){
            int whiteBlue = GeneralUse.getInt("white/blue hybrid mana cost");
            int whiteBlack = GeneralUse.getInt("white/black hybrid mana cost");
            int blueBlack = GeneralUse.getInt("blue/black hybrid mana cost");
            int blueRed = GeneralUse.getInt("blue/red hybrid mana cost");
            int blackRed = GeneralUse.getInt("black/red hybrid mana cost");
            int blackGreen = GeneralUse.getInt("black/green hybrid mana cost");
            int redGreen = GeneralUse.getInt("red/green hybrid mana cost");
            int redWhite = GeneralUse.getInt("red/white hybrid mana cost");
            int greenWhite = GeneralUse.getInt("green/white hybrid mana cost");
            int greenBlue = GeneralUse.getInt("green/blue hybrid mana cost");
            int colorlessWhite = GeneralUse.getInt("colorless/white hybrid mana cost");
            int colorlessBlue = GeneralUse.getInt("colorless/blue hybrid mana cost");
            int colorlessBlack = GeneralUse.getInt("colorless/black hybrid mana cost");
            int colorlessRed = GeneralUse.getInt("colorless/red hybrid mana cost");
            int colorlessGreen = GeneralUse.getInt("colorless/green hybrid mana cost");
            hybridMana += GeneralUse.toColorCost("W/U", whiteBlue);
            hybridMana += GeneralUse.toColorCost("W/B", whiteBlack);
            hybridMana += GeneralUse.toColorCost("U/B", blueBlack);
            hybridMana += GeneralUse.toColorCost("U/R", blueRed);
            hybridMana += GeneralUse.toColorCost("B/R", blackRed);
            hybridMana += GeneralUse.toColorCost("B/G", blackGreen);
            hybridMana += GeneralUse.toColorCost("R/G", redGreen);
            hybridMana += GeneralUse.toColorCost("R/W", redWhite);
            hybridMana += GeneralUse.toColorCost("G/W", greenWhite);
            hybridMana += GeneralUse.toColorCost("G/U", greenBlue);
            hybridMana += GeneralUse.toColorCost("2/W", colorlessWhite);
            hybridMana += GeneralUse.toColorCost("2/U", colorlessBlue);
            hybridMana += GeneralUse.toColorCost("2/B", colorlessBlack);
            hybridMana += GeneralUse.toColorCost("2/R", colorlessRed);
            hybridMana += GeneralUse.toColorCost("2/G", colorlessGreen);

        }
        manaCostString += phyrexianMana + snowMana + hybridMana;
    }
    @Override
    public String toString() {
        return manaCostString;
    }
}
