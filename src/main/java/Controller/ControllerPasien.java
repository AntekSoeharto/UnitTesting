/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author hp
 */
public class ControllerPasien {
    public ControllerPasien(){
        
    }
    static DBHandler conn = new DBHandler();

    // SELECT ALL from table pasiens
    public static ArrayList<Pasien> getAllPasiens() {
        ArrayList<Pasien> pasiens = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM Pasien";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Pasien pasien = new Pasien();
                pasien.setNIK(rs.getString("NIK"));
                pasien.setNama(rs.getString("Nama"));
                pasien.setTglLahir((Date) rs.getObject("Tgl_lahir"));
                pasien.setGolDar(rs.getString("Goldar"));
                pasien.setGender(rs.getString("Gender"));
                pasien.setAlergi(rs.getString("Alergi"));
                pasien.setPenyakitMenurun(rs.getString("Penyakit_Menurun"));
                pasien.setAlamat(rs.getString("Alamat"));
                pasien.setTelepon(rs.getString("No_telepon"));
                pasiens.add(pasien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (pasiens);
    }

    // SELECT WHERE
    public static Pasien getPasien(String NIK) {
        conn.connect();
        String query = "SELECT * FROM Pasien WHERE NIK='" + NIK + "'";
        Pasien pasien = new Pasien();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                pasien.setNIK(rs.getString("NIK"));
                pasien.setNama(rs.getString("Nama"));
                pasien.setTglLahir((Date) rs.getObject("Tgl_lahir"));
                pasien.setGolDar(rs.getString("Goldar"));
                pasien.setGender(rs.getString("Gender"));
                pasien.setAlergi(rs.getString("Alergi"));
                pasien.setPenyakitMenurun(rs.getString("Penyakit_Menurun"));
                if(rs.getString("Golongan").equals("BPJS")){
                    pasien.setBPJS(GolonganPasien.BPJS);
                }else{
                    pasien.setBPJS(GolonganPasien.NON_BPJS);
                }
                pasien.setAlamat(rs.getString("Alamat"));
                pasien.setTelepon(rs.getString("No_telepon"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (pasien);
        
    }
    
    // INSERT
    public static boolean insertNewPasien(Pasien pasien) {
        conn.connect();
        String query = "INSERT INTO Pasien VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, pasien.getNIK());
            stmt.setString(2, pasien.getNama());
            stmt.setObject(3, pasien.getTglLahir());
            stmt.setString(4, String.valueOf(pasien.getGolDar()));
            stmt.setString(5, pasien.getGender());
            stmt.setString(6, pasien.getAlergi());
            stmt.setString(7, pasien.getPenyakitMenurun());
            stmt.setObject(8, String.valueOf(pasien.getBPJS()));
            stmt.setString(9, pasien.getTelepon());
            stmt.setString(10, pasien.getAlamat());
            stmt.setString(11, Singleton.getInstance().getStaff().getIdCabang());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // UPDATE
    public static boolean updatePasien(String Golongan,String Alamat,String Telepon,String NIK) {
        conn.connect();
        String query = "UPDATE Pasien SET Golongan='" + Golongan + "', "
                + "Alamat='" + Alamat+ "', "
                + "No_telepon='" + Telepon+ "' "
                + " WHERE NIK='" + NIK+ "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // DELETE
    public static boolean deletePasien(String NIK) {
        conn.connect();

        String query = "DELETE FROM Pasien WHERE NIK='" + NIK + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
