import Controller.ControllerDokter;
import Controller.ControllerPasien;
import Model.Pasien;
import Model.Singleton;
import Model.Staff;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

public class PasienTester {
    public static ControllerPasien condok = new ControllerPasien();

    @BeforeAll
    public static void login(){
        Staff staff = new Staff("intan", "intan", "01");
        Singleton.getInstance().setStaff(staff);
    }
//
//    @Test
//    public void testGetAllPasien(){
//        ArrayList<Pasien> listPasienExpected = new ArrayList<Pasien>();
//        Pasien pasien = condok.getPasien("1");
//        Pasien pasien2 = condok.getPasien("4");
//        listDokterExpected.add(dokter);
//        listDokterExpected.add(dokter2);
//        listDokterExpected.add(condok.getDokter("1"));
//        ArrayList<Dokter> listDokterActual = condok.getAllDokter();
////        Assertions.assertThat(dokters.getNID()).isEqualTo(temp.getNID());
//
//        for (int i = 0; i < listPasienActual.size(); i++) {
//            Assertions.assertEquals(listPasienExpected.get(i).getNIK(), listPasienActual.get(i).getCabang());
//        }
//    }
//
//    @Test
//    public void testAddPasienTrue(){
//        Pasien pasien = new Pasien("NON_BPJS", "10", new Date(2020), "+B", "Pria", "10", "10", "NON_BPJS", "10", "10");
//        boolean masuk = condok.insertNewPasien(pasien);
//        boolean sukses = true;
//        Assertions.assertEquals(sukses, masuk);
//
//    }
//
//    @Test
//    public void testAddPasienFalse(){
//        Pasien pasien = new Pasien("5", "Dokter Spesialis Anak", "Dave", "258025", new Date(2020), "A", "Pria", "TKO", "05850585");
////        dokter.setNID(null);
////        boolean masuk = condok.addDokter(dokter);
//        boolean sukses = true;
////        Assertions.assertEquals(sukses, masuk);
//
//    }
//
//    @Test
//    public void testUpdatePasienTrue(){
//        Dokter dokter = new Dokter("5", "Dokter Spesialis Anak", "Dave Nathaniel", "258025", new Date(2020), "A", "Pria", "TKO", "05850585");
//        String tl = "2020-02-12";
//        boolean update = condok.updateDokter(dokter, tl);
//        Assertions.assertEquals(true, update);
//    }
//
//    @Test
//    public void testUpdatePasienFalse(){
//        Dokter dokter = new Dokter("5", "Dokter Spesialis Anak", "Dave Nathaniel", "258025", new Date(2020), "A", "Pria", "TKO", "05850585");
//        String tl = "582582";
////        boolean update = condok.updateDokter(dokter, tl);
////        Assertions.assertEquals(true, update);
//    }
//

    @AfterAll
    public static void AfterAll(){
        System.out.println("Sudah Selesai untuk testing Pasien");
    }




}
