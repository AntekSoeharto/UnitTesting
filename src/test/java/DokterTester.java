import Controller.ControllerDokter;
import Controller.DBHandler;
import Model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdk.swing.interop.SwingInterOpUtils;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class DokterTester {
    public static ControllerDokter condok = new ControllerDokter();
    static DBHandler conn = new DBHandler();

    @BeforeAll
    public static void login(){
        Staff staff = new Staff("intan", "intan", "01");
        Singleton.getInstance().setStaff(staff);
    }

    @Test
    public void testGetAllDoctor(){
        ArrayList<Dokter> listDokterExpected = new ArrayList<Dokter>();
        Dokter dokter = condok.getDokter("1");
        Dokter dokter2 = condok.getDokter("4");
        listDokterExpected.add(dokter);
        listDokterExpected.add(dokter2);
        listDokterExpected.add(condok.getDokter("1"));
        ArrayList<Dokter> listDokterActual = condok.getAllDokter();
//        Assertions.assertThat(dokters.getNID()).isEqualTo(temp.getNID());

        for (int i = 0; i < listDokterActual.size(); i++) {
            Assertions.assertEquals(listDokterExpected.get(i).getNID(), listDokterActual.get(i).getNID());
        }
    }

    @Test
    public void testAddDokterTrue(){
        Dokter dokter = new Dokter("5", "Dokter Spesialis Anak", "Dave", "258025", new Date(2020), "A", "Pria", "TKO", "05850585");
        boolean masuk = condok.addDokter(dokter);
        boolean sukses = true;
        Assertions.assertEquals(sukses, masuk);

    }

    @Test
    public void testAddDokterFalse(){
        Dokter dokter = new Dokter("5", "Dokter Spesialis Anak", "Dave", "258025", new Date(2020), "A", "Pria", "TKO", "05850585");
        dokter.setNID(null);
        try {
            boolean masuk = condok.addDokter(dokter);
            Assertions.assertEquals(false, masuk);
        }catch (Exception ex){
            System.out.println("Gagal Add Dokter");
        }
    }

    @Test
    public void testDeleteDokterTrue(){
        boolean hapus = condok.deleteDokter("258025");
        Assertions.assertEquals(true, hapus);
    }

    public void testDeleteDokterFalse(){
        String nid = "58";
        nid = null;
        boolean hapus = condok.deleteDokter(nid);
        Assertions.assertEquals(false, hapus);
    }

    @Test
    public void testUpdateDokterTrue(){
        Dokter dokter = new Dokter("5", "Dokter Spesialis Anak", "Dave Nathaniel", "258025", new Date(2020), "A", "Pria", "TKO", "05850585");
        String tl = "2020-02-12";
        boolean update = condok.updateDokter(dokter, tl);
        Assertions.assertEquals(true, update);
    }

    @Test
    public void testUpdateDokterFalse(){
        Dokter dokter = new Dokter("5", "Dokter Spesialis Anak", "Dave Nathaniel", "258025", new Date(2020), "A", "Pria", "TKO", "05850585");
        String tl = "582582";
        try {
            boolean update = condok.updateDokter(dokter, tl);
            Assertions.assertEquals(false, update);
        }catch (Exception ex){
            System.out.println("Gagal Update DOkter");
        }

    }

    @Test
    public void testAddAbsenDokterTrue(){
        String nid = "1";
        Date tanggal = new Date();
        String status = "ALPHA";
        boolean masuk = condok.addAbsen(nid, tanggal, status);
        Assertions.assertEquals(true, masuk);
    }

    @Test
    public void testAddAbsenDokterFalse(){
        String nid = "1";
        Date tanggal = new Date();
        nid = null;
        String status = "ALPHA";
        try {
            boolean masuk = condok.addAbsen(nid, tanggal, status);
            Assertions.assertEquals(false, masuk);
        }catch (Exception ex){
            System.out.println("Gagal memasukan Add Absen");
        }

    }

    @Test
    public void testGetAllAbsensi(){
        conn.connect();
        String nid = "1";
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

        ArrayList<AbsensiDokter> listAbsensiDokter = condok.getAllAbsen(nid);

        for (int i = 0; i < listAbsensiDokter.size(); i++) {
            Assertions.assertEquals(absen.get(i).getStatus(), listAbsensiDokter.get(i).getStatus());
        }
    }

    @Test
    public void testDeleteDokter(){
        String nid = "258025";
        boolean hapus = condok.deleteDokter(nid);
        Assertions.assertEquals(true, hapus);
    }



    @AfterAll
    public static void AfterAll(){
        System.out.println("Sudah Selesai untuk testing Dokter");
    }




}
