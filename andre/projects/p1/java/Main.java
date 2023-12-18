import account.Account;
import account.CheckingAccount;
import account.SavingAccount;
import bank.Bank;
import customer.Customer;

public class Main {

	public static void printUsage() {
		System.out.println("Usage: java Main <number of deposits> <amount per deposit>");
	}

	public static void main(String[] args) {

		if (args.length != 2) {
			printUsage();
			System.exit(-1);
		}

		int numDeposits = Integer.parseInt(args[0]);
		double numPerDeposit = Double.parseDouble(args[1]);

		Customer alice = new Customer("Alice");
		Customer bob = new Customer("Bob");


		Bank bank = new Bank();
		Account alicesAccount = new CheckingAccount(1, alice, 0);
		Account bobsAccount = new SavingAccount(2, bob, 0);

		for (int i = 0; i < numDeposits; i++) {
			alicesAccount.deposit(numPerDeposit);
			bobsAccount.deposit(numPerDeposit);
		}

		bobsAccount.accrue(0.05);

		System.out.println(alicesAccount.toString());
		System.out.println(bobsAccount.toString());
	}
}
