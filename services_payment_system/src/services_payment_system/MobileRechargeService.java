package services_payment_system;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MobileRechargeService extends Service {
    ServiceCost mobileServiceCost=new MobileServiceCost();
    MobileRechargeService() {
        ProvidersList=new HashMap<>();
        ProvidersList.put(1,"Mobile Recharge Vodafone Provider");
        ProvidersList.put(2,"Mobile Recharge Etisalat Provider");
        ProvidersList.put(3,"Mobile Recharge Orange Provider");
        ProvidersList.put(4,"Mobile Recharge We Provider");

        SupportedPaymentMethodsList=new HashMap<>();
        SupportedPaymentMethodsList.put(1,"Credit Card Payment Method");
        SupportedPaymentMethodsList.put(2,"Wallet Payment Method");
        SupportedPaymentMethodsList.put(3,"Cash On Delivery Payment Method");
    }
    @Override
    public void checkDiscounts( ){
        ServiceCost serviceCost=new MobileServiceCost();
        System.out.println("service cost before discounts= "+serviceCost.cost());
        System.out.println("overall discount value = "+OverallDiscount.getDiscount());
        System.out.println("specific landline service discount value = "+MobileSpecificDiscount.getDiscount());
        System.out.println("service cost after applying discounts will be  = "+(serviceCost.cost()-OverallDiscount.getDiscount()-MobileSpecificDiscount.getDiscount()));
    }

    @Override
    public double applyDiscounts() {
        ServiceCost serviceCost=new MobileServiceCost();
        serviceCost=new OverallDiscount(serviceCost);             /// decorator pattern wrapping with overall discount
        serviceCost=new MobileSpecificDiscount(serviceCost);   ///  decorator pattern wrapping with specific discount
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
        if(Objects.equals(providerType, "Mobile Recharge Vodafone Provider")){return new MobileVodafoneProvider();}
        else if(Objects.equals(providerType, "Mobile Recharge Etisalat Provider")){return new MobileEtisalatProvider();}
        else if(Objects.equals(providerType, "Mobile Recharge Orange Provider")){return new MobileOrangeProvider();}
        else if(Objects.equals(providerType, "Mobile Recharge We Provider")){return new MobileWeProvider();}
        else return null;
    }
}