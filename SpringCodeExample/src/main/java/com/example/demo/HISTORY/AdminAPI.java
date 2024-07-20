package com.example.demo.HISTORY;

import com.example.demo.HISTORY.HistoryController;
import com.example.demo.PAYMENT.Payment;
import com.example.demo.PAYMENT.RefundRequest;
import com.example.demo.PROVIDERS.ServiceProvider;
import com.example.demo.SERVICECOST.Discounts;
import com.example.demo.service.SearchService;
import com.example.demo.service.Service;
import com.example.demo.service.ServiceControl;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Vector;

@RestController
public class AdminAPI{



    @GetMapping(value = "/services")
    public String displayServices() {
        Map<String, Service> sevices = ServiceControl.getServices();
        String s = "";
        for (Map.Entry<String, Service> entry : sevices.entrySet()) {
            s += entry.getKey();
            s += "\n";
        }
        return s;
    }

    Service service;
    @GetMapping(value = "/service/{serviceName}")
    public Double chooseService(@PathVariable("serviceName") String serviceName){
        service=SearchService.searchService(serviceName);
        return check();

    }

    public Double check(){
        if (service==null){return -1.;}
        else {return service.serviceCost.cost();}
    }

    @GetMapping(value = "/services/providers")
    public String displayProviders(){
        Map<String, ServiceProvider> providers = ServiceControl.getServiceProviders();
        String s = "";
        for (Map.Entry<String, ServiceProvider> entry : providers.entrySet()) {
            s += entry.getKey();
            s += "\n";
        }
        return s;
    }

    @PostMapping(value = "/add/provider/{name}")
    public String addProvider(@PathVariable("name") String name) {  ///obj Person inside request body
        return service.addProvider(name);
    }

    @PostMapping(value = "/Discounts/overall/{value}")
    public String addOverallDiscount(@PathVariable("value") double value){
        return Discounts.addOverallDiscount(value);
    }

    @PostMapping(value = "/Discounts/specific/{idx}/{value}")
    public String addSpecificDiscount(@PathVariable("idx") int idx,@PathVariable("value") double value){
        return Discounts.addSpecificDiscount(idx,value);
    }

    @GetMapping(value = "/list/refundrequests")
    public String refundRequests() {
        return HistoryController.ListRefundRequests();
    }

    @GetMapping(value = "/refundRequests/accept/{paymentID}")
    public String acceptRequest(@PathVariable("paymentID") int paymentID){
        RefundRequest refundRequest=new RefundRequest();
        return refundRequest.acceptRefundRequest(paymentID);
    }


    @GetMapping(value = "/refundRequests/reject/{paymentID}")
    public String rejectRequest(@PathVariable("paymentID") int paymentID){
        RefundRequest refundRequest=new RefundRequest();
        return refundRequest.rejectRefundRequest(paymentID);
    }


    @GetMapping(value = "/list/paymentTransactions")
    public String paymentTransactions() {
        return HistoryController.listPaymentTransactions();
    }

    @GetMapping(value = "/list/walletTransactions")
    public String walletTransactions() {
        return HistoryController.listAddToWalletTransactions();
    }

    @GetMapping(value = "/list/refundTransactions")
    public String refundTransactions() {
        return HistoryController.listRefundTransactions();
    }
}