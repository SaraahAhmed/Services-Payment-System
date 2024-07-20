package com.example.demo.HISTORY;

import com.example.demo.PAYMENT.CreditCard;
import com.example.demo.PAYMENT.Payment;
import com.example.demo.PAYMENT.PaymentMethod;
import com.example.demo.PAYMENT.PaymentMethodCritiria;
import com.example.demo.PAYMENT.RefundRequest;
import com.example.demo.PROVIDERS.CancerHospitalProvider;
import com.example.demo.PROVIDERS.NGOsProvider;
import com.example.demo.PROVIDERS.SchoolsProvider;
import com.example.demo.SERVICECOST.Discounts;
import com.example.demo.USER.Client;
import com.example.demo.service.SearchService;
import com.example.demo.service.Service;
import com.example.demo.service.ServiceControl;
import com.example.demo.service.ServiceData;
import com.example.demo.HISTORY.HistoryController;

import java.util.Map;
import java.util.Scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ClientAPI {
	

    Service service;
    double totalServiceCost;
    Discounts discounts=new Discounts();
    Payment newPayment=new Payment();
    Client client=new Client();

    @GetMapping(value = "/getService/{serviceName}")
    public void getService(@PathVariable("serviceName") String serviceName){
        service= SearchService.searchService(serviceName);
    }

    @GetMapping(value = "/serviceProviders")
    public String showServiceProviders(){
        return  service.displayProviders();
    }

    @PutMapping(value="/chooseProvider/{vall}")
    public void chooseProvider(@PathVariable("vall")String vall)
    {
        service.createSP(vall);
    }


    //fill form
    @PutMapping(value="/choosenProvider/{val}/{amount}")
    public void choosenProvider(@PathVariable("val")String val,@PathVariable("amount")double amount) {
        service.serviceProvider.SP_form(val, amount);
    }

    @GetMapping(value="/paymentOptions")
    public String displayPaymentMethods()
    {
        return service.displaySupportedPaymentMethods();
    }

    @PutMapping(value="/payment/{paymentMethod}")
    public void choosePaymentMethod(@PathVariable("paymentMethod")String paymentMethod) {
        totalServiceCost =discounts.applyDiscounts(service.serviceCost);
        newPayment.setPaymentMethod(paymentMethod);
    }

    @GetMapping(value="/PaymentMethod/info")
    public String SetpaymentMethodinfo(@RequestBody PaymentMethodCritiria pmc) {
        newPayment.paymentMethod.setInfo(pmc);
        return service.serviceProvider.SP_handler(newPayment,totalServiceCost, Client.getClientID());
    }

    @GetMapping(value="/requestRefund/{id}")
    public String requestRF(@PathVariable("id")Long id ) {
        RefundRequest refundRequest =new RefundRequest();
        return refundRequest.requestRefund(id);

    }

    @GetMapping(value="/addFundToWallet")
    public String AddtoWallet(@RequestBody PaymentMethodCritiria pmc)
    {
        CreditCard cc=new CreditCard();
        cc.setInfo(pmc);
        return client.myWallet.addFundsToWallet(pmc.getChargedAmount(),cc);
    }

    @GetMapping(value="/checkDiscount")
    public String checkDiscount() {
        return discounts.checkDiscounts();
    }
    
}
