package com.example.demo.PAYMENT;


import com.example.demo.HISTORY.HistoryController;
import com.example.demo.PAYMENT.CreditCard;
import com.example.demo.PAYMENT.PaymentMethod;
import com.example.demo.USER.Client;
import com.example.demo.USER.User;

import java.util.Scanner;

public class Wallet extends PaymentMethod {

    public static Double  walletBalance=0.0;
    public void addRefundValue(Double refundAmount){
        walletBalance+=refundAmount;

    }

    public String addFundsToWallet(Double amount,CreditCard cc){  ///directly or for paying service reasons
        if(cc.pay(amount)){
            walletBalance+=amount;
            HistoryController.addWalletTransaction(Client.getClientID(),amount);
            
            return "funds added to wallet";
        }
        
        return "transaction failled";

    }


    @Override
    public Double getBalanceInfo(){
        return walletBalance ;
    }

    @Override
    public boolean pay(Double serviceAmount) {
        if(walletBalance>=serviceAmount){
            walletBalance-=serviceAmount;
            return true;
        }
        else{
            return false;
        }
    }

	@Override
	public void setInfo(PaymentMethodCritiria pmc) {
		walletBalance=pmc.getWalletBalance();
	}


}