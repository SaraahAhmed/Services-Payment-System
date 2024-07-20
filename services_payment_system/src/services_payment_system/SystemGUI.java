package services_payment_system;

import java.util.Scanner;

public class SystemGUI {
    public void  displaySystemGUI()
    {
        User user=new User() ;
        while (!user.signup()){user.signup();}
        while (!user.signIn()){user.signIn();}

        Scanner input=new Scanner(System.in);
    	System.out.println("if you are client enter 1 ,if you are admin enter 0");
    	int x=input.nextInt();
    	if(x==1)
    	{
    		ClientGUI clientGUI=new ClientGUI();
    		clientGUI.displayClientGUI();
    	}
    	else
    	{
    		AdminGui adminGui=new AdminGui();
    		adminGui.displayAdminGUI();
    	}
    	
    }
   }
