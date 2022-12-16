/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Start_System;

import Create_and_insertDB.DDL_DML_DQL;
import LOGIN.login;

/**
 * @lector: Sam Weiss
 * @lector: Aldana Louzan
 * @author Carolina Gomes Landim 2021226
 * @author Wandwilson Almeida Da Silva 2021230
 * GIT_HUB LINK: https://github.com/wandyalmeida/CA_DJA
 */
public class CA_DJA {

    /**
     * @param args the command line arguments
     *          
     *          Strategy
     * 
     * 1) Create a interfaces and class.
     * 2) Create the menu to show what the user want to do and get input.
     * 3) Start the connection with the DataBase.
     * 4) Create methods to create the Schema and the tables on the DataBase.
     * 5) Create methods to insert, select, update and delete on the DataBase.
     * 6) Create the Math calculator to do the Linear equation but using the Matrix.
     * 7) Create the Enum class that will be using to give the options to users.
     * 8) Start the System creating the database and show the menu to user.
     *
     *  
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Create the DataBase and add the Admin user
        DDL_DML_DQL createDB = new DDL_DML_DQL();
        createDB.create_schema();
        
        // Show the menu for login or sign up.
        login log = new login();
        log.menu();
    }
    
}
