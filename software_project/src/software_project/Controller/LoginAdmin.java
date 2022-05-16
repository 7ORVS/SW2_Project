/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software_project.Controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import software_project.Model.Model;
/**
 *
 * @author ALMASA
 */
public class LoginAdmin implements ILogin{

   ResultSet result;
    String SQL;
   @Override
    public boolean login(String userName, String password) {
        Model login = new Model();
        try {
            
            SQL = login.QueryOfLoginAdmin();
            result = login.ConnectionWithDatabase(SQL);
            while (result.next()){
                String Name = result.getString("USERNAME");
                String Password = result.getString("PASS");
                if (Name.compareTo(userName) == 0 && Password.compareTo(password) == 0) {
                    return true;
                }
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ControllerViewBills.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                login.CloseConnection();
            } catch (SQLException ex) {
                Logger.getLogger(LoginAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
     return false;
    }
}
