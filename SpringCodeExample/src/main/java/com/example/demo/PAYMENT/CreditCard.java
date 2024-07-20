package com.example.demo.PAYMENT;
import com.example.demo.PAYMENT.PaymentMethod;

import java.util.Scanner;

public class CreditCard extends PaymentMethod {
    String cardName="";
    String cardNumber="";
    Integer CVV=5;
    Double balance=1.2;       

    

    @Override
    public Double getBalanceInfo() {return balance;}

    @Override/////
    public boolean pay(Double serviceAmount) {
        if(balance>=serviceAmount){
            balance-=serviceAmount;
            return true;
        }
        else{
            return false;
        }
    }

	@Override
	public void setInfo(PaymentMethodCritiria pmc) {
		cardName=pmc.getCardName();
        cardNumber=pmc.getCardNumber();
        CVV=pmc.getCVV();
        balance=pmc.getBalane();
		
	}
}
