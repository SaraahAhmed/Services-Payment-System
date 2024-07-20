package com.example.demo.PAYMENT;

public abstract class PaymentMethod {

    public  abstract void setInfo(PaymentMethodCritiria pmc);
    public abstract Double getBalanceInfo();
    public abstract boolean pay(Double serviceAmount);


}
