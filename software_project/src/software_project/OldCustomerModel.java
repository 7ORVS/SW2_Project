/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software_project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import static software_project.connection.connect;

/**
 *
 * @author HP
 */
public class OldCustomerModel extends OldCustomerController{

    Scanner S = new Scanner(System.in) ;
    
    public OldCustomerModel() {
    }
    
    public boolean LogIn (long metercode , String email) throws SQLException, ClassNotFoundException
    {
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("select email,metercode from information where metercode = ? and email = ? ");
        pstmt.setLong(1, metercode);
        pstmt.setString(2,email);
        ResultSet rs=pstmt.executeQuery();
        
        while(rs.next())
        {
            if(metercode == rs.getLong("metercode") && email.equals(rs.getString("email")))
                return true ;
        }
        return false ;
    }
    public boolean EnterReading (int reading , long metercode) throws SQLException, ClassNotFoundException
    {
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("select reading from information where metercode = ?");
        pstmt.setLong(1, metercode);
        ResultSet rs=pstmt.executeQuery();
        
        rs.next();
        if(reading > rs.getInt("reading"))
            return true ;
        else
            return false ;
    }
    public void UpdateReading (int reading , long metercode) throws SQLException, ClassNotFoundException
    {
        boolean valid = EnterReading(reading , metercode) ;
        if(valid)
        {
            Connection con = connect();
            PreparedStatement pstmt = con.prepareStatement("update information set reading = ? where metercode = ? ");
            pstmt.setInt(1, reading);
            pstmt.setLong(2, metercode);
            pstmt.executeUpdate();
        }
    }
    public boolean IsFreezing (long metercode) throws SQLException, ClassNotFoundException
    {
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("select isFreeze from information where metercode = ?");
        pstmt.setLong(1, metercode);
        ResultSet rs=pstmt.executeQuery();
        rs.next() ;
        if(rs.getInt("isFreeze") == 1)
            return true ;
        else
            return false ;
    }
    /*
    public boolean IsFreezing (long metercode) throws SQLException, ClassNotFoundException
    {
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("select sum (ispaid) as sumNotPaid from bill where metercode = ?");
        pstmt.setLong(1, metercode);
        ResultSet rs=pstmt.executeQuery();
        
        rs.next() ;
        if(rs.getInt("sumNotPaid") >= 3)
            return true ;
        else
            return false ;
    }
    
    public void UpdateFreezingState (long metercode) throws SQLException, ClassNotFoundException
    {
        if(IsFreezing(metercode))
        {
            Connection con = connect();
            PreparedStatement pstmt = con.prepareStatement("update information set isFreeze = ? where metercode = ?");
            pstmt.setFloat(1, 1);
            pstmt.setLong(2, metercode);
            pstmt.executeUpdate();
        }
    }
    */
    public void MakeComplain (long metercode , String complain) throws ClassNotFoundException, SQLException
    {
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("update information set compliment = ? where metercode = ?");
        pstmt.setString(1, complain);
        pstmt.setLong(2, metercode);
        pstmt.executeUpdate();
    }
    public ArrayList BillsOfSpecificMeterCode (long metercode) throws ClassNotFoundException, SQLException
    {
        ArrayList <GetBillsOfSpecificMeterCode> BillList = new ArrayList() ;
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("select metercode , region , kilowatt , tariff , Enter_date from bill where metercode = ? and isPaid = 1");
        pstmt.setLong(1, metercode);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next())
        {
            BillList.add(new GetBillsOfSpecificMeterCode (rs.getLong("metercode") , rs.getString("region") , rs.getInt("kilowatt") , rs.getFloat("tariff") , rs.getDate("Enter_date")));
        }
        return BillList ;
    }
    
    /*public void Getbills (long metercode) throws ClassNotFoundException, SQLException
    {
        ArrayList <GetBillsOfSpecificMeterCode> BillList = new ArrayList() ;
        BillList = BillsOfSpecificMeterCode(metercode) ;
        for(int i = 0 ; i < BillList.size() ; i++)
        {
            System.out.println(BillList.get(i).MeterCode + " " + BillList.get(i).region + " " + BillList.get(i).KiloWatt + " " + BillList.get(i).Tariff + " " + BillList.get(i).EnterDate);
        }
    }
    */
    public boolean Paybills (long metercode , int BillNumber) throws ClassNotFoundException, SQLException
    {
        ArrayList <GetBillsOfSpecificMeterCode> BillList = new ArrayList() ;
        BillList = BillsOfSpecificMeterCode(metercode) ;
        
        if(BillNumber >= 1 && BillNumber <= BillList.size())
        {
            BillNumber-- ;
            Connection con = connect();
            PreparedStatement pstmt = con.prepareStatement("update bill set isPaid = 0 where metercode =  ? and  region = ? and  kilowatt = ?  and tariff = ?");
            pstmt.setLong(1, BillList.get(BillNumber).MeterCode);
            pstmt.setString(2, BillList.get(BillNumber).region);
            pstmt.setInt(3, BillList.get(BillNumber).KiloWatt);
            pstmt.setFloat(4, BillList.get(BillNumber).Tariff);
            pstmt.executeUpdate();
            return true ;
        }
        else
        {
            return false ;
        }
    }
}
