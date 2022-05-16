/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software_project;

import java.sql.SQLException;

/**
 *
 * @author HP
 */
public  class NewCustomerController {
    public boolean CheckEmailValidationController (String email) throws ClassNotFoundException, SQLException
    {
        NewCustomerModel c1 = new NewCustomerModel() ;
        return c1.CheckEmailValidation(email);
    }
}
