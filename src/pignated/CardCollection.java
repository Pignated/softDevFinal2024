/*
 * Course: CS1011 - 111
 * Spring 2024
 * Software Dev Final
 * Name: Nathan Cobb
 * Created: 4/19/2024
 */
package pignated;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Collection of Magic the Gathering cards
 **/
public class CardCollection implements Serializable {
    private final ArrayList<Card> cards = new ArrayList<>();
    private int collectionSize;
    /**
     * Create a new card collection
     */
    public CardCollection(){
        collectionSize = 0;
    }
    /**
     * View all cards in the collection
     */
    public void viewAllCards() {
        for (Card c : cards) {
            System.out.println(c.getName());
        }
    }
    /**
     * Add a card to the collection
     * @param card card to add
     */
    public void addCard(Card card) {
        if(!contains(card)) {
            cards.add(card);
            collectionSize++;
            System.out.println("Card added to collection");
        } else {
            System.out.println("Card already in collection");
        }
    }
    private boolean contains(Card card) {
        for (Card c : cards) {
            if (c.equals(card)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Search for a card in the collection
     */
    public void searchForCard() {
        boolean found = false;
        String name = GeneralUse.getStringWithSpaces(
                "Enter the name of the card you are looking for");
        for (Card c : cards) {
            if (c.getName().equals(name)) {
                System.out.println("Card found");
                System.out.println(c);
                found = true;
            }
        }
        if (!found){
            System.out.println("Card not found");
        }
    }
    /**
     * Delete a card from the collection
     */
    public void deleteCard() {
        String name = GeneralUse.getStringWithSpaces(
                "Enter the name of the card you want to delete");
        for (Card c : cards) {
            if (c.getName().equals(name)) {
                cards.remove(c);
                collectionSize--;
                System.out.println("Card deleted");
                return;
            }
        }
        System.out.println("Card not found");
    }
    /**
     * Search a card by type
     */
    public void searchByType() {
        boolean found = false;
        String type = Type.getType().toString();
        for (Card c : cards) {
            for (Type t : c.getTypes()) {
                if (t.toString().contains(type)) {
                    System.out.println(c);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Card(s) not found");
        }
    }
    /**
     * Search a card by color
     */
    public void searchByColor() {
        boolean found = false;
        System.out.println("Enter the color you are looking for: ");
        System.out.println("1. White");
        System.out.println("2. Blue");
        System.out.println("3. Black");
        System.out.println("4. Red");
        System.out.println("5. Green");
        System.out.println("6. Multicolor");
        System.out.println("7. Colorless");
        int choice = GeneralUse.getInt("color");
        switch (choice) {
            case 1:
                searchForColor("W");
                break;
            case 2:
                searchForColor("U");
                break;
            case 3:
                searchForColor("B");
                break;
            case 4:
                searchForColor("R");
                break;
            case GeneralUse.FIVE:
                searchForColor("G");
                break;
            case GeneralUse.SIX:
                searchByColorMulti();
                break;
            case GeneralUse.SEVEN:
                searchByColorless();
                break;
            default:
                System.out.println("Invalid choice");
        }

        if (!found) {
            System.out.println("Card(s) not found");
        }


    }
    private void searchForColor(String color) {
        manaMatcher(String.format("\\S*{%s}\\S", color));
    }
    private void searchByColorMulti() {
        manaMatcher("\\S*(\\{[A-Za-z]*}){2,}\\S*");
    }
    private void searchByColorless() {
        manaMatcher("\\S*\\{[0-9]*}\\S*");
    }

    private void manaMatcher(String pat) {
        boolean found = false;
        Pattern pattern = Pattern.compile(pat);
        for (Card c : cards) {
            Matcher matcher = pattern.matcher(c.getManaCostString());
            if (matcher.find()) {
                System.out.println(c.getName());
                found = true;
            }
        }
        if(!found) {
            System.out.println("Card(s) not found");
        }
    }
    /**
     * Search a card by converted mana cost
     */
    public void cmcSearch() {
        boolean found = false;
        int cmc = GeneralUse.getInt("CMC");
        for (Card c : cards) {
            if (c.cmc() == cmc) {
                System.out.println(c.getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Card(s) not found");
        }
    }
    /**
     * Get the size of the collection
     * @return the size of the collection
     */
    public int getCollectionSize() {
        return collectionSize;
    }
}

