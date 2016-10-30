package com.sketchproject;

public class Main {

    public static void main(String[] args) {
	    ITelephone phone = new DeskPhone(45345);
        phone.powerOn();
        phone.callPhone(45345);
        phone.answer();

        System.out.println();

        phone = new MobilePhone(1122);
        phone.powerOn();
        phone.callPhone(1122);
        phone.answer();
    }
}
