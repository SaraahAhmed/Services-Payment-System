package com.example.demo.service;

import com.example.demo.PAYMENT.CashOnDelivery;
import com.example.demo.PAYMENT.CreditCard;
import com.example.demo.PAYMENT.PaymentMethod;
import com.example.demo.PAYMENT.Wallet;
import com.example.demo.PROVIDERS.MonthlyLandlineProvider;
import com.example.demo.PROVIDERS.QuarterLandlineProvider;
import com.example.demo.PROVIDERS.ServiceProvider;
import com.example.demo.SERVICECOST.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class LandlineServices extends Service {
    LandlineServices() {
        serviceCost = new LandlineServiceCost();
        serviceData.supportedProviders.put(++serviceIdx,"Landline Monthly Receipt Provider");
        serviceData.supportedProviders.put(++serviceIdx,"Landline Quarter Receipt Provider");

        serviceData.supportedPaymentMethods.put(1,"Credit Card Payment Method");
        serviceData.supportedPaymentMethods.put(2,"Wallet Payment Method");
        serviceData.supportedPaymentMethods.put(3,"Cash On Delivery Payment Method");
    }



   

    public String displayProviders(){
    	String s="";
        for (Map.Entry<Integer,String> entry : serviceData.supportedProviders.entrySet()) {
            s+=entry.getKey()+" : "+entry.getValue();
            s+="\n";
        }
        return s;
    }
    public String displaySupportedPaymentMethods(){
    	String s="";
        for (Map.Entry<Integer, String> entry : serviceData.supportedPaymentMethods.entrySet()) {
            s+=entry.getKey()+" : "+entry.getValue();
            s+="\n";
        }
        return s;
    }

    @Override
    public void createSP(String providerType) {
        serviceProvider= ServiceData.serviceProviders.get(providerType);
    }
}