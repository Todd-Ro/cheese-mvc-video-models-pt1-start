package org.launchcode.models;

import java.util.ArrayList;

/**
 *
 */
public class CheeseData {

    static ArrayList<Cheese> cheeses = new ArrayList<>();

    // getAll
    public static ArrayList<Cheese> getAll() {
        return cheeses;
    }

    // add
    public static void add(Cheese newCheese) {
        cheeses.add(newCheese);
    }

    // remove
    public static void remove(int id) {
        Cheese cheeseToRemove = getById(id);
        cheeses.remove(cheeseToRemove);
    }

    // getById
    public static Cheese getById(int id) {

        Cheese theCheese = null; // returns null if none found

        for (Cheese candidateCheese : cheeses) {
            if (candidateCheese.getCheeseId() == id) {
                theCheese = candidateCheese;
            }
        }

        return theCheese;
    }

    public static void editCheese(int id, String newName, String newDescription) {
        Cheese theCheese = getById(id);
        theCheese.setName(newName);
        theCheese.setDescription(newDescription);
    }

    public static void editCheese(int id, String newName, String newDescription, CheeseType newType) {
        Cheese theCheese = getById(id);
        theCheese.setName(newName);
        theCheese.setDescription(newDescription);
        theCheese.setType(newType);
    }

    public static void editCheese(int id, String newName, String newDescription, CheeseType newType,
                                  Integer newRating) {
        Cheese theCheese = getById(id);
        theCheese.setName(newName);
        theCheese.setDescription(newDescription);
        theCheese.setType(newType);
        theCheese.setRating(newRating);
    }

}
