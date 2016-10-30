package com.sketchproject;

/**
 * InheritanceChallenge
 * Created by Angga on 22/07/2016.
 */
public class Vehicle {

    private String name;
    private String size;

    private int currentVelocity;
    private int currentDirection;

    public Vehicle(String name, String size) {
        this.name = name;
        this.size = size;

        this.currentVelocity = 0;
        this.currentDirection = 0;
    }

    public void start() {
        this.currentVelocity = 0;
        this.currentDirection = 0;
        System.out.println("Vehicle.start(): Velocity " + currentVelocity + " direction " + currentDirection);
    }

    public void steer(int direction) {
        this.currentDirection += direction;
        System.out.println("Vehicle.steer(): Steering at " + currentDirection);
    }

    public void move(int velocity, int direction) {
        this.currentVelocity = velocity;
        this.currentDirection = direction;
        System.out.println("Vehicle.move(): Moving at " + currentVelocity + " in direction " + currentDirection);
    }

    public void stop() {
        this.currentVelocity = 0;
        System.out.println("Vehicle.stop(): Velocity " + currentVelocity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public void setCurrentVelocity(int currentVelocity) {
        this.currentVelocity = currentVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }
}
