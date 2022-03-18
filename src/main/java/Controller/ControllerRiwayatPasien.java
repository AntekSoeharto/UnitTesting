/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RiwayatPasien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author V for Vladimir
 */
public class ControllerRiwayatPasien {
    public ControllerRiwayatPasien(){
        
    }
    static DBHandler conn = new DBHandler();

    // SELECT ALL from table RPs
    public static ArrayList<RiwayatPasien> getAllRiwayatPasiens() {
        ArrayList<RiwayatPasien> RPs = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM Riwayat_Pasien";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                RiwayatPasien RP = new RiwayatPasien();
                RP.setPenyakit(rs.getString("Penyakit"));
                RP.setTanggalKunjungan((Date) rs.getObject("Tgl_kunjungan"));
                RP.setKeluhan(rs.getString("Keluhan"));
                RP.setResepObat(getResepObatPasien());
                RPs.add(RP);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (RPs);
    }
    public static ArrayList<RiwayatPasien> getAllRiwayatPasiens(String NIK) {
        ArrayList<RiwayatPasien> RPs = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM Riwayat_Pasien WHERE NIK = '" + NIK + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                RiwayatPasien RP = new RiwayatPasien();
                RP.setPenyakit(rs.getString("Penyakit"));
                RP.setTanggalKunjungan((Date) rs.getObject("Tgl_kunjungan"));
                RP.setKeluhan(rs.getString("Keluhan"));
                RPs.add(RP);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (RPs);
    }
    // SELECT WHERE
    public static RiwayatPasien getRiwayatPasien(String NIK) {
        conn.connect();
        String query = "SELECT * FROM Riwayat_Pasien WHERE NIK='" + NIK + "'";
        RiwayatPasien RP = new RiwayatPasien();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                RP.setPenyakit(rs.getString("Penyakit"));
                RP.setTanggalKunjungan((Date) rs.getObject("Tgl_kunjungan"));
                RP.setKeluhan(rs.getString("Keluhan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (RP);
        
    }
    
    // INSERT
    public static boolean insertNewRiwayatPasien(RiwayatPasien RP,String NIK) {
        conn.connect();
        String query = "INSERT INTO Riwayat_Pasien VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, getLastIDFromRiwayatPasien(NIK));
            stmt.setString(2, RP.getPenyakit());
            stmt.setObject(3, RP.getTanggalKunjungan());
            stmt.setString(4, RP.getKeluhan());
            stmt.setString(5, NIK);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // UPDATE
    public static boolean updateRiwayatPasien(String Penyakit,Date tglKunjungan,String Keluhan,String NIK) {
        conn.connect();
        String query = "UPDATE Riwayat_Pasien SET Penyakit='" + Penyakit + "', "
                + "Tgl_kunjungan='" + tglKunjungan+ "', "
                + "Keluhan='" + Keluhan+ "' "
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
    public static boolean deleteRiwayatPasien(String NIK) {
        conn.connect();

        String query = "DELETE FROM Riwayat_Pasien WHERE ID_pasien='" + NIK + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static int getLastIDFromRiwayatPasien(String NIK){
        int ID = 0;
        conn.connect();
        String query = "SELECT ID_Riwayat FROM riwayat_pasien ORDER BY ID_Riwayat DESC LIMIT 1";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ID = rs.getInt("ID_Riwayat");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ID + 1);
    }
    public static ArrayList<String> getResepObatPasien(){
        ArrayList<String> resepObat = new ArrayList<>();
        conn.connect();
        String query = "SELECT a.Nama_obat "
                + "FROM obat a,Resep_Obat_Pasien b,riwayat_pasien c "
                + "WHERE a.ID_Obat = b.ID_Obat "
                + "AND b.NIK = c.NIK ";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String RO = new String();
                RO = rs.getString("Nama_obat");
                resepObat.add(RO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resepObat;
    }
    public static ArrayList<String> getResepObat1Pasien(String NIK){
        ArrayList<String> resepObat = new ArrayList<>();
        conn.connect();
        String query = "SELECT a.Nama_obat "
                + "FROM obat a,Resep_Obat_Pasien b,riwayat_pasien c,pasien d "
                + "WHERE a.ID_Obat = b.ID_Obat "
                + "AND b.NIK = c.NIK "
                + "AND c.NIK = d.NIK "
                + "AND d.NIK = " + NIK;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String RO = new String();
                RO = rs.getString("Nama_obat");
                resepObat.add(RO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resepObat;
    }
    //paramnya id obat sama NIK pasien
    public static boolean insertNewResepObat(String NIK,String IdObat){
        conn.connect();
        String query = "INSERT INTO Riwayat_Pasien VALUES(?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
