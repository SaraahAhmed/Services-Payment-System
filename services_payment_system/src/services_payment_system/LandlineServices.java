package services_payment_system;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LandlineServices extends Service{
    LandlineServices() {
        ServiceCost landlineServiceCost=new LandlineServiceCost();
        ProvidersList=new HashMap<>();
        ProvidersList.put(1,"Landline Monthly Receipt Provider");
        ProvidersList.put(2,"Landline Quarter Receipt Provider");

        SupportedPaymentMethodsList=new HashMap<>();
        SupportedPaymentMethodsList.put(1,"Credit Card Payment Method");
        SupportedPaymentMethodsList.put(2,"Wallet Payment Method");
        SupportedPaymentMethodsList.put(3,"Cash On Delivery Payment Method");
    }
    @Override
    public void checkDiscounts( ){
        ServiceCost serviceCost=new LandlineServiceCost();
        System.out.println("service cost before discounts= "+serviceCost.cost());
        System.out.println("overall discount value = "+OverallDiscount.getDiscount());
        System.out.println("specific landline service discount value = "+LandlineSpecificDiscount.getDiscount());
        System.out.println("service cost after applying discounts will be  = "+(serviceCost.cost()-OverallDiscount.getDiscount()-LandlineSpecificDiscount.getDiscount()));
    }

    @Override
    public double applyDiscounts() {
        ServiceCost serviceCost=new LandlineServiceCost();
        serviceCost=new OverallDiscount(serviceCost);             /// decorator pattern wrapping with overall discount
        serviceCost=new LandlineSpecificDiscount(serviceCost);   ///  decorator pattern wrapping with specific discount
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
        if(Objects.equals(providerType, "Landline Monthly Receipt Provider")){return new MonthlyLandlineProvider();}
        else if(Objects.equals(providerType, "Landline Quarter Receipt Provider")){return new QuarterLandlineProvider();}
        else return null;
    }
}