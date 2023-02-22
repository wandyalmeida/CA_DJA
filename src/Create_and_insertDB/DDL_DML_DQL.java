/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Create_and_insertDB;

import USER_GET_SET.Users;
import LOGIN.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author Wandwilson Almeida Da Silva 2021230
 * @author Carolina Gomes Landim 2021226
 */
public class DDL_DML_DQL implements DDL_DML_DQLINTERFACE{
    
    /*
    comands that will be using on the all methods.
    */
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    
    
    /*
        DDL
     Start create the schema and the tables on the DataBase.
    */
    @Override
    public boolean create_schema(){
        try {
           conn = new ConnectionFactory().conectaBD();
           Statement stmt = conn.createStatement();
            
            stmt.execute("CREATE SCHEMA IF NOT EXISTS systemca;");//check if the data base have this schema. if no they will create the schema.
            stmt.execute("USE systemca;");
            
            /*
                Start DDL create the tables on the DataBase.
                
            */
            
            /*
            user_id INT(20) PRIMARY KEY AUTO_INCREMENT,
            equations VARCHAR(30),
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
            
            /*
            equation_id INT(20) PRIMARY KEY AUTO_INCREMENT,
            equations VARCHAR(100),
            solution VARCHAR(100),
            users_id INT(20) NOT NULL;
            */
            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS equation ("
                            + "equation_id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                            + "equations VARCHAR(100),"
                            + "solution VARCHAR(100),"
                            + "users_id INT(20) NOT NULL,"
                            + "CONSTRAINT users_id FOREIGN KEY (users_id) REFERENCES users(user_id));"
                            
            );
            
            /*
            admin_id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
            users_id INT(20) NOT NULL,
            equation_id INT(20) NOT NULL;
            */
            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS admin_user  ("
                            + "admin_id INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                            + "userS_id INT(20) NOT NULL,"
                            + "equation_id INT(20) NOT NULL,"
                            + "CONSTRAINT user_id FOREIGN KEY (userS_id) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE,"
                            + "CONSTRAINT equation_id FOREIGN KEY (equation_id) REFERENCES equation(equation_id) ON DELETE CASCADE ON UPDATE CASCADE);"
                            
            );
           
            insert_admin();
            return true; // return if the data was created.
        } catch (SQLException e) {
            System.out.println("Create Schema and Tables: " + e);// show this message if this method get a error.
            return false; // return false if the data base is ready created.
        }
    }

    /*
        Start DML
        insert the new Users on the DataBase.
    */

    @Override
    public void Sign_UPUser(Users objsign_up){
       
       String SQL_COMMAND = "insert into  users (username, password) values (?, ?)";// insert the new user on the DataBase.

        conn = new ConnectionFactory().conectaBD();

        try {
            /*
            PSTM = Prepare Statment.
            RS = ResultSet
            CONN = Connection
            */
            pstm = conn.prepareStatement(SQL_COMMAND);
            pstm.setString(1, objsign_up.getUsername());// set and get the equations.
            pstm.setString(2, objsign_up.getUser_password());// set and get the password.
            
            pstm.execute("USE systemca;");
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println("Sign UP User: " + e);
        }
    }
    
    /*
    Add the equation on the DataBase.
    */
    @Override
    public void addEquation(String equation, String solution, int id){
        // Start the variable;
        int id_equation = 0;
        String SQL_COMMAND = "insert into  equation (equations, solution, users_id) values (?, ?, ?)";//inset the equation on the DataBase.
        String SQL_COMMAND2 = "select * from equation where equation_id";//Get the equation_id DDL command.
       
        conn = new ConnectionFactory().conectaBD();//connect on the DataBase.

        try {
            /*
            PSTM = Prepare Statment.
            RS = ResultSet
            CONN = Connection
            */
            
            pstm = conn.prepareStatement(SQL_COMMAND);
            pstm.setString(1, equation);
            pstm.setString(2, solution);
            pstm.setInt(3, id);
            
            pstm.execute("USE systemca;");
            pstm.execute();
            pstm = conn.prepareStatement(SQL_COMMAND2);
            rs = pstm.executeQuery();
            /*
              Get the equation_id to put in Admin_user Table.
            using while loop to get the last equation add on the equation table.
            */
            while(rs.next()){
                id_equation = rs.getInt("equation_id");                    
            }
            
            insert_adminfk(id_equation); //will move to insert_adminfk and insert the equation_id on the Admin_user.
            
        } catch (SQLException e) {
            System.out.println("add equation: " + e);// show this message if this method get a error.
        }
    }
    
