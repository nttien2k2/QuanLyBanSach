/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Sach_DTO;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author nguye
 */
public class Sach_DAO extends DataProvider{
    public static ArrayList<Sach_DTO> getListSach(){  
        String query = "select * from SACH where SoLuong > 0";
        try {
            ResultSet result = resultData(query);
            ArrayList<Sach_DTO> l_Sachs = new ArrayList<Sach_DTO>();
            while(result.next()){
                Sach_DTO sach = new Sach_DTO();
                sach.setMaSach(result.getString(1));
                sach.setTenSach(result.getString(2));
                sach.setGia(Double.valueOf(result.getString(3)));
                sach.setSoLuong(Integer.valueOf(result.getString(4)));
                sach.setTacGia(result.getString(5));
                sach.setNgayXuatBan(Date.valueOf(result.getString(6)));
                sach.setNhaXuatBan(result.getString(7));
                sach.setTheLoai(TheLoai_DAO.getTheLoai(result.getString(8)));
                
                l_Sachs.add(sach);
            }
            CloseConnection();
            return l_Sachs;
        } catch (Exception e) {
             System.err.print("\nError getListSach !!!!");
        }
        
        return null;
    }
    
    
    public static int addNewSach(String maSach, String tenSach, String gia, String soLuong, String tacGia, String ngayXuatBan, String nhaXuatBan, String maTheLoai){        
        String query = "insert into SACH values ('" + maSach + "', N'" + tenSach +"', " + gia + ", " + soLuong + ", N'" + tacGia + "', '" + ngayXuatBan + "', N'" + nhaXuatBan + "', '" + maTheLoai + "')";
        int result = UpdateData(query);
        CloseConnection();
        return result;
    }
    
    public static int updateSach(String maSach, String tenSach, String gia, String soLuong, String tacGia, String ngayXuatBan, String nhaXuatBan, String maTL){
        String query = "exec dbo.UpdateSach "
                + "'" + maSach + "', N'" + tenSach + "', " 
                + gia + ", " + soLuong + ", N'" + tacGia +"', '" 
                + ngayXuatBan + "', N'" + nhaXuatBan + "', '" + maTL + "'"; 
        
        int result = UpdateData(query);
        CloseConnection();
        return result;
    }
    
    public static int xoaSach(String maSach){
        String query = "delete from SACH where MaSach = '" + maSach + "'";
        int result = UpdateData(query);
        CloseConnection();
        return result;
    }
    
    public static String getMaSach(String tenSach){
        String query = "select MaSach from SACH where TenSach = N'" + tenSach + "'";
        try {
            ResultSet result = resultData(query);
            result.next();
            String maSach = result.getString(1);
            CloseConnection();
            return maSach;
        } catch (Exception e) {
            System.err.print("\nError getMaSach !!!!");
        }
        return null;
    }
}   
