import Controller.ControllerObat;
import Controller.DBHandler;
import Model.Obat;
import Model.Singleton;
import Model.Staff;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ObatTester {
    static ControllerObat conob = new ControllerObat();
    static DBHandler conn = new DBHandler();

    @BeforeAll
    public static void login(){
        Staff staff = new Staff("intan", "intan", "01");
        Singleton.getInstance().setStaff(staff);
    }

    @Test
    public void testAddObatTrue(){
        Obat obat = new Obat("076", "MLO0101", "Paracetamolous", 500, 50, 1000, "2020-10-06", "2020-10-06");
        boolean masuk = conob.addObat(obat);
        Assertions.assertEquals(true, masuk);
    }

    @Test
    public void testAddObatFalse(){
        Obat obat = new Obat("075", "MLO0101", "Paracetamolous", 500, 50, 1000, "2020-10-06", "2020-10-06");
        obat.setIDObat(null);
//        boolean masuk = conob.addObat(obat);
//        Assertions.assertEquals(false, masuk);
    }

    @Test
    public void testBeliObatTrue(){
        Obat obat = new Obat("075", "MLO0102", "Paracetamolous", 500, 50, 1000, "2020-10-06", "2020-10-06");
        boolean masuk = conob.beliObat(obat);
        Assertions.assertEquals(true, masuk);
    }

    @Test
    public void testBeliObatFalse(){
        Obat obat = new Obat("075", "MLO0101", "Paracetamolous", 500, 50, 1000, "2020-10-06", "2020-10-06");
        obat.setIDMasaLakuObat(null);
//        boolean masuk = conob.beliObat(obat);
//        Assertions.assertEquals(false, masuk);
    }

    @Test
    public void testGetObat(){
        Obat obat = new Obat();
        obat.setNama("Paracetamolous");
        obat.setHargaBeli(500);
        obat.setHargaJual(1000);
        obat.setStok(0);
        Obat actual = conob.getObat("Paracetamolous");
        Assertions.assertEquals(obat.getNama(), actual.getNama());
    }

    @Test
    public void testinsertResepObatPasienTrue(){
        String IDObat = "075";
        String NIK = "222";
        boolean masuk = conob.insertResepObatPasien(IDObat, NIK);
        Assertions.assertEquals(true, masuk);
    }

    @Test
    public void testinsertResepObatPasienFalse(){
        String IDObat = null;
        String NIK = "222";
//        boolean masuk = conob.insertResepObatPasien(IDObat, NIK);
//        Assertions.assertEquals(false, masuk);
    }

    @Test
    public void testGetIDMLO(){
        String expected = "MLO00102";
        String idMLO = conob.getIDMLO();
        Assertions.assertEquals(expected, idMLO);
    }

    @AfterAll
    public static void AfterAll(){
        System.out.println("Sudah Selesai untuk testing Obat!!");
    }
}
