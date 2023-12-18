package account;

import customer.Customer;

public class SavingAccount extends Account {

    private double interest = 0;

    public SavingAccount(int number, Customer customer, double balance) {
        this.number = number;
        this.customer = customer;
        this.balance = balance;
    }

    public void accrue(double rate) {
        interest += balance * rate;
        balance += balance * rate;
    }

}
