/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software_project.Model;

import java.sql.Date;

public class GetBillsOfSpecificMeterCode {
    public long MeterCode ;
    public String region ;
    public int KiloWatt ;
    public float Tariff ;
    public Date EnterDate ;

    public GetBillsOfSpecificMeterCode(long MeterCode, String region, int KiloWatt, float Tariff, Date EnterDate) {
        this.MeterCode = MeterCode;
        this.region = region;
        this.KiloWatt = KiloWatt;
        this.Tariff = Tariff;
        this.EnterDate = EnterDate;
    }
    
}
