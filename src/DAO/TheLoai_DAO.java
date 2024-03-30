/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TheLoai_DTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class TheLoai_DAO extends DataProvider{
    public static String getTheLoai(String maTL){
        String query = "select TL_Sach from THELOAI where MA_TL = '" + maTL + "'";
        try {
            ResultSet result = resultData(query);
            result.next();
            String value = result.getString(1);
            CloseConnection();
            return value;
        } catch (Exception e) {
            System.err.print("\nError getTheLoai !!!!");
        }
        return null;
    }
    
    public static String getMaTheLoai(String tenTL){
        String query = "select MA_TL from THELOAI where TL_Sach = N'" + tenTL + "'";
        try {
            ResultSet result = resultData(query);
            result.next();
            String value = result.getString(1);
            CloseConnection();
            return value;
        } catch (Exception e) {
             System.err.print("\nError getMaTheLoai !!!!");
        }
        return null;
    }
    
    public static ArrayList<TheLoai_DTO> getListTheLoai(){
        String query = "select * from THELOAI";
        try {
            ResultSet result = resultData(query);
            ArrayList<TheLoai_DTO> l_TheLoais = new ArrayList<TheLoai_DTO>();
            while(result.next()){
                TheLoai_DTO theloai = new TheLoai_DTO();
                theloai.setMa_TL(result.getString(1));
                theloai.setTl_Sach(result.getString(2));
                
                l_TheLoais.add(theloai);
            }
            CloseConnection();
            return l_TheLoais;
        } catch (Exception e) {
            System.err.print("\nError getListTheLoai !!!!");
        }
        
        return null;
    }
    
    public static int addNewTheLoai(String maTL, String tenTL){
        String query = "insert into THELOAI values('" + maTL + "', N'" + tenTL +"')";
        int result = UpdateData(query);
        CloseConnection();
        return result;
    }
    
    public static int updateTheLoai(String maTL, String theLoai){
        String query = "update THELOAI set TL_SACH = N'" + theLoai + "' where MA_TL = '" + maTL + "'";
        int result = UpdateData(query);
        CloseConnection();
        return result;
    }
    
    public static int deleteTheloai(String maTL){
        String query = "delete from THELOAI where MA_TL = '" + maTL + "'";
        int result = UpdateData(query);
        CloseConnection();
        return result;
    }
}
