package org.launchcode.models;

import java.util.ArrayList;

public class UserData {

    static ArrayList<User> users = new ArrayList<>();

    // getAll
    public static ArrayList<User> getAll() {
        return users;
    }

    // add
    public static void add(User newUser) {
        users.add(newUser);
    }

    // getById
    public static User getById(Integer id) {

        User theUser = null; // returns null if none found

        for (User candidateUser : users) {
            if (candidateUser.getUserId() == id) {
                theUser = candidateUser;
            }
        }

        return theUser;
    }

    // remove
    public static void remove(Integer id) {
        User userToRemove = getById(id);
        users.remove(userToRemove);
    }


    public static void editUser(Integer id, String newUsername, String newPassword) {
        User theUser = getById(id);
        theUser.setUsername(newUsername);
        theUser.setPassword(newPassword);
    }

}




