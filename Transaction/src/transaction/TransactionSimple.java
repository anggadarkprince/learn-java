/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Angga
 */
public class TransactionSimple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // define global variable (main scope)
        Scanner userInput = new Scanner(System.in);
        // all master car data predefined here
        String[][] carData = {
            {"1", "MOBILIO", "300000"},
            {"2", "SUZUKI APV", "250000"},
            {"3", "TOYOTA AVANZA", "200000"}
        };
        // all master customer data predefined here
        String[][] customerData = {
            {"1", "Angga"},
            {"2", "Ari"},
            {"3", "Wijaya"}
        };

        System.out.println("RENT CARS");
        // program has several menus, keep asking unless you select 0 or intend to exit
        while (true) {
            System.out.println("");
            System.out.println("Available Action:");
            System.out.println("Press 1 Show All Cars Data");
            System.out.println("Press 2 Show All Customer Data");
            System.out.println("Press 3 Rent Car (Transaction)");
            System.out.println("Press 0 Exit");
            System.out.println("");

            System.out.print("Your action: ");
            int action = userInput.nextInt();
            switch (action) {
                case 1:
                    System.out.println("");
                    System.out.println("CARS DATA");
                    System.out.println("----------------------------------------------");
                    System.out.printf("%5s%20s%20s\n", "Car ID", "Vendor", "Cost per day");
                    System.out.println("----------------------------------------------");
                    for (int i = 0; i < carData.length; i++) {
                        System.out.printf("%5s%20s%20s\n", carData[i][0], carData[i][1], carData[i][2]);
                    }
                    System.out.println("----------------------------------------------");
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("CUSTOMER DATA");
                    System.out.println("-------------------------------");
                    System.out.printf("%10s%20s\n", "Customer ID", "Name");
                    System.out.println("-------------------------------");
                    for (int i = 0; i < customerData.length; i++) {
                        System.out.printf("%10s%20s\n", customerData[i][0], customerData[i][1]);
                    }
                    System.out.println("-------------------------------");
                    break;
                case 3:
                    // select customer who rent the car by ID
                    System.out.println("");
                    System.out.println("Available Customer");
                    System.out.println("-------------------------------");
                    System.out.printf("%10s%20s\n", "Customer ID", "Name");
                    System.out.println("-------------------------------");
                    for (int i = 0; i < customerData.length; i++) {
                        System.out.printf("%10s%20s\n", customerData[i][0], customerData[i][1]);
                    }
                    System.out.println("-------------------------------");
                    System.out.print("(Step 1/3) Select Customer ID: ");
                    int selectedCustomerID = userInput.nextInt();
                    int customerIndex = selectedCustomerID - 1;
                    System.out.println("Customer " + customerData[customerIndex][1] + " selected");

                    // select picked car (rent) by customer by ID
                    System.out.println("");
                    System.out.println("Available Car");
                    System.out.println("----------------------------------------------");
                    System.out.printf("%5s%20s%20s\n", "Car ID", "Vendor", "Cost per day");
                    System.out.println("----------------------------------------------");
                    for (int i = 0; i < carData.length; i++) {
                        System.out.printf("%5s%20s%20s\n", carData[i][0], carData[i][1], carData[i][2]);
                    }
                    System.out.println("----------------------------------------------");

                    System.out.print("(Step 2/3)Select Car ID: ");
                    int selectedCarID = userInput.nextInt();
                    int carIndex = selectedCarID - 1;
                    System.out.println("Car " + carData[carIndex][1] + " selected");

                    // how long customer rent the car
                    System.out.println("");
                    System.out.print("(Step 3/3) How long '" + customerData[customerIndex][1] + "' rent '" + carData[carIndex][1] + "' (more 5 days got 10% discount):");

                    int rentDays = userInput.nextInt();

                    // calculate cost of transaction
                    int rentCost = rentDays * Integer.parseInt(carData[carIndex][2]);

                    // give discount 10% if rent the car more than 5 days
                    float rentCostAfterDiscount = rentCost;
                    if (rentDays > 5) {
                        rentCostAfterDiscount = (float) 90 / 100 * rentCost;
                    }

                    // print receipt in console
                    System.out.println("");
                    System.out.println("-----------------------------------");
                    System.out.println("Receipt of Transaction");
                    System.out.println("-----------------------------------");
                    System.out.printf("%15s%20s\n", "Customer ID", customerData[customerIndex][0]);
                    System.out.printf("%15s%20s\n", "Name", customerData[customerIndex][1]);
                    System.out.printf("%15s%20s\n", "Car ID", carData[carIndex][0]);
                    System.out.printf("%15s%20s\n", "Vendor", carData[carIndex][1]);
                    System.out.printf("%15s%20s\n", "Cost/day", carData[carIndex][2]);
                    System.out.println("-----------------------------------");
                    System.out.printf("%15s%20s\n", "Rent a Car in ", rentDays + " Days");
                    System.out.printf("%15s%20s\n", "Total Cost", "RP." + rentCost);
                    System.out.printf("%15s%20s\n", "After Discount", "RP." + (int) rentCostAfterDiscount);
                    System.out.println("-----------------------------------");
                    System.out.println("Thank you for you business");
                    System.out.println("");

                    // put receipt info to text file (saved into root of project folder "receipt.txt")
                    try {
                        FileWriter fw = new FileWriter("receipts.txt", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter out = new PrintWriter(bw);
                        out.println("-------------------------");
                        out.println("Name: " + customerData[customerIndex][1]);
                        out.println("Rent Car: " + carData[carIndex][1]);
                        out.println("For: " + rentDays + " Days");
                        out.println("Total : Rp." + rentCostAfterDiscount);
                        out.println("-------------------------");
                        out.println();
                    } catch (IOException e) {
                        System.out.println("Something went wrong when write recipt into text file.");
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Good bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("The options only available in 0 - 3");
                    break;
            }

            while (true) {
                System.out.print("Press 0 to back: ");
                int back = userInput.nextInt();
                if (back == 0) {
                    break;
                }
            }
        }
    }
}
