/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author hp
 */
import Model.*;
import Model.Singleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class ControllerObat {
    
    static DBHandler conn = new DBHandler();
    
    public ControllerObat(){
        
    }
    
    public static boolean addObat(Obat obat){
        conn.connect();
        String query = "INSERT INTO obat VALUES(?,?,?,?) ";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);

            stmt.setString(1, obat.getIDObat());
            stmt.setString(2, obat.getNama());
            stmt.setInt(3, obat.getHargaBeli());
            stmt.setInt(4, obat.getHargaJual());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            return (false);
        }        
    }
    public static boolean beliObat(Obat obat){
        conn.connect();
        String query = "INSERT INTO Masa_berlaku_obat VALUES(?,?,?,?,?,?) ";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, obat.getIDMasaLakuObat());
            stmt.setString(2, obat.getIDObat());
            stmt.setObject(3, obat.getTgl_beli());
            stmt.setObject(4, obat.getTgl_kadaluarsa());
            stmt.setInt(5, obat.getStok());
            stmt.setString(6, Singleton.getInstance().getStaff().getIdCabang());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            return (false);
        }        
    }

    public static Obat getObat(String namaObat) {
        conn.connect();
        String query = "SELECT * FROM obat WHERE Nama_obat='" + namaObat + "'";
        Obat obatPasien = new Obat();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                obatPasien.setIDObat(rs.getString("ID_Obat"));
                obatPasien.setNama(rs.getString("Nama_obat"));
                obatPasien.setHargaBeli(rs.getInt("Harga_beli"));
                obatPasien.setHargaJual(rs.getInt("Harga_jual"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (obatPasien);
        
    }
    public static boolean insertResepObatPasien(String IDObat,String NIK){
        conn.connect();
        String query = "INSERT INTO Resep_Obat_pasien VALUES(?,?) ";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, IDObat);
            stmt.setString(2, NIK);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            return (false);
        } 
    }
    public static String getIDMLO() {
        conn.connect();
        String query = "SELECT ID_MLO FROM `Masa_berlaku_obat` ORDER BY ID_MLO DESC LIMIT 1";
        String IDMLO = "";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                IDMLO += rs.getString("ID_MLO");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int id = Integer.parseInt(IDMLO.substring(3));
        return ("MLO00" + (id+1));
    }

    public static String getLastIDObat() {
        conn.connect();
        String query = "SELECT ID_Obat FROM `obat` ORDER BY ID_Obat DESC LIMIT 1";
        String IDObat = "";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                IDObat = rs.getString("ID_Obat");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int id = Integer.valueOf(IDObat.substring(1));
        return ("M00" + (id + 1));
        
    }
    public static boolean updateStockObat(String IDObat,int stok) {
        conn.connect();
        String query = "UPDATE Masa_berlaku_obat SET stok='" + stok + "' "
                + " WHERE ID_Obat='" + IDObat+ "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            return (false);
        }
    }

    public static int getStockObat(String IDObat) {
        conn.connect();
        String query = "SELECT stok FROM Masa_berlaku_obat WHERE ID_Obat = '"+ IDObat +"'";
        int stockObat = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                stockObat += rs.getInt("stok");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (stockObat);
    }

}
