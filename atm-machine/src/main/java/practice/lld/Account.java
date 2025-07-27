package practice.lld;

public class Account {
    private String accountNumber;
    private int balance;

    public Account(String accountNumber,int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }

    public void deposit(int amount) {
        balance += amount;
    }
    public int getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    };

}
