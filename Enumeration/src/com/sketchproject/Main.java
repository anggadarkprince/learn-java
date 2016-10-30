package com.sketchproject;

public class Main {

    public static void main(String[] args) {
        Player hero = new Player("Angga", 10, Weapon.SWORD);
        System.out.println(hero.getName() + " brings " + hero.getWeapon());

        if(hero.getWeapon() == Weapon.SWORD){
            System.out.println("Hero brings sword");
        }
    }
}
