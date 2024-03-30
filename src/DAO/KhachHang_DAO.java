/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.KhachHang_DTO;
import java.sql.*;

/**
 *
 * @author nguye
 */
public class KhachHang_DAO extends DataProvider{
    public static int addNewKhachHang(String maKH, String tenKH, String sdtKH, String gtKH, String dcKH){
        String query = "insert into KHACHHANG values('" + maKH + "', N'" + tenKH + "', '" + sdtKH + "', N'" + gtKH + "', N'" + dcKH + "', 0)";
        int result = UpdateData(query);
        CloseConnection();
        return result;
    }
    
    public static String getKhachQuen(String maKH){
        String query = "select dbo.timKhachQuen('" + maKH + "')";
        try {
            ResultSet result = resultData(query);
            result.next();
            String value = result.getString(1);
            CloseConnection();
            return value;
        } catch (Exception e) {
            System.err.print("\nError getKhachQuen !!!!");
        }
        return null;
    }
    
    public static KhachHang_DTO getKhachHang(String maKH){
        String query = "select * from KHACHHANG where MaKH = '" + maKH + "'";
        try {
            ResultSet result = resultData(query);
            result.next();
            KhachHang_DTO khachhang = new KhachHang_DTO();
            khachhang.setMaKH(result.getString(1));
            khachhang.setTenKhach(result.getString(2));
            khachhang.setSdt(result.getString(3));
            khachhang.setGioiTinh(result.getString(4));
            khachhang.setDiaChi(result.getString(5));
            khachhang.setSoSachDaMua(Integer.parseInt(result.getString(6)));
            CloseConnection();
            return khachhang;
        } catch (Exception e) {
            System.err.print("\nError getKhachHang !!!!");
        }
        return null;
    }
}
