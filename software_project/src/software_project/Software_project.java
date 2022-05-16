///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
// */
//package software_project;
//
//import java.sql.SQLException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import static software_project.connection.connect;
//
///**
// *
// * @author hp
// */
//public class Software_project {
//
//    /**
//     * @param args the command line arguments
//     */
//    
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        System.out.println("hello world ...");
//        System.out.println("second commit test..");
//        Operator_Model model = new Operator_Model();
//        Object[] info = model.viewbills("rames");
//          for (int i=0;i<9;i++)
//        {
//            System.out.print(info[i]+"==");
//        }
//        System.out.println();
//        
//        int Reading = model.GetLastReading(1234506708);
//        
//        System.out.println(Reading);
//        
//        boolean result = model.UpdateReading(1023450670, 100);
//        System.out.println(result);
//        
//        boolean take = model.UpdateTariff(19, 1023450670);
//        System.out.println(take);
//    }
//    
//}
