package com.example.demo.service;

import com.example.demo.PROVIDERS.ServiceProvider;
import com.example.demo.SERVICECOST.ServiceCost;

import java.util.Map;
import java.util.Scanner;

public abstract class Service {

    public ServiceProvider serviceProvider;
    public ServiceCost serviceCost;
    public ServiceData serviceData=new ServiceData();
    Integer serviceIdx=0;

    public String addProvider(String providerName) {
        if(serviceData.supportedProviders.containsValue(providerName)) {
            return "Provider already exist";
        }
        else{
            serviceData.supportedProviders.put(++serviceIdx,providerName);
            return "provider added successfully";
        }
    }
    
    public abstract String displayProviders();

    public abstract String displaySupportedPaymentMethods();

    public abstract void createSP(String providerType);
}
