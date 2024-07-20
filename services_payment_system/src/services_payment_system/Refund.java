package services_payment_system;


public class Refund{
    public void requestRefund(Long ID) {
        if(SystemController.checkRequest(ID)){
            this.notifyAdmin(ID);
        }
    }
    public void notifyAdmin(long ID){
        Admin.updateRefundRequestsList(ID);
    }
}
