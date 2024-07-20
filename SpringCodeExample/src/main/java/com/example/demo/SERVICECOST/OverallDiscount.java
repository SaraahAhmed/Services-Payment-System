package com.example.demo.SERVICECOST;

import com.example.demo.SERVICECOST.DiscountDecorator;
import com.example.demo.SERVICECOST.ServiceCost;

public class OverallDiscount extends DiscountDecorator {
    static double overallDiscount=0.0;
   // ServiceCost serviceCost;    //decorator already has it so remove it
    public  OverallDiscount(ServiceCost serviceCost){this.serviceCost=serviceCost;}  //decorator pattern

    @Override
    public double cost() { return (serviceCost.cost())-(getDiscount()); }      ///decorator pattern


    public static void setDiscount(double discount) {    ///for admin to add discount
        overallDiscount=discount;
    }


    public static double getDiscount() {  ///for client to get discount value and apply it on service cost
        return overallDiscount;
    }

}