package practice.lld.strategy_pattern;

public class Main {
    public static void main(String[] args) {
        // Create strategy instances for each payment type
        PaymentStrategy creditCard = new CreditCardPayment();
        PaymentStrategy payPal = new PayPalPayment();
        PaymentStrategy crypto = new CryptoPayment();
        // Use the Strategy Pattern to process payments
        PaymentProcessor processor =
                new PaymentProcessor(creditCard); // Initially using CreditCardPayment
        processor.processPayment(); // Processing credit card payment...
        // Dynamically change the payment strategy to PayPal
        processor.setPaymentStrategy(payPal);
        processor.processPayment(); // Processing PayPal payment...
        // Switch to Crypto
        processor.setPaymentStrategy(crypto);
        processor.processPayment(); // Processing crypto payment...
    }
}