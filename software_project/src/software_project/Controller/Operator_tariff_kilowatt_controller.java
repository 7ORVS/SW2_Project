/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software_project.Controller;

import java.sql.SQLException;
import software_project.Model.Operator_model;

/**
 *
 * @author tarek&sohaila
 */
public class Operator_tariff_kilowatt_controller {
    
    public int calc_kilowatt (int current_reading , int last_reading )
    {
        int kilowatt = current_reading - last_reading;
        return kilowatt;
    } 
    
    public int Define_kilowatt_level (int kilowatt)
    {
        int level = 1;
        if (kilowatt>=0 && kilowatt<=100)
            level = 2;
        else if(kilowatt>100 && kilowatt<=500)
            level = 3;
        else if(kilowatt>500 && kilowatt<=1000)
            level = 4;
        else if (kilowatt>1000 && kilowatt<=1500)
            level = 5;
        else if (kilowatt >1500 && kilowatt <=2000)
            level = 6;
        else
            level = 7;
  
        return level;
    }
    
    public void Define_Tariffs_values (int level , float tariff) throws ClassNotFoundException, SQLException
    {
        Operator_model.Update_tariff(level, tariff);
    }
}

//    public void tariff_control (int metercode) throws ClassNotFoundException, SQLException
//    {
//       int last_reading = Reading_model.GetLastReading(metercode);
//       int reading = 200;
//       int kilowatt = this.calc_kilowatt(reading, last_reading);
//       int level = this.Define_kilowatt_level(kilowatt);
//       float tariff = Tariff_Kilowatt_model.Get_tariff(level);
//       Tariff_Kilowatt_model.UpdateTariff(tariff, metercode);
//    }