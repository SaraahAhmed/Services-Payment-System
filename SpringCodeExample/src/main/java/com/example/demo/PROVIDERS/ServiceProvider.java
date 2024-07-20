package com.example.demo.PROVIDERS;


import com.example.demo.HISTORY.HistoryController;
import com.example.demo.PAYMENT.Payment;
import com.example.demo.HISTORY.HistoryDB;

public  abstract class ServiceProvider {
    String phoneNumber;  
    double amount;       
    public abstract void SP_form (String a,double c) ;

    public String SP_handler(Payment payment, double serviceCost, long clientID) ///given the user answers to this form then provider will handle the user request 1-pay 2-add payment to database
    {
    	
        if(payment.paymentMethod.pay(amount+serviceCost))
        {
            payment.setClientID(clientID);
            payment.setPaymentID();
            payment.setPaymentDate();
            payment.setAmountPayed(amount+serviceCost);
            HistoryController.addPaymentTransaction(payment.getPaymentID(),payment);
            
            return "Transaction Completed Successfully! (service cost added)\nYour Payment ID Is: " + payment.getPaymentID();
            //adding payment includes above updated details into database
        }
        else {
        	
           return "Transaction Failed";
        }
    }


}