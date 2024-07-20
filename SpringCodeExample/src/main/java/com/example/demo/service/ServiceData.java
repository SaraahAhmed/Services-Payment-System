package com.example.demo.service;

import com.example.demo.PAYMENT.PaymentMethod;
import com.example.demo.PROVIDERS.ServiceProvider;
import com.example.demo.USER.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class ServiceData {

    public static Map<String, Service> services =new HashMap<>();
    public static Map<String, ServiceProvider>serviceProviders=new HashMap<>();

    public  Map<Integer,String>supportedProviders=new HashMap<>();
    public  Map<Integer,String>supportedPaymentMethods=new HashMap<>();

}
