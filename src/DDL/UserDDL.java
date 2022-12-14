/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DDL;

import DML.UserDML;
import LOGIN.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author wandw
 */
public class UserDDL implements UserDDLInterface{
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    
    
    @Override
    public boolean outputSetup(){
        try {
           conn = new ConnectionFactory().conectaBD();
           Statement stmt = conn.createStatement();
            
            stmt.execute("CREATE SCHEMA IF NOT EXISTS systemca;");
            stmt.execute("USE systemca;");
            /*
            user_id INT(20) PRIMARY KEY AUTO_INCREMENT,
            username VARCHAR(30),
            password VARCHAR(30),
            email VARCHAR(100),
            contact VARCHAR(15);
            */
            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS users  ("
                            + "user_id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                            + "username VARCHAR(30),"
                            + "password VARCHAR(30),"
                            + "surname VARCHAR(40),"
                            + "email VARCHAR(100),"
                            + "contact VARCHAR(15));"
            );
            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS equation ("
                            + "equation_id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                            + "equations VARCHAR(100),"
                            + "solution VARCHAR(100),"
                            + "users_id INT(20) NOT NULL,"
                            + "CONSTRAINT users_id FOREIGN KEY (users_id) REFERENCES users(user_id));"
                            
            );
            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS admin_user  ("
                            + "admin_id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                            + "userS_id INT(20) NOT NULL,"
                            + "equation_id INT(20) NOT NULL,"
                            + "CONSTRAINT user_id FOREIGN KEY (userS_id) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE,"
                            + "CONSTRAINT equation_id FOREIGN KEY (equation_id) REFERENCES equation(equation_id) ON DELETE CASCADE ON UPDATE CASCADE);"
                            
            );
           
            insert_admin();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public void Sign_UPUser(UserDML objsign_up) {
       
       String sql = "insert into  users (username, password) values (?, ?)";

        conn = new ConnectionFactory().conectaBD();

        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objsign_up.getUsername());
            pstm.setString(2, objsign_up.getUser_password());
            
            pstm.execute("USE systemca;");
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("Sign UP User: " + e);
        }
    }
    
      public void addEquation(String equation, String solution, int id) {
       int id_equation = 0;
        String sql = "insert into  equation (equations, solution, users_id) values (?, ?, ?)";
        String sq2 = "select * from equation where equation_id";
        conn = new ConnectionFactory().conectaBD();

        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, equation);
            pstm.setString(2, solution);
            pstm.setInt(3, id);
            
            pstm.execute("USE systemca;");
            pstm.execute();
            pstm = conn.prepareStatement(sq2);
            rs = pstm.executeQuery();
            while(rs.next()){
                id_equation = rs.getInt("equation_id");                   
            }
            
            insert_adminfk(id_equation);
            
        } catch (SQLException e) {
            System.out.println("add equation: " + e);
        }
    }
        public void insert_adminfk(int id_equation) {
       
        String sql = "insert into  admin_user (userS_id, equation_id) values (1, ?)";

        conn = new ConnectionFactory().conectaBD();

        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_equation);

            
            pstm.execute("USE systemca;");
            pstm.execute();
            pstm.close();            
        } catch (SQLException e) {
            System.out.println("insert admin foreign key: " + e);
        }
    }
   
    
      
    
      @Override
    public void insert_admin() {
       
       String sql = "insert into users (username, password) values (?, ?)";
        conn = new ConnectionFactory().conectaBD();

        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, "CCT");
            pstm.setString(2, "Dublin");
                    
            pstm.execute("USE systemca;");
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("insert Admin: " + e);
        }
    }

    @Override
    public void check_admin(int id, String username, String password) {
        String sql = "select * from users where user_id = '1' and username = ? and password = ?";
        login lg = new login();

   
        try {
            conn = new ConnectionFactory().conectaBD();
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, username);
            pstm.setString(2, password);
            
            pstm.execute("USE systemca;");
            rs = pstm.executeQuery();
            if(rs.next()){
                System.out.println("Welcome back "+ username);
                lg.admin(id);
                               
            }else{
                System.out.println("Welcome back "+ username);
                lg.users(id);
            }
            
        } catch (SQLException e) {
            System.out.println("Admin check: " + e);
        }
    }

    @Override
    public void findUser(int id) {
        String sql = "select * from users where user_id != ?";
        String user_name,user_password;
        int id_user;

        
        
        try {
            conn = new ConnectionFactory().conectaBD();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            
            pstm.execute("USE systemca;");
            rs = pstm.executeQuery();
            
            System.out.println("id  " + "  name  " + " password  " );

            while(rs.next()){
                  
                   id_user = rs.getInt("user_id");
                   user_name = rs.getString("username");
                   user_password = rs.getString("password");

                   System.out.println(id_user +"| "+user_name +"| "+user_password );
                   
                   
                   
               
            }
        } catch (SQLException e) {
            System.out.println("Find User: " + e);
        }
    }
    
    public void seeEquation() {
        String sql = "select * from equation ";
        String user_name,user_password;
        int id_user, equation_id;

        
        
        try {
            conn = new ConnectionFactory().conectaBD();
            pstm = conn.prepareStatement(sql);
            
            pstm.execute("USE systemca;");
            rs = pstm.executeQuery();
            
            System.out.println("id  " + "  name  " + " solution  " + "User_ID" );

            while(rs.next()){
                  
                   equation_id = rs.getInt("equation_id");
                   user_name = rs.getString("equations");
                   user_password = rs.getString("solution");
                   id_user = rs.getInt("users_id");
                   System.out.println(equation_id +"| "+user_name +"| "+user_password+"| "+id_user );
                   
                   
                   
               
            }
        } catch (SQLException e) {
            System.out.println("See equation: " + e);
        }
    }

    @Override
    public int getId(String username, String password) {
        String sql = "select * from users where username = ? and password = ?";

        int id_user;
        
        
        try {
            conn = new ConnectionFactory().conectaBD();
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, username);
            pstm.setString(2, password);
            
            pstm.execute("USE systemca;");
            rs = pstm.executeQuery();
            if(rs.next()){
                id_user = rs.getInt("user_id");
                return id_user; 
                               
            }
        } catch (SQLException e) {
            System.out.println("Get ID: " + e);
        }
        return 0;
    }

    @Override
    public void updateUser(UserDML objupdateDML) {
        String sql = "update users set username = ?, password = ?, surname = ?, email = ?, contact = ?  where user_id = ? ";
        conn = new ConnectionFactory().conectaBD();
         try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objupdateDML.getUsername());
            pstm.setString(2, objupdateDML.getUser_password());
            pstm.setString(3, objupdateDML.getSurname());
            pstm.setString(4, objupdateDML.getEmail());
            pstm.setString(5, objupdateDML.getContact());
            pstm.setInt(6, objupdateDML.getId_user());

            pstm.execute("USE systemca;");
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("Update User: " + e);
        }
    }

    @Override
    public void delete(UserDML objdeleteDML) {
        String sql = "delete from users where user_id = ? ";

        
        
        try {
            if (objdeleteDML.getId_user() == 1){
                System.out.println("Sorry you cant delete this user!");
                login login = new login();
                login.admin(objdeleteDML.getId_user());
            }else{
                conn = new ConnectionFactory().conectaBD();
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, objdeleteDML.getId_user());

                pstm.execute("USE systemca;");
                pstm.execute();
                pstm.close();
            }
            
        } catch (SQLException e) {
            System.out.println("Delete usuario: " + e);
        }
    }
    
}
