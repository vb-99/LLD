package practice.lld.payment;

public class CreditCardPaymentProcessor implements PaymentProcessor{
    @Override
    public void processPayment(double amount) {
        System.out.println("Payment processed successfully");
    }
}
