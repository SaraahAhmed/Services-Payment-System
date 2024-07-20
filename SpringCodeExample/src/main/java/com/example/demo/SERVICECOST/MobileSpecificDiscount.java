package com.example.demo.SERVICECOST;


import com.example.demo.SERVICECOST.DiscountDecorator;
import com.example.demo.SERVICECOST.ServiceCost;

public class MobileSpecificDiscount extends DiscountDecorator {
    static double moblieDiscount=0;

    public MobileSpecificDiscount(ServiceCost serviceCost){   //decorator pattern
        this.serviceCost=serviceCost;
    }
    @Override
    public double cost() {                                            //decorator pattern
        return (serviceCost.cost())-(getDiscount());
    }

    public static void setDiscount(double discount) {         ///for admin to add discount
        moblieDiscount=discount;
    }

    public static double getDiscount() {                 ///for client to get discount value and apply it on service cost
        return moblieDiscount;
    }
}
