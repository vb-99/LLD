package practice.lld;

public class CashDispenser {
    private double balance;
    public CashDispenser(int balance) {
        this.balance = balance;
    }
    public void dispenseCash(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds in the ATM");
        } else{
            balance -= amount;
            System.out.println("Dispensed: " + amount);
        }
    }
}
