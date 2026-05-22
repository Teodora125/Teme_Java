public class BankApp {

    public static void main(String[] args) {

        SavingsAccount account = new SavingsAccount("Ana Popescu", 1000, 0.05);

        try {

            account.displayBalance();

            account.deposit(500);
            account.displayBalance();

            account.withdraw(200);
            account.displayBalance();

            account.addInterest();
            account.displayBalance();

            account.withdraw(5000);

        } catch (InvalidAmountException e) {
            System.out.println("Invalid amount: " + e.getMessage());

        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}