/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.ControllerDokter.conn;
import Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author V for Vladimir
 */
public class ControllerStaff {
    
    public static Staff getStaff(String username){
        conn.connect();
        Staff staff = new Staff();
        String query = "SELECT * FROM staff WHERE username='" + username + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                staff.setUsername(rs.getString("username"));
                staff.setPassword(rs.getString("password"));
                staff.setIdCabang(rs.getString("ID_cabang"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (staff);
    }
    
    public static Cabang getCabang(String id){
        conn.connect();
        Cabang cabang = new Cabang();
        String query = "SELECT * FROM cabang WHERE ID_cabang = '" + id + "'";
        try {
            Statement stmt = conn.con.createStatement();
            System.out.println(id);
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                cabang.setAlamat(rs.getString("Alamat"));
                cabang.setTelepon(rs.getString("No_telepon"));
                cabang.setNama(rs.getString("Nama_cabang"));
            }
            return(cabang);
        } catch (SQLException e) {
            e.printStackTrace();
            return(null);
        }
    }
}
