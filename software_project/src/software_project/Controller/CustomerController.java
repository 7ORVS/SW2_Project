package software_project.Controller;


import java.sql.ResultSet;
import java.sql.SQLException;
import software_project.Model.ConsumptionStatisticsModel;
import software_project.Model.CustomerModel;
import software_project.DatabaseConnection;
import software_project.Model.AddUserModel;
import software_project.Model.DeleteUserModel;
import software_project.Model.SearchUserModel;
import software_project.Model.UpdateUserModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DELL
 */
public class CustomerController {

    DatabaseConnection database = new DatabaseConnection();
    CustomerModel customerModel = new CustomerModel();
    ConsumptionStatisticsModel consumptionValue = new ConsumptionStatisticsModel();

    public int getCustomerIsFreeze() {
        return customerModel.CustomerIsFreeze;
    }

    public void setCustomerIsFreeze(int CustomerIsFreeze) {
        this.customerModel.CustomerIsFreeze = CustomerIsFreeze;
    }

    public int getCustomerMonthlyBillReading() {
        return customerModel.CustomerMonthlyBillReading;
    }

    public void setCustomerMonthlyBillReading(int CustomerMonthlyBillReading) {
        this.customerModel.CustomerMonthlyBillReading = CustomerMonthlyBillReading;
    }

    public int getConsumptionStatistics() {
        return customerModel.ConsumptionStatistics;
    }

    public void setConsumptionStatistics(int ConsumptionStatistics) {
        this.customerModel.ConsumptionStatistics = ConsumptionStatistics;
    }

    public String getCustomerFirstName() {
        return customerModel.CustomerFirstName;
    }

    public void setCustomerFirstName(String CustomerFirstName) {
        this.customerModel.CustomerFirstName = CustomerFirstName;
    }

    public String getCustomerLastName() {
        return customerModel.CustomerLastName;
    }

    public void setCustomerLastName(String CustomerLastName) {
        this.customerModel.CustomerLastName = CustomerLastName;
    }

    public int getCustomerPassword() {
        return customerModel.CustomerPassword;
    }

    public void setCustomerPassword(int CustomerPassword) {
        this.customerModel.CustomerPassword = CustomerPassword;
    }

    public String getCustomerEmail() {
        return customerModel.CustomerEmail;
    }

    public void setCustomerEmail(String CustomerEmail) {
        this.customerModel.CustomerEmail = CustomerEmail;
    }

    public int getCustomerStreetNumber() {
        return customerModel.CustomerStreetNumber;
    }

    public void setCustomerStreetNumber(int CustomerStreetNumber) {
        this.customerModel.CustomerStreetNumber = CustomerStreetNumber;
    }

    public String getCustomerStreetName() {
        return customerModel.CustomerStreetName;
    }

    public void setCustomerStreetName(String CustomerStreetName) {
        this.customerModel.CustomerStreetName = CustomerStreetName;
    }

    public String getCustomerRegion() {
        return customerModel.CustomerRegion;
    }

    public void setCustomerRegion(String CustomerRegion) {
        this.customerModel.CustomerRegion = CustomerRegion;
    }

    public int getCustomerApartmentNumber() {
        return customerModel.CustomerApartmentNumber;
    }

    public void setCustomerApartmentNumber(int CustomerApartmentNumber) {
        this.customerModel.CustomerApartmentNumber = CustomerApartmentNumber;
    }

    public int getCustomerFloorNumber() {
        return customerModel.CustomerFloorNumber;
    }

    public void setCustomerFloorNumber(int CustomerFloorNumber) {
        this.customerModel.CustomerFloorNumber = CustomerFloorNumber;
    }

    public int getCustomerMetercode() {
        return customerModel.CustomerMetercode;
    }

    public void setCustomerMetercode(int CustomerMetercode) {
        this.customerModel.CustomerMetercode = CustomerMetercode;
    }

    public String getCustomerComplain() {
        return customerModel.CustomerComplain;
    }

    public void setCustomerComplain(String CustomerComplain) {
        this.customerModel.CustomerComplain = CustomerComplain;
    }

    public void addCustomer() {
        try {
            AddUserModel addCustomer = new AddUserModel();
            addCustomer.AddCustomer(customerModel.CustomerFirstName, customerModel.CustomerLastName, customerModel.CustomerRegion, customerModel.CustomerStreetName, customerModel.CustomerStreetNumber, customerModel.CustomerFloorNumber, customerModel.CustomerApartmentNumber, customerModel.CustomerEmail, customerModel.CustomerPassword);
        } catch (SQLException ex) {
            database.showErrorDialog("SOMETHING WRONG !!!!");
        }
    }

    public boolean searchCustomer(int searchMetercode) {
        try {
            SearchUserModel searchCustomer = new SearchUserModel();
            database.getInstance();
            customerModel.sql = searchCustomer.SearchCustomer(searchMetercode);
            ResultSet exist = database.getRecords(customerModel.sql);
            while (exist.next()) {
                setCustomerMetercode(exist.getInt("METERCODE"));
                setCustomerFirstName(exist.getString("FIRSTNAME"));
                setCustomerLastName(exist.getString("LASTNAME"));
                setCustomerRegion(exist.getString("REGION"));
                setCustomerStreetName(exist.getString("STREETNAME"));
                setCustomerStreetNumber(exist.getInt("STREETNO"));
                setCustomerFloorNumber(exist.getInt("FLOORNO"));
                setCustomerEmail(exist.getString("EMAIL"));
                setCustomerPassword(exist.getInt("PASSWORD"));
                setCustomerIsFreeze(exist.getInt("isFreeze"));
                setCustomerComplain(exist.getString("compliment"));

                return true;
            }
        } catch (SQLException ex) {
            database.showErrorDialog("THE CUSTOMER METERCODE IS NOT FOUND PLEASE TRY AGAIN...");

        }
        return false;
    }

    public void updateCustomer() {
        UpdateUserModel updateCustomer = new UpdateUserModel();
        try {
            updateCustomer.UpdateCustomer(customerModel.CustomerMetercode, customerModel.CustomerFirstName, customerModel.CustomerLastName, customerModel.CustomerRegion, customerModel.CustomerStreetName, customerModel.CustomerStreetNumber, customerModel.CustomerFloorNumber, customerModel.CustomerEmail, customerModel.CustomerPassword, customerModel.CustomerComplain, customerModel.CustomerIsFreeze);

        } catch (SQLException ex) {
            database.showErrorDialog("SQL EXCEPTION !!!");
        }
    }

    public void deleteCustomer(int SearchKey) {
        int customerMetercode = SearchKey;
        DeleteUserModel deleteCustomer = new DeleteUserModel();
        try {
            deleteCustomer.DeleteCustomer(customerMetercode);

        } catch (SQLException ex) {
            database.showErrorDialog("SQL EXCEPTION !!!");
        }
    }

    public boolean consumptionStatistics(String Region) throws SQLException {
        try {
            database.getInstance();
            customerModel.sql = consumptionValue.CalCulateConsumption(Region);
            ResultSet exist = database.getRecords(customerModel.sql);
            while (exist.next()) {
                setConsumptionStatistics(exist.getInt("sum"));
                return true;
            }
        } catch (SQLException ex) {
            database.showErrorDialog("SQL EXCEPTION !!!");
        }
        return false;
    }

    public void showErrorDialog(String errorMessage) {
        database.showErrorDialog(errorMessage);
    }

    public void showInfoDialog(String infoMessage) {
        database.showInfoDialog(infoMessage);
    }
}
