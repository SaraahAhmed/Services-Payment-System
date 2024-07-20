package services_payment_system;

import java.util.HashMap;
import java.util.Map;

public class SystemDB {
    public static Map<Long,Payment> paymentsList =new HashMap<>();
    public static Map<Long,User> signedUpUsers =new HashMap<>();
    public static Payment getRecodedPayment(long ID){
        return paymentsList.get(ID);
    }
}