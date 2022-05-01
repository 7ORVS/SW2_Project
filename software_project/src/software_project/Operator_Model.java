/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software_project;

import java.sql.*;
import static software_project.connection.connect;


/**
 *
 * @author hp
 */
public class Operator_Model {
    
    public void hello ()
    {
        System.out.println("hello");
        System.out.println("this is the test string");
    }
    
    public Object[] printbill (int metercode) throws ClassNotFoundException, SQLException
    {
        Object[] array = new Object[10];
        try{
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("Select  firstname, lastname, region , streetname, streetno, floorno , apartmentno , id , nowcode  , kilowatt  from information where metercode = ?");
        pstmt.setInt(1, metercode);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next())
        {
            array[0] = rs.getString(1);
            array[1] = rs.getString(2);
            array[2] = rs.getString(3);
            array[3] = rs.getString(4);
            array[4] = rs.getInt(5);
            array[5] = rs.getInt(6);
            array[6] = rs.getInt(7);
            array[7] = rs.getInt(8);
            array[8] = rs.getInt(9);
            array[9] = rs.getInt(10);
        }
       con.close();
        }
        catch (ClassNotFoundException | SQLException e) {}
      return array;
    }
    public Object[] viewbills (String region)throws ClassNotFoundException, SQLException
    {
        Object[] array = new Object[9];
        try{
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("Select metercode, firstname, lastname, streetname, streetno, floorno, apartmentno, id, kilowatt from information where region = ?;");
        pstmt.setString(1, region);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next())
        {
           array[0] = rs.getInt(1);
           array[1] = rs.getString(2);
           array[2] = rs.getString(3);
           array[3] = rs.getString(4);
           array[4] = rs.getInt(5);
           array[5] = rs.getInt(6);
           array[6] = rs.getInt(7);
           array[7] = rs.getInt(8);
           array[8]= rs.getInt(9);
        }
       con.close();
        }
        catch (ClassNotFoundException | SQLException e) {System.out.print(e);}
      return array;
    }
    public int GetLastReading(int metercode) throws ClassNotFoundException, SQLException
    {
        Object[] array = new Object[9];
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("select kilowatt from information where metercode = ?");
        pstmt.setInt(1, metercode);
        ResultSet rs=pstmt.executeQuery();
        rs.next();
        int Reading = rs.getInt(1);
        return Reading;
    }
    public boolean UpdateReading(int metercode , int kilowatt) throws ClassNotFoundException, SQLException
    {
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("update information set kilowatt=? where metercode=?");
        pstmt.setInt(1, kilowatt);
        pstmt.setInt(2, metercode);
        pstmt.executeUpdate();
        return true;
    }
    public void StopMeterCode() throws ClassNotFoundException, SQLException
    {
        //query "update information set freeze = 1 where metercode=?"
    }
    public boolean UpdateTariff(float tax , int metercode) throws ClassNotFoundException, SQLException
    {
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("update information set taxs = ? where metercode=?");
        pstmt.setFloat(1, tax);
        pstmt.setInt(2, metercode);
        pstmt.executeUpdate();
        return true;
    }
    
}
