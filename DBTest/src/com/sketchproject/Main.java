package com.sketchproject;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        UserModel userModel = new UserModel();
        ArrayList<User> users = userModel.selectAll();
        for (User user:users) {
            System.out.println(user.getFirstName() + " " + user.getLastName());
        }

        User singleUser = userModel.selectById(1);
        System.out.println(singleUser.getFirstName());

        User updateUser = new User(1, "Lala", "Trilili", "lala43");
        System.out.println("affected update " + userModel.update(updateUser));

        System.out.println("affected delete " + userModel.delete(25));


    }
}
