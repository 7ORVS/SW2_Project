/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software_project.Controller;

import java.sql.SQLException;
import software_project.Model.Operator_model;
//import software_project.Operator_model.Metercode_model;
/**
 *
 * @author hp
 */
public class Operator_metercode_controller {
    public void Stop_metercode (int metercode) throws ClassNotFoundException, SQLException
    {
        if(validate_metercode(metercode)){
        Operator_model.Stop_metercode(metercode);
        }
        else
            System.out.println("this metercode doesn't exist");
    }
//////////////////////////////////////////////////////////////////////////////////////////////    
    public void Restart_metercode (int metercode) throws ClassNotFoundException, SQLException
    {
        if(validate_metercode(metercode)){
            Operator_model.Unfreeze_metercode(metercode);
        }
        else
            System.out.println("this metercode doesn't exist");
    }
/////////////////////////////////////////////////////////////////////////////////////////////////
 public boolean validate_metercode (int metercode) throws ClassNotFoundException, SQLException
    {
      return Operator_model.validate_metercode(metercode);
    }

}



