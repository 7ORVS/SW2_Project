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
public class UpdateUserModel {

    DatabaseConnection database = new DatabaseConnection();

    String sql;
    int result;

    public String UpdateAdmin(String AdminUsername, int AdminPassword, int AdminID) throws SQLException {
        try {
            database.getInstance();
            sql = "UPDATE ADMIN SET USERNAME='" + AdminUsername + "',PASS='" + AdminPassword + "' WHERE ID ='" + AdminID + "' ";
            result = database.update(sql);
            if (result == 1) {
                database.showInfoDialog("ADMIN UPDATED SUCCESSFULLY..");
            }
        } catch (SQLException ex) {
            database.showErrorDialog("SQL EXCEPTION !!!");
        }
        return sql;
    }

    public String UpdateOperator(String OperatorUsername, int OperatorPassword, String OperatorRegion, int OperatorID) throws SQLException {
        try {
            database.getInstance();
            sql = "UPDATE OPERATOR SET USERNAME='" + OperatorUsername + "',PASS='" + OperatorPassword + "',REGION='" + OperatorRegion + "' WHERE ID ='" + OperatorID + "' ";
            result = database.update(sql);
            if (result == 1) {
                database.showInfoDialog("OPERATOR UPDATED SUCCESSFULLY..");
            }

        } catch (SQLException ex) {
            database.showErrorDialog("SQL EXCEPTION !!!");
        }
        return null;
    }

    public String UpdateCustomer(int CustomerMetercode, String CustomerFirstName, String CustomerLastName, String CustomerRegion, String CustomerStreetName, int CustomerStreetNumber, int CustomerFloorNumber, String CustomerEmail, int CustomerPassword, String CustomerComplain, int CustomerIsFreeze) throws SQLException {
        try {
            database.getInstance();
            sql = "UPDATE INFORMATION SET username='" + CustomerFirstName + "',LASTNAME='" + CustomerLastName + "',REGION='" + CustomerRegion + "',STREETNAME='" + CustomerStreetName
                    + "',STREETNO='" + CustomerStreetNumber + "',FLOORNO='" + CustomerFloorNumber + "',Email='" + CustomerEmail
                    + "',COMPLIMENT='" + CustomerComplain + "',PASSWORD='" + CustomerPassword + "',isFreeze='" + CustomerIsFreeze + "' WHERE METERCODE ='" + CustomerMetercode + "' ";
            result = database.update(sql);
            if (result == 1) {
                database.showInfoDialog("CUSTOMER UPDATED SUCCESSFULLY..");
            }
        } catch (SQLException ex) {
            database.showErrorDialog("SQL EXCEPTION !!!");
        }
        return null;
    }
}
