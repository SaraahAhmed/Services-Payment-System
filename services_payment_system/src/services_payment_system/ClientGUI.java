package services_payment_system;

import java.util.Scanner;

public class ClientGUI {
	public void  displayClientGUI()
    {

        Client client=new Client();
        //client.myWallet.addFundstoWallet();

        
        String type; 
        SearchService.displayServices();
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter one of the services above (write it the same way it is shown above) :");
         type= sc.nextLine();
        Service service=client.myService.searchService(type);


        
        
        System.out.println("Choose The Number Corresponding To Your Service Provider :");
        service.displayProviders();
        int idx=sc.nextInt();
        while (idx<1 || idx>service.ProvidersList.size()){
            System.out.println("Wrong input! Please Enter One Of The Numbers Displayed In The List");
            idx=sc.nextInt();
        }
        type=service.ProvidersList.get(idx);
        ServiceProvider Servpro = service.createSP(type);

        Servpro.SP_form();

        service.checkDiscounts();
        double totalServiceCost=service.applyDiscounts();                        

        System.out.println("Enter 0 if you want to pay using credit card (the default payment method): ");
        System.out.println("Enter 1 if you want to change payment method");
        int f = sc.nextInt();
        while (f!=1&&f!=0){
            System.out.println("Wrong input! Please Enter Either 0 OR 1");
            f = sc.nextInt();
        }
        if(f==1){
            System.out.println("Choose The Number Corresponding To Your Payment Method :");
            service.displaySupportedPaymentMethods();
            idx=sc.nextInt();
            while (idx<1 || idx>service.SupportedPaymentMethodsList.size()){
                System.out.println("Wrong input! Please Enter One Of The Numbers Displayed In The List");
                idx=sc.nextInt();
            }
            type=service.SupportedPaymentMethodsList.get(idx);
            client.myPayment.setPaymentMethod(type);
        }
        Servpro.SP_handler(client.myPayment,totalServiceCost,client.getUserID());

        
    }
}
