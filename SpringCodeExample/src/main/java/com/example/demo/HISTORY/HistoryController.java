package com.example.demo.HISTORY;

import com.example.demo.PAYMENT.Payment;
import com.example.demo.USER.Client;
import com.example.demo.USER.User;

import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class HistoryController {



	public static Map<Long, Client> getSignedUpUsers(){
        return HistoryDB.signedUpUsers;
    }

    public static Vector<Long> getRefundRequests(){
        return HistoryDB.refundRequestsList;
    }

    public static Map<Long, Payment> getPaymentTransactions(){
        return HistoryDB.paymentTransactions;
    }

    public static Map<Long,Double> getAddToWalletTransactions(){
        return HistoryDB.addToWalletTransactions;
    }

    public static Vector<Payment> getRefundTransactions(){
        return HistoryDB.refundTransactions;
    }


    public void notifyDB (long paymentID){
        addRefundRequest(paymentID);
    }
    public static void addSignedUpUser(long userID, Client client) {  ///notifyDB
        HistoryDB.signedUpUsers.put(userID,client);
    }

    public static void addRefundRequest(long paymentID) {  ///notifyDB
        HistoryDB.refundRequestsList.add(paymentID);
    }

    public static void addPaymentTransaction(Long paymentID,Payment payment) {
        HistoryDB.paymentTransactions.put(paymentID,payment);
    }

    public static void addWalletTransaction(Long clientID,Double amount) {
        HistoryDB.addToWalletTransactions.put(clientID,amount);
    }

    public static void addRefundTransaction(Payment payment) {
        HistoryDB.refundTransactions.add(payment);
    }


    public static String ListRefundRequests(){
        Vector<Long> refundRequests = HistoryController.getRefundRequests();
        if(refundRequests.size()==0){
            return "no available refund requests";
        }
        String s="";
        for (long i = 0; i < refundRequests.size(); i++) {
            long paymentID = i+1;
            Payment payment = HistoryController.getPaymentTransactions().get(paymentID);
            s += "payment ID: " + paymentID + "\n";
            s += "client ID: " + payment.getClientID() + "\n";
            s += "amount payed: " + payment.getAmountPayed() + "\n";
            s += "payment date: " + payment.getPaymentDate() + "\n";
            s += "\n";
        }
        return s;
    }

    public static String listPaymentTransactions(){
        Map<Long, Payment> paymentTransactions=getPaymentTransactions();
        if (paymentTransactions.size() == 0) {
            return "No payment transactions done yet";
        }
        String s="";
        for (Map.Entry<Long, Payment> set : paymentTransactions.entrySet()){
            s+="payment ID: " + set.getKey()+"\n";
            s+="client ID: " + set.getValue().getClientID()+"\n";
            s+="amount payed: " + set.getValue().getAmountPayed()+"\n";
            s+="payment date: " + set.getValue().getPaymentDate()+"\n";
            s+="\n";
        }
        return s;
    }

    public static String listAddToWalletTransactions() {
        Map<Long, Double> walletTransactions = getAddToWalletTransactions();
        if (walletTransactions.size() == 0) {
            return ("No wallet transactions done yet now");
        }
        String s="";
        for (Map.Entry<Long, Double> set : walletTransactions.entrySet()) {
            s+="client ID: " + set.getKey()+"\n";
            s+="amount : " + set.getValue()+"\n";
            s+="\n";
        }
        return s;
    }

    public static String listRefundTransactions(){
        Vector<Payment> refundTransactions=getRefundTransactions();
        if (refundTransactions.size() == 0) {
            return ("No refund transactions done yet");
        }
        String s="";
        for (Payment payment : refundTransactions){
            s+="payment ID: " + payment.getPaymentID()+"\n";
            s+="client ID: " + payment.getClientID()+"\n";
            s+="amount refunded : " + payment.getAmountPayed()+"\n";
            s+="\n";
        }
        return s;
    }


    public static void removeRefundRequest(long paymentID){
        HistoryDB.refundRequestsList.remove(paymentID);
    }

    public static void removePaymentTransaction(long paymentID){
        HistoryDB.paymentTransactions.remove(paymentID);
    }
}

