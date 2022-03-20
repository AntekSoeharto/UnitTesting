import Controller.ControllerStaff;
import Model.Cabang;
import Model.Singleton;
import Model.Staff;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SingletonTester {
    static ControllerStaff constaf = new ControllerStaff();

    @BeforeAll
    public static void login(){
        Staff staff = new Staff("intan", "intan", "01");
        Singleton.getInstance().setStaff(staff);
        Singleton.getInstance().setCabang(constaf.getCabang(staff.getIdCabang()));

    }

    @Test
    public void testGetStaff(){
        Staff staff = new Staff("intan", "intan", "01");
        Assertions.assertEquals(staff.getUsername(), Singleton.getInstance().getStaff().getUsername());
    }

    @Test
    public void testGetCabang(){
        Cabang cabang = new Cabang();
        cabang.setNama("Puskesmas Antapani");
        Assertions.assertEquals(cabang.getNama(), Singleton.getInstance().getCabang().getNama());
    }

    @AfterAll
    public static void AfterAll(){
        System.out.println("Sudah Selesai untuk testing Obat!!");
    }
}
