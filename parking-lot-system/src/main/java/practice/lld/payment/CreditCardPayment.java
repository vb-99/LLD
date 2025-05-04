package practice.lld.payment;

public class CreditCardPayment implements PaymentStrategy{

    @Override
    public void makePayment(double amount) {
        System.out.println("Credit Card Payment done with amount: " + amount);
    }
}
