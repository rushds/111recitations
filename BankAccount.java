public class BankAccount{
    //instance variables
	private String accountNumber;
	public String name;
	private double balance;

	//constructor 1
    //no initial deposit
	public BankAccount(String acctnum, String name){ 
		this.accountNumber = acctnum;
		this.name = name;
		this.balance = 0;
	}
	//constructor 2
    //initial deposit
	public BankAccount(String acctnum, String name, double initialDeposit){
		this.accountNumber = acctnum;
		this.name = name;
		this.balance = initialDeposit;
	}
    //if anyone could just do BankAccountName.balance = anyvalue,
    //then people could give themselves free money!
    //or be silly and deposit negative money!

    //this is why we limit access by
    //1) making balance private
    //2) having conditional logic in our deposit method
    public boolean depositMoney(double amount){
		if(amount > 0){
			this.balance += amount;
			return true;
		}
		return false;
	}

    //similar to above
    //we use our method to limit access, and ensure
    //that changes to the object's data are valid
	public boolean withdrawMoney(double amount){
		if(amount > 0  &&  this.balance >= amount){
			this.balance -= amount;
			return true;
		}
		return false;
	}
    
    //withdraw money returns true if the account had enough to be withdrawn
    //only if we can withdraw the money should we deposit it in the other account
    public static boolean transferMoney(BankAccount from, BankAccount to, double amount){
		if(from.withdrawMoney(amount)){
			to.depositMoney(amount);
			return true;
		}
		return false;
	}
    

    public String getAccountNumber(){ 
		return this.accountNumber;
	}
	public double getBalance(){ 
		return this.balance;
	}

    @Override
    //^ think – why do we need this?
	public String toString(){
		return this.accountNumber + " - " + this.name + ": $" + this.balance;
	}

	public boolean equals(BankAccount other){
		if(this.accountNumber.equals(other.accountNumber)){
			return true;
		}
		return false;
	}

    public static void main(String [] args){
        BankAccount rushd = new BankAccount("001", "Rushd Syed", 99);
        BankAccount jane = new BankAccount("002", "Jane Doe", 999);
        BankAccount secondConstructorExample = new BankAccount("003", "John Doe");

        //example of how our conditional logic handles incorrect usage
        if(rushd.depositMoney(-99)){
            System.out.println("successfully deposited negative money :/");
        }
        else System.out.println("unable to deposit.");
        //feel free to test the other methods as well!
        
        //

        System.out.println(rushd); //pre deposit. notice how toString is called automatically?
        rushd.depositMoney(999);
        System.out.println(rushd);//post deposit         
    }

}