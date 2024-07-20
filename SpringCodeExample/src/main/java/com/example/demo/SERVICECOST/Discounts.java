package com.example.demo.SERVICECOST;

public class Discounts {

	public String checkDiscounts(){
        String s="";
        s+="overall discount value = "+ OverallDiscount.getDiscount()+"\n";
        s+="Donation service specific discount value = "+ DonationsSpecificDiscount.getDiscount()+"\n";
        s+="LandLine service specific discount value = "+ LandlineSpecificDiscount.getDiscount()+"\n";
        s+="Internet payment service specific discount value = "+ InternetSpecificDiscount.getDiscount()+"\n";
        s+="Mobile recharge service specific discount value = "+ MobileSpecificDiscount.getDiscount()+"\n";
        return s;
    }

    public double applyDiscounts(ServiceCost serviceCost) {
        serviceCost=new OverallDiscount(serviceCost);            
        serviceCost=new DonationsSpecificDiscount(serviceCost);  
        return serviceCost.cost();
    }

    public static String addOverallDiscount(double dicountValue) {
        OverallDiscount.setDiscount(dicountValue);
        return "Discount value added successfully";
    }

    public static String addSpecificDiscount(int idx, double dicountValue) {
        if (idx == 1) {
            InternetSpecificDiscount.setDiscount(dicountValue);
        } else if (idx == 2) {
            MobileSpecificDiscount.setDiscount(dicountValue);
        } else if (idx == 3) {
            LandlineSpecificDiscount.setDiscount(dicountValue);
        } else if (idx == 4) {
            DonationsSpecificDiscount.setDiscount(dicountValue);
        }
        return "Discount value added successfully";
    }

}
