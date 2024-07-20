package services_payment_system;

import java.util.Scanner;
import java.util.Vector;

public class Admin extends User {
        static Vector<Long>refundRequestsList = new Vector<Long>();

        public static void updateRefundRequestsList(long ID){
                refundRequestsList.add(ID);

        }
        public  void listRefundRequest(){
                for(int i=0 ; i<refundRequestsList.size(); i++){
                        long paymentID=refundRequestsList.get(i);
                        Payment payment=SystemDB.paymentsList.get(i);
                        System.out.println("payment ID: "+payment.getPaymentID());
                        System.out.println("client ID: "+payment.getClientID());
                        System.out.println("amount payed: "+payment.getAmountPayed());
                        System.out.println("payment date: "+payment.getPaymentDate());
                        System.out.println("Enter 1 to accept refund request and 0 to refuse:" );
                        Scanner sc =new Scanner(System.in);
                        int flag=sc.nextInt();
                        if(flag==1){
                                long clientID =payment.getClientID();
                                Client client = (Client) SystemDB.signedUpUsers.get(clientID);
                                client.myWallet.addRefundValue(payment.getPaymentID());
                        }
                }
        }

        public void addOverallDiscount(double dicountValue){
                OverallDiscount.setDiscount(dicountValue);
        }

        public void addSpecificDiscount(int idx,double dicountValue){
                if(idx==1){InternetSpecificDiscount.setDiscount(dicountValue);}
                else if(idx==2){MobileSpecificDiscount.setDiscount(dicountValue);}
                else if(idx==3){LandlineSpecificDiscount.setDiscount(dicountValue);}
                else if(idx==4){DonationsSpecificDiscount.setDiscount(dicountValue);}
        }
}

