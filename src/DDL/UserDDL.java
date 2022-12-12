/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DDL;

import DML.RegularUserDML;
import LOGIN.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author wandw
 */
public class UserDDL implements UserDDLInterface{
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
//    ArrayList<UserDML> list = new ArrayList<>();

    @Override
    public void Sign_UPUser(RegularUserDML objsign_up) {
       String sql = "insert into  user (user_name, password) values (?, ?)";

        conn = new ConnectionFactory().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objsign_up.getUser_name());
            pstm.setString(2, objsign_up.getUser_password());

            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("Sign UP User: " + e);
        }
    }

    @Override
    public void check_admin(int id, String user_name, String password) {
        String sql = "select * from user where user_name = 'cct' and password = ?";
        login lg = new login();

   
        try {
            conn = new ConnectionFactory().conectaBD();
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, password);
            
            rs = pstm.executeQuery();
            if(rs.next()){
                System.out.println("Welcome back "+ user_name);
                lg.admin(id);
                               
            }else{
                System.out.println("Welcome back "+ user_name);
                lg.users(id);
            }
            
        } catch (SQLException e) {
            System.out.println("Admin check: " + e);
        }
    }

    @Override
    public void findUser(int id) {
        String sql = "select * from user where id_user != ?";
        String user_name,user_password;
        int id_user;

        
        
        try {
            conn = new ConnectionFactory().conectaBD();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            
            System.out.println("id  " + "  name  " + " password  " );

            while(rs.next()){
                  
                   id_user = rs.getInt("id_user");
                   user_name = rs.getString("user_name");
                   user_password = rs.getString("password");

                   System.out.println(id_user +"| "+user_name +"| "+user_password );
                   
                   
                   
               
            }
        } catch (SQLException e) {
            System.out.println("Regular User: " + e);
        }
    }

    @Override
    public int getId(String user_name, String password) {
        String sql = "select * from user where user_name = ? and password = ?";

        int id_user;
        
        
        try {
            conn = new ConnectionFactory().conectaBD();
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, user_name);
            pstm.setString(2, password);
            
            rs = pstm.executeQuery();
            if(rs.next()){
                id_user = rs.getInt("id_user");
                return id_user; 
                               
            }
        } catch (SQLException e) {
            System.out.println("Regular User: " + e);
        }
        return 0;
    }

    @Override
    public void updateUser(RegularUserDML objupdateDML) {
        String sql = "update user set user_name = ?, password = ?  where id_user = ? ";
        conn = new ConnectionFactory().conectaBD();
         try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objupdateDML.getUser_name());
            pstm.setString(2, objupdateDML.getUser_password());
            pstm.setInt(3, objupdateDML.getId_user());

            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("Update User: " + e);
        }
    }

    @Override
    public void delete(RegularUserDML objdeleteDML) {
        String sql = "delete from user where id_user = ? ";
//        String user_name,user_password;
//        int id_user;
        
        
        try {
            conn = new ConnectionFactory().conectaBD();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objdeleteDML.getId_user());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("Delete usuario: " + e);
        }
    }
    
}
