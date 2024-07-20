package com.example.demo.HISTORY;

import com.example.demo.PAYMENT.Payment;
import com.example.demo.USER.Client;
import com.example.demo.USER.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class HistoryDB {
    public static Map<Long, Client> signedUpUsers =new HashMap<>();
    public static Vector<Long> refundRequestsList = new Vector<Long>();   ///here we store payment id
    public static Map<Long, Payment> paymentTransactions =new HashMap<>();
    static  Map<Long, Double> addToWalletTransactions = new HashMap<>();
    static Vector<Payment> refundTransactions = new Vector<Payment>();
}