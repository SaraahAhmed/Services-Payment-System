package services_payment_system;

import java.util.Vector;

public class SearchService {


    CreateService createObj=new CreateService() ;
    static Vector<String> services = new Vector<String>(); 
    static{
    	services.add("Donations");
    	services.add("Landline Service");
    	services.add("Internet Payment Service");
    	services.add("Mobile Recharge Service");
    }
    Service chosenService;
    public Service searchService(String type){
        chosenService= createObj.create(type);
        return chosenService;
    }
    public static void displayServices()
    {
    	System.out.print("{");
    	for(int i=0;i<services.size()-1;i++)
    	{
    		System.out.print(services.get(i)+"-");
    	}
    	System.out.print(services.get(services.size()-1));
    	System.out.println("}");
    	
    }
}
