/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DDL;

import DML.RegularUserDML;

/**
 *
 * @author wandw
 */
public interface UserDDLInterface {
    public void Sign_UPUser(RegularUserDML objsign_up);
    public void check_admin(int id, String user_name, String password);
    public void findUser(int id);
    public int getId(String user_name, String password);
    public void updateUser(RegularUserDML objupdateDML);
    public void delete(RegularUserDML objdeleteDML);
}
