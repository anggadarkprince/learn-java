package com.sketchproject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) {
        Object o = new Machine("Honda", 42545);

        Class<?> c = o.getClass();
        System.out.println("Class name: " + c.getName());

        System.out.println();

        try {
            Class<?> sup = Class.forName("com.sketchproject.Machine");
            Object machine = sup.newInstance();
            System.out.println("Reflection with default constructor: " + machine.toString());
            ((Machine) machine).ignite();
            ((Machine) machine).turnOff();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println();

        try {
            Class<?> machineClass = Class.forName("com.sketchproject.Machine");
            Constructor<?> machineConstructor = machineClass.getConstructor(String.class, int.class);
            Object machine = machineConstructor.newInstance("Toyota", 3434234);
            System.out.println("Reflection with constructor argument: " + machine.toString());
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
