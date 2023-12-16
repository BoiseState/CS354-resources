

public class Main {

	public static void main(String[] args) {

		System.out.println("Depositing x money into Checking Account #1234");


		//main idea here is to provide a runner that simulates x number of deposits to a savings account. 
		//maybe, something like CheckingAccount.deposit(numDeposits, amountPer) that is implemented as a non
		//synchronized thread.
		//
		//Then, the deposits won't come out right for larger and larger numbers of deposits.
		//
		//Can take parameters from the command line, such as number of runs (with each
		//run increasing the number of deposits, perhaps by a power of 10). 
		//
		//Output should be something like: 
		//
		//Account 1234, #numDesposits deposits from <name>:
		//Starting Amount 1000, ending amount xyz
		//
		//Total amount deposited: #runs * numDeposits * $amt 

		//then demonstrate race condition


	}


}
