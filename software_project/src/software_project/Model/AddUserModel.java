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
public class AddUserModel {

    DatabaseConnection database = new DatabaseConnection();
    String sql;
    int result;

    public String AddAdmin(String AdminUsername, int AdminPassword, int AdminID) throws SQLException {
        try {
            database.getInstance();
            sql = "insert into admin(USERNAME,PASS,ID) values('" + AdminUsername + "','" + AdminPassword + "','" + AdminID + "')";
            result = database.update(sql);
            if (result == 1) {
                database.showInfoDialog("Admin INSERTED SUCCESSFULLY..");
            }

        } catch (SQLException ex) {
            database.showErrorDialog("SOMETHING WRONG !!!!");
        }
        return null;

    }

    public String AddOperator(String OperatorUsername, String OperatorRegion, int OperatorPassword, int OperatorID) throws SQLException {
        try {
            database.getInstance();
            sql = "insert into operator(USERNAME,REGION,PASS,ID) values('" + OperatorUsername + "','" + OperatorRegion + "','" + OperatorPassword + "','" + OperatorID + "')";
            result = database.update(sql);
            if (result == 1) {
                database.showInfoDialog("OPERATOR INSERTED SUCCESSFULLY..");
            }
        } catch (SQLException ex) {
            database.showErrorDialog("SOMETHING WRONG !!!!");
        }
        return null;
    }

    public String AddCustomer(String CustomerFirstName, String CustomerLastName, String CustomerRegion, String CustomerStreetName, int CustomerStreetNumber, int CustomerFloorNumber, int CustomerApartmentNumber, String CustomerEmail, int CustomerPassword) throws SQLException {
        try {
            database.getInstance();
            sql = " insert into information(firstname,lastname,region,streetname,streetno,floorno,apartmentno,email,password) values ('" + CustomerFirstName + "','" + CustomerLastName + "','" + CustomerRegion + "','" + CustomerStreetName + "','" + CustomerStreetNumber + "','" + CustomerFloorNumber + "','" + CustomerApartmentNumber + "','" + CustomerEmail + "','" + CustomerPassword + "')";

            result = database.update(sql);

            if (result == 1) {
                database.showInfoDialog("CUSTOMER INSERTED SUCCESSFULLY..");
            }

        } catch (SQLException ex) {
            database.showErrorDialog("SOMETHING WRONG !!!!");
        }
        return null;
    }
}
