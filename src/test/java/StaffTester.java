import Controller.ControllerObat;
import Controller.ControllerStaff;
import Controller.DBHandler;
import Model.Cabang;
import Model.Obat;
import Model.Singleton;
import Model.Staff;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StaffTester {
    static ControllerStaff constaff = new ControllerStaff();
    static DBHandler conn = new DBHandler();

    @BeforeAll
    public static void login(){
        Staff staff = new Staff("intan", "intan", "01");
        Singleton.getInstance().setStaff(staff);
    }

    @Test
    public void testGetStaff(){
        Staff staff = new Staff();
        staff.setUsername("Asri");
        staff.setPassword("Asri123");
        Staff actual = constaff.getStaff("Asri");
        Assertions.assertEquals(staff.getUsername(), actual.getUsername());
    }

    @Test
    public void testGetCabang(){
        Cabang cabang = new Cabang();
        cabang.setAlamat("Antapani No.5");
        cabang.setTelepon("02209232093");
        cabang.setNama("Puskesmas Antapani");
        Cabang actual = constaff.getCabang("01");
        Assertions.assertEquals(cabang.getNama(), actual.getNama());
    }

    @AfterAll
    public static void AfterAll(){
        System.out.println("Sudah Selesai untuk testing Staff");
    }
}
