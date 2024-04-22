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
public class Ability implements Serializable {
    private final AbilityCost abilityCost;
    private final String abilityText;
    Ability() {
        System.out.println("Ability Generator:\n----------------");
        abilityText = GeneralUse.getStringWithSpaces("ability text");
        abilityCost = new AbilityCost();
    }

    @Override
    public String toString() {
        return abilityCost + " " + abilityText;
    }
}
