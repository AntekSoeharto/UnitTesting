import Controller.ControllerPasien;
import Controller.ControllerTransaksi;
import Controller.DBHandler;
import Model.Singleton;
import Model.Staff;
import Model.Transaksi;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class TransaksiTester {
    static DBHandler conn = new DBHandler();
    static ControllerTransaksi contrak = new ControllerTransaksi();

    @BeforeAll
    public static void login(){
        Staff staff = new Staff("intan", "intan", "01");
        Singleton.getInstance().setStaff(staff);
    }

    @Test
    public void testGetAllTransaksi(){
        String nik = "1";
        ControllerPasien control = new ControllerPasien();
        conn.connect();
        ArrayList<Transaksi> listTransaksi = new ArrayList<Transaksi>();
        String query = "";
        if(nik.equals("")){
            query = "SELECT * FROM transaksi WHERE ID_cabang='" + Singleton.getInstance().getStaff().getIdCabang() + "'";
        }else{
            query = "SELECT * FROM transaksi WHERE ID_cabang='" + Singleton.getInstance().getStaff().getIdCabang() + "' and idPasien='" + nik +  "'and isBayar = '" + 0 + "'";
        }

        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setIdTransaksi(rs.getString("ID_Transaksi"));
                transaksi.setPasien(control.getPasien(rs.getString("idPasien")));
                transaksi.setTanggalMasuk((Date)rs.getObject("Tanggal_masuk"));
                transaksi.setJumlah(rs.getInt("Jumlah"));
                transaksi.setJenisPasien(rs.getInt("Jenis_pasien"));
                transaksi.setHargaKonsultasi(rs.getInt("Harga_konsul"));
                transaksi.setHargaObat(rs.getInt("Harga_obat"));
                transaksi.setTotal(rs.getInt("Total_harga"));
                boolean isBayar = false;
                if(rs.getInt("isBayar") == 1){
                    isBayar = true;
                }
                transaksi.setIsBayar(isBayar);
                transaksi.setIsBayar(true);
                listTransaksi.add(transaksi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ArrayList<Transaksi> listTransaksis = contrak.getAllTransaksi(nik);
        for (int i = 0; i < listTransaksis.size(); i++) {
            Assertions.assertEquals(listTransaksi.get(i).getPasien().getNIK(), listTransaksis.get(i).getPasien().getNIK());

        }
    }

    @Test
    public void testGetLastIDFromTransaksi(){
        String actual = "T003";
        String idTran = contrak.getLastIDFromTransaksi();
        Assertions.assertEquals(actual, idTran);
    }

    @Test
    public void testGetTransaksi(){
        String idTransaksi = "T001";
        ControllerPasien control = new ControllerPasien();
        Transaksi transaksi = new Transaksi();
        conn.connect();
        String query = "SELECT * FROM Transaksi WHERE ID_Transaksi='" + idTransaksi + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                transaksi.setIdTransaksi(rs.getString("ID_Transaksi"));
                transaksi.setPasien(control.getPasien(rs.getString("idPasien")));
                transaksi.setTanggalMasuk((Date)rs.getObject("Tanggal_masuk"));
                transaksi.setJumlah(rs.getInt("Jumlah"));
                transaksi.setJenisPasien(rs.getInt("Jenis_pasien"));
                transaksi.setHargaKonsultasi(rs.getInt("Harga_konsul"));
                transaksi.setHargaObat(rs.getInt("Harga_obat"));
                transaksi.setTotal(rs.getInt("Total_harga"));
                boolean isBayar = false;
                if(rs.getInt("isBayar") == 1){
                    isBayar = true;
                }
                transaksi.setIsBayar(isBayar);
                transaksi.setIsBayar(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Transaksi tran = contrak.getTransaksi(idTransaksi);
        Assertions.assertEquals(transaksi.getIdTransaksi(), tran.getIdTransaksi());
    }

    @Test
    public void testInsertTransaksibyBayarTagihan(){
        Transaksi transaksi = new Transaksi();
        transaksi.setIdTransaksi("T001");
        boolean isBayar = contrak.insertTransaksibyBayarTagihan(transaksi);
        Assertions.assertEquals(true, isBayar);
    }

    @AfterAll
    public static void AfterAll(){
        System.out.println("Sudah Selesai untuk testing Transaksi");
    }
}
