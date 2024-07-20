package com.example.demo.PAYMENT;


import java.util.Objects;

public class CreatePaymentMethod {///controller

    CreatePaymentMethod(){
        PaymentData.paymentMethods.put("Credit Card Payment Method",new CreditCard());
        PaymentData.paymentMethods.put("Wallet Payment Method",new Wallet());
        PaymentData.paymentMethods.put("Cash On Delivery Payment Method",new CashOnDelivery());
    }

    public  PaymentMethod createPayment(String type){
        return PaymentData.paymentMethods.get(type);
    }
}
