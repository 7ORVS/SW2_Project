package software_project.Controller;

import software_project.Controller.Operator_bills_controller;
import java.sql.SQLException;
import java.util.ArrayList;
import software_project.Model.OldCustomerModel;
public class OldCustomerController {
    public boolean LogInController (long metercode , String email) throws SQLException, ClassNotFoundException
    {
        OldCustomerModel c1 = new OldCustomerModel() ;
        return c1.LogIn(metercode , email) ;
    }
    
    public boolean IsFreezingController(long metercode) throws SQLException, ClassNotFoundException
    {
        OldCustomerModel c1 = new OldCustomerModel() ;
        return c1.IsFreezing(metercode);
    }
    
    public ArrayList BillsOfSpecificMeterCodeController (long metercode) throws ClassNotFoundException, SQLException
    {
        OldCustomerModel c1 = new OldCustomerModel() ;
        return c1.BillsOfSpecificMeterCode(metercode) ;
    }
    
    public void MakeComplainController (long metercode , String complain) throws ClassNotFoundException, SQLException
    {
        OldCustomerModel c1 = new OldCustomerModel() ;
        c1.MakeComplain(metercode, complain);
    }
    
    public boolean PaybillsController (long metercode , int BillNumber) throws ClassNotFoundException, SQLException
    {
        OldCustomerModel c1 = new OldCustomerModel() ;
        return c1.Paybills(metercode, BillNumber) ;
    }
    
    public boolean EnterReadingController (int reading , long metercode) throws SQLException, ClassNotFoundException
    {
        
        OldCustomerModel c1 = new OldCustomerModel() ;
        return c1.EnterReading(reading, metercode) ;
    }
    
    public void UpdateReadingController (int reading , long metercode) throws SQLException, ClassNotFoundException
    {
        Operator_bills_controller bill_creator = new Operator_bills_controller();
        bill_creator.create_bill(reading, (int)metercode);
        OldCustomerModel c1 = new OldCustomerModel() ;
        c1.UpdateReading(reading, metercode);
        
    }
    
    
}
