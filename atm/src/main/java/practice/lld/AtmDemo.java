package practice.lld;

public class AtmDemo {
    public static void main(String[] args) {
        BankingService bankingService = new BankingService();
        CashDispenser cashDispenser = new CashDispenser(10000);
        Atm atm = new Atm(bankingService, cashDispenser);

        // Create sample accounts
        Account account1 = bankingService.addAccount(new Account("1234567890", 1000.0));
        Account account2 = bankingService.addAccount(new Account("9876543210", 500.0));

        // Perform ATM operations
        Card card = new Card("1234567890", "1234",account1);
        if(atm.authenticateUser(card)){

        double balance = atm.checkBalance(card);
        System.out.println("Account balance: " + balance);

        atm.withdrawCash(card, 500.0);
        atm.depositCash(card, 200.0);

        balance = atm.checkBalance(card);
        System.out.println("Updated account balance: " + balance);
        }
    }
}
