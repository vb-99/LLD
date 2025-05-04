package practice.lld.payment;

public class CashPayment implements  PaymentStrategy{

    @Override
    public void makePayment(double amount) {
        System.out.println("Cash Payment done with amount: " + amount);
    }
}
