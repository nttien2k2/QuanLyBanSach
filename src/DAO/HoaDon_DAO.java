/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;

/**
 *
 * @author nguye
 */
public class HoaDon_DAO extends DataProvider{
    
    public static String getCountHoaDon(){
        String query = "select count(*) from HOADON";
        try {
            ResultSet result = resultData(query);
            result.next();
            String value = result.getString(1);
            CloseConnection();
            return value;
        } catch (Exception e) {
            System.err.print("\nError getCountHoaDon !!!!");
        }
        return null;
    }
    
    public static int addNewHoaDon(String maKH, String maNV, String ngayThanhToan){
        String query = "insert into HOADON values('" + maKH + "', '" + maNV + "', '" + ngayThanhToan + "', 0, 0)";
        int result = UpdateData(query);
        CloseConnection();
        return result;
    }
    
    public static String getMaHD(){
        String query = "select top(1) * from HOADON order by MaHoaDon desc";
        try {
            ResultSet result = resultData(query);
            result.next();
            String value = result.getString(1);
            CloseConnection();
            return value;
        } catch (Exception e) {
            System.err.print("\nError getMaHD !!!!");
        }
        return null;
    }
}
