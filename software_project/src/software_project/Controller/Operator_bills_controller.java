/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software_project.Controller; 

import java.sql.SQLException;
import software_project.Model.Operator_model;
//import software_project.Operator_model.Bill_model;
/*import software_project.Operator_model.collected;
import software_project.Operator_model.metercode;
import software_project.Operator_model.reading;
Operator_model/**
 *
 * @author hp
 */

public class Operator_bills_controller  {
    
    
    
    public static Object[] print_bill (int metercode) throws ClassNotFoundException, SQLException
    {
        
        Object[] bill_data = Operator_model.printbill(metercode);
        
        return bill_data;
    }
 //////////////////////////////////////////////////////////////////////////////////////////////////  
    public static void pay_bill (int metercode) throws ClassNotFoundException, SQLException
    {
       Operator_model.update_Pay_bill(metercode);
    }
    
    public void create_bill (int current_reading , int metercode) throws ClassNotFoundException, SQLException
    {
        int last_reading = Operator_model.GetLastReading(metercode);
        System.out.println(last_reading + " " + current_reading);
        Operator_tariff_kilowatt_controller kilowatt_control = new Operator_tariff_kilowatt_controller();
        int kilowatt = kilowatt_control.calc_kilowatt(current_reading, last_reading);
        System.out.println(kilowatt);
        int kilowatt_level = kilowatt_control.Define_kilowatt_level(kilowatt);
        float tariff_value = Operator_model.Get_tariff(kilowatt_level);
        String region = Operator_model.Get_region(metercode);
        float payment = kilowatt*tariff_value;
        Operator_model.Create_bill(metercode, region, kilowatt, tariff_value, payment);
    }
}
