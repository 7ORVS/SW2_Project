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
public class Operator_reading_controller {
    
    public boolean reading_validation (int reading , int metercode) throws ClassNotFoundException, SQLException
    {
        int last_reading = Operator_model.GetLastReading(metercode);   
        return this.Compare(reading, last_reading);
    }
    
    private boolean Compare (int current_reading , int last_reading)
    {
        if (current_reading>last_reading)
            return true;
        else
            return false;
    }
}
