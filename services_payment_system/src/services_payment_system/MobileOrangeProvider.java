package services_payment_system;

import java.util.Scanner;

public class MobileOrangeProvider extends ServiceProvider{
    
    @Override
    public void SP_form() {
        Scanner sc =new Scanner(System.in);
        System.out.println("ENTER YOUR PHONE NUMBER: ");
        phoneNumber= sc.nextLine();
        System.out.println("ENTER THE AMOUNT: ");
        amount= sc.nextDouble();
    }

}
