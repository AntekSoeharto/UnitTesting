import Controller.DBHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.TimeZone;

public class DBHandlerTester {
    static DBHandler conn = new DBHandler();

    @Test
    public void testConnect(){
        String url = "jdbc:mysql://localhost/PBO?serverTimezone=" + TimeZone.getDefault().getID();
        String username = "root";
        String password = "";
        Connection con = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            //Load JDBC Driver
            Class.forName(driver).newInstance();
            //Buat Object Connection
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "Error Ocurred when login" + ex);
        }
        Connection actual = conn.logOn();
//        Assertions.assertEquals(con, actual);
    }
}
