package services_payment_system;


import java.util.Date;

public class Payment {

    static long paymentID=0;
    long clientID;
    Date paymentDate;
    double amountPayed;
    public PaymentMethod paymentMethod=new CreditCard();

    public void setPaymentID() {paymentID++;}
    public void setClientID(long ID) {clientID=ID;}
    public void setPaymentDate() {paymentDate=new Date();}
    public void setAmountPayed(double amountPayed) {
        this.amountPayed = amountPayed;
    }
    public void setPaymentMethod(String paymentType){
        paymentMethod=CreatePayment.createPayment(paymentType);
    }


    public long getPaymentID(){return paymentID;}
    public Date getPaymentDate(){return paymentDate;}
    public double getAmountPayed(){return amountPayed;}
    public long getClientID() {return clientID;}
    public PaymentMethod getPaymentMethod(){return paymentMethod;}



}
