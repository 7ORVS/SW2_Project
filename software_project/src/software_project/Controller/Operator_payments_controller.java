/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software_project.Controller;
import java.sql.SQLException;
import software_project.Model.Operator_model;
//import software_project.Operator_model.Tariff_Kilowatt_model;
/**
 *
 * @author hp
 */
public class Operator_payments_controller {
    
    public float payment_controller (int metercode) throws ClassNotFoundException, SQLException
    {
        float payment = 0;
        
        Object[] kilowatt_tariff = new Object[2];
        
        kilowatt_tariff = Operator_model.get_kilowatt_tariff(metercode);
       
        payment = this.calc_payment(kilowatt_tariff);
        return payment;
    }
 //then return payment to view
////////////////////////////////////////////////////////////////////
    public float calc_payment (Object [] data)
    {
        int kilowatt = (int) data[0];
        float tariff = (float) data[1];
        float payment = kilowatt*tariff;
        return payment;
    } 
    public float Collect_payment (int metercode) throws ClassNotFoundException, SQLException
    {
         float Total_payments = Operator_model.Get_payments(metercode);
         
         return Total_payments;
    }
    
}
