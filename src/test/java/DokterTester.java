import Controller.ControllerDokter;
import Model.Dokter;
import Model.Singleton;
import Model.Staff;
import jdk.swing.interop.SwingInterOpUtils;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.Date;

public class DokterTester {
    public static ControllerDokter condok = new ControllerDokter();

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
//        dokter.setNID(null);
//        boolean masuk = condok.addDokter(dokter);
        boolean sukses = true;
//        Assertions.assertEquals(sukses, masuk);

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
//        boolean update = condok.updateDokter(dokter, tl);
//        Assertions.assertEquals(true, update);
    }


    @AfterAll
    public static void AfterAll(){
        System.out.println("Sudah Selesai untuk testing Dokter");
    }




}
