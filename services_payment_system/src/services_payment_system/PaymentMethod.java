package services_payment_system;

public abstract class PaymentMethod {

    public abstract void setInfo();

    public abstract void getBalanceInfo();
    public abstract boolean pay(double serviceAmount);
}
