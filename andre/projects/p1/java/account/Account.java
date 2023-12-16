package account;

import customer.Customer;

public abstract class Account extends Thread {

    protected String number;
    protected Customer customer;
    protected double balance;

    public double balance() {
	    return balance;
    }

    public void run() {

    }

    public abstract void deposit(int num, double amount);

    public void withdraw(double amount) {
	    balance -= amount;
    }

    public String toString() {
	    return number + ": " + customer + ": "+ balance;
    }

}
