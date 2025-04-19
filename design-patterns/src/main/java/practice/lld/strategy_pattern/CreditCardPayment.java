package practice.lld.strategy_pattern;

public class CreditCardPayment implements PaymentStrategy{

    @Override
    public void processPayment() {
        System.out.println("Credit Card Payment is processed!");
    }
}
