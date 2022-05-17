/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software_project.Controller;

/**
 *
 * @author hp
 */
public class Generate_metercode {
    public static int Generate_metercode ()
    {
        int mc=(int) (Math.random()*1000000000);
        String metercode=mc+"";  
        int code = Integer.parseInt(metercode);
        return code;
    }
}
