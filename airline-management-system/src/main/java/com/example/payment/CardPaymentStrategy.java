package com.example.payment;

public class CardPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean makePayment(double amount) {
        System.out.println("Card Payment made successfully");
        return true;
    }
}
