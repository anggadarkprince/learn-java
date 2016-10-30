package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        // select all users
        ArrayList<User> users = userManager.selectAll();
        printAllUser(users);

        System.out.println();

        // select single user by id
        int userId = 2;
        User singleUser = userManager.selectById(userId);
        printUser(singleUser);

        System.out.println();

        // update
        singleUser.setId(userId);
        singleUser.setUsername("flario");
        userManager.update(singleUser);
        printUser(singleUser);

        System.out.println();

        // insert
        User newUser = new User("Herby", "Dolly", "herbydoll", "Herb1234");
        userManager.insert(newUser);
        users = userManager.selectAll();
        printAllUser(users);

        System.out.println();

        // delete
        userManager.delete(5);
        users = userManager.selectAll();
        printAllUser(users);
    }

    public static void printUser(User user) {
        System.out.println(user.getFirstName() + " " + user.getLastName() + " (" + user.getUsername() + ")");
    }

    public static void printAllUser(ArrayList<User> users) {
        users.forEach(Main::printUser);
    }
}
