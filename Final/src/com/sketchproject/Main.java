package com.sketchproject;

public class Main {

    public static void main(String[] args) {
        Player player = new Player("Angga");

        int playerHealth = player.getHealth() - player.HIT_POINT;
        System.out.println("Player " + player.getName() + " got hit by " + player.HIT_POINT);
        System.out.println("\tCurrent player health " + playerHealth);

        System.out.println("Player weapon are " + Player.PRIMARY_WEAPON + " and " + Player.SECONDARY_WEAPON);

    }
}
