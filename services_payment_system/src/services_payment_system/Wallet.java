package services_payment_system;


import java.util.Date;
import java.util.Scanner;

public class Wallet extends PaymentMethod{

    public static Double  walletBalance=0.0;
    public void display(){System.out.println("i'm Wallet Payment Method");}
    Scanner sc =new Scanner(System.in);

    protected void addRefundValue(double refundAmount){
        walletBalance+=refundAmount;

    }

    protected void addFundstoWallet(){
        System.out.println("Enter The Amount You Want To Add To Your Wallet ");
        double amount =sc.nextDouble();
        CreditCard cc=new CreditCard();
        cc.setInfo();
        if(cc.pay(amount)){
            walletBalance+=amount;
        }
        System.out.print("Your Wallet balance is now is: ");
        this.getBalanceInfo();
    }
    @Override
    public void setInfo() {
        this.addFundstoWallet();

    }

    @Override
    public void getBalanceInfo(){
        System.out.println(walletBalance);
    }

    @Override
    public boolean pay(double serviceAmount) {
        if(walletBalance>=serviceAmount){
            walletBalance-=serviceAmount;
            System.out.println("Transaction Completed Successfully! (service cost added)");
            System.out.print("your current wallet balance is: ");
            this.getBalanceInfo();
            return true;
        }
        else{
            System.out.println("Insufficient wallet Balance! Transaction Failed");
            return false;
        }
    }
}