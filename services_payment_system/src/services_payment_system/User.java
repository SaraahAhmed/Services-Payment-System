package services_payment_system;

import java.util.Scanner;


public class User {
    public static long userID=0;
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
    public long getUserID(){return userID;}
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


    Scanner sc =new Scanner(System.in);

    public boolean signup () {
        System.out.print("Enter your user name : ");
        UserName=sc.nextLine();
        System.out.print("Enter your email address : ");
        UserEmail=sc.nextLine();
        System.out.print("Enter your password : ");
        UserPassword=sc.nextLine();

        if(SystemController.checkAuthentication(this.UserName,this.UserEmail))
        {
            System.out.println("signed up successfully!");
            userID++;
            SystemDB.signedUpUsers.put(userID++,this);
            return true;
        }
        else{
            System.out.println("duplicated info please please sign in again");
            return false;
        }
    }


    public boolean signIn() {
        System.out.print("Enter your email : ");
        String email=sc.nextLine();
        System.out.print("Enter your password : ");
        String password=sc.nextLine();

        if(SystemController.checkValidaion(email,password))
        {
            System.out.println("signed in successfully!");
            return true;
        }
        else{
            System.out.println("incorrect info please please sign in again");
            return false;
        }
    }

}