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

import Model.*;
import Controller.*;
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

public class PreBayarTagihan implements ActionListener{
    ControllerDokter control = new ControllerDokter();
    
    JFrame preBayarTagihan = new JFrame("PRE BAYAR TAGIHAN");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    
    JLabel idTransaksi = new JLabel("Id Transaksi");
    JButton hitung = new JButton("LIHAT TRANSAKSI");
    String[] listIdTransaksi;
    JComboBox boxIdTransaksi;
    
    
    public PreBayarTagihan(ArrayList<Transaksi> listTransaksi){
        
        preBayarTagihan.setSize(1200, 620);
        preBayarTagihan.setLocationRelativeTo(null);
        preBayarTagihan.setLayout(null);
        
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
        hitung.addActionListener(this);
        
        idTransaksi.setBounds(40, 20, 160, 30);
        hitung.setBounds(100,80,120,30);
        
        listIdTransaksi = new String[listTransaksi.size()];
        
        for(int i = 0; i < listTransaksi.size(); i++){
            Transaksi transaksi = listTransaksi.get(i);
            listIdTransaksi[i] = transaksi.getIdTransaksi();
        }
        
        boxIdTransaksi = new JComboBox(listIdTransaksi);
        boxIdTransaksi.setBounds(120, 20, 160, 30);
        
        isi.add(hitung);
        isi.add(boxIdTransaksi);
        isi.add(idTransaksi);
        
        preBayarTagihan.add(isi);
        preBayarTagihan.add(menu);
        
        preBayarTagihan.setUndecorated(true);
        preBayarTagihan.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        preBayarTagihan.setVisible(true);
        preBayarTagihan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                preBayarTagihan.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                preBayarTagihan.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                preBayarTagihan.setVisible(false);
                break;
            case "LIHAT TRANSAKSI":
                ControllerTransaksi control = new ControllerTransaksi();
                String strIdTransaksi = String.valueOf(boxIdTransaksi.getSelectedItem());;
                Transaksi transaksi = control.getTransaksi(strIdTransaksi);
                new BayarTagihan(transaksi);
                preBayarTagihan.setVisible(false);
                break;
             default: 
                break;
        }
    }
}