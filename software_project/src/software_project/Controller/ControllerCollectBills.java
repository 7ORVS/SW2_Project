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
public class ControllerCollectBills {

    ResultSet Result;
    String SQL;

    public String generalTotal() throws SQLException {
        String TotalBills;
        Model ConnectFromData = new Model();
        try {
            SQL = ConnectFromData.QueryOfCollectedTotal();
            Result = ConnectFromData.ConnectionWithDatabase(SQL);
            if (Result.next()) {
                double BillValue = Result.getDouble("sum");
                TotalBills = BillValue + "  Pounds";
                ConnectFromData.QueryOfUpdateCollected();
                return TotalBills;
             
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ControllerViewBills.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectFromData.CloseConnection();
        }
        return null;
    }
}
