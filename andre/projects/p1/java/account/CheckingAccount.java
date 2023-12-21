package account;

import customer.Customer;

public class CheckingAccount extends Account {

    public CheckingAccount(int number, Customer customer, double balance) {
        this.number = number;
        this.customer = customer;
        this.balance = balance;
    }

    public void accrue(double rate) {
        //checking accounts don't accrue interest.
    }
}
