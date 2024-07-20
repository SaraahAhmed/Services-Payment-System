package com.example.demo.USER;

import com.example.demo.PAYMENT.Wallet;


public class User {
    protected String UserName;
    protected String UserEmail;
    protected String UserPassword;


    public void setUserName(String UserName)
    {
        this.UserName=UserName;
    }
    public void setUserEmail(String UserEmail)
    {
        this.UserEmail=UserEmail;
    }
    public void setUserPassword(String UserPassword)
    {
        this.UserPassword=UserPassword;
    }


    public String getUserName()
    {
        return this.UserName;
    }
    public String getUserEmail()
    {
        return this.UserEmail;
    }
    public String getUserPassword()
    {
        return this.UserPassword;
    }


}