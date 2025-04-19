package practice.lld.strategy_pattern;

public class PayPalPayment implements PaymentStrategy{

    @Override
    public void processPayment() {
        System.out.println("PayPal Payment is processed!");
    }
}
