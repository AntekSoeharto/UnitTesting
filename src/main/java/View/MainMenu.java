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

public class MainMenu implements ActionListener{
    
    JFrame frame = new JFrame("MAIN MENU");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    JLabel homePertama;
    JLabel homeKedua;
    
    public MainMenu(){
        
        frame.setSize(1200, 620);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(10,520,1170,50);
        isi.setBounds(10,10,1170,500);
        
        menu.setBackground(Color.ORANGE);
        isi.setBackground(Color.ORANGE);

        menuPasien.setBounds(320,10,90,30);
        menuDokter.setBounds(520,10,90,30);
        menuAdmin.setBounds(720,10,120,30);
        
        menu.add(menuDokter);
        menu.add(menuPasien);
        menu.add(menuAdmin);

        menuDokter.addActionListener(this);
        menuPasien.addActionListener(this);
        menuAdmin.addActionListener(this);
        
        String homesPertama = "SELAMAT DATANG DI PROGRAM PUSKESMAS";
        String homesKedua = "Cabang : " + Singleton.getInstance().getCabang().getNama();
        
        homePertama = new JLabel(homesPertama);
        homeKedua = new JLabel(homesKedua);
        
        homePertama.setFont(new Font("Times New Roman", Font.BOLD, 33));
        homeKedua.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        
        homePertama.setBounds(100, 20, 750, 100);
        homeKedua.setBounds(100, 110, 500, 100);
   
        isi.add(homePertama);
        isi.add(homeKedua);

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
            default: 
                break;
        }
    }
    
}