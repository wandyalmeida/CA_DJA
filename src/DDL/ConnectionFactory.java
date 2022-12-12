/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DDL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author wandw
 */
public class ConnectionFactory implements ConnectionInterface{

    @Override
    public Connection conectaBD() {
        Connection conn = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/bancoteste?user=root&password=root";
            conn = DriverManager.getConnection(url);
//            System.out.println("connect yeahhh");
            
            
            
        } catch (SQLException e) {
            System.out.println("Erro on the connection part " + e.getMessage());
        }
        
        return conn;
    }
    
}
