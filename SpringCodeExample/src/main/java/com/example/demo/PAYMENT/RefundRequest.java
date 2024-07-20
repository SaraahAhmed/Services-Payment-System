package com.example.demo.PAYMENT;

import com.example.demo.HISTORY.HistoryController;
import com.example.demo.HISTORY.HistoryDB;
import com.example.demo.USER.Client;
import com.example.demo.USER.User;
import java.util.Scanner;
import java.util.Vector;

public class RefundRequest {

    static HistoryController historyController = new HistoryController();

    public String requestRefund(Long paymentID) {
        if (checkRequest(paymentID)) {   
            historyController.notifyDB(paymentID); 
            return "refund request has been issued and sent to admin successfully";
        }
        else {
			return "there no payment found with such an ID!";
		}
    }

    public static boolean checkRequest(long ID) {
        if (HistoryController.getPaymentTransactions().get(ID) == null) {
            return false;
        } else {
            return true;
        }
    }

    public String acceptRefundRequest(long paymentID ){

        Payment payment=HistoryController.getPaymentTransactions().get(paymentID);
        long clientID = payment.getClientID();
        Client client = HistoryController.getSignedUpUsers().get(clientID);
        client.myWallet.addRefundValue(payment.getAmountPayed());
        HistoryController.addRefundTransaction(payment);
        HistoryController.removeRefundRequest(paymentID);
        HistoryController.removePaymentTransaction(paymentID);
        return "refund request got accepted";
    }

    public String rejectRefundRequest(long paymentID){
        HistoryController.removeRefundRequest(paymentID);
        return "refund request got rejected";
    }


}


