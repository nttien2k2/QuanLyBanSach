/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author nguye
 */
public class CT_HoaDon_DAO extends DataProvider{
    public static int addNewCT_HoaDon(String maHD, String maKhach, String sl, String giamGia, String thanhTien){
 
        String query = "insert into CT_HOADON values('" + maHD + "', '" + maKhach + "', " + sl + ", '" + giamGia + "', " + thanhTien + ")";
        int result = UpdateData(query);
        CloseConnection();
        return result;
    }
}
