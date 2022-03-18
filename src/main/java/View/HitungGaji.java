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


public class HitungGaji implements ActionListener{
    
    JFrame hitungGaji = new JFrame("HITUNG GAJI");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    JLabel labNid = new JLabel ("NID    :");
    JLabel labNama = new JLabel("Nama   :");
    JLabel labGaji = new JLabel("Gaji   :");

    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    
    private ControllerDokter control = new ControllerDokter();

    public HitungGaji(Dokter dokter){
        
        System.out.println(dokter.getNama());
        
        hitungGaji.setSize(1200, 620);
        hitungGaji.setLocationRelativeTo(null);
        hitungGaji.setLayout(null);
        
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
        
        labNid.setBounds(40, 10, 160, 25);
        labNama.setBounds(40, 50, 160, 25);
        labGaji.setBounds(40, 90, 160, 25);
        
        JLabel nama = new JLabel(dokter.getNama());
        JLabel nid = new JLabel(dokter.getNID());
        JLabel gaji = new JLabel(String.valueOf(dokter.hitungGaji()));
        
        nama.setBounds(120, 10, 160, 25);
        nid.setBounds(120, 50, 160, 25);
        gaji.setBounds(120, 90, 160, 25);
        
        isi.add(labNid);
        isi.add(labNama);
        isi.add(labGaji);
        isi.add(nama);
        isi.add(nid);
        isi.add(gaji);

        hitungGaji.add(isi);
        hitungGaji.add(menu);
    
        hitungGaji.setUndecorated(true);
        hitungGaji.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        hitungGaji.setVisible(true);
        hitungGaji.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                hitungGaji.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                hitungGaji.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                hitungGaji.setVisible(false);
                break; 
            default: 
                break;
        }
    }
    
}