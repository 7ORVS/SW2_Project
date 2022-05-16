/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software_project.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import  software_project.connection;


/**
 *
 * @author ALMASA
 */
public class Model {

    private long metercode;
    private int billvalue;
    private String region;
    Connection connect = null;
    PreparedStatement statement = null;
    ResultSet result = null;
    

    public long getmetercode() {
        return metercode;
    }

    public void setmetercode(long metercode) {
        this.metercode = metercode;
    }

    public int getbill() {
        return billvalue;
    }

    public void setbill(int bill) {
        this.billvalue = bill;
    }

    public String getregion() {
        return region;
    }

    public void setregion(String region) {
        this.region = region;
    }
    
    public ResultSet ConnectionWithDatabase(String sql) throws SQLException {
        connect = connection.getconnection();
        statement = connect.prepareStatement(sql);
        result = statement.executeQuery();
        return result;
    }

    public void CloseConnection() throws SQLException {
        result.close();
        statement.close();
        connect.close();
    }
    
    public String QueryOfViewBill() throws SQLException {
        String sql , Region;
        Region = getregion();
        sql = "select * from bill where region ='" + Region + "'";
        return sql;
    }

    public String QueryOfLoginAdmin() throws SQLException {
        String sql;
        sql = "select username,pass from admin";
        return sql;
    }
     public String QueryOfLoginCustomer() throws SQLException {
        String sql;
        sql = "select username,password from information";
        return sql;
    }
      public String QueryOfLoginOperator() throws SQLException {
        String sql;
        sql = "select username,pass from operator";
        return sql;
    }

    public String QueryOfCollectedTotal() throws SQLException {
        String sql;
        sql = "Select SUM(billvalue) AS sum from bill where isCollected=0";
        return sql;
    }

    public void QueryOfUpdateCollected() throws SQLException {
        String sql;
        sql = "update bill set isCollected = 1 ";
        connect = connection.getconnection();
        statement = connect.prepareStatement(sql);
        statement.executeUpdate();
    }
    
}
