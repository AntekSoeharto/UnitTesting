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

import Controller.ControllerDokter;
import Controller.ControllerTransaksi;
import Model.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class PreBayarTagihanNik implements ActionListener{
    
    JFrame preBayarTagihanNIK = new JFrame("PRE BAYAR TAGIHAN (NIK)");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    JLabel labNik = new JLabel("NIK");
    JTextField textNik = new JTextField();

    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    JButton cari = new JButton("CARI");

    private ControllerDokter control = new ControllerDokter();

    public PreBayarTagihanNik(){
        
        preBayarTagihanNIK.setSize(1200, 620);
        preBayarTagihanNIK.setLocationRelativeTo(null);
        preBayarTagihanNIK.setLayout(null);
        
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
        
        labNik.setBounds(40, 20, 160, 30);
        textNik.setBounds(120, 20, 120, 30);
       
        cari.addActionListener(this);
        cari.setBounds(100, 80, 120, 30);
        
        isi.add(labNik);
        isi.add(textNik);
        isi.add(cari);
         
        preBayarTagihanNIK.add(isi);
        preBayarTagihanNIK.add(menu);
        
        preBayarTagihanNIK.setUndecorated(true);
        preBayarTagihanNIK.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        preBayarTagihanNIK.setVisible(true);
        preBayarTagihanNIK.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                preBayarTagihanNIK.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                preBayarTagihanNIK.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                preBayarTagihanNIK.setVisible(false);
                break; 
            case "CARI":
                ControllerTransaksi control = new ControllerTransaksi();
                String strnik = textNik.getText();
                ArrayList<Transaksi> listTransaksi = control.getAllTransaksi(strnik);
                preBayarTagihanNIK.setVisible(false);
                new PreBayarTagihan(listTransaksi);
                break;
            default: 
                break;
        }
    }
    
}