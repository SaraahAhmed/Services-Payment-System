package com.example.demo.service;

import com.example.demo.PAYMENT.CreditCard;
import com.example.demo.PAYMENT.PaymentMethod;
import com.example.demo.PAYMENT.Wallet;
import com.example.demo.PROVIDERS.*;
import com.example.demo.SERVICECOST.InternetServiceCost;
import com.example.demo.SERVICECOST.InternetSpecificDiscount;
import com.example.demo.SERVICECOST.OverallDiscount;
import com.example.demo.SERVICECOST.ServiceCost;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class InternetPaymentService extends Service {

    InternetPaymentService() {
        serviceCost=new InternetServiceCost();
        serviceData.supportedProviders.put(++serviceIdx,"Vodafone Provider");
        serviceData.supportedProviders.put(++serviceIdx,"Etisalat Provider");
        serviceData.supportedProviders.put(++serviceIdx,"Orange Provider");
        serviceData.supportedProviders.put(++serviceIdx,"We Provider");

        serviceData.supportedPaymentMethods.put(1,"Credit Card Payment Method");
        serviceData.supportedPaymentMethods.put(2,"Wallet Payment Method");

    }



    @Override

    public String displayProviders(){
    	String s="";
        for (Map.Entry<Integer,String> entry : serviceData.supportedProviders.entrySet()) {
            s+=entry.getKey()+" : "+entry.getValue();
            s+="\n";
        }
        return s;
    }

    @Override
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
