package practice.lld.payment;

public class CardPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
