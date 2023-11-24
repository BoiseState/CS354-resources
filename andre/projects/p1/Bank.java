import java.util.*;

public class Bank {

    private Set<Account> accounts=new HashSet<Account>();

    public void add(Account account) {
		accounts.add(account);
    }

    public void accrue(double rate) {
		for (Account account: accounts) {
			account.accrue(rate);
		}
    }

    public String toString() {
		String string = "";
		for (Account account: accounts) {
			string += account + "\n";
		}
		return string ;
    }

    public static void main(String[] args) {
		Bank bank = new Bank();
		Customer customer = new Customer("Ann");
		bank.add(new CheckingAccount("01001", customer,100.00));
		bank.add(new SavingAccount("01002", customer,200.00));
		bank.accrue(0.02);
		System.out.println(bank);
    }

}
