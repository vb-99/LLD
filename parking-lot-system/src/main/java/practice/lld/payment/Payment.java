package practice.lld.payment;

import practice.lld.Vehicle;

public class Payment {
    double amount;
    PaymentStrategy paymentStrategy;

    public Payment(double amount, PaymentStrategy paymentStrategy) {
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(double amount){
        paymentStrategy.makePayment(amount);
    }

}
