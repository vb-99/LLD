package practice.lld.payment;

public class PayPalPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
