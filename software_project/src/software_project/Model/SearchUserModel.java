package software_project.Model;

import software_project.DatabaseConnection;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class SearchUserModel {
    
    
    DatabaseConnection database = new DatabaseConnection();

    String sql;
    int result;
    public String SearchAdmin(int searchID) throws SQLException {
            sql = "select * from admin where ID = '" + searchID + "'";
        return sql;
    }
    public String SearchOperator(int searchID) throws SQLException {
            sql = "select * from operator where ID = '" + searchID + "'"; 
        return sql;
    }
    public String SearchCustomer(int searchMetercode) throws SQLException {
            sql = "select * from information where metercode ='" + searchMetercode + "'";
        return sql;
    }
}
