/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGIN;

import DDL.Autentication;
import DDL.UserDDL;
import DML.UserDML;
import SIGNUP.SignUp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author wandw
 */
public class login implements LoginInterface {
    Scanner input = new Scanner(System.in);
    UserDDL list = new UserDDL();
    SignUp update = new SignUp();
    Equation.Math math = new Equation.Math();
    
    
    
    @Override
    public void login() {
        try {
            String user_name, password;
            int id;
//            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Digite seu usuario:");
            user_name = input.next();
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Digite sua senha:");
            password = input.next();
            
            UserDML objuserdml = new UserDML();
            objuserdml.setUser_name(user_name);
            objuserdml.setUser_password(password);
            
            Autentication objautentication = new Autentication();
            ResultSet rsusuariodao = objautentication.autenticationUesr(objuserdml);
            id = list.getId(user_name, password);
            
            
            
            if (rsusuariodao.next()) {
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("Loggin sucefull");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                         
            } else {
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("Usuario ou senha invalida");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                login();
            }
            list.check_admin(id, user_name, password);

        } catch (SQLException e) {
            System.out.println("Erro no login " + e);
        }

    }
    
    @Override
     public void menu(){
        boolean start = true; 
         System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
         System.out.println("Welcome to equation Database: ");
         System.out.println("[1] to Login");
         System.out.println("[2] to registar new users");
         System.out.println("please choosen one of the option:");
         System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
         String option = input.next();

         while (start){
         
             switch (option){

                case "1": 
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    login();
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                                 
//                    break;
                    
                case "2":
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    SignUp signUP = new SignUp();
                    signUP.Sign_upUsers();
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
//                    break;
                    menu();
                default:
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("Sorry, Wrong option try again...");
                    menu();
                

            }
         }   
    }
    
    @Override
    public void admin(int id){
        boolean start = true; 
        UserDDL list = new UserDDL();
        
      
         System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
         System.out.println("What would you like to do? ");
         System.out.println("[1] modify profile");
         System.out.println("[2] see the users list");
         System.out.println("[3] remove users");
         System.out.println("[4] see the operations ");
         System.out.println("[5] log out. ");
         System.out.println("please choosen one of the option:");
         System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
         String option = input.next();
         while (start){
         
             switch (option){

                case "1": 
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println(id);
                    update.update(id);
   
                    admin(id);
                    
//                    break;
                    
                case "2":
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

                    list.findUser(id);
                    admin(id);

                case "3":
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    list.findUser(id);  
                    SignUp del = new SignUp();
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    del.delete();
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("Usuario deletado com sucesso");
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    list.findUser(id);
                    admin(id);
//                  
                case "4":
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("It is not working yet.");
                    admin(id);

                case "5":
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("Bye see you soon");
                    menu();

                default:
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("Sorry, Wrong option try again...");
                    admin(id);
            }
         }
        
    }
    
    /**
     * menu user to check what the user would like to do.
     * @param id  get the id from the user is log in to check if he would like to update profile
     */
    @Override
    public void users(int id){
        boolean start = true; 
        
      
         System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
         System.out.println("What would you like to do? ");
         System.out.println("[1] Modify profile");
         System.out.println("[2] Solve systems of linear equations");
         System.out.println("[3] Log out");
//         System.out.println("[4] see the operations ");
//         System.out.println("[5] log out. ");
         System.out.println("please choosen one of the option:");
         System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
         String option = input.next();
         while (start){
         
             switch (option){

                case "1": 
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    update.update(id);
                    users(id);
                    
//                    break;
                    
                case "2":
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
//                    System.out.println("sorry is not work yet..");
                    math.math(id);
//                    users(id);
                case "3":
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("Bye see you soon");
                    menu();
                default:
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("Sorry, Wrong option try again...");
                    users(id);
            }
         }
        
    }
    
}
