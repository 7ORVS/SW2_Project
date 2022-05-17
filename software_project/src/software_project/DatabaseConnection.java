package software_project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class DatabaseConnection {


    public static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Electricbills;encrypt=true;trustServerCertificate=true;";
    public static final String USER_NAME = "tarek";
    public static final String PASSWORD = "1362001116";
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;
    public static DatabaseConnection database;
    public DatabaseConnection getInstance() throws SQLException {
        if (database==null) {
            database = new DatabaseConnection();
            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
            statement = connection.createStatement();
        }
        return database;
    }
    public int update(String query) throws SQLException {
        return statement.executeUpdate(query);
    }
    public ResultSet getRecords(String query) throws SQLException {
        resultSet = statement.executeQuery(query);
        return resultSet;
    }
    public  void showErrorDialog(String errorMessage) {
        JOptionPane.showMessageDialog(null,errorMessage,"Error",JOptionPane.ERROR_MESSAGE);
    }
    public void showInfoDialog(String infoMessage) {
        JOptionPane.showMessageDialog(null,infoMessage,"Information",JOptionPane.INFORMATION_MESSAGE);
    }
}

    
   

