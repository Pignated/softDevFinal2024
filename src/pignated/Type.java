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
 * An enumeration of the possible types for a Magic: The Gathering card
 */
public enum Type implements Serializable {
    /**
     * A creature card
     */
    CREATURE("Creature"),
    /**
     * An artifact card
     */
    ARTIFACT("Artifact"),
    /**
     * An enchantment card
     */
    ENCHANTMENT("Enchantment"),
    /**
     * An instant card
     */
    INSTANT("Instant"),
    /**
     * A sorcery card
     */
    SORCERY("Sorcery"),
    /**
     * A planeswalker card
     */
    PLANESWALKER("Planeswalker"),
    /**
     * A land card
     */
    LAND("Land");
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private final String type;

    Type(String type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return type;
    }
    /**
     * Prompts the user to choose a type
     * @return the type chosen by the user
     */
    public static Type getType(){
        System.out.println("Choose type: ");
        System.out.println("1. Creature");
        System.out.println("2. Artifact");
        System.out.println("3. Enchantment");
        System.out.println("4. Instant");
        System.out.println("5. Sorcery");
        System.out.println("6. Planeswalker");
        System.out.println("7. Land");

        int choice = GeneralUse.getInt("type");
        if(choice < 1 || choice > SEVEN) {
            System.out.println("Invalid choice. Please try again.");
            return getType();
        }
        return switch (choice) {
            case 1 -> CREATURE;
            case 2 -> ARTIFACT;
            case 3 -> ENCHANTMENT;
            case 4 -> INSTANT;
            case FIVE -> SORCERY;
            case SIX -> PLANESWALKER;
            case SEVEN -> LAND;
            default -> null;
        };
    }
}
