package software_project.Controller;


import java.sql.ResultSet;
import java.sql.SQLException;
import software_project.Model.OperatorModel;
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
public class OperatorController {

    OperatorModel operatorModel = new OperatorModel();
    DatabaseConnection database = new DatabaseConnection();

    public String getOperatorUsername() {
        return operatorModel.OperatorUsername;
    }

    public void setOperatorUsername(String OperatorUsername) {
        this.operatorModel.OperatorUsername = OperatorUsername;
    }

    public int getOperatorPassword() {
        return operatorModel.OperatorPassword;
    }

    public void setOperatorPassword(int OperatorPassword) {
        this.operatorModel.OperatorPassword = OperatorPassword;
    }

    public int getOperatorID() {
        return operatorModel.OperatorID;
    }

    public void setOperatorID(int OperatorID) {
        this.operatorModel.OperatorID = OperatorID;
    }

    public String getOperatorRegion() {
        return operatorModel.OperatorRegion;
    }

    public void setOperatorRegion(String OperatorRegion) {
        this.operatorModel.OperatorRegion = OperatorRegion;
    }

    public void addOperator() throws SQLException {
        AddUserModel addOperator = new AddUserModel();
        addOperator.AddOperator(operatorModel.OperatorUsername, operatorModel.OperatorRegion, operatorModel.OperatorPassword, operatorModel.OperatorID);

    }

    public boolean searchOperator(int searchID) {
        try {
             SearchUserModel searchOperator = new SearchUserModel();
            database.getInstance();
            operatorModel.sql = searchOperator.SearchOperator(searchID);
            ResultSet exist = database.getRecords(operatorModel.sql);
            while (exist.next()) {
                setOperatorUsername(exist.getString("USERNAME"));
                setOperatorPassword(exist.getInt("PASS"));
                setOperatorRegion(exist.getString("REGION"));
                setOperatorID(exist.getInt("ID"));
                return true;
            }
        } catch (SQLException ex) {
            database.showErrorDialog("THE OPERATOR ID IS NOT FOUND PLEASE TRY AGAIN...");
        }
        return false;
    }

    public void updateOperator() {
        try {
            UpdateUserModel updateOperator = new UpdateUserModel();
            updateOperator.UpdateOperator(operatorModel.OperatorUsername, operatorModel.OperatorPassword, operatorModel.OperatorRegion, operatorModel.OperatorID);

        } catch (SQLException ex) {
            database.showErrorDialog("SQL EXCEPTION !!!");
        }
    }

    public void deleteOperator(int SearchKey) {
        int operatorID = SearchKey;
        try {
            DeleteUserModel deleteOperator = new DeleteUserModel();
            deleteOperator.DeleteOperator(operatorID);
        } catch (SQLException ex) {
            database.showErrorDialog("SQL EXCEPTION !!!");
        }
    }
       public  void showErrorDialog(String errorMessage) {
                database.showErrorDialog(errorMessage);
    }
      public void showInfoDialog(String infoMessage) {
        database.showInfoDialog(infoMessage);
    }  
}
