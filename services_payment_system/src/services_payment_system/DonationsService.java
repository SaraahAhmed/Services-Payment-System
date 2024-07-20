package services_payment_system;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DonationsService extends Service{
    ServiceCost donationsServiceCost=new DonationsServiceCost();
    DonationsService() {
        ProvidersList=new HashMap<>();
        ProvidersList.put(1,"Cancer Hospital Provider");
        ProvidersList.put(2,"Donations Schools Provider");
        ProvidersList.put(3,"Donations NGOs Provider");

        SupportedPaymentMethodsList=new HashMap<>();
        SupportedPaymentMethodsList.put(1,"Credit Card Payment Method");
        SupportedPaymentMethodsList.put(2,"Wallet Payment Method");
        SupportedPaymentMethodsList.put(3,"Cash On Delivery Payment Method");
    }
    @Override
    public void checkDiscounts( ){
        ServiceCost serviceCost=new DonationsServiceCost();
        System.out.println("service cost before discounts= "+serviceCost.cost());
        System.out.println("overall discount value = "+OverallDiscount.getDiscount());
        System.out.println("specific landline service discount value = "+DonationsSpecificDiscount.getDiscount());
        System.out.println("service cost after applying discounts will be  = "+(serviceCost.cost()-OverallDiscount.getDiscount()-DonationsSpecificDiscount.getDiscount()));
    }

    @Override
    public double applyDiscounts() {
        ServiceCost serviceCost=new DonationsServiceCost();
        serviceCost=new OverallDiscount(serviceCost);             /// decorator pattern wrapping with overall discount
        serviceCost=new DonationsSpecificDiscount(serviceCost);   ///  decorator pattern wrapping with specific discount
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
        if(Objects.equals(providerType, "Cancer Hospital Provider")){return new CancerHospitalProvider();}
        else if(Objects.equals(providerType, "Donations Schools Provider")){return new SchoolsProvider();}
        else if(Objects.equals(providerType, "Donations NGOs Provider")){return new NGOsProvider();}
        else return null;
    }
}

