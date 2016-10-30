package com.sketchproject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TheatreEnhanced theatre = new TheatreEnhanced("Olympian", 8, 12);
        theatre.getSeats();
        if (theatre.reserveSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        if (theatre.reserveSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        System.out.println();

        List<TheatreEnhanced.Seat> seatsCopy = new ArrayList<>();

        Collections.reverse(theatre.getSeatsList());
        Collections.copy(theatre.getSeatsList(), seatsCopy);
        Collections.sort(theatre.getSeatsList());
        Collections.shuffle(theatre.getSeatsList());
        Collections.rotate(theatre.getSeatsList(), 5);
        Collections.swap(theatre.getSeatsList(), 2, 4);

        Collections.min(theatre.getSeatsList());
        Collections.max(theatre.getSeatsList());

        System.out.println();


        if(theatre.reserveSeat("B13")) {
            System.out.println("Please pay for B13");
        } else {
            System.out.println("Seat already reserved");
        }

        List<TheatreEnhanced.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);


        List<TheatreEnhanced.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));
        Collections.sort(priceSeats, TheatreEnhanced.PRICE_ORDER);
        printList(priceSeats);
    }

    public static void printList(List<TheatreEnhanced.Seat> list) {
        for(TheatreEnhanced.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice());
        }
        System.out.println();
        System.out.println("======================================================================");
    }
}
