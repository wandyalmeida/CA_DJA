/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Create_and_insertDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Wandwilson Almeida Da Silva 2021230
 * @author Carolina Gomes Landim 2021226
 */
public class ConnectionFactory implements ConnectionInterface{
    /*
        Will connect the Java Aplication with the DataBase.
    */
    
    @Override
    public Connection conectaBD(){

        Connection conn = null;
       
        try {
            String dbName = "systemca";
            String DB_URL = "jdbc:mysql://localhost/" + dbName;
            String USER = "root";
            String PASS = "root";
            conn = DriverManager.getConnection("jdbc:mysql://localhost/", USER, PASS);
           
           
        } catch (SQLException e) {
            System.out.println("Erro on the connection part " + e.getMessage());// show this message if this method get a error.
        }
        
        return conn;
    }
    
}
