package com.example.demo.PAYMENT;

public class PaymentMethodCritiria {
	
	  String cardName="";
	    String cardNumber="";
	    Integer CVV=5;
	    Double balance=1.2;  
	    Double  walletBalance=0.0;
	    String city;
	    String address;
	    String phoneNum;	    
	    Double chargedAmount;
	    public void setCardName(String name)
	    {
	    	cardName=name;
	    }
	    public String getCardName()
	    {
	    	return cardName;
	    }
	    public void setCardNumber(String num)
	    {
	    	cardNumber=num;
	    }
	    public String getCardNumber()
	    {
	    	return cardNumber;
	    }
	    public void setCVV(Integer cv)
	    {
	    	CVV=cv;
	    }
	    public Integer getCVV()
	    {
	    	return CVV;
	    }
	    public void setBalance(Double b)
	    {
	    	balance=b;
	    }
	    public Double getBalane()
	    {
	    	return balance;
	    }
	    public void setWalletBalance(Double bal){walletBalance=bal;}
	    public Double getWalletBalance() {return walletBalance; }
	    public void setCity(String c)
	    {
	    	city=c;
	    }
	    public String getCity()
	    {
	    	return city;
	    }
	    public void setAddress(String d)
	    {
	    	address=d;
	    }
	    public String getAddress()
	    {
	    	return address;
	    }
	    public void setPhoneNum(String p)
	    {
	    	phoneNum=p;
	    }
	    public String getPhoneNum()
	    {
	    	return phoneNum;
	    }
	    public Double getChargedAmount()
	    {
	    	return chargedAmount;
	    }
}
