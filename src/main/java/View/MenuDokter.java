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

public class MenuDokter implements ActionListener{
    JFrame frame = new JFrame("MenuDokter");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    JButton insertDokter = new JButton("INSERT DOKTER");
    JButton updateDokter = new JButton("UPDATE DOKTER");
    JButton deleteDokter = new JButton("DELETE DOKTER");
    JButton absensiDokter = new JButton("ABSENSI DOKTER");
    JButton hitungGaji = new JButton("HITUNG GAJI");
    JLabel homePertama;
    
    
    public MenuDokter(){
        
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
        
        String homesPertama = "MENU DOKTER";
        
        homePertama = new JLabel(homesPertama);
        
        homePertama.setFont(new Font("Times New Roman", Font.BOLD, 30));
        
        homePertama.setBounds(465, 20, 750, 100);
        insertDokter.setBounds(475,100,200,50);
        updateDokter.setBounds(475,180,200,50);
        deleteDokter.setBounds(475,260,200,50);
        absensiDokter.setBounds(475,340,200,50);
        hitungGaji.setBounds(475,420,200,50);
        
        isi.add(homePertama);
        isi.add(insertDokter);
        isi.add(updateDokter);
        isi.add(deleteDokter);
        isi.add(absensiDokter);
        isi.add(hitungGaji);

        insertDokter.addActionListener(this);
        updateDokter.addActionListener(this);
        deleteDokter.addActionListener(this);
        absensiDokter.addActionListener(this);
        hitungGaji.addActionListener(this);

        frame.add(isi);
        frame.add(menu);
   
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        frame.setVisible(true);
    }

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
            case "INSERT DOKTER":
                new InputDokter();
                frame.setVisible(false);
                break;
            case "UPDATE DOKTER":
                new PreUpdateDokter();
                frame.setVisible(false);
                break;
            case "DELETE DOKTER":
                new DeleteDokter();
                frame.setVisible(false);
                break;
            case "ABSENSI DOKTER":
                new ViewAbsensiDokter();
                frame.setVisible(false);
                break;
            case "HITUNG GAJI":
                new PreHitungGaji();
                frame.setVisible(false);
                break;
            default: 
                break;
        }
    }
    
//    public static void main(String[] args){
//        new MenuDokter();
//    }
}
