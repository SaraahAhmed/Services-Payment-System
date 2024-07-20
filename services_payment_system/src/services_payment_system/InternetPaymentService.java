package services_payment_system;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InternetPaymentService extends Service{

    InternetPaymentService() {
        ProvidersList=new HashMap<>();
        ProvidersList.put(1,"Internet Payment Vodafone Provider");
        ProvidersList.put(2,"Internet Payment Etisalat Provider");
        ProvidersList.put(3,"Internet Payment Orange Provider");
        ProvidersList.put(4,"Internet Payment We Provider");

        SupportedPaymentMethodsList=new HashMap<>();
        SupportedPaymentMethodsList.put(1,"Credit Card Payment Method");
        SupportedPaymentMethodsList.put(2,"Wallet Payment Method");
    }
    @Override
    public void checkDiscounts( ){
        ServiceCost serviceCost=new InternetServiceCost();
        System.out.println("service cost before discounts= "+serviceCost.cost());
        System.out.println("overall discount value = "+OverallDiscount.getDiscount());
        System.out.println("specific landline service discount value = "+InternetSpecificDiscount.getDiscount());
        System.out.println("service cost after applying discounts will be  = "+(serviceCost.cost()-OverallDiscount.getDiscount()-InternetSpecificDiscount.getDiscount()));
    }

    @Override
    public double applyDiscounts() {
        ServiceCost serviceCost=new InternetServiceCost();
        serviceCost=new OverallDiscount(serviceCost);             /// decorator pattern wrapping with overall discount
        serviceCost=new InternetSpecificDiscount(serviceCost);   ///  decorator pattern wrapping with specific discount
        return serviceCost.cost();
    }

    @Override
    public void displayProviders(){
        for (Map.Entry<Integer,String> entry : ProvidersList.entrySet()) {
            System.out.println(entry.getKey() +" : "+ entry.getValue());
        }
    }
    @Override
    public void displaySupportedPaymentMethods(){
        for (Map.Entry<Integer,String> entry : SupportedPaymentMethodsList.entrySet()) {
            System.out.println(entry.getKey() +" : "+ entry.getValue());
        }
    }
    @Override
    public ServiceProvider createSP(String providerType) {
        if(Objects.equals(providerType, "Internet Payment Vodafone Provider")){return new InternetVodfoneProvider();}
        else if(Objects.equals(providerType, "Internet Payment Etisalat Provider")){return new InternetEtisalatProvider();}
        else if(Objects.equals(providerType, "Internet Payment Orange Provider")){return new InternetOrangeProvider();}
        else if(Objects.equals(providerType, "Internet Payment We Provider")){return new InternetWeProvider();}
        else return null;
    }


}
