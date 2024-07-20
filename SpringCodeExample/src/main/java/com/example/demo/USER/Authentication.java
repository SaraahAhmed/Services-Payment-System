package com.example.demo.USER;

import com.example.demo.HISTORY.HistoryController;
import com.example.demo.HISTORY.HistoryDB;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Authentication
{
    @GetMapping(value = "/user/checkAuthentication")
    public String  checkAuthentication(@RequestParam ("userName") String userName,@RequestParam("Email") String Email){
        for (Map.Entry<Long, Client> entry : HistoryController.getSignedUpUsers().entrySet())
        {
            Client client =entry.getValue();
            if (Objects.equals(client.getUserName(), userName) && !Objects.equals(client.getUserEmail(), Email)) {
                return "duplicated username";
            }
            if(!Objects.equals(client.getUserName(), userName) && Objects.equals(client.getUserEmail(), Email) ){
                return "duplicated email";
            }
            else if  (Objects.equals(client.getUserName(), userName) && Objects.equals(client.getUserEmail(), Email)){
                    return "User name: " + client.getUserName() + "\n" + "User email: " + client.getUserEmail()
                            + "\n" + "user id: " + Client.getClientID();
            }
        }
        return "not exist";
    }

    @GetMapping(value = "/user/checkValidation")
    public static String checkValidation(@RequestParam("email") String email,@RequestParam ("password") String password){
        for (Map.Entry<Long,Client> entry : HistoryController.getSignedUpUsers().entrySet())
        {
            Client client =entry.getValue();
            if (Objects.equals(client.getUserEmail(), email) && Objects.equals(client.getUserPassword(), password)) {
                return  "valid";
            }
        }
        return "invalid";
    }

    @PostMapping (value = "/user/signup")
    public String signup (@RequestParam ("userName") String userName,@RequestParam("Email") String Email,@RequestParam ("password") String password) {
        if(Objects.equals(checkAuthentication(userName, Email), "not exist"))
        {
            Client client=new Client();
            client.setUserName(userName);
            client.setUserEmail(Email);
            client.setUserPassword(password);
            Client.setClientID();
            HistoryController.addSignedUpUser(Client.getClientID(),client);
            return ("signed up successfully!");
        }
        else{
            return ("duplicated info please please sign up again");
        }
    }

    @PostMapping (value = "/user/signIn")
    public String signIn(@RequestParam("email") String email,@RequestParam ("password") String password) {
        if(checkValidation(email, password).equals("valid"))
        {
            return ("signed in successfully!");
        }
        else{
            return ("incorrect info please please sign in again");
        }
    }
}
