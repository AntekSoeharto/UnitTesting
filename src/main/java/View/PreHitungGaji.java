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

public class PreHitungGaji implements ActionListener{
    ControllerDokter control = new ControllerDokter();
    
    JFrame preHitungGaji = new JFrame("PRE HITUNG GAJI DOKTER");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    
    JLabel nids = new JLabel("NID");
    JButton hitung = new JButton("HITUNG");
    ArrayList<Dokter> dokters= control.getAllDokter();
    String[] listnid;
    JComboBox nid;
    
    
    public PreHitungGaji(){
        
        preHitungGaji.setSize(1200, 620);
        preHitungGaji.setLocationRelativeTo(null);
        preHitungGaji.setLayout(null);
        
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
        
        nids.setBounds(40, 20, 160, 30);
        hitung.setBounds(120,80,120,30);
        
        listnid = new String[dokters.size()];
        
        for(int i = 0; i < dokters.size(); i++){
            Dokter dokter = dokters.get(i);
            listnid[i] = dokter.getNID();
        }
        
        nid = new JComboBox(listnid);
        nid.setBounds(100, 20, 160, 30);

        isi.add(hitung);
        isi.add(nids);
        isi.add(nid);

        preHitungGaji.add(isi);
        preHitungGaji.add(menu);
        
        preHitungGaji.setUndecorated(true);
        preHitungGaji.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        preHitungGaji.setVisible(true);
        preHitungGaji.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                preHitungGaji.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                preHitungGaji.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                preHitungGaji.setVisible(false);
                break;
            case "HITUNG":
                String strnid = String.valueOf(nid.getSelectedItem());;
                Dokter dokter = control.getDokter(strnid);
                new HitungGaji(dokter);
                preHitungGaji.setVisible(false);
                break;
             default: 
                break;
        }
    }
}