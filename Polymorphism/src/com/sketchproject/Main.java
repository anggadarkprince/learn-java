package com.sketchproject;

public class Main {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Movie movie = randomMovie();
            System.out.println("Movie #" + i + " : " + movie.getName() + "\n" + movie.plot() + "\n");
        }
    }

    public static Movie randomMovie() {
        int randomNumber = (int) (Math.random() * 5) + 1;
        System.out.println("Random number generated: " + randomNumber);
        switch (randomNumber) {
            case 1:
                return new Jaws();
            case 2:
                return new IndependenceDay();
            case 3:
                return new MazeRunner();
            case 4:
                return new StarWars();
            case 5:
                return new ForgettableMovie();
        }
        return null;
    }
}