    /*
     insert the admin foreign key on the admin_user table.
    */
    @Override
    public void insert_adminfk(int id_equation) {
       
        String SQL_COMMAND = "insert  into  admin_user (userS_id, equation_id) values (1, ?)";// this will set the equation_id the userS_id will be always the admin id.

        conn = new ConnectionFactory().conectaBD();

        try {
            /*
            PSTM = Prepare Statment.
            CONN = Connection
            */
            pstm = conn.prepareStatement(SQL_COMMAND);
            pstm.setInt(1, id_equation);

            
            pstm.execute("USE systemca;");
            pstm.execute();
            pstm.close();  
            
        } catch (SQLException e) {
            System.out.println("insert admin foreign key: " + e);// show this message if this method get a error.
        }
    }
   
    /*
    insert the CCT user as admin of the DataBase.
    Delete user CCT If the system is restarted.
    */
      
    
    @Override
    public void insert_admin(){ 
       String SQL_COMMAND = "insert into  users(username, password) values (?, ?)"; // will set the CCT as a Admin when the code start on the first time.
       String delete = "delete from users where user_id != '1' and username = 'CCT' and password = 'Dublin'";// this command will avoid the CCT user can created more than once when the system is restart.
       


        try {
            /*
            PSTM = Prepare Statment.
            CONN = Connection.
            */
            conn = new ConnectionFactory().conectaBD();
            pstm = conn.prepareStatement(SQL_COMMAND);
            pstm.setString(1, "CCT");
            pstm.setString(2, "Dublin");
                    
            pstm.execute("USE systemca;");
            pstm.execute();
            /*
            start to delete if the user CCT is found more than one 
            */
            pstm = conn.prepareStatement(delete);
            pstm.execute();
        } catch (SQLException e) {
            System.out.println("insert Admin: " + e);// show this message if this method get a error.
        }
    }
    
    /*
     Update the users profile
    */
    
    @Override
    public void updateUser(Users objupdateDML){
        String SQL_COMMAND = "update users set username = ?, password = ?, surname = ?, email = ?, contact = ?  where user_id = ? ";//This will get the user input to update the data.
        conn = new ConnectionFactory().conectaBD();
         try {
            /*
            PSTM = Prepare Statment.
            CONN = Connection.
            */
            pstm = conn.prepareStatement(SQL_COMMAND);
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
            System.out.println("Update User: " + e);// show this message if this method get a error.
        }
    }

    /*
    Delete the user from DataBase.
    */
    @Override
    public void delete(Users objdeleteDML){
        String SQL_COMMAND_Delete_equation = "delete from equation where users_id = ? ";//This will get the id that the admin put to delete.
        String SQL_COMMAND = "delete from users where user_id = ? ";//This will get the id that the admin put to delete.
        
        
        
        try {
            if (objdeleteDML.getId_user() == 1){ //this will check if the admin is try to delete himself that will show a error.
                System.out.println("Sorry you cannot delete this user!");
                login login = new login();
                login.admin(objdeleteDML.getId_user());
            }else{
                conn = new ConnectionFactory().conectaBD();
                //Delete equation that the user did if the admin decide delete the user
                pstm = conn.prepareStatement(SQL_COMMAND_Delete_equation);
                pstm.setInt(1, objdeleteDML.getId_user());

                pstm.execute("USE systemca;");
                pstm.execute();
                //Delete the user
                pstm = conn.prepareStatement(SQL_COMMAND);
                pstm.setInt(1, objdeleteDML.getId_user());

                pstm.execute("USE systemca;");
                pstm.execute();
                pstm.close();
            }
            
        } catch (SQLException e) {
            System.out.println("Delete usuario: " + e);// show this message if this method get a error.
        }
    }

 
    /*
       Start DQL = DATA QUERY LANGUAGUE. 
       Start Check_user if it is admin or it is a regular user. 
    */
    @Override
    public void check_user(int id, String username, String password){
        String SQL_COMMAND = "select * from users where user_id = '1' and username = ? and password = ?";// will check if the user is an admin or a regular user.
        login signin = new login(); // call the menu option.

   
        try {
             /*
            PSTM = Prepare Statment.
            CONN = Connection.
            */
            conn = new ConnectionFactory().conectaBD();
            pstm = conn.prepareStatement(SQL_COMMAND);
            
            pstm.setString(1, username);
            pstm.setString(2, password);
            
            pstm.execute("USE systemca;");
            rs = pstm.executeQuery();
           
            if(rs.next()){// this command will get the first id that was set it is an Admin
                System.out.println("Welcome back "+ username);
                signin.admin(id);
                               
            }else{ // if is not an Admin they willl use this part for regular user
                System.out.println("Welcome back "+ username);
                signin.users(id);
            }
            
        } catch (SQLException e) {
            System.out.println("Check user: " + e);// show this message if this method get a error.
        }
    }

