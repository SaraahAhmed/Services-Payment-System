package com.example.demo.PAYMENT;

import com.example.demo.PAYMENT.PaymentMethod;

import java.util.Scanner;

public class CashOnDelivery extends PaymentMethod {


    String city;
    String address;
    String phoneNum;
    

   @Override
    public void setInfo(PaymentMethodCritiria pmc) {
    	
        city=pmc.getCity();
        address=pmc.getAddress();
        phoneNum=pmc.getPhoneNum();

    }

    @Override
    public Double getBalanceInfo() {
        return 0.0 ;
    }

    @Override
    public boolean pay(Double serviceAmount) {
    	
        return true;
    }




}