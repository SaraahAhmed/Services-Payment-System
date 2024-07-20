package com.example.demo.service;

import com.example.demo.PAYMENT.*;
import com.example.demo.PROVIDERS.CancerHospitalProvider;
import com.example.demo.PROVIDERS.NGOsProvider;
import com.example.demo.PROVIDERS.SchoolsProvider;
import com.example.demo.PROVIDERS.ServiceProvider;
import com.example.demo.SERVICECOST.DonationsServiceCost;
import com.example.demo.SERVICECOST.DonationsSpecificDiscount;
import com.example.demo.SERVICECOST.OverallDiscount;
import com.example.demo.SERVICECOST.ServiceCost;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class DonationsService extends Service {
    DonationsService() {
        serviceCost = new DonationsServiceCost();
        serviceData.supportedProviders.put(++serviceIdx,"Cancer Hospital Provider");
        serviceData.supportedProviders.put(++serviceIdx,"Donations Schools Provider");
        serviceData.supportedProviders.put(++serviceIdx,"Donations NGOs Provider");

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

