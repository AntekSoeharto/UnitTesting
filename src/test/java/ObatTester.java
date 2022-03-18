import Controller.ControllerObat;
import Model.Obat;
import Model.Singleton;
import Model.Staff;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ObatTester {
    static ControllerObat conob = new ControllerObat();

    @BeforeAll
    public static void login(){
        Staff staff = new Staff("intan", "intan", "01");
        Singleton.getInstance().setStaff(staff);
    }

    @Test
    public void testAddObatTrue(){
        Obat obat = new Obat("075", "MLO0101", "Paracetamolous", 500, 50, 1000, "2020-10-06", "2020-10-06");
        boolean masuk = conob.addObat(obat);
        Assertions.assertEquals(true, masuk);
    }

    @Test
    public void testAddObatFalse(){
        Obat obat = new Obat("075", "MLO0101", "Paracetamolous", 500, 50, 1000, "2020-10-06", "2020-10-06");
        obat.setIDObat(null);
        boolean masuk = conob.addObat(obat);
        Assertions.assertEquals(false, masuk);
    }

    @Test
    public void testBeliObatTrue(){
        Obat obat = new Obat("075", "MLO0101", "Paracetamolous", 500, 50, 1000, "2020-10-06", "2020-10-06");
        boolean masuk = conob.beliObat(obat);
        Assertions.assertEquals(true, masuk);
    }

    @Test
    public void testBeliObatFalse(){
        Obat obat = new Obat("075", "MLO0101", "Paracetamolous", 500, 50, 1000, "2020-10-06", "2020-10-06");
        obat.setIDMasaLakuObat(null);
        boolean masuk = conob.beliObat(obat);
        Assertions.assertEquals(false, masuk);
    }



    @AfterAll
    public static void AfterAll(){
        System.out.println("Sudah Selesai untuk testing Obat");
    }
}
