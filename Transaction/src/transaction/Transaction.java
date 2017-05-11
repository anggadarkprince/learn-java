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
public class Transaction {

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
        // if customer rent a car, put the transaction here
        String[][] rentedData = new String[0][0];
        // helper variable to count the transaction ID
        int idTransaction = 1;

        System.out.println("RENT CARS");
        // program has several menus, keep asking unless you select 0 or intend to exit
        while (true) {
            System.out.println("");
            System.out.println("Available Action:");
            System.out.println("Press 1 Show All Cars Data");
            System.out.println("Press 2 Show All Customer Data");
            System.out.println("Press 3 Rent Car (Transaction)");
            System.out.println("Press 4 Show Rented Cars (By Customer)");
            System.out.println("Press 5 Return Car");
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
                    if (carData.length > 0) {
                        for (int i = 0; i < carData.length; i++) {
                            System.out.printf("%5s%20s%20s\n", carData[i][0], carData[i][1], carData[i][2]);
                        }
                    } else {
                        System.out.println("No car available (All cars has been rented)");
                    }
                    System.out.println("----------------------------------------------");
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("CUSTOMER DATA");
                    System.out.println("-------------------------------");
                    System.out.printf("%10s%20s\n", "Customer ID", "Name");
                    System.out.println("-------------------------------");
                    if (customerData.length > 0) {
                        for (int i = 0; i < customerData.length; i++) {
                            System.out.printf("%10s%20s\n", customerData[i][0], customerData[i][1]);
                        }
                    } else {
                        System.out.println("No customer data available");
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
                    int customerIndex = -1;
                    for (int i = 0; i < customerData.length; i++) {
                        if (Integer.parseInt(customerData[i][0]) == selectedCustomerID) {
                            customerIndex = i;
                            break;
                        }
                    }
                    if (customerIndex == -1) {
                        System.out.println("Customer not found, transaction cancelled!");
                        break;
                    }
                    System.out.println("Customer " + customerData[customerIndex][1] + " selected");

                    // select picked car (rent) by customer by ID
                    System.out.println("");
                    System.out.println("Available Car");
                    System.out.println("----------------------------------------------");
                    System.out.printf("%5s%20s%20s\n", "Car ID", "Vendor", "Cost per day");
                    System.out.println("----------------------------------------------");
                    if (carData.length > 0) {
                        for (int i = 0; i < carData.length; i++) {
                            System.out.printf("%5s%20s%20s\n", carData[i][0], carData[i][1], carData[i][2]);
                        }
                    } else {
                        System.out.println("All cars has been rented");
                        System.out.println("----------------------------------------------");
                        System.out.println("Transaction cancelled");
                        break;
                    }
                    System.out.println("----------------------------------------------");

                    int selectedCarID = 0;
                    int carIndex = -1;
                    while (true) {
                        System.out.print("(Step 2/3)Select Car ID: ");
                        selectedCarID = userInput.nextInt();
                        carIndex = -1;
                        for (int i = 0; i < carData.length; i++) {
                            if (Integer.parseInt(carData[i][0]) == selectedCarID) {
                                carIndex = i;
                                break;
                            }
                        }
                        if (carIndex != -1) {
                            break;
                        }
                        System.out.println("Car not found, input available car ID");

                    }
                    System.out.println("Car " + carData[carIndex][1] + " selected");

                    // how long customer rent the car (minimum 1 day)
                    int rentDays = 0;
                    while (true) {
                        System.out.println("");
                        System.out.print("(Step 3/3) How long '" + customerData[customerIndex][1] + "' rent '" + carData[carIndex][1] + "' (more 5 days got 10% discount):");

                        rentDays = userInput.nextInt();
                        if (rentDays > 0) {
                            break;
                        }
                        System.out.println("Rent day must be minimum 1 day");
                    }

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

                    // these parts little bit complex (with static array)!
                    // move selected car and customer data into rented data
                    // the car cannot rent if it has already rented
                    // if you want, delete this part is okay, you don't need detail for simple school project
                    // I think without this part you got score A already.                    
                    // first, put current rent data into array rentCarData (+1 we add new row)
                    String[][] tempRentedData = new String[rentedData.length + 1][8];
                    for (int i = 0; i < rentedData.length; i++) {
                        tempRentedData[i] = rentedData[i];
                    }
                    // add new transaction in last index (remember we +1 of array length)
                    int lastIndex = tempRentedData.length - 1;
                    tempRentedData[lastIndex][0] = String.valueOf(idTransaction);
                    tempRentedData[lastIndex][1] = customerData[customerIndex][0];
                    tempRentedData[lastIndex][2] = customerData[customerIndex][1];
                    tempRentedData[lastIndex][3] = carData[carIndex][0];
                    tempRentedData[lastIndex][4] = carData[carIndex][1];
                    tempRentedData[lastIndex][5] = carData[carIndex][2];
                    tempRentedData[lastIndex][6] = String.valueOf(rentDays);
                    tempRentedData[lastIndex][7] = String.valueOf(rentCostAfterDiscount);
                    // we got new rented data
                    rentedData = tempRentedData;

                    idTransaction++;

                    // rebuild car data, a car should rent by now, if first time you have 3 cars,
                    // then now you should have only 2 cars (because one of them is rented)
                    // but for customer we leave it that way, because one customer maybe and allow to rent more than 1 car
                    // okay let's create temporary array to hold cars except the one which rented 
                    // and override the last carData array (-1 we remove a car)
                    String[][] tempCarData = new String[carData.length - 1][3];
                    int counter = 0;
                    for (int i = 0; i < carData.length; i++) {
                        // we check if selected car ID (selectedCar) is found then EXCLUDE it (that car has been rented)
                        if (Integer.parseInt(carData[i][0]) != selectedCarID) {
                            tempCarData[counter] = carData[i];
                            counter++;
                        }
                    }
                    // we got all car data WITHOUT car which rented in this transaction
                    carData = tempCarData;
                    //------- remove till this line if you want but you must remove some feature as well

                    break;
                case 4:
                    System.out.println("");
                    System.out.println("RENT DATA");
                    System.out.println("--------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%10s%15s%15s%10s%15s%15s%15s%15s\n", "Trans ID", "Customer ID", "Name", "Car ID", "Rent Car", "Price/Day", "In Days", "Total");
                    System.out.println("--------------------------------------------------------------------------------------------------------------");
                    if (rentedData.length > 0) {
                        for (int i = 0; i < rentedData.length; i++) {
                            System.out.printf("%10s%15s%15s%10s%15s%15s%15s%15s\n", rentedData[i][0], rentedData[i][1], rentedData[i][2], rentedData[i][3], rentedData[i][4], rentedData[i][5], rentedData[i][6], rentedData[i][7]);
                        }
                    } else {
                        System.out.println("No car rented yet (All cars available)");
                    }
                    System.out.println("--------------------------------------------------------------------------------------------------------------");
                    break;
                case 5:
                    // first show all rented cars, if not available then skip it, because there is no car can return
                    System.out.println("");
                    System.out.println("Rented Car");
                    System.out.println("--------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%10s%15s%15s%10s%15s%15s%15s%15s\n", "Trans ID", "Customer ID", "Name", "Car ID", "Rent Car", "Price/Day", "In Days", "Total");
                    System.out.println("--------------------------------------------------------------------------------------------------------------");
                    if (rentedData.length > 0) {
                        for (int i = 0; i < rentedData.length; i++) {
                            System.out.printf("%10s%15s%15s%10s%15s%15s%15s%15s\n", rentedData[i][0], rentedData[i][1], rentedData[i][2], rentedData[i][3], rentedData[i][4], rentedData[i][5], rentedData[i][6], rentedData[i][7]);
                        }
                    } else {
                        System.out.println("No car rented yet (All cars available), Returning action will be cancelled");
                        System.out.println("--------------------------------------------------------------------------------------------------------------");
                        break;
                    }
                    System.out.println("--------------------------------------------------------------------------------------------------------------");

                    // there is car able to return, then ask which one transaction would return (by ID)
                    System.out.print("Select Trans ID which return the Car: ");
                    int selectedTransID = userInput.nextInt();
                    int rentedIndex = -1;
                    for (int i = 0; i < rentedData.length; i++) {
                        if (Integer.parseInt(rentedData[i][0]) == selectedTransID) {
                            rentedIndex = i;
                            break;
                        }
                    }
                    // transaction ID not found, cancel returning
                    if (rentedIndex == -1) {
                        System.out.println("Transaction not found, returning action will be cancelled!");
                        break;
                    }

                    // return the car to array carData and remove it from rentedData
                    // create temporary car data +1 (return) and copy array (and add returned car)
                    String[][] temporaryCarData = new String[carData.length + 1][3];
                    for (int i = 0; i < carData.length; i++) {
                        temporaryCarData[i] = carData[i];
                    }
                    // get car data from rentData array to temporaryCarData in last index
                    // car data on index 3 (id), 4 (car name), 5 (cost/day)
                    int lastCarIndex = temporaryCarData.length - 1;
                    temporaryCarData[lastCarIndex][0] = rentedData[rentedIndex][3];
                    temporaryCarData[lastCarIndex][1] = rentedData[rentedIndex][4];
                    temporaryCarData[lastCarIndex][2] = rentedData[rentedIndex][5];
                    // we got new car data (last car data + returned car data)
                    carData = temporaryCarData;

                    System.out.println("Car " + rentedData[rentedIndex][4] + " has returned");

                    // remove selected item on rentedData array
                    String[][] temporaryRentedData = new String[rentedData.length - 1][7];
                    int counterCar = 0;
                    for (int i = 0; i < rentedData.length; i++) {
                        if (Integer.parseInt(rentedData[i][0]) != selectedTransID) {
                            temporaryRentedData[counterCar] = rentedData[i];
                            counterCar++;
                        }
                    }
                    // we got all rented data WITHOUT car which returned
                    rentedData = temporaryRentedData;
                    break;
                case 0:
                    System.out.println("Good bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("The options only available in 0 - 5");
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
