/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Singleton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 *
 * @author hp
 */
public class MenuPasien implements ActionListener{
    
    JFrame frame = new JFrame("MENU PASIEN");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    JButton insertPasienBaru, searchPasien, beliObat, tambahRiwayatPasien, buatJanjiTemu, lihatRiwayatPasien;
    JLabel homePertama;
    
    public MenuPasien(){

        insertPasienBaru = new JButton("INSERT PASIEN BARU");
        searchPasien = new JButton("CARI PASIEN");
        beliObat = new JButton("BELI OBAT");
        tambahRiwayatPasien = new JButton("UPDATE RIWAYAT PASIEN");
        buatJanjiTemu = new JButton("JANJI TEMU");
        lihatRiwayatPasien = new JButton("LIHAT RIWAYAT PASIEN");
        
        frame.setSize(1200, 620);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
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
        
        String homesPertama = "MENU PASIEN";
        
        homePertama = new JLabel(homesPertama);
        
        homePertama.setFont(new Font("Times New Roman", Font.BOLD, 30));
        
        homePertama.setBounds(465, 20, 750, 100);
        insertPasienBaru.setBounds(475, 100, 200, 50);
        searchPasien.setBounds(475, 180, 200, 50);
        tambahRiwayatPasien.setBounds(475, 260, 200, 50);
        buatJanjiTemu.setBounds(475, 340, 200, 50);
        lihatRiwayatPasien.setBounds(475, 420, 200, 50);
        
        isi.add(homePertama);
        isi.add(insertPasienBaru);
        isi.add(searchPasien);
        isi.add(tambahRiwayatPasien);
        isi.add(lihatRiwayatPasien);
        isi.add(buatJanjiTemu);
        
        insertPasienBaru.addActionListener(this);
        searchPasien.addActionListener(this);
        tambahRiwayatPasien.addActionListener(this);
        buatJanjiTemu.addActionListener(this);
        lihatRiwayatPasien.addActionListener(this);
        
        frame.add(isi);
        frame.add(menu);
           
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                frame.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                frame.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                frame.setVisible(false);
                break;
            case "INSERT PASIEN BARU":
                new ViewInsertPasienBaru();
                break;
            case "CARI PASIEN":
                new ViewSearchPasien();
                frame.setVisible(false);
                break;
            case "UPDATE RIWAYAT PASIEN":
                new viewTambahRiwayatPasien();
                frame.setVisible(false);
                break;
            case "JANJI TEMU":
                new ViewJanjiTemu();
                frame.setVisible(false);
                break;
            case "LIHAT RIWAYAT PASIEN":
                new viewLihatRiwayat1Pasien();
                frame.setVisible(false);
                break;
            default: 
                break;
        }
    }
}
