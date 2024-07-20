package com.example.demo.service;

import com.example.demo.PAYMENT.CashOnDelivery;
import com.example.demo.PAYMENT.CreditCard;
import com.example.demo.PAYMENT.Wallet;
import com.example.demo.PROVIDERS.*;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class ServiceControl {
    static {
        ServiceData.services.put("Donations",new DonationsService());
        ServiceData.services.put("Landline Service",new LandlineServices());
        ServiceData.services.put("Internet Payment Service",new InternetPaymentService());
        ServiceData.services.put("Mobile Recharge Service",new MobileRechargeService());

        ServiceData.serviceProviders.put("Landline Monthly Receipt Provider",new MonthlyLandlineProvider());
        ServiceData.serviceProviders.put("Landline Quarter Receipt Provider",new QuarterLandlineProvider());
        ServiceData.serviceProviders.put("Cancer Hospital Provider",new CancerHospitalProvider());
        ServiceData.serviceProviders.put("Donations Schools Provider",new SchoolsProvider());
        ServiceData.serviceProviders.put("Donations NGOs Providers",new NGOsProvider());
        ServiceData.serviceProviders.put("Vodafone Provider",new vodafoneProvider());
        ServiceData.serviceProviders.put("We Provider",new weProvider());
        ServiceData.serviceProviders.put("Orange Provider",new orangeProvider());
        ServiceData.serviceProviders.put("Etisalat Provider",new etisalatProvider());


    }

    public static Map<String, Service> getServices(){
        return ServiceData.services;

    }

    public static Map<String, ServiceProvider> getServiceProviders(){
        return ServiceData.serviceProviders;

    }
    @GetMapping(value="/displayServices")
    public static String displayServices() {
        int i=0;
        String s="";
        for (Map.Entry<String,Service> entry : ServiceData.services.entrySet()) {
        	i++;
            s+=i+" : "+entry.getKey();
            s+="\n";
        }
        return s;
    }

}
