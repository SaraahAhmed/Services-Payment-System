package services_payment_system;
import java.util.Scanner;

public class CreditCard extends PaymentMethod{
    String cardName;
    String cardNumber;
    int CVV;
    public static double balance;       

    @Override
    public void setInfo() {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter The Name On Your Credit Card Please: ");
        cardName=sc.nextLine();
        System.out.println("Enter Your Credit Card Number Please: ");
        cardNumber=sc.nextLine();
        System.out.println("Enter Your Credit Card CVV Please: ");
        CVV=sc.nextInt();
        System.out.println("Enter Your Credit Card Balance Please: ");
        balance=sc.nextDouble();
    }

    @Override
    public void getBalanceInfo() {System.out.println(balance);}

    @Override
    public boolean pay(double serviceAmount) {
        if(balance>=serviceAmount){
            balance-=serviceAmount;
            System.out.println("Transaction Completed Successfully! (service cost added)");
            System.out.print("your current credit card balance is: ");
            this.getBalanceInfo();
            return true;
        }
        else{
            System.out.println("Insufficient Balance in your credit card! Transaction Failed");
            return false;
        }
    }
}
