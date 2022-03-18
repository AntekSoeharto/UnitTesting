import Controller.ControllerObat;
import Model.Obat;
import Model.Singleton;
import Model.Staff;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EntityObatTester {
    ControllerObat conab = new ControllerObat();
    Obat obat = new Obat("076", "MLO0101", "Paracetamolous", 500, 50, 1000, "2020-10-06", "2020-10-06");

    @BeforeAll
    public static void login(){
        Staff staff = new Staff("intan", "intan", "01");
        Singleton.getInstance().setStaff(staff);

    }


    @Test
    public void testGetIDObat(){
        Assertions.assertEquals(conab.getObat("Paracetamolous").getIDObat(), obat.getIDObat());
    }

    @Test
    public void testGetNama(){
        Assertions.assertEquals(conab.getObat("Paracetamolous").getNama(), obat.getNama());
    }

    @Test
    public void testGetHargaBeli(){
        Assertions.assertEquals(conab.getObat("Paracetamolous").getHargaBeli(), obat.getHargaBeli());
    }

    @Test
    public void testGetHargaJual(){
        Assertions.assertEquals(conab.getObat("Paracetamolous").getHargaJual(), obat.getHargaJual());
    }

    @AfterAll
    public static void AfterAll(){
        System.out.println("Sudah Selesai untuk testing Obat!!");
    }
}
