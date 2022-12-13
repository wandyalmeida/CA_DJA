/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DDL;

import LOGIN.login;

/**
 *
 * @author wandw
 */
public class CA_DJA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UserDDL createDB = new UserDDL();
        createDB.outputSetup();
//        createDB.insert_admin();
        login log = new login();
        log.menu();
    }
    
}
