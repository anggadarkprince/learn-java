package com.sketchproject;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        player.name = "Angga Ari Wijaya";
        player.health = 100;
        player.weapon = "Sword";

        int damage = 40;
        player.loseHealth(damage);
        System.out.println("Remaining health = " + player.healthRemaining());

        damage = 70;
        player.loseHealth(damage);
        System.out.println("Remaining health = " + player.healthRemaining());

        EnhancedPlayer player2 = new EnhancedPlayer("Angga Ari Wijaya", 200, "Sword");
        System.out.println("Initial health is " + player2.getHealth());
        player2.loseHealth(10);
    }
}
