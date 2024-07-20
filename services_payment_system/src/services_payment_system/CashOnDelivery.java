package services_payment_system;

import java.util.Scanner;

public class CashOnDelivery extends PaymentMethod{
    

    String city;
    String address;
    String phoneNum;

    @Override
    public void setInfo() {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Your City Name Please: ");
        city=sc.nextLine();
        System.out.println("Enter Address Please: ");
        address=sc.nextLine();
        System.out.println("Enter Your Phone Number Please: ");
        phoneNum=sc.nextLine();

    }

    @Override
    public void getBalanceInfo() {
        System.out.println(city+" "+address+" "+phoneNum);
    }

    @Override
    public boolean pay(double serviceAmount) {
        System.out.println("Our Executive Is Out For Delivery And Will Reach You As Soon As Possible");
        return true;
    }



		
	}
