package com.example.payment;

public class CashPaymentStrategy implements PaymentStrategy{
    @Override
    public boolean makePayment(double amount) {
        System.out.println("cash Payment made successfully");
        return true;
    }
}
