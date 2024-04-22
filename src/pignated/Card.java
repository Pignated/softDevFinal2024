/*
* Course: CS1011 - 111
* Spring 2024
* Software Dev Final
* Name: Nathan Cobb
* Created: 4/19/2024
*/
package pignated;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * A Magic the Gathering card
 */
public class Card implements Serializable {
    private final String name;
    private final Cost cost;
    private final Ability[] abilities;
    private final String set;
    private final int power;
    private final int toughness;
    private final Type[] types;
    private final String[] subtypes;
    private final String artist;
    private final boolean foil;
    /**
     * Create a card
     */
    public Card(){
        name = GeneralUse.getStringWithSpaces("card name");
        cost = new Cost();
        power = GeneralUse.getInt("power");
        toughness = GeneralUse.getInt("toughness");
        int numAbilities = GeneralUse.getInt("number of abilities");
        abilities = new Ability[numAbilities];
        for (int i = 0; i < numAbilities; i++) {
            abilities[i] = new Ability();
        }
        int numTypes = GeneralUse.getInt("number of types");
        types = new Type[numTypes];
        for (int i = 0; i < numTypes; i++) {
            types[i] = Type.getType();
        }
        int numSubtypes = GeneralUse.getInt("number of subtypes");
        subtypes = new String[numSubtypes];
        for (int i = 0; i < numSubtypes; i++) {
            subtypes[i] = GeneralUse.getStringWithSpaces("subtype" + (i + 1));
        }

        set = GeneralUse.getStringWithSpaces("set");
        artist = GeneralUse.getStringWithSpaces("artist");
        System.out.println("Is it a foil? (Y/N)");
        foil = GeneralUse.getYN();
    }

    @Override
    public String toString() {
        String line1 = name + " " + cost + " " + power + "/" + toughness + " ";
        StringBuilder line2 = new StringBuilder();
        StringBuilder line3 = new StringBuilder();
        StringBuilder line4 = new StringBuilder();
        for (Ability ability: abilities) {
            line3.append("\n").append(ability);
        }
        for (Type type: types) {
            line2.append(type).append(" ");
        }
        line2.append("- ");
        for (String subtype: subtypes) {
            line2.append(subtype).append(" ");
        }
        line4.append(set).append("-").append(artist).append(" ");
        if (foil) {
            line4.append("Foil");
        }
        return line1 + "\n" + line2 + "\n" + line3 + "\n" + line4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return power == card.power && toughness == card.toughness &&
                foil == card.foil && Objects.equals(name, card.name) &&
                Objects.equals(cost, card.cost) && Arrays.equals(abilities, card.abilities) &&
                Objects.equals(set, card.set) && Arrays.equals(types, card.types) &&
                Arrays.equals(subtypes, card.subtypes) && Objects.equals(artist, card.artist);
    }
    public String getName() {
        return name;
    }
    public Type[] getTypes() {
        return types;
    }

    /**
     * Get the converted mana cost of the card
     * @return the converted mana cost
     */
    public int cmc(){
        return cost.getCMC();
    }
    public String getManaCostString(){
        return cost.getManaCostString();
    }
}
