/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import Model.Singleton;
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
public class ControllerDokter {
    
    static DBHandler conn = new DBHandler();
    
    
    public static ArrayList<Dokter> getAllDokter(){
        conn.connect();
        ArrayList<Dokter> dokters = new ArrayList<Dokter>();
        String query = "SELECT * FROM dokter WHERE ID_cabang='" + Singleton.getInstance().getStaff().getIdCabang() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Dokter dokter = new Dokter();
                dokter.setNIK(rs.getString("NIK"));
                dokter.setNama(rs.getString("Nama"));
                dokter.setTglLahir((Date)rs.getObject("Tgl_lahir"));
                dokter.setGolDar(rs.getString("Goldar"));
                dokter.setGender(rs.getString("Gender"));
                dokter.setNID(rs.getString("NID"));
                dokter.setPoliklinik(rs.getString("Poliklinik"));
                dokter.setTelepon(rs.getString("No_Telepon"));
                dokter.setAbsen(getAllAbsen(rs.getString("NID")));
                dokter.setAlamat(rs.getString("Alamat"));
                dokters.add(dokter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dokters;
    }
    
   
    public static Dokter getDokter(String nik){
        conn.connect();
        Dokter dokter = new Dokter();
        String query = "SELECT * FROM dokter WHERE nid='" + nik + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                dokter.setNIK(rs.getString("NIK"));
                dokter.setNama(rs.getString("Nama"));
                dokter.setTglLahir((Date)rs.getObject("Tgl_lahir"));
                dokter.setGolDar(rs.getString("Goldar"));
                dokter.setGender(rs.getString("Gender"));
                dokter.setNID(rs.getString("NID"));
                dokter.setPoliklinik(rs.getString("Poliklinik"));
                dokter.setTelepon(rs.getString("No_Telepon"));
                dokter.setAbsen(getAllAbsen(rs.getString("NID")));
                dokter.setAlamat(rs.getString("Alamat"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (dokter);
    }
    
    
    public static boolean addDokter(Dokter dokter){
        conn.connect();
        String query = "INSERT INTO dokter VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, dokter.getNIK());
            stmt.setString(2, dokter.getNama());
            stmt.setObject(3, dokter.getTglLahir());
            stmt.setString(4, dokter.getGolDar());
            stmt.setString(5, dokter.getGender());
            stmt.setString(6, dokter.getNID());
            stmt.setString(7, dokter.getPoliklinik());
            stmt.setString(8, dokter.getTelepon());
            stmt.setString(9, dokter.getAlamat());
            stmt.setString(10, Singleton.getInstance().getStaff().getIdCabang());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            return (false);
        }
    }
    
    public static boolean updateDokter(Dokter dokter, String tgllahir){
        conn.connect();
        String query = "UPDATE dokter SET nik='" + dokter.getNIK() + "', "
                + "nama='" + dokter.getNama() + "', "
                + "Tgl_Lahir='" + tgllahir + "', "
                + "Goldar='" + dokter.getGolDar() + "', "
                + "Gender='" + dokter.getGender() + "', "
                + "NID='" + dokter.getNID() + "', "
                + "Poliklinik='" + dokter.getPoliklinik() + "', "
                + "No_Telepon='" + dokter.getTelepon() + "', "
                + "Alamat='" + dokter.getAlamat() + "', "
                + "ID_cabang='" + Singleton.getInstance().getStaff().getIdCabang() + "' "
                + "WHERE nik='" + dokter.getNIK() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            return (false);
        }
    }
    
    public static boolean deleteDokter(String strnid){
        conn.connect();

        String query = "DELETE FROM dokter WHERE nid='" + strnid + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            return (false);
        }
    }
    
    public static boolean addAbsen(String nid, Date tanggal, String status){
        conn.connect();
        String query = "INSERT INTO absensi_dokter VALUES(?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setObject(1, tanggal);
            stmt.setString(2, status);
            stmt.setString(3, nid);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            return (false);
        }        
    }
    
    public static ArrayList<AbsensiDokter> getAllAbsen(String nid){
        conn.connect();
        ArrayList<AbsensiDokter> absen = new ArrayList<AbsensiDokter>();
        String query = "SELECT * FROM absensi_dokter WHERE NID='" + nid + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Date tanggal = (Date)rs.getObject("Tgl_absen");
                if(rs.getString("Status").equals("ALPHA")){
                    AbsensiDokter absens = new AbsensiDokter(tanggal, StatusAbsensi.ALPHA);
                    absen.add(absens);
                }else if(rs.getString("Status").equals("HADIR")){
                    AbsensiDokter absens = new AbsensiDokter(tanggal, StatusAbsensi.MASUK);
                    absen.add(absens);
                }else{
                    AbsensiDokter absens = new AbsensiDokter(tanggal, StatusAbsensi.IZIN);
                    absen.add(absens);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return absen;
        
    }
}
