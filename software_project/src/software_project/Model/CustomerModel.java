package software_project.Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class CustomerModel {
     public String CustomerFirstName;
    public String CustomerLastName;
    public int CustomerPassword;
    public String CustomerEmail;
    public int CustomerStreetNumber;
    public String CustomerStreetName;
    public String CustomerRegion;
    public int CustomerApartmentNumber;
    public int CustomerFloorNumber;
    public int CustomerMetercode;
    public String CustomerComplain;
    public int CustomerMonthlyBillReading;
    public int CustomerIsFreeze;
    public int ConsumptionStatistics;
    int result;
    public String sql;

    public int getCustomerIsFreeze() {
        return CustomerIsFreeze;
    }

    public void setCustomerIsFreeze(int CustomerIsFreeze) {
        this.CustomerIsFreeze = CustomerIsFreeze;
    }

    public int getCustomerMonthlyBillReading() {
        return CustomerMonthlyBillReading;
    }

    public void setCustomerMonthlyBillReading(int CustomerMonthlyBillReading) {
        this.CustomerMonthlyBillReading = CustomerMonthlyBillReading;
    }

    public int getConsumptionStatistics() {
        return ConsumptionStatistics;
    }

    public void setConsumptionStatistics(int ConsumptionStatistics) {
        this.ConsumptionStatistics = ConsumptionStatistics;
    }

    public String getCustomerFirstName() {
        return CustomerFirstName;
    }

    public void setCustomerFirstName(String CustomerFirstName) {
        this.CustomerFirstName = CustomerFirstName;
    }

    public String getCustomerLastName() {
        return CustomerLastName;
    }

    public void setCustomerLastName(String CustomerLastName) {
        this.CustomerLastName = CustomerLastName;
    }

    public int getCustomerPassword() {
        return CustomerPassword;
    }

    public void setCustomerPassword(int CustomerPassword) {
        this.CustomerPassword = CustomerPassword;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String CustomerEmail) {
        this.CustomerEmail = CustomerEmail;
    }

    public int getCustomerStreetNumber() {
        return CustomerStreetNumber;
    }

    public void setCustomerStreetNumber(int CustomerStreetNumber) {
        this.CustomerStreetNumber = CustomerStreetNumber;
    }

    public String getCustomerStreetName() {
        return CustomerStreetName;
    }

    public void setCustomerStreetName(String CustomerStreetName) {
        this.CustomerStreetName = CustomerStreetName;
    }

    public String getCustomerRegion() {
        return CustomerRegion;
    }

    public void setCustomerRegion(String CustomerRegion) {
        this.CustomerRegion = CustomerRegion;
    }

    public int getCustomerApartmentNumber() {
        return CustomerApartmentNumber;
    }

    public void setCustomerApartmentNumber(int CustomerApartmentNumber) {
        this.CustomerApartmentNumber = CustomerApartmentNumber;
    }

    public int getCustomerFloorNumber() {
        return CustomerFloorNumber;
    }

    public void setCustomerFloorNumber(int CustomerFloorNumber) {
        this.CustomerFloorNumber = CustomerFloorNumber;
    }

    public int getCustomerMetercode() {
        return CustomerMetercode;
    }

    public void setCustomerMetercode(int CustomerMetercode) {
        this.CustomerMetercode = CustomerMetercode;
    }

    public String getCustomerComplain() {
        return CustomerComplain;
    }

    public void setCustomerComplain(String CustomerComplain) {
        this.CustomerComplain = CustomerComplain;
    }

}
