package software_project.Controller;


import java.sql.ResultSet;
import java.sql.SQLException;
import software_project.Model.AdminModel;
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
public class AdministratorController {

    DatabaseConnection database = new DatabaseConnection();
    AdminModel adminModel = new AdminModel();

//    public String AdminUsername;
//    public int AdminPassword;
//    public int AdminID;
//    int result;
//    String sql;
    //String mylist[] = new String[100] ;
    //int size=0,i=0,c;
//    public AdministratorController() {
//        this.AdminUsername = AdminUsername;
//        this.AdminPassword = AdminPassword;
//        this.AdminID = AdminID;
//        
//    }
    public String getAdminUsername() {
        return adminModel.getAdminUsername();
    }

    public void setAdminUsername(String AdminUsername) {
        this.adminModel.AdminUsername = AdminUsername;
    }

    public int getAdminPassword() {
        return adminModel.getAdminPassword();
    }

    public void setAdminPassword(int AdminPassword) {
        this.adminModel.AdminPassword = AdminPassword;
    }

    public int getAdminID() {
        return adminModel.getAdminID();
    }

    public void setAdminID(int AdminID) {
        this.adminModel.AdminID = AdminID;
    }

    public void addAdministrator() {
        try {
            AddUserModel addAdmin = new AddUserModel();
            addAdmin.AddAdmin(adminModel.AdminUsername, adminModel.AdminPassword, adminModel.AdminID);
        } catch (SQLException ex) {
            database.showErrorDialog("SOMETHING WRONG !!!!");
        }
    }

    public boolean searchAdministrator(int searchID) {
        try {
            SearchUserModel searchAdmin = new SearchUserModel();

            database.getInstance();
            adminModel.sql = searchAdmin.SearchAdmin(searchID);
            ResultSet exist = database.getRecords(adminModel.sql);
            while (exist.next()) {
                setAdminUsername(exist.getString("USERNAME"));
                setAdminPassword(exist.getInt("PASS"));
                setAdminID(exist.getInt("ID"));

                return true;
            }
        } catch (SQLException ex) {
            database.showErrorDialog("THE ADMIN ID IS NOT FOUND PLEASE TRY AGAIN...");
        }
        return false;
    }

    public void updateAdministrator() {
        try {
            UpdateUserModel updateAdmin = new UpdateUserModel();
            updateAdmin.UpdateAdmin(adminModel.AdminUsername, adminModel.AdminPassword, adminModel.AdminID);

        } catch (SQLException ex) {
            database.showErrorDialog("SQL EXCEPTION !!!");
        }
    }

    public void deleteAdministrator(int SearchKey) {
        int adminID = SearchKey;
        try {
            DeleteUserModel deleteAdmin = new DeleteUserModel();
            deleteAdmin.DeleteAdmin(adminID);

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
