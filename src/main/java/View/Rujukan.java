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

public class Rujukan implements ActionListener{
    
    JFrame rujukan = new JFrame("RUJUKAN");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    JTextArea rujuks;
    String text;
    
    
    public Rujukan(Pasien pasien, String rs){
        
        rujukan.setSize(1200, 620);
        rujukan.setLocationRelativeTo(null);
        rujukan.setLayout(null);
        
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
        
        text = "\n\n\n\n\t\t\t\tSurat Rujukan Pasien\n\tKami dari staff dan dokter dari puskesmas ingin mengirim pasien kami.";
        text += "Karena\nalasan kekurangn sumber daya manusia dan alat medis di puskesmas kami. Dengan ini data pasien:\n";
        text += "\tNIK\t: " + pasien.getNama() + "\n";
        text += "\tNama\t: " + pasien.getNama() + "\n";
        text += "\tTelepon\t: " + pasien.getTelepon() + "\n";
        text += "\t Dengan ini kami menyatakan bahwa tanggung jawab pasien ini ada di tangan Rumah Sakit " + rs;
        text += ".\nAtas Kerjasamanya Terimakasih\n\n\n\n\n\n\n";
        text += "\t\t\t\t\t\tStaff Puskesmas\n\n\n";
        text += "\t\t\t\t\t\t" + Singleton.getInstance().getStaff().getUsername();
        
        rujuks = new JTextArea(text);
        rujuks.setBounds(10, 10, 1000, 600);
        rujuks.setFont(rujuks.getFont().deriveFont(15f));
        System.out.println(text);
        isi.add(rujuks);
        String bpjs = String.valueOf(pasien.getBPJS());
        
        rujukan.add(isi);
        rujukan.add(menu);
        
        rujukan.setUndecorated(true);
        rujukan.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        rujukan.setVisible(true);
        rujukan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                rujukan.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                rujukan.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                rujukan.setVisible(false);
                break;
            default: 
                break;
        }
    }
    
}