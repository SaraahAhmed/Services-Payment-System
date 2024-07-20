package services_payment_system;


public class LandlineSpecificDiscount extends DiscountDecorator{
    static double landlineDiscount=0;
    ServiceCost serviceCost;

    public LandlineSpecificDiscount(ServiceCost serviceCost){   //decorator pattern
        this.serviceCost=serviceCost;
    }
    @Override
    double cost() {                                            //decorator pattern
        return (serviceCost.cost())-(getDiscount());
    }

    public static void setDiscount(double discount) {         ///for admin to add discount
        landlineDiscount=discount;
    }

    public static double getDiscount() {                 ///for client to get discount value and apply it on service cost
        return landlineDiscount;
    }
}