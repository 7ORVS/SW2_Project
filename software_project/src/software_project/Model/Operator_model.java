/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software_project.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static software_project.connectionT.connect;

/**
 *
 * @author sohai
 */
public class Operator_model {
     public static Object[] printbill (int metercode) throws ClassNotFoundException, SQLException
    {
         Object[] array = new Object[12];
        try{
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("select top(1) information.metercode , information.username, information.lastname , information.region, information.streetname, information.streetno , information.floorno , information.apartmentno , bill.kilowatt, bill.tariff , bill.Enter_date,bill.billvalue from information join bill on (information.metercode=bill.metercode and information.metercode=?) and bill.notPaid=0 and bill.isCollected=1");
        pstmt.setInt(1, metercode);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next())
        {
           array[0] = "METER-CODE  :"+ rs.getInt(1);
           array[1] = "FIRST-NAME  :"+rs.getString(2);
           array[2] = "LAST-NAME   :"+rs.getString(3);
           array[3] = "REGION     :"+rs.getString(4);
           array[4] = "STREET-NAME :"+ rs.getString(5);
           array[5] = "STREET-NUMBER    :"+ rs.getInt(6);
           array[6] = "FLOOR-NUMBER    :"+ rs.getInt(7);
           array[7] = "APARTMENT-NUMBER :"+rs.getInt(8);
           array[8] = "KILOWATT   :"+rs.getInt(9);
           array[9] = "TRAIFF     :"+rs.getFloat(10);
           array[10] = "ENTER-DATE :"+rs.getDate(11);
           array[11] = "Bil Value :"+rs.getFloat(12);
        }
       con.close();
        }
        catch (ClassNotFoundException | SQLException e) {}
      return array;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    public static Object[] viewbills (String region)throws ClassNotFoundException, SQLException
//    {
//        Object[] array = new Object[9];
//        try{
//        Connection con = connect();
//        PreparedStatement pstmt = con.prepareStatement("Select metercode, firstname, lastname, streetname, streetno, floorno, apartmentno, id, kilowatt from information where region = ?;");
//        pstmt.setString(1, region);
//        ResultSet rs=pstmt.executeQuery();
//        while(rs.next())
//        {
//           array[0] = rs.getInt(1);
//           array[1] = rs.getString(2);
//           array[2] = rs.getString(3);
//           array[3] = rs.getString(4);
//           array[4] = rs.getInt(5);
//           array[5] = rs.getInt(6);
//           array[6] = rs.getInt(7);
//           array[7] = rs.getInt(8);
//           array[8]= rs.getInt(9);
//        }
//       con.close();
//        }
//        catch (ClassNotFoundException | SQLException e) {System.out.print(e);}
//      return array;
//    }
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void update_Pay_bill (int metercode) throws ClassNotFoundException, SQLException
    {
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("update top(1) bill set notPaid = 0 where metercode=? and notPaid=1");
        pstmt.setInt(1, metercode);
        pstmt.executeUpdate();
    }  
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void update_collected (int metercode) throws ClassNotFoundException, SQLException
    {
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("update top(1) bill set isCollected = 1 where metercode=?");
        pstmt.setInt(1, metercode);
        pstmt.executeUpdate();
    }
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean validate_metercode (int metercode) throws ClassNotFoundException, SQLException
    {
        int meter =0;
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("select metercode from information where metercode = ?");
        pstmt.setInt(1, metercode);
        ResultSet rs=pstmt.executeQuery();
        rs.next();
        meter = rs.getInt(1);
        if(meter == 0 ) return false;
        else
            return true;
    }

 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void Stop_metercode (int metercode) throws ClassNotFoundException, SQLException
    {
      try{
        //query "update information set freeze = 1 where Metercode_model=?"
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("update information set isFreeze = 1 where metercode=?");
        pstmt.setInt(1, metercode);
        pstmt.executeUpdate();
      }
      catch (ClassNotFoundException | SQLException | NullPointerException ex) {
          System.out.println(ex.getMessage());
      }
    }
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void Unfreeze_metercode (int metercode) throws ClassNotFoundException, SQLException
    {
        try{
        //query "update information set freeze = 1 where Metercode_model=?"
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("update information set isFreeze = 0 where metercode=?");
        pstmt.setInt(1, metercode);
        pstmt.executeUpdate();
      }
      catch (ClassNotFoundException | SQLException | NullPointerException ex) {
          System.out.println(ex.getMessage());
      }
    }
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     public static int GetLastReading(int metercode) throws ClassNotFoundException, SQLException
    {
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("select reading from information where metercode = ?");
        pstmt.setInt(1, metercode);
        ResultSet rs=pstmt.executeQuery();
        rs.next();
        int Reading = rs.getInt(1);
        return Reading;
    }
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean UpdateReading(int metercode , int kilowatt) throws ClassNotFoundException, SQLException
    {
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("update information set kilowatt=? where metercode=?");
        pstmt.setInt(1, kilowatt);
        pstmt.setInt(2, metercode);
        pstmt.executeUpdate();
        return true;
    }

 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 //to collect payment
    public static Object[] get_kilowatt_tariff (int metercode) throws ClassNotFoundException, SQLException
    {
        Object[] data = new Object[2];
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("select top(1) kilowatt , tariff from bill where metercode = ? and notPaid =1");
        pstmt.setInt(1, metercode);
        ResultSet rs=pstmt.executeQuery();
        rs.next();
        data[0] = rs.getInt(1);
        data [1] = rs.getFloat(2);
        return data;
    }
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static float Get_tariff (int level ) throws ClassNotFoundException, SQLException
    {
        
        float tariff = 0;
        try{
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("select tariff from tariff where level = ?");
        pstmt.setInt(1, level);
        ResultSet rs=pstmt.executeQuery();
        rs.next();
        tariff = rs.getFloat(1);
      }
      catch (ClassNotFoundException | SQLException e )
      {
          System.out.println(e);
      }
        return tariff;
    }
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 public static void Update_tariff (int level , float tariff) throws ClassNotFoundException, SQLException
    {
        try{
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("update tariff set tariff = ? where level=?");
        pstmt.setFloat(1, tariff);
        pstmt.setInt(2, level);
        pstmt.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e )
      {
          System.out.println(e);
      }
    }
 //////////////////////////////////////////////////////////////////////////////////////////////////////////
 public static float Get_payments (int metercode) throws ClassNotFoundException, SQLException
 {
     float payments = 0;
     try
     {
         Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("select SUM(kilowatt*tariff) from bill where metercode=? and notPaid=0 and isCollected=0");
        PreparedStatement update = con.prepareStatement("update bill set isCollected = 1 where metercode=? and notPaid=0");
        pstmt.setInt(1, metercode);
        update.setInt(1 , metercode);
        ResultSet rs=pstmt.executeQuery();
        update.executeUpdate();
        rs.next();
        payments = rs.getFloat(1);
     } 
     catch (ClassNotFoundException | SQLException e )
      {
          System.out.println(e);
      }
         return payments;
 }
 //////////////////////////////////////////////////////////////////////////////////
    public static String Get_region (int metercode) throws ClassNotFoundException, SQLException
    {
        
        String region = "";
        try{
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("select region from information where metercode =?");
        pstmt.setInt(1, metercode);
        ResultSet rs=pstmt.executeQuery();
        rs.next();
        region = rs.getString(1);
        return region;
        }
     catch (ClassNotFoundException | SQLException e )
      {
          System.out.println(e);
          return "Error" ;
      }

    }
 /////////////////////////////////////////////////////////////////////   
   public static void Create_bill (int metercode , String region , int kilowatt , float tariff , float bill_value) throws ClassNotFoundException, SQLException
   {
       try{
           Connection con = connect();
           PreparedStatement insert_statement = con.prepareStatement("insert into bill (metercode , region , kilowatt , tariff , billvalue) values (?,?,?,?,?)");
           insert_statement.setInt(1,metercode);            
           insert_statement.setString(2, region);
           insert_statement.setInt(3,kilowatt);               
           insert_statement.setFloat(4,tariff);
           insert_statement.setFloat(5,bill_value);
           insert_statement.executeUpdate();
       }
       catch (ClassNotFoundException | SQLException e )
      {
          System.out.println(e.getMessage());
      }
   }
    
    
    
    
    
}

