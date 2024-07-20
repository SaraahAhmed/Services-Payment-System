package com.example.demo.USER;


import com.example.demo.PAYMENT.Wallet;

public class Client extends User {

    public static long clientID=0;
    public Wallet myWallet=new  Wallet();
    public static void setClientID(){clientID++;}
    public static long getClientID(){return clientID;}
}