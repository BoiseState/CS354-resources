package account;

import customer.Customer;

public abstract class Account {

    protected int number;
    protected Customer customer;
    protected double balance;

    public double balance() {
	    return balance;
    }

    public abstract void accrue(double rate);

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
	    balance -= amount;
    }

    public String toString() {
	    return number + ": " + customer + ": "+ balance;
    }

}
