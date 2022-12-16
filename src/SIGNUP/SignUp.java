/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SIGNUP;

import Create_and_insertDB.DDL_DML_DQL;
import USER_GET_SET.Users;
import java.util.Scanner;

/**
 *
 * @author Wandwilson Almeida Da Silva 2021230
 * @author Carolina Gomes Landim 2021226
 */
public class SignUp implements SignUpInterface{
    
    //Call the class that will be using in this class.
    Scanner input = new Scanner(System.in);
    Users objRegularUser = new Users();
    DDL_DML_DQL objUserDDL = new DDL_DML_DQL();
    
    
    //If the User chose SIGN UP.
    @Override
    public void Sign_upUsers(){
        String username, password;// Start variables to get the user input.
       
        System.out.println("Username");
        username = input.nextLine();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("password");
        password = input.nextLine();
        Users signUP = new Users();//call the users class
        signUP.setUsername(username);//set the username
        signUP.setUser_password(password);//set the password
       
        objUserDDL.Sign_UPUser(signUP);//Go to SIGN_UP method to sign up a new user on DataBase.
        
    }
    
    //Update the users.
    @Override
    public void update(int id){
        
            String username, password, surname, email, contact;//Start variables to get the user input.
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("New username: ");
            username = input.next();
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("New password: ");
            password = input.next();
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Surname: ");
            surname = input.next();
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Email: ");
            email = input.next();
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Contact: ");
            contact = input.next();
            
            //Set the user inputs.
            objRegularUser.setId_user(id);
            objRegularUser.setUsername(username);
            objRegularUser.setUser_password(password);
            objRegularUser.setSurname(surname);
            objRegularUser.setEmail(email);
            objRegularUser.setContact(contact);
            

            objUserDDL.updateUser(objRegularUser);// Go to update method to update on database.      
    }
    
    //Delete user if the admin want delete.
    @Override
    public void delete(){
         int user_id;
         System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
         System.out.println("Type the id that you would like to delete: ");
         user_id = input.nextInt();
         
         objRegularUser.setId_user(user_id);//set the id that will be deleted
         
         objUserDDL.delete(objRegularUser);//Go to delete method to delete on database.
    }
    
}