    /*
        Will show a list with the user is on the DataBase.
    */
    @Override
    public void findUser(int id) {
        String SQL_COMMAND = "select * from users where user_id != 1"; // will get the user list.
        /*
        Start variable
        */
        String username, surname, email, contact;
        int id_user;
        
        
        
        try {
            /*
            PSTM = Prepare Statment.
            RS = ResultSet
            CONN = Connection
            */
            conn = new ConnectionFactory().conectaBD();
            pstm = conn.prepareStatement(SQL_COMMAND);
            
            pstm.execute("USE systemca;");
            rs = pstm.executeQuery();
            
            System.out.println("|ID\t" + "|NAME\t  " + "\t|SURNAME " + "\t|EMAIL " + "\t|CONTACT" );
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            while(rs.next()){// show a table with the users.
                  
                   id_user = rs.getInt("user_id");
                   username = rs.getString("username");
                   surname = rs.getString("surname");
                   contact = rs.getString("contact");
                   email = rs.getString("email");
                   
                   if (username.length() <= 6){
                       System.out.println("|" +id_user +"\t|"+username +"\t \t|"+surname +"\t|"+email +"\t|"+contact);// show the table.
                        
                   }
                   else if(username.length() >= 6){
                       System.out.println("|" +id_user +"\t|"+username +"\t|"+surname +"\t|"+email + "\t|"+contact);// show the table.
                   }                   
                                 
            }
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            
        } catch (SQLException e) {
            System.out.println("Find User: " + e);// show this message if this method get a error.
        }
    }
    
    /*
    Show the equation table.
    */
    @Override
    public void seeEquation(int id){
        /*
        start variables
        */
        String SQL_COMMAND;
        String equations,solutions;
        int id_user, equation_id;

        try {
            /*
            PSTM = Prepare Statment.
            RS = ResultSet
            CONN = Connection
            */
            //admin user should see all equation and regular user should see only the equation he did.
            if (id == 1){//check if the user is admin or regular user and show the equation
                    SQL_COMMAND = "select * from equation ";//this will get the equation table
                    conn = new ConnectionFactory().conectaBD();
                    pstm = conn.prepareStatement(SQL_COMMAND);

                    pstm.execute("USE systemca;");
                    rs = pstm.executeQuery();

                    System.out.println("|id  " + "\t| equations  " + "\t| solution  " + "\t| User_ID" );
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    while(rs.next()){ // on this part will show a table with the equations

                           equation_id = rs.getInt("equation_id");
                           equations = rs.getString("equations");
                           solutions = rs.getString("solution");
                           id_user = rs.getInt("users_id");
                           System.out.println("|"+equation_id +"\t|"+equations +"\t|"+solutions+"\t|"+id_user );

                    }
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            }else{
                    SQL_COMMAND = "select * from equation where users_id = ? ";//this will get the equation table
                    conn = new ConnectionFactory().conectaBD();
                    pstm = conn.prepareStatement(SQL_COMMAND);
                    pstm.setInt(1, id);

                    pstm.execute("USE systemca;");
                    rs = pstm.executeQuery();

                    System.out.println("|id  " + "\t| equations  " + "\t| solution  " + "\t| User_ID" );
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    while(rs.next()){ // on this part will show a table with the equations

                           equation_id = rs.getInt("equation_id");
                           equations = rs.getString("equations");
                           solutions = rs.getString("solution");
                           id_user = rs.getInt("users_id");
                           System.out.println("|"+equation_id +"\t|"+equations +"\t|"+solutions+"\t|"+id_user );

                }
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            }
            
        } catch (SQLException e) {
            System.out.println("See equation: " + e);// show this message if this method get a error.
        }
    }

    /*
    Get the user_id from the table to split the users.
    */
    @Override
    public int getId(String username, String password){
        String SQL_COMMAND = "select * from users where username = ? and password = ?";

        int id_user;
        
        
        try {
             /*
            PSTM = Prepare Statment.
            CONN = Connection.
            */
            conn = new ConnectionFactory().conectaBD();
            pstm = conn.prepareStatement(SQL_COMMAND);
            
            pstm.setString(1, username);//set the username to get the id
            pstm.setString(2, password);//set the password to get id
            
            pstm.execute("USE systemca;");
            rs = pstm.executeQuery();
            if(rs.next()){
                id_user = rs.getInt("user_id");//get the id from the user
                return id_user; 
                               
            }
        } catch (SQLException e) {
            System.out.println("Get ID: " + e);// show this message if this method get a error.
        }
        return 0;
    }
    
    
}
