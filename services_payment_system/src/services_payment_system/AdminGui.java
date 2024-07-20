package services_payment_system;

import java.util.Scanner;

public class AdminGui {
    public void  displayAdminGUI()
    {
        Admin admin=new Admin();
        Scanner sc =new Scanner(System.in);
        double i=1; int idx=1;
        while (i!=0 || idx!=0)
        {
            System.out.println("choose from list: ");
            System.out.println("1. add overall discount: ");
            System.out.println("2. add specific discount: ");
            System.out.println("3. list clients refund request: ");
            i=sc.nextInt();

            if (i == 1) {
                System.out.println("Enter the overall discount value: ");
                i=sc.nextDouble();
                admin.addOverallDiscount(i);

            }
            else if (i == 2) {
                System.out.println("Enter the 1 for Internet Specific discount");
                System.out.println("Enter the 2 for Mobile Specific discount");
                System.out.println("Enter the 3 for Landline Specific discount");
                System.out.println("Enter the 4 for Donations Specific discount");
                idx=sc.nextInt();
                System.out.println("Enter the specific discount value : ");
                i=sc.nextDouble();
                admin.addSpecificDiscount(idx,i);
            }
            else if (i == 3) {
                admin.listRefundRequest();
            }
        }
    }
}
