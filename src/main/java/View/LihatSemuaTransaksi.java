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

import Controller.ControllerTransaksi;
import Model.Dokter;
import Model.Singleton;
import Model.Transaksi;
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
import javax.swing.table.JTableHeader;

public class LihatSemuaTransaksi implements ActionListener{
    
    JFrame lihatSemuaTransaksi = new JFrame("LIHAT SEMUA TRANSAKSI");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    JButton obatPasien = new JButton("PENCAIRAN RESEP DOKTER");
    JButton lihatTransaksi = new JButton("LIHAT SEMUA TRANSAKSI");
    
    JTable table;
    JScrollPane scroll;
  
    public LihatSemuaTransaksi(){
        
        lihatSemuaTransaksi.setSize(1200, 620);
        lihatSemuaTransaksi.setLocationRelativeTo(null);
        lihatSemuaTransaksi.setLayout(null);
        
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
        
        ArrayList<Transaksi> listTransaksi = ControllerTransaksi.getAllTransaksi("");
        String[] header = {"Id Transaksi", "NIK", "Tanggal", "Nama", "Total Harga"};
        
        String[][] isitable = new String[listTransaksi.size()][5];
        
        for(int i = 0; i < listTransaksi.size(); i++){
            Transaksi transaksi = listTransaksi.get(i);
            isitable[i][0] = transaksi.getIdTransaksi();
            isitable[i][1] = transaksi.getPasien().getNIK();
            isitable[i][2] = transaksi.getTanggalMasuk().toString();
            isitable[i][3] = transaksi.getPasien().getNama();
            isitable[i][4] = "" + transaksi.getTotal();
        }
        
        table = new JTable(isitable, header);
        scroll = new JScrollPane(table);
        scroll.setBounds(50, 50, 800, 400);
        isi.add(scroll);

        
        lihatSemuaTransaksi.add(isi);
        lihatSemuaTransaksi.add(menu);
        
        lihatSemuaTransaksi.setUndecorated(true);
        lihatSemuaTransaksi.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        lihatSemuaTransaksi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lihatSemuaTransaksi.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                lihatSemuaTransaksi.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                lihatSemuaTransaksi.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                lihatSemuaTransaksi.setVisible(false);
                break;
            default: 
                break;
        }
    }
    
}