/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DDL;

import DML.UserDML;
import java.sql.ResultSet;

/**
 *
 * @author Wandwilson Almeida Da Silva
 * Student name: Carolina Gomes Landim
 */
public interface AutenticationInterface {
    public ResultSet autenticationUesr(UserDML objUserDML);
    
}
