/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SIGNUP;

import DDL.UserDDL;
import DML.RegularUserDML;
import java.util.Scanner;

/**
 *
 * @author wandw
 */
public class SignUp implements SignUpInterface{
    
    Scanner input = new Scanner(System.in);
    RegularUserDML objRegularUserDML = new RegularUserDML();
    UserDDL objUserDDL = new UserDDL();
    
    @Override
    public void Sign_upUsers(){
        String user_name, password;
       
        System.out.println("Username");
        user_name = input.nextLine();
        System.out.println("password");
        password = input.nextLine();
        RegularUserDML signUP = new RegularUserDML();
        signUP.setUser_name(user_name);
        signUP.setUser_password(password);
        
       
        objUserDDL.Sign_UPUser(signUP);
        
    }
    
    @Override
    public void update(int id){
            UserDDL list = new UserDDL();
            String username, password;
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Digite um novo usuario: ");
            username = input.next();
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Digite a nova senha: ");
            password = input.next();
            
            objRegularUserDML.setId_user(id);
            objRegularUserDML.setUser_name(username);
            objRegularUserDML.setUser_password(password);

            objUserDDL.updateUser(objRegularUserDML);
           
    }
    
    @Override
    public void delete(){
         int user_id;
         System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
         System.out.println("Type the id that would you like to delete: ");
         user_id = input.nextInt();
         
         objRegularUserDML.setId_user(user_id);
         
         objUserDDL.delete(objRegularUserDML);
    }
    
}
