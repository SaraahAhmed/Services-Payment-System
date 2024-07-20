package services_payment_system;

import java.util.Map;
import java.util.Vector;

public abstract class Service {
    ServiceProvider sp;
    
    public Map<Integer,String>ProvidersList;
    public Map<Integer,String>SupportedPaymentMethodsList;
    public abstract void displayProviders();
    public abstract void displaySupportedPaymentMethods();
    public abstract ServiceProvider createSP(String providerType);
    public abstract void checkDiscounts( );
    public abstract double applyDiscounts();
    };
