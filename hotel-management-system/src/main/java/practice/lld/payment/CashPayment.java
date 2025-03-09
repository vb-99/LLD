package practice.lld.payment;

public class CashPayment implements Payment {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Cash Payment processed with amount " + amount);
        return true;
    }
}
