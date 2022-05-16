package software_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static software_project.connection.connect;

public class NewCustomerModel {

    public NewCustomerModel() {
    }
     public boolean CheckEmailValidation(String Email) throws ClassNotFoundException, SQLException
     {
        Connection con = connect();
        PreparedStatement pstmt = con.prepareStatement("select email from information");
        ResultSet rs=pstmt.executeQuery();
        while(rs.next())
        {
            if(Email.equals(rs.getString("email")))
            {
                return false ;
            }
        }
        return true ; 
     }
}
