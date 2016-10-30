package com.sketchproject;

public class Main {

    public static void main(String[] args) {
        // Create a new class for a bank account
        // Create fields for the account number, balance, customer name, email and phone number.
        //
        // Create getters and setters for each field
        // Create two additional methods
        // 1. To allow the customer to deposit funds (this should be increment the balance field).
        // 2. To allow the customer to withdraw funds. This should deduct from the valance field,
        // but not allow the withdrawal to complete if their are insufficient funds.
        // You will want to create various code in the Main class (the one created by IntelliJ)
        // confirm your code is working.
        // Add some System.out.println's in the two methods above as well

        BankAccount anggaAccount = new BankAccount();
        anggaAccount.setAccountNumber("12345");
        anggaAccount.setCustomerName("Angga Ari Wijaya");
        anggaAccount.setBalance(0);
        anggaAccount.setEmail("anggadarkprince@gmail.com");
        anggaAccount.setPhoneNumber("085655479868");

        System.out.println("-" + anggaAccount.getCustomerName());
        anggaAccount.withdraw(200);
        anggaAccount.deposit(500);
        anggaAccount.withdraw(100);

        System.out.println();

        BankAccount shangrillaAccount = new BankAccount("4321", 0);
        shangrillaAccount.setCustomerName("Shangrilla Riyana");
        shangrillaAccount.setPhoneNumber("088343515334");
        System.out.println("-" + shangrillaAccount.getCustomerName());
        shangrillaAccount.deposit(1000);

        System.out.println();

        BankAccount alexAccount = new BankAccount("1111", 200, "Alex", "alex@gmail.com", "089776322323");
        System.out.println("-" + alexAccount.getCustomerName());
        alexAccount.withdraw(50);

        System.out.println();

        // Create a new class VipCustomer
        // it should has name, credit limit, and email address
        // create 3 constructors
        // 1st constructor empty should call the constructor with 3 parameters with default values
        // 2.nd constructor should pass on the 2 values it receives and add a default value for the 3rd
        // 3rd constructor should save all fields.
        // Create getters only for this using code generation of IntelliJ as setters wont be needed
        // test and confirm it works.

        System.out.println("VIP CUSTOMER");

        VipCustomer angga = new VipCustomer("Angga Ari", 5000, "angga@email.com");
        System.out.println("Customer Name : " + angga.getCustomerName());
        System.out.println("Customer Credit Limit : " + angga.getCreditLimit());
        System.out.println("Customer Email : " + angga.getEmailAddress());

        System.out.println();

        VipCustomer bob = new VipCustomer();
        System.out.println("Customer Name : " + bob.getCustomerName());
        System.out.println("Customer Credit Limit : " + bob.getCreditLimit());
        System.out.println("Customer Email : " + bob.getEmailAddress());

        System.out.println();

        VipCustomer vita = new VipCustomer("Vita", 200);
        System.out.println("Customer Name : " + vita.getCustomerName());
        System.out.println("Customer Credit Limit : " + vita.getCreditLimit());
        System.out.println("Customer Email : " + vita.getEmailAddress());
    }
}
