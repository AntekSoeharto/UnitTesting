/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Singleton;
import java.awt.Font;
import java.awt.Color;
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
public class MenuAdmin implements ActionListener{
    
    JFrame frame = new JFrame("MENU ADMIN");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    JButton logout = new JButton("LOG OUT");
    JButton inputObat = new JButton("INPUT OBAT");
    JButton restockObat = new JButton("RESTOCK OBAT");
    JButton rujukan = new JButton("RUJUKAN");
    JButton transaksi = new JButton("TRANSAKSI");
    JLabel homePertama;
    
    public MenuAdmin(){
        
        frame.setSize(1200, 620);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(10,520,1170,50);
        isi.setBounds(10,10,1170,500);
        
        isi.setBackground(Color.ORANGE);
        menu.setBackground(Color.ORANGE);
        
        menuPasien.setBounds(250,10,90,30);
        menuDokter.setBounds(430,10,90,30);
        menuAdmin.setBounds(590,10,120,30);
        logout.setBounds(790,10,120,30);
        
        menu.add(menuDokter);
        menu.add(menuPasien);
        menu.add(menuAdmin);
        menu.add(logout);
        
        menuDokter.addActionListener(this);
        menuPasien.addActionListener(this);
        menuAdmin.addActionListener(this);
        logout.addActionListener(this);
        
        String homesPertama = "MENU ADMINISTRASI";
        
        homePertama = new JLabel(homesPertama);
        
        homePertama.setFont(new Font("Times New Roman", Font.BOLD, 30));
        
        homePertama.setBounds(420, 20, 750, 100);
        inputObat.setBounds(475,120,200,50);
        restockObat.setBounds(475,220,200,50);
        rujukan.setBounds(475,320,200,50);
        transaksi.setBounds(475,420,200,50);
        
        isi.add(homePertama);
        isi.add(inputObat);
        isi.add(restockObat);
        isi.add(rujukan);
        isi.add(transaksi);
        
        inputObat.addActionListener(this);
        restockObat.addActionListener(this);
        rujukan.addActionListener(this);
        transaksi.addActionListener(this);
        
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
            case "INPUT OBAT":
                new InputObat();
                frame.setVisible(false);
                break;
            case "RESTOCK OBAT":
                new ReStockObat();
                frame.setVisible(false);
                break;
            case "LOG OUT"    :
                Singleton.getInstance().setStaff(null);
                Singleton.getInstance().setCabang(null);
                frame.setVisible(false);;
                new LoginScreen();
                break;
            case "RUJUKAN":
                new PreRujukan();
                frame.setVisible(false);
                break;
            case "TRANSAKSI":
                new MenuTransaksi();
                frame.setVisible(false);
                break;
            default: 
                break;
        }
    }
    
}
