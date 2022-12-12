/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DDL;

import DML.UserDML;
import java.sql.ResultSet;

/**
 *
 * @author wandw
 */
public interface AutenticationInterface {
    public ResultSet autenticationUesr(UserDML objUserDML);
    
}
