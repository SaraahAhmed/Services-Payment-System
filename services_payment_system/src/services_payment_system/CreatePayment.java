package services_payment_system;


import java.util.Objects;

public class CreatePayment {
    static PaymentMethod createPayment(String type){
        if(Objects.equals(type, "Credit Card Payment Method")){return new CreditCard(); }
        else if(Objects.equals(type, "Wallet Payment Method")){return new Wallet(); }
        else if(Objects.equals(type, "Cash On Delivery Payment Method")){return new CashOnDelivery(); }
        return null;
    }
}
