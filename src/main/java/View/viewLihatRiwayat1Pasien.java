/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerRiwayatPasien;
import Model.RiwayatPasien;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author V for Vladimir
 */
public class viewLihatRiwayat1Pasien implements ActionListener{
    JFrame lihatRiwayatPasien = new JFrame("Lihat Riwayat Pasien");
    JLabel NIKInputLabel,tglKunjunganInput,namaLabel;
    JTextField NIKInputField;
    JTable tableRiwayatPasien;
    JButton lihatRiwayat;
    JPanel panelMenu,panelContent;
    JScrollPane scrollPane;
    JDatePickerImpl tglKunjungan;
    JDatePanelImpl datePanel;
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
   
    public viewLihatRiwayat1Pasien() {
        namaLabel = new JLabel("Nama : ");
        NIKInputLabel = new JLabel("NIK");
        NIKInputField = new JTextField();
        panelMenu = new JPanel();
        panelContent = new JPanel();
        lihatRiwayat = new JButton("LIHAT RIWAYAT");
        
        NIKInputLabel.setBounds(10,10,120,25);
        NIKInputField.setBounds(140,10,120,25);
        lihatRiwayat.setBounds(100, 80, 150, 30);
        
        menuPasien.setBounds(320,10,90,30);
        menuDokter.setBounds(520,10,90,30);
        menuAdmin.setBounds(720,10,120,30);
        
        panelContent.add(NIKInputLabel);
        panelContent.add(NIKInputField);
        panelContent.add(lihatRiwayat);
        
        panelMenu.add(menuDokter);
        panelMenu.add(menuPasien);
        panelMenu.add(menuAdmin);
        
        lihatRiwayatPasien.setSize(1200, 620);
        lihatRiwayatPasien.setLocationRelativeTo(null);
        lihatRiwayatPasien.setLayout(null);
        panelMenu.setLayout(null);
        panelContent.setLayout(null);
        panelMenu.setBounds(10,520,1170,50);
        panelContent.setBounds(10,10,1170,500);
        panelMenu.setBackground(Color.ORANGE);
        panelContent.setBackground(Color.ORANGE);
        
        lihatRiwayat.addActionListener(this);
        menuDokter.addActionListener(this);
        menuPasien.addActionListener(this);
        menuAdmin.addActionListener(this);
        
        lihatRiwayatPasien.add(panelContent);
        lihatRiwayatPasien.add(panelMenu);
        lihatRiwayatPasien.setUndecorated(true);
        lihatRiwayatPasien.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        lihatRiwayatPasien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lihatRiwayatPasien.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                lihatRiwayatPasien.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                lihatRiwayatPasien.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                lihatRiwayatPasien.setVisible(false);
                break;
            case "LIHAT RIWAYAT":
                String[] column = {"tgl kunjungan","keluhan","penyakit","resep obat"};
                ArrayList<RiwayatPasien> RP = ControllerRiwayatPasien.getAllRiwayatPasiens(NIKInputField.getText());
                ArrayList<String> resepObat = ControllerRiwayatPasien.getResepObat1Pasien(NIKInputField.getText());
                StringBuffer sb = new StringBuffer();
                String data[][] = new String[RP.size()][4];
                for(int i = 0; i < RP.size(); i++){
                    data[i][0] = String.valueOf(RP.get(i).getTanggalKunjungan());
                    data[i][1] = RP.get(i).getKeluhan();
                    data[i][2] = RP.get(i).getPenyakit();
                    for(String s : resepObat){
                        sb.append(s);
                        sb.append(",");
                    }
                    String str = sb.toString();
                    data[i][3] = str;
                }
                tableRiwayatPasien = new JTable(data,column);
                scrollPane = new JScrollPane(tableRiwayatPasien);
                scrollPane.setBounds(10,150,910,200);
                panelContent.add(scrollPane);
                break;
            default: 
                break;
        }
    }
}
