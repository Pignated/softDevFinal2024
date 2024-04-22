/*
* Course: CS1011 - 111
* Spring 2024
* Software Dev Final
* Name: Nathan Cobb
* Created: 4/19/2024
*/
package pignated;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Card Management
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to your card collection management");
        /*
        Try to load the collection from a file. If fine dne then create a new collection
        which will be saved later
         */
        CardCollection collection;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("collection.bin"));
            collection = (CardCollection) in.readObject();
            System.out.println("Loaded collection with " +
                    collection.getCollectionSize() + " cards");
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            collection = new CardCollection();
        }

        boolean cont = true;
        while (cont) {
            System.out.println("What would you like to do?");
            System.out.println("1. Add a card");
            System.out.println("2. View all cards");
            System.out.println("3. Search for a card");
            System.out.println("4. Delete a card");
            System.out.println("5. Exit");
            switch (GeneralUse.getInt("choice")) {
                case 1:
                    collection.addCard(new Card());
                    break;
                case 2:
                    collection.viewAllCards();
                    break;
                case 3:
                    System.out.println("Search by: ");
                    System.out.println("1. Name");
                    System.out.println("2. Type");
                    System.out.println("3. Color");
                    System.out.println("4. CMC");
                    switch (GeneralUse.getInt("search type")) {
                        case 1:
                            collection.searchForCard();
                            break;
                        case 2:
                            collection.searchByType();
                            break;
                        case 3:
                            collection.searchByColor();
                            break;
                        case 4:
                            collection.cmcSearch();
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }

                    break;
                case 4:
                    collection.deleteCard();
                    break;
                case GeneralUse.FIVE:
                    cont = false;
                    try {
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
                                "collection.bin"));
                        out.writeObject(collection);
                        out.close();
                    } catch (IOException e) {
                        System.out.println("Error saving collection");
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}