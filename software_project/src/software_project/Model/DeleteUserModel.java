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
public class DeleteUserModel {

    DatabaseConnection database = new DatabaseConnection();
    String sql;
    int result;

    public String DeleteAdmin(int AdminID) throws SQLException {
        try {
            database.getInstance();
            sql = "DELETE FROM ADMIN WHERE ID ='" + AdminID + "'";
            result = database.update(sql);
            if (result == 1) {
                database.showInfoDialog("ADMIN DELETED SUCCESSFULLY...");
            }

        } catch (SQLException ex) {
            database.showErrorDialog("SQL EXCEPTION !!!");
        }
        return null;

    }

    public String DeleteOperator(int operatorID) throws SQLException {
        try {
            database.getInstance();
            sql = "DELETE FROM OPERATOR WHERE ID ='" + operatorID + "'";
            result = database.update(sql);
            if (result == 1) {
                database.showInfoDialog("OPERATOR DELETED SUCCESSFULLY...");
            }
        } catch (SQLException ex) {
            database.showErrorDialog("SQL EXCEPTION !!!");
        }
        return null;
    }

    public String DeleteCustomer(int customerMetercode) throws SQLException {
        try {
            database.getInstance();
            sql = "DELETE FROM INFORMATION WHERE METERCODE ='" + customerMetercode + "'";
            result = database.update(sql);
            if (result == 1) {
                database.showInfoDialog("CUSTOMER DELETED SUCCESSFULLY...");
            }

        } catch (SQLException ex) {
            database.showErrorDialog("SQL EXCEPTION !!!");
        }
        return null;
    }
}
