package com.example.demo.SERVICECOST;

import com.example.demo.SERVICECOST.DiscountDecorator;
import com.example.demo.SERVICECOST.ServiceCost;

public class DonationsSpecificDiscount extends DiscountDecorator {
    static double donationsDiscount=0;

    public DonationsSpecificDiscount(ServiceCost serviceCost){   //decorator pattern
        this.serviceCost=serviceCost;
    }
    @Override
    public double cost() {                                            //decorator pattern
        return (serviceCost.cost())-(getDiscount());
    }

    public static void setDiscount(double discount) {         ///for admin to add discount
        donationsDiscount=discount;
    }

    public static double getDiscount() {                 ///for client to get discount value and apply it on service cost
        return donationsDiscount;
    }
}

