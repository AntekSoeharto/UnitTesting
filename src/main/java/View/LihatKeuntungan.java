package View;

import Controller.ControllerTransaksi;
import Model.Singleton;
import Model.Transaksi;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class LihatKeuntungan implements ActionListener{
/**
 *
 * @author hp
 */
    
    JFrame lihatKeuntunganKlinik = new JFrame("LIHAT KEUNTUNGAN KLINIK");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    JButton kembaliKeMenu = new JButton("KEMBALI KE MENU");
    

    public LihatKeuntungan(){
        
        lihatKeuntunganKlinik.setSize(1200, 620);
        lihatKeuntunganKlinik.setLocationRelativeTo(null);
        lihatKeuntunganKlinik.setLayout(null);
        
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(10,520,1170,50);
        isi.setBounds(10,10,1170,500);
        
        isi.setBackground(Color.ORANGE);
        menu.setBackground(Color.ORANGE);
        
        menuPasien.setBounds(320,10,90,30);
        menuDokter.setBounds(520,10,90,30);
        menuAdmin.setBounds(720,10,120,30);
        
        menu.add(menuDokter);
        menu.add(menuPasien);
        menu.add(menuAdmin);
        
        menuDokter.addActionListener(this);
        menuPasien.addActionListener(this);
        menuAdmin.addActionListener(this);

        
        JLabel labidCabang = new JLabel("Nama Cabang : ");
        JLabel labKeuntungan = new JLabel("Keuntungan : ");
        
        ArrayList<Transaksi> listTransaksi = ControllerTransaksi.getAllTransaksi("");
        long Keuntungan = 0;
        for (Transaksi transaksi : listTransaksi) {
            Keuntungan += transaksi.getTotal();
        }
        JLabel isilabidCabang = new JLabel(Singleton.getInstance().getCabang().getNama());
        JLabel isilabKeuntungan = new JLabel("Rp. " + Keuntungan);
        
        
        labidCabang.setBounds(40, 20, 160, 30);
        isi.add(labidCabang);
        isilabidCabang.setBounds(120, 20, 160, 30);
        isi.add(isilabidCabang);
        labKeuntungan.setBounds(40, 80, 160, 30);
        isi.add(labKeuntungan);
        isilabKeuntungan.setBounds(120, 80, 160, 30);
        isi.add(isilabKeuntungan);
        
        kembaliKeMenu.addActionListener(this);
        kembaliKeMenu.setBounds(100, 120, 160, 30);
        isi.add(kembaliKeMenu);
        
        lihatKeuntunganKlinik.add(isi);
        lihatKeuntunganKlinik.add(menu);
        
        lihatKeuntunganKlinik.setUndecorated(true);
        lihatKeuntunganKlinik.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        lihatKeuntunganKlinik.setVisible(true);
        lihatKeuntunganKlinik.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                lihatKeuntunganKlinik.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                lihatKeuntunganKlinik.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                lihatKeuntunganKlinik.setVisible(false);
                break;
            case "KEMBALI KE MENU":
                lihatKeuntunganKlinik.setVisible(false);
                new MenuAdmin();
                break;
            default: 
                break;
        }
    }
}

