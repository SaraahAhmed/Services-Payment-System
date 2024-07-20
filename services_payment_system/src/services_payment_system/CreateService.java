package services_payment_system;


import java.util.Objects;

public class CreateService {

     Service create(String serviceType) {
        if (Objects.equals(serviceType, "Mobile Recharge Service")) {
            return new MobileRechargeService();
        }
        else if (Objects.equals(serviceType, "Internet Payment Service")) {
            return new InternetPaymentService();
        }
        else if (Objects.equals(serviceType, "Landline Service")) {
            return new LandlineServices();
        }
        else if (Objects.equals(serviceType, "Donations")) {
            return new DonationsService();
        }
        else return null;
    };


}