/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author nguye
 */
public class DataProvider {
    private static Connection connection = null;
    private static ResultSet resultSet = null;
    //private static String URL = "jdbc:sqlserver://localhost//LAPTOP-FRMKN0GD//TIEN//SQLEXPRESS:1433;encrypt=true;trustServerCertificate=true;databaseName=CuaHangSach";
private static String URL = "jdbc:sqlserver://localhost:1433;databaseName=CuaHangSach;encrypt=true;trustServerCertificate=true";
    
    protected static ResultSet resultData(String query){
        try {
            connection = DriverManager.getConnection(URL, "sa", "123");
            resultSet = connection.createStatement().executeQuery(query);
            return resultSet;
        } catch (Exception e) {
            System.err.print("\nError resultData !!!\n");
        }
        return null;
    }
    
    
    protected static int UpdateData(String query){
        try {
            connection = DriverManager.getConnection(URL, "sa", "123");
            int value = connection.createStatement().executeUpdate(query);
            return value;
        } catch (Exception e) {
            System.err.print("\nError UpdateData !!!\n");
        }
        return 0;
    }
    
    protected static void CloseConnection(){
        try {
            connection.close();
            resultSet.close();
        } catch (Exception e) {
            System.err.print("\nError CloseConnection !!!\n");
        }
    }
}
