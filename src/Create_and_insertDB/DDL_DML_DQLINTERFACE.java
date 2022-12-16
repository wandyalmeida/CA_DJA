/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Create_and_insertDB;

import USER_GET_SET.Users;

/**
 *
 * @author Wandwilson Almeida Da Silva 2021230
 * @author Carolina Gomes Landim 2021226
 */
public interface DDL_DML_DQLINTERFACE {
    public boolean create_schema();
    public void Sign_UPUser(Users objsign_up);
    public void check_user(int id, String user_name, String password);
    public void findUser(int id);
    public int getId(String user_name, String password);
    public void updateUser(Users objupdateDML);
    public void delete(Users objdeleteDML);
    public void insert_admin();
    public void addEquation(String equation, String solution, int id);
    public void insert_adminfk(int id_equation);
    public void seeEquation(int id);
    
}
