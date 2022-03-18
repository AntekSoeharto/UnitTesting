/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerDokter;
import Model.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import Controller.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author V for Vladimir
 */
public class ViewJanjiTemu implements ActionListener{
    ControllerPasien conPasien = new ControllerPasien();
    ControllerTransaksi conTransaksi = new ControllerTransaksi();
    JFrame janjiTemu = new JFrame("Buat Janji Temu Pasien dengan Dokter");
    JLabel NIKLabel,poliLabel,dokterLabel,hargaLabel;
    JTextField NIKField;
    JComboBox<Object>dokterField,poliField;
    JButton buttonNext,buttonBuatJanji,buttonBack;
    JPanel panelContent,panelMenu;
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    
    public ViewJanjiTemu(){
        NIKLabel = new JLabel("NIK");
        poliLabel = new JLabel("poli");
        dokterLabel = new JLabel("nama dokter");
        hargaLabel = new JLabel("harga");
        String[] poli = {"Dokter Umum","Dokter THT","Dokter Spesialis Anak"};
        poliField = new JComboBox<>(poli);
        dokterField = new JComboBox<>();
        NIKField = new JTextField();
        buttonBuatJanji = new JButton("DONE");
        buttonNext = new JButton("NEXT");
        buttonBack = new JButton("BACK");
        panelContent = new JPanel();
        panelMenu = new JPanel();
        panelContent.setLayout(null);
        panelMenu.setLayout(null);
        
        janjiTemu.setSize(1200, 620);
        janjiTemu.setLayout(null);
        janjiTemu.setLocationRelativeTo(null);
        
        panelMenu.setBounds(10,520,1170,50);
        panelContent.setBounds(10,10,1170,500);
        
        panelContent.setBackground(Color.ORANGE);
        panelMenu.setBackground(Color.ORANGE);
        
        NIKLabel.setBounds(40, 10, 160, 25);
        poliLabel.setBounds(40, 50, 160, 25);
        dokterLabel.setBounds(40, 90, 160, 25);
        dokterField.setBounds(120, 90, 160, 25);
        NIKField.setBounds(120, 10, 160, 25);
        poliField.setBounds(120, 50, 160, 25);
        
        buttonBack.setBounds(80, 200, 100, 25);
        buttonNext.setBounds(200, 100, 100, 25);
        buttonBuatJanji.setBounds(280, 200, 100, 25);
        
        
        menuPasien.setBounds(320,10,90,30);
        menuDokter.setBounds(520,10,90,30);
        menuAdmin.setBounds(720,10,120,30);
        
        panelContent.add(NIKLabel);
        panelContent.add(NIKField);
        panelContent.add(poliLabel);
        panelContent.add(poliField);
        panelContent.add(dokterLabel);
        panelContent.add(dokterField);
        panelContent.add(buttonNext);
        panelContent.add(buttonBack);
        panelContent.add(buttonBuatJanji);
        
        buttonBuatJanji.setVisible(false);
        buttonBack.setVisible(false);
        dokterLabel.setVisible(false);
        dokterField.setVisible(false);
        
        panelMenu.add(menuAdmin);
        panelMenu.add(menuDokter);
        panelMenu.add(menuPasien);
        
        janjiTemu.add(panelContent);
        janjiTemu.add(panelMenu);
        
        menuDokter.addActionListener(this);
        menuPasien.addActionListener(this);
        menuAdmin.addActionListener(this);
        buttonNext.addActionListener(this);
        buttonBack.addActionListener(this);
        buttonBuatJanji.addActionListener(this);
        
        janjiTemu.setUndecorated(true);
        janjiTemu.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        janjiTemu.setVisible(true);
        janjiTemu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        ControllerDokter CD = new ControllerDokter();
        ArrayList<Dokter> DAL = CD.getAllDokter();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                janjiTemu.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                janjiTemu.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                janjiTemu.setVisible(false);
                break;
            case "NEXT":
                for (int i = 0; i < DAL.size(); i++) {
                    if(DAL.get(i).getPoliklinik().equals(poliField.getSelectedItem())){
                        dokterField.addItem(DAL.get(i).getNama());
                    }
                }
                dokterLabel.setVisible(true);
                dokterField.setVisible(true);
                buttonBack.setVisible(true);
                buttonBuatJanji.setVisible(true);
                poliField.setVisible(false);
                NIKField.setVisible(false);
                buttonNext.setVisible(false);
                poliLabel.setText("poliklinik : " + poliField.getSelectedItem());
                NIKLabel.setText("NIK : " + NIKField.getText());
                break;
            case "BACK":
                dokterField.removeAllItems();
                dokterLabel.setVisible(false);
                dokterField.setVisible(false);
                buttonBack.setVisible(false);
                buttonBuatJanji.setVisible(false);
                poliField.setVisible(true);
                NIKField.setVisible(true);
                buttonNext.setVisible(true);
                poliLabel.setText("poliklinik");
                NIKLabel.setText("NIK");
                break;
            case "DONE":
                String nik = NIKField.getText();
                Pasien pasien = conPasien.getPasien(nik);
                double hargaKonsul = 15000;
                Transaksi transaksi = new Transaksi();
                transaksi.setTanggalMasuk(new Date());
                transaksi.setIsBayar(false);
                int isBpjs = 0;
                if(pasien.getBPJS() == GolonganPasien.BPJS){
                    isBpjs = 1;
                }
                transaksi.setJenisPasien(isBpjs);
                transaksi.setHargaKonsultasi(15000);
                transaksi.setTotal(15000);
                transaksi.setPasien(pasien);
                transaksi.setHargaObat(0);
                transaksi.setJumlah(0);
                hargaLabel.setText("harga = " + hargaKonsul);
                conTransaksi.insterTransaksibyJanjiTemu(transaksi);
                janjiTemu.setVisible(false);
                JOptionPane.showMessageDialog(null, "Janji Temu Berhasil Dimasukan");
                new MenuPasien();
                
                break;
            default: 
                break;
        }
    }
}
