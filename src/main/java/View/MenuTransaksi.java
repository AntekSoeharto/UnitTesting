/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author hp
 */

import Model.Singleton;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;
import java.awt.Font;


public class MenuTransaksi implements ActionListener{
    
    JFrame frame = new JFrame("MENU TRANSAKSI");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menu_pasien = new JButton("PASIEN");
    JButton menu_dokter = new JButton("DOKTER");
    JButton menu_admin = new JButton("ADMINISTRASI");
    JButton obatPasien = new JButton("PERNCAIRAN RESEP DOKTER");
    JButton lihatTransaksi = new JButton("LIHAT SEMUA TRANSAKSI");
    JButton bayarTransaksi = new JButton("BAYAR TAGIHAN");
    JButton lihatKeuntungan = new JButton("LIHAT KEUNTUNGAN");
    JLabel homePertama;
    
    
    public MenuTransaksi(){
        
        frame.setSize(1200, 620);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(10,520,1170,50);
        isi.setBounds(10,10,1170,500);
       
        isi.setBackground(Color.ORANGE);
        menu.setBackground(Color.ORANGE);
        
        menu_pasien.setBounds(320,10,90,30);
        menu_dokter.setBounds(520,10,90,30);
        menu_admin.setBounds(720,10,120,30);
       
        menu.add(menu_dokter);
        menu.add(menu_pasien);
        menu.add(menu_admin);
       
        menu_dokter.addActionListener(this);
        menu_pasien.addActionListener(this);
        menu_admin.addActionListener(this);
        
        String homesPertama = "MENU TRANSAKSI";
        
        homePertama = new JLabel(homesPertama);
        
        homePertama.setFont(new Font("Times New Roman", Font.BOLD, 30));
        
        homePertama.setBounds(430, 20, 750, 100);
        obatPasien.setBounds(475,100,200,50);
        lihatTransaksi.setBounds(475,180,200,50);
        bayarTransaksi.setBounds(475,260,200,50);
        lihatKeuntungan.setBounds(475,340,200,50);
        
        isi.add(homePertama);
        isi.add(obatPasien);
        isi.add(lihatTransaksi);
        isi.add(bayarTransaksi);
        isi.add(lihatKeuntungan);
        
        obatPasien.addActionListener(this);
        lihatTransaksi.addActionListener(this);
        bayarTransaksi.addActionListener(this);
        lihatKeuntungan.addActionListener(this);
        
        
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
            case "PERNCAIRAN RESEP DOKTER":
                new PrePencairanResepDokter();
                frame.setVisible(false);
                break;
            case "LIHAT SEMUA TRANSAKSI":
                new LihatSemuaTransaksi();
                frame.setVisible(false);
                break;
            case "BAYAR TAGIHAN":
                new PreBayarTagihanNik();
                frame.setVisible(false);
                break;
            case "LIHAT KEUNTUNGAN":
                new LihatKeuntungan();
                frame.setVisible(false);
                break;    
            default: 
                break;
        }
    }
    
}