package practice.lld.strategy_pattern;

public class CryptoPayment implements PaymentStrategy{
        public void processPayment() {
            System.out.println("Crypto Payment is processed");
        }
}
