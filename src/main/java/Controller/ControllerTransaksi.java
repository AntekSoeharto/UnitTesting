/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.ControllerDokter.conn;
import Model.*;
import Model.Singleton;
import Model.Transaksi;
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
public class ControllerTransaksi {
    static DBHandler conn = new DBHandler();

//    public static boolean insertNewTransaksi(Transaksi transaksi) {
//        conn.connect();
//        String query = "INSERT INTO transaksi VALUES(?,?,?,?,?,?,?,?)";
//        try {
//            PreparedStatement stmt = conn.con.prepareStatement(query);
//            SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
//            String stringDate= DateFor.format(transaksi.getTanggalMasuk());
//
//            stmt.setString(1, getLastIDFromTransaksi());
//            stmt.setObject(2, stringDate);
//            stmt.setInt(3, transaksi.getJumlah());
//            stmt.setInt(4, transaksi.getJenisPasien());
//            stmt.setInt(5, (int)transaksi.getHargaKonsultasi());
//            stmt.setInt(6, (int)transaksi.getHargaObat());
//            stmt.setInt(7, (int)transaksi.getTotal());
//            stmt.setString(8, Singleton.getInstance().getStaff().getIdCabang());
//            stmt.executeUpdate();
//            return (true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return (false);
//        }
//    }
    public static String getLastIDFromTransaksi(){
        String ID = "T000";
        conn.connect();
        String query = "SELECT ID_Transaksi FROM transaksi ORDER BY ID_Transaksi DESC LIMIT 1";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ID = rs.getString("ID_Transaksi");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int intID = Integer.parseInt(ID.substring(1));
        return ("T00" + (intID + 1));
    }
    
    public static ArrayList<Transaksi> getAllTransaksi(String nik){
        ControllerPasien control = new ControllerPasien();
        conn.connect();
        ArrayList<Transaksi> listTransaksi = new ArrayList<Transaksi>();
        String query = "";
        if(nik.equals("")){
            query = "SELECT * FROM transaksi WHERE ID_cabang='" + Singleton.getInstance().getStaff().getIdCabang() + "'";
        }else{
            query = "SELECT * FROM transaksi WHERE ID_cabang='" + Singleton.getInstance().getStaff().getIdCabang() + "' and idPasien='" + nik +  "'and isBayar = '" + 0 + "'";
        }
        
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setIdTransaksi(rs.getString("ID_Transaksi"));
                transaksi.setPasien(control.getPasien(rs.getString("idPasien")));
                transaksi.setTanggalMasuk((Date)rs.getObject("Tanggal_masuk"));
                transaksi.setJumlah(rs.getInt("Jumlah"));
                transaksi.setJenisPasien(rs.getInt("Jenis_pasien"));
                transaksi.setHargaKonsultasi(rs.getInt("Harga_konsul"));
                transaksi.setHargaObat(rs.getInt("Harga_obat"));
                transaksi.setTotal(rs.getInt("Total_harga"));
                boolean isBayar = false;
                if(rs.getInt("isBayar") == 1){
                    isBayar = true;
                }
                transaksi.setIsBayar(isBayar);
                transaksi.setIsBayar(true);
                listTransaksi.add(transaksi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTransaksi;
    }
    
    public static Transaksi getTransaksi(String idTransaksi){
        ControllerPasien control = new ControllerPasien();
        Transaksi transaksi = new Transaksi();
        conn.connect();
        String query = "SELECT * FROM Transaksi WHERE ID_Transaksi='" + idTransaksi + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                transaksi.setIdTransaksi(rs.getString("ID_Transaksi"));
                transaksi.setPasien(control.getPasien(rs.getString("idPasien")));
                transaksi.setTanggalMasuk((Date)rs.getObject("Tanggal_masuk"));
                transaksi.setJumlah(rs.getInt("Jumlah"));
                transaksi.setJenisPasien(rs.getInt("Jenis_pasien"));
                transaksi.setHargaKonsultasi(rs.getInt("Harga_konsul"));
                transaksi.setHargaObat(rs.getInt("Harga_obat"));
                transaksi.setTotal(rs.getInt("Total_harga"));
                boolean isBayar = false;
                if(rs.getInt("isBayar") == 1){
                    isBayar = true;
                }
                transaksi.setIsBayar(isBayar);
                transaksi.setIsBayar(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaksi;
    }

    public static boolean insterTransaksibyJanjiTemu(Transaksi transaksi){
        conn.connect();
        String query = "INSERT INTO transaksi VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
            String stringDate= DateFor.format(transaksi.getTanggalMasuk()); 
            int isBayar = 0;
            
            stmt.setString(1, getLastIDFromTransaksi());
            stmt.setObject(2, transaksi.getPasien().getNIK());
            stmt.setObject(3, stringDate);
            stmt.setInt(4, transaksi.getJumlah());
            stmt.setInt(5, transaksi.getJenisPasien());
            stmt.setInt(6, (int)transaksi.getHargaKonsultasi());
            stmt.setInt(7, (int)transaksi.getHargaObat());
            stmt.setInt(8, (int)transaksi.getTotal());
            stmt.setString(9, Singleton.getInstance().getStaff().getIdCabang());
            if(transaksi.getIsBayar() == true){
                isBayar = 1;
            }
            stmt.setInt(10, isBayar);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            return (false);
        }
    }
    
    public static boolean insertTransaksibyBeliObat(Transaksi transaksi){
        conn.connect();
        String query = "UPDATE Transaksi SET Jumlah='" + transaksi.getJumlah() + "', "
                + "Harga_obat='" + transaksi.getHargaObat() + "', "
                + "Total_harga='" + transaksi.getTotal() + "', "
                + "isBayar='" + 1 + "' "
                + "WHERE ID_Transaksi='" + transaksi.getIdTransaksi() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            return (false);
        }
    }
    
    public static boolean insertTransaksibyBayarTagihan(Transaksi transaksi){
        conn.connect();
        String query = "UPDATE Transaksi SET isBayar= " + 1 + " "
                + "WHERE ID_Transaksi='" + transaksi.getIdTransaksi() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            return (false);
        }
    }
}
