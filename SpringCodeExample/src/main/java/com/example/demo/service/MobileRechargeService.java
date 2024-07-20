package com.example.demo.service;

import com.example.demo.PAYMENT.*;
import com.example.demo.PROVIDERS.*;
import com.example.demo.SERVICECOST.*;

import java.util.Map;
import java.util.Scanner;

public class MobileRechargeService extends Service {
    public MobileRechargeService() {

        serviceCost=new InternetServiceCost();
        serviceData.supportedProviders.put(++serviceIdx,"Vodafone Provider");
        serviceData.supportedProviders.put(++serviceIdx,"Etisalat Provider");
        serviceData.supportedProviders.put(++serviceIdx,"Orange Provider");
        //serviceData.supportedProviders.put(4,"We Provider");

        serviceData.supportedPaymentMethods.put(1,"Credit Card Payment Method");
        serviceData.supportedPaymentMethods.put(2,"Wallet Payment Method");
        serviceData.supportedPaymentMethods.put(3,"Cash On Delivery Payment Method");
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