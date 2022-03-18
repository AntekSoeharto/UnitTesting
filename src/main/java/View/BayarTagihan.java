/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerTransaksi;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Model.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.WindowConstants;

/**
 *
 * @author hp
 */
public class BayarTagihan implements ActionListener{
    
    JFrame frameBayarTagihan = new JFrame("BAYAR TAGIHAN");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    JButton bayarTagihan = new JButton("BAYAR TAGIHAN");
    Transaksi tempTransaksi;

    public BayarTagihan(Transaksi transaksi){
        
        frameBayarTagihan.setSize(1200, 620);
        frameBayarTagihan.setLocationRelativeTo(null);
        frameBayarTagihan.setLayout(null);
        
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
        
        bayarTagihan.setBounds(120,200,150,30);
        bayarTagihan.addActionListener(this);

        JLabel labIdTransaksi = new JLabel("Id Transaksi : ");
        JLabel labNamaPasien = new JLabel("Nama : ");
        JLabel labTotalTagihan = new JLabel("Total Tagihan : ");
        
        JLabel isilabIdTransaksi = new JLabel(transaksi.getIdTransaksi());
        JLabel isilabNamaPasien = new JLabel(transaksi.getPasien().getNama());
        JLabel isilabTotalTagihan = new JLabel("" + transaksi.getTotal());
        
        labIdTransaksi.setBounds(40, 50, 160, 25);
        isilabIdTransaksi.setBounds(120, 50, 160, 25);
        labNamaPasien.setBounds(40, 100, 160, 25);
        isilabNamaPasien.setBounds(120, 100, 160, 25);
        labTotalTagihan.setBounds(40, 150, 160, 25);
        isilabTotalTagihan.setBounds(130, 150, 160, 25);
        
        isi.add(labIdTransaksi);
        isi.add(isilabIdTransaksi);
        isi.add(labNamaPasien);
        isi.add(isilabNamaPasien);
        isi.add(labTotalTagihan);
        isi.add(isilabTotalTagihan);
        
        bayarTagihan.addActionListener(this);
        isi.add(bayarTagihan);
        
        frameBayarTagihan.add(isi);
        frameBayarTagihan.add(menu);
        
        frameBayarTagihan.setUndecorated(true);
        frameBayarTagihan.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frameBayarTagihan.setVisible(true);
        frameBayarTagihan.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    
        tempTransaksi = transaksi;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                frameBayarTagihan.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                frameBayarTagihan.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                frameBayarTagihan.setVisible(false);
                break;
            case "BAYAR TAGIHAN":
                ControllerTransaksi.insertTransaksibyBayarTagihan(tempTransaksi);
                frameBayarTagihan.setVisible(false);
                new MenuAdmin();
                JOptionPane.showMessageDialog(null, "Pembayaran Telah Berhasil, Trimaksih");
                break;
            default: 
                break;
        }
    }
}
