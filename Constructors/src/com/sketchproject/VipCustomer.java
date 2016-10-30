package com.sketchproject;

/**
 * Constructors
 * Created by Angga on 22/07/2016.
 */
public class VipCustomer {
    private String customerName;
    private double creditLimit;
    private String emailAddress;

    public VipCustomer() {
        this.customerName = "No name";
        this.creditLimit = 0;
        this.emailAddress = "no@email.com";
    }

    public VipCustomer(String customerName, double creditLimit) {
        this.customerName = customerName;
        this.creditLimit = creditLimit;
        this.emailAddress = "no@email.com";
    }

    public VipCustomer(String customerName, double creditLimit, String emailAddress) {
        this.customerName = customerName;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
