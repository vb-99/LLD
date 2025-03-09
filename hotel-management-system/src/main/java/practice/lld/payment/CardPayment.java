package practice.lld.payment;

public class CardPayment implements Payment {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Card Payment Proccessed with amount " + amount);
        return false;
    }
}
