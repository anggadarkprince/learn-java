package com.sketchproject;

public class Main {

    public static void main(String[] args) {
        // public : at the member level, public has the same meaning as at top level. A public class member (or field) and public method can be accessed from any other class anywhere, even in a different package.
        // package 0 private : this also has the sam meaning as it does at the top level. An object with no access modifier is visible to every class within the same package (but not to classes in external packages)
        // private : the object is only visible within the class it is declared. It is not visible anywhere else (including in subclasses of its class).
        // protected : the object is visible anywhere in its own package (like package-private) but also in subclasses even if they are in another package
        Account anggaAccount = new Account("Angga Ari");
        anggaAccount.deposit(10000);
        anggaAccount.withdraw(100);
        anggaAccount.withdraw(-200);
        anggaAccount.deposit(-100);
        anggaAccount.calculateBalance();

        System.out.println("Balance on account is " + anggaAccount.getBalance());
    }
}
