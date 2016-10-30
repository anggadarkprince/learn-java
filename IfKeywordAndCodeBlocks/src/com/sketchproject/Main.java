package com.sketchproject;

public class Main {

    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 5000;
        int levelComplete = 5;
        int bonus = 100;

        if (score == 5000)
            System.out.println("Your score was 5000");
        System.out.println("This was always executed");

        if (score < 5000 && score > 1000) {
            System.out.println("Your score was less than 5000 but greater than 1000");
        } else if (score < 1000) {
            System.out.println("Your score was less than 1000");
        } else {
            System.out.println("Got here, your score is extremely high");
        }

        if (gameOver) {
            int finalScore = score + (levelComplete * bonus);
            System.out.println("Store the score if " + finalScore + " is highest score");
            System.out.println("Restart the game");
        } else {
            System.out.println("Keep tracking game score");
        }

        // Print out a second score on the screen with the following
        // score set to 10000
        // levelCompleted set to 8
        // bonus set to 200
        // But make sure the first printout above still display as well

        score = 10000;
        levelComplete = 8;
        bonus = 200;

        if (gameOver) {
            int finalScore = score + (levelComplete * bonus);
            System.out.println("Your final score was " + finalScore);
        }
    }
}
