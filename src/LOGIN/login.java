/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGIN;

import enums.AdminEnum;
import enums.MenuEnum;
import enums.UserEnum;
import Create_and_insertDB.Autentication;
import Create_and_insertDB.ConnectionFactory;
import Create_and_insertDB.DDL_DML_DQL;
import USER_GET_SET.Users;
import SIGNUP.SignUp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Equation.Math;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wandwilson Almeida Da Silva 2021230
 * @author Carolina Gomes Landim 2021226
 */
public class login implements LoginInterface {
    //Call the packages that will be using in this class.
    Scanner input = new Scanner(System.in);
    DDL_DML_DQL function = new DDL_DML_DQL();
    SignUp update = new SignUp();
    Math math = new Math();
    Connection conn;
    
    
    /*
     Get the user input to sign in.
    */
    @Override
    public void login() {
        try {
            // Create variables
            conn = new ConnectionFactory().conectaBD();
            String username, password;
            int id;
            int limitTry = 3;
            ResultSet rs;
            
            // Using do loop to give only 3 times to user try to SIGN IN.
            do{
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("Username:");
                username = input.next();
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("Password:");
                password = input.next();

                Users objuserdml = new Users();
                objuserdml.setUsername(username);
                objuserdml.setUser_password(password);

                Autentication objautentication = new Autentication();
                rs = objautentication.autenticationUesr(objuserdml);
                id = function.getId(username, password);
                limitTry --;
                if (rs.next()) { // check if was possible to SIGN IN
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("Sign_in Successful");
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    function.check_user(id, username, password);//GO to check if it is a regular user or Admin
                }
                else{ // if is worng try again
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("Usename or password is invalid");
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                }
             }while(!(rs.next()) && (limitTry >= 1));//If the user wrong 3 times the user have to wait 10 minutes to try again
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("You have been sign out.\nyou have to wait 10 seconds to try again.");
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    TimeUnit.SECONDS.sleep(10); //Use the TimeUnit to give a 10 second of deley
                    menu();// call the menu function again
           

        } catch (SQLException e) {
            System.out.println("Erro in login " + e);
        } catch (InterruptedException ex) { //Need to using this catch for te sleep function
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /*
        Menu option to check what the user want to do SIGN_IN or SIGN_UP.
    */
    @Override
    public void menu(){
        

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Welcome to equation Database: ");
        /*
        Show the enum menu
        */
        for (int type = 1; type <=MenuEnum.values().length; type++) {
             System.out.println( type + ". " + MenuEnum.values()[type-1]);
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Please enter only numbers");  
        System.out.println("Please choosen one of the option:");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        String option = input.next();

         
        switch (option){ //Using switch to check the user input

           case "1": 
               System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
               login();

           case "2":
               System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
               SignUp signUP = new SignUp();
               signUP.Sign_upUsers();
               System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
               System.out.println("Sign Up Successful");
               menu();
           default:
               System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
               System.out.println("Sorry, Wrong option try again...");
               menu();//Call the menu if the option is wrong.


       }
   
    }
    
    
    /*
        Admin options
    */
    @Override
    public void admin(int id){
          
      
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("What would you like to do? ");
        /*
        Show the enum menu
        */
        for (int type = 1; type <=AdminEnum.values().length; type++) {
             System.out.println( type + ". " + AdminEnum.values()[type-1]);
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Please enter only numbers"); 
        System.out.println("Please choosen one of the option:");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        String option = input.next();

        switch (option){//Using switch to check the user input

           case "1": 
               System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
               System.out.println(id);
               update.update(id);
               admin(id);


           case "2":
               System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

               function.findUser(id);
               admin(id);

           case "3":
               System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
               function.findUser(id);  
               SignUp del = new SignUp();
               System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
               del.delete();
               System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
               System.out.println("User deleted!");
               System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
               function.findUser(id);
               admin(id);

           case "4":
               System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

               function.seeEquation(id);
               admin(id);

           case "5":
               System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
               System.out.println("Bye see you soon");
               menu();

           default:
               System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
               System.out.println("Sorry, Wrong option try again...");
               admin(id); //Call the admin if the option is wrong.

       }
        
    }
    
    /*
        Regular Users options.
    */
    @Override
    public void users(int id){
              
         
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("What would you like to do? ");
        /*
        Show the enum menu
        */
        for (int type = 1; type <=UserEnum.values().length; type++) {
             System.out.println( type + ". " + UserEnum.values()[type-1]);
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Please enter only numbers");  
        System.out.println("Please choosen one of the option:");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        String option = input.next();

        switch (option){//Using switch to check the user input

           case "1": 
               System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
               update.update(id);
               users(id);
           case "2":
               System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
               math.math(id);
           case "3":
               System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
               function.seeEquation(id);
               users(id);
           case "4":
               System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
               System.out.println("Bye see you soon");
               menu();
           default:
               System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
               System.out.println("Sorry, Wrong option try again...");
               users(id); //Call the users if the option is wrong.

       }
       
        
    }
    
}
