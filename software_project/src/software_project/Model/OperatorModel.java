package software_project.Model;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class OperatorModel {
    public String OperatorUsername;
    public int OperatorPassword;
    public int OperatorID;
    public String OperatorRegion;
    int result;
    public String sql;

    public String getOperatorUsername() {
        return OperatorUsername;
    }

    public void setOperatorUsername(String OperatorUsername) {
        this.OperatorUsername = OperatorUsername;
    }

    public int getOperatorPassword() {
        return OperatorPassword;
    }

    public void setOperatorPassword(int OperatorPassword) {
        this.OperatorPassword = OperatorPassword;
    }

    public int getOperatorID() {
        return OperatorID;
    }

    public void setOperatorID(int OperatorID) {
        this.OperatorID = OperatorID;
    }

    public String getOperatorRegion() {
        return OperatorRegion;
    }

    public void setOperatorRegion(String OperatorRegion) {
        this.OperatorRegion = OperatorRegion;
    }
}
