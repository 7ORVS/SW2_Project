/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software_project;

import java.sql.Date;

public class GetBillsOfSpecificMeterCode {
    long MeterCode ;
    String region ;
    int KiloWatt ;
    float Tariff ;
    Date EnterDate ;

    public GetBillsOfSpecificMeterCode(long MeterCode, String region, int KiloWatt, float Tariff, Date EnterDate) {
        this.MeterCode = MeterCode;
        this.region = region;
        this.KiloWatt = KiloWatt;
        this.Tariff = Tariff;
        this.EnterDate = EnterDate;
    }
    
}
