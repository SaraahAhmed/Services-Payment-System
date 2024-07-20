package services_payment_system;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SystemController {

    public static boolean checkAuthentication(String newUserName,String newEmail){
        boolean bool=true;
        for (Map.Entry<Long,User> entry : SystemDB.signedUpUsers.entrySet())
        {
            User user=entry.getValue();
            if (Objects.equals(user.getUserName(), newUserName) || Objects.equals(user.getUserEmail(), newEmail)) {
                bool = false;
                break;
            }
        }
        return bool;
    }

    public static boolean checkValidaion(String email,String password){
        boolean bool=false;
        for (Map.Entry<Long,User> entry : SystemDB.signedUpUsers.entrySet())
        {
            User user=entry.getValue();
            if (Objects.equals(user.getUserEmail(), email) && Objects.equals(user.getUserPassword(), password)) {
                bool = true;
                break;
            }
        }
        return bool;
    }

    public static boolean checkRequest(long ID){
        if(SystemDB.getRecodedPayment(ID)==null){
            System.out.println("there no payment found with such an ID!");
            return true;
        }
        else {
            System.out.println("refund request has been issued and sent to admin successfully");
            return false;
        }
    }
}