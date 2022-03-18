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

import Controller.*;
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

public class PreRujukan implements ActionListener{
    
    JFrame preRujukan = new JFrame("PRE RUJUKAN");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    JLabel labNid = new JLabel("NIK");
    JTextField textNid = new JTextField();
    JLabel namars = new JLabel("Rumah Sakit");
    
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    JButton submit = new JButton("SUBMIT");
    String[] listrs = {"Boromeus", "Santosa Pasir Kaliki", "Santosa Kopo", "Immanuel"};
    JComboBox rs = new JComboBox(listrs);
    
    private ControllerPasien control = new ControllerPasien();
    
    public PreRujukan(){
        
        preRujukan.setSize(1200, 620);
        preRujukan.setLocationRelativeTo(null);
        preRujukan.setLayout(null);
        
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(10,520,1170,50);
        isi.setBounds(10,10,1170,500);
        
        isi.setBackground(Color.ORANGE);
        menu.setBackground(Color.ORANGE);
        
        menuPasien.setBounds(320, 10, 90, 30);
        menuDokter.setBounds(520, 10, 90, 30);
        menuAdmin.setBounds(720, 10, 120, 30);
        
        menu.add(menuDokter);
        menu.add(menuPasien);
        menu.add(menuAdmin);
        
        menuDokter.addActionListener(this);
        menuPasien.addActionListener(this);
        menuAdmin.addActionListener(this);
        
        labNid.setBounds(40, 10, 160, 25);
        textNid.setBounds(120, 10, 160, 25);
        
        namars.setBounds(40, 60, 160, 25);
        rs.setBounds(120, 60, 160, 25);
        
        submit.addActionListener(this);
        submit.setBounds(80, 120, 160, 25);
        
        isi.add(namars);
        isi.add(rs);
        isi.add(labNid);
        isi.add(textNid);
        isi.add(submit);

        preRujukan.add(isi);
        preRujukan.add(menu);
        
        preRujukan.setUndecorated(true);
        preRujukan.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        preRujukan.setVisible(true);
        preRujukan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
        
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                preRujukan.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                preRujukan.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                preRujukan.setVisible(false);
                break; 
            case "SUBMIT":
                String strnid = textNid.getText();
                Pasien pasien = control.getPasien(strnid);
                String strrs = String.valueOf(rs.getSelectedItem());;
                preRujukan.setVisible(false);
                new Rujukan(pasien, strrs);
            default: 
                break;
        }
    }
    
}