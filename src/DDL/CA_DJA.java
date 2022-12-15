/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DDL;

import LOGIN.login;

/**
 *
 * @author Wandwilson Almeida Da Silva
 * Student name: Carolina Gomes Landim
 */
public class CA_DJA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Create the DataBase and add the Admin user.
        UserDDL createDB = new UserDDL();
        createDB.outputSetup();
        
        // Show the menu for login or sign up.
        login log = new login();
        log.menu();
    }
    
}
