import Controller.ControllerRiwayatPasien;
import Controller.DBHandler;
import Model.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class RiwayatPasienTester {
    public static ControllerRiwayatPasien conriwpas = new ControllerRiwayatPasien();
    static DBHandler conn = new DBHandler();

    @BeforeAll
    public static void login(){
        Staff staff = new Staff("intan", "intan", "01");
        Singleton.getInstance().setStaff(staff);
    }

    @Test
    public void testGetAllRiwayatPasien(){
        ArrayList<RiwayatPasien> RPs = new ArrayList<>();
        conn.connect();
        String NIK = "2";
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
        ArrayList<RiwayatPasien> listRiwayatPasien = conriwpas.getAllRiwayatPasiens(NIK);

        for (int i = 0; i < listRiwayatPasien.size(); i++) {
            Assertions.assertEquals(RPs.get(i).getKeluhan(), listRiwayatPasien.get(i).getKeluhan());
        }
    }

    @Test
    public void testAddRiwayatPasienTrue() {
        RiwayatPasien riwayatPasien = new RiwayatPasien("diputusin", "sakit hati", new Date(2020));
        boolean masuk = conriwpas.insertNewRiwayatPasien(riwayatPasien, "10");
        Assertions.assertEquals(true, masuk);
    }

    @Test
    public void testAddRiwayatPasienFalse(){
        RiwayatPasien riwayatPasien = new RiwayatPasien("diputusin", "sakit hati", new Date(2020));
        riwayatPasien.setKeluhan(null);
        boolean masuk = conriwpas.insertNewRiwayatPasien(riwayatPasien, "2");
        Assertions.assertEquals(false, masuk);
    }

    @AfterAll
    public static void AfterAll(){
        System.out.println("Sudah Selesai untuk testing Riwayat Pasien");
    }
}
