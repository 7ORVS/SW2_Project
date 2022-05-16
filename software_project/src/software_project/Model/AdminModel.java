package software_project.Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class AdminModel {


    public String AdminUsername;
    public int AdminPassword;
    public int AdminID;
    int result;
    public String sql;
      
    public String getAdminUsername() {
        return AdminUsername;
    }

    public void setAdminUsername(String AdminUsername) {
        this.AdminUsername = AdminUsername;
    }

    public int getAdminPassword() {
        return AdminPassword;
    }

    public void setAdminPassword(int AdminPassword) {
        this.AdminPassword = AdminPassword;
    }

    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int AdminID) {
        this.AdminID = AdminID;
    }

}
