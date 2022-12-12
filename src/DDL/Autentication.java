/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DDL;

import DML.UserDML;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author wandw
 */
public class Autentication implements AutenticationInterface {
    Connection conn;
    
    @Override
    public ResultSet autenticationUesr(UserDML objUserDML) {
          conn = new ConnectionFactory().conectaBD();
        
        try {
            String sql = "select * from usuario where nome_usuario = ? and senha_usuario = ?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objUserDML.getUser_name());
            pstm.setString(2, objUserDML.getUser_password());
            
           
            
            ResultSet rs = pstm.executeQuery();
            
            return rs;
        } catch (SQLException e) {
            System.out.println("UsuarioDao: " + e);
            return null;
        }
    }
    
}
