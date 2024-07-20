package services_payment_system;


import java.util.Objects;

public abstract class ServiceProvider {
    String phoneNumber;
    double amount;
    public abstract void SP_form();
    public void SP_handler(Payment payment,double serviceCost,long clientID)
    {
        payment.paymentMethod.setInfo();
        if(payment.paymentMethod.pay(amount+serviceCost))
        {
            payment.setClientID(clientID);
            payment.setPaymentID();
            payment.setPaymentDate();
            payment.setAmountPayed(amount);
            System.out.println("Your Payment ID Is: " + payment.getPaymentID());
            SystemDB.paymentsList.put(payment.getPaymentID(),payment);
        }

    }
}