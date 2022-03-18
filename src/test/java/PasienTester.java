import Controller.ControllerDokter;
import Controller.ControllerPasien;
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

public class PasienTester {
    public static ControllerPasien conpas = new ControllerPasien();
    static DBHandler conn = new DBHandler();

    @BeforeAll
    public static void login(){
        Staff staff = new Staff("intan", "intan", "01");
        Singleton.getInstance().setStaff(staff);
    }

    @Test
    public void testGetAllPasien(){
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

        ArrayList<Pasien> listPasien = conpas.getAllPasiens();

        for (int i = 0; i < listPasien.size(); i++) {
            Assertions.assertEquals(pasiens.get(i).getNIK(), listPasien.get(i).getNIK());
        }

    }

    @Test
    public void testAddPasienTrue(){
        Pasien pasien = new Pasien(GolonganPasien.NON_BPJS, "makanan","diabetes", "Andreas Jumaga", "69", new Date(1945), "Komplek Bumi Harapan cc5 no 3a", "08696969696", "+AB", "Pria");
        boolean masuk = conpas.insertNewPasien(pasien);
        boolean sukses = true;
        Assertions.assertEquals(sukses, masuk);
    }

    @Test
    public void testAddPasienFalse(){
        Pasien pasien = new Pasien(GolonganPasien.NON_BPJS, "makanan","diabetes", "Andreas Jumaga", "69", new Date(1945), "Komplek Bumi Harapan cc5 no 3a", "08696969696", "+AB", "Pria");
//        dokter.setNID(null);
//        boolean masuk = condok.addDokter(dokter);
        boolean sukses = true;
//        Assertions.assertEquals(sukses, masuk);

    }

    @Test
    public void testUpdatePasienTrue(){
        Pasien pasien = new Pasien(GolonganPasien.NON_BPJS, "makanan","diabetes", "Andreas Jumaga", "69", new Date(1945), "Komplek Bumi Harapan cc5 no 3a", "08696969696", "+AB", "Pria");
        String gol = "A";
        String ala = "Taman Kopo";
        String tlp = "0865968405";
        String nik = "100";
        boolean update = conpas.updatePasien(gol, ala, tlp, nik);
        Assertions.assertEquals(true, update);
    }

    @Test
    public void testUpdatePasienFalse(){
        Pasien pasien = new Pasien(GolonganPasien.NON_BPJS, "makanan","diabetes", "Andreas Jumaga", "69", new Date(1945), "Komplek Bumi Harapan cc5 no 3a", "08696969696", "+AB", "Pria");
        String gol = "B";
        String ala = "Taman Kopo";
        String tlp = "0865968405";
        String nik = "100";
//        boolean update = condok.updateDokter(dokter, tl);
//        Assertions.assertEquals(true, update);
    }

    @AfterAll
    public static void AfterAll(){
        System.out.println("Sudah Selesai untuk testing Pasien");
    }
}
