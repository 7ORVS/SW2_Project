/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software_project.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import software_project.Model.Model;
import software_project.GUI.ViewAllBills;
/**
 *
 * @author ALMASA
 */
public class ControllerViewBills {


    ResultSet Result ;
    String SQL ;
 

    public ArrayList<Model> getAllBills(String region) throws SQLException {
        
        ArrayList<Model> ElectricityBillValue = new ArrayList<>();
        Model ValueOfBill = new Model();
        ValueOfBill.setregion(region);

        try {
 
            SQL = ValueOfBill.QueryOfViewBill();
            Result = ValueOfBill.ConnectionWithDatabase(SQL);
            while (Result.next()) {
                ValueOfBill.setmetercode(Result.getLong("metercode"));
                ValueOfBill.setbill(Result.getInt("billvalue"));
                ValueOfBill.setregion(Result.getString("region"));
                ElectricityBillValue.add(ValueOfBill);
            }

        } catch (SQLException Ex) {
            Logger.getLogger(ControllerViewBills.class.getName()).log(Level.SEVERE, null, Ex);
        } finally {
            ValueOfBill.CloseConnection();
        }
        return ElectricityBillValue;
    }

    

 

}
