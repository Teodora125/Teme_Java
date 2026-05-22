public class BankAccount {

    protected String accountHolder;
    protected double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than 0!");
        }

        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {

        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than 0!");
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Not enough money in the account!");
        }

        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    public void displayBalance() {
        System.out.println("Account holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}