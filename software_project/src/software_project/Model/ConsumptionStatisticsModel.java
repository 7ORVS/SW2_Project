package software_project.Model;


import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DELL
 */
public class ConsumptionStatisticsModel {
      public String CalCulateConsumption(String region) throws SQLException {
       String sql;
        sql = "select sum(kilowatt) AS sum from bill where region= '" + region + "'";
        return sql;
  }
}

