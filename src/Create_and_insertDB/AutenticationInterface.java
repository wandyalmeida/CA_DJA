/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Create_and_insertDB;

import USER_GET_SET.Users;
import java.sql.ResultSet;

/**
 *
 * @author Wandwilson Almeida Da Silva 2021230
 * @author Carolina Gomes Landim 2021226
 */
public interface AutenticationInterface {
    public ResultSet autenticationUesr(Users objUserDML);
    
}
