import account.CheckingAccount;
import account.SavingAccount;
import bank.Bank;
import customer.Customer;

public class Main {

	public static void main(String[] args) {
		Bank bank = new Bank();
		Customer ann = new Customer("Ann");
		Customer bob = new Customer("Bob");
		bank.add(new CheckingAccount(1, ann,100.00));
		bank.add(new SavingAccount(2, ann,200.00));
		bank.add(new SavingAccount(3, bob,150.00));
		bank.accrue(0.02);

		System.out.println(bank);
	}
}
