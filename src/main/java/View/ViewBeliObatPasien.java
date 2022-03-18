/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerObat;
import Controller.ControllerPasien;
import Controller.ControllerTransaksi;
import Model.GolonganPasien;
import Model.Obat;
import Model.Transaksi;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author V for Vladimir
 */
public class ViewBeliObatPasien implements ActionListener{
    Transaksi t = new Transaksi();
    JFrame beliObatPasien = new JFrame("JUMLAH JENIS OBAT ");
    JLabel jumlahJenisObatLabel,totalHargaLabel;
    JLabel[] namaObatLabel,jumlahObatLabel;
    JTextField jumlahJenisObatField;
    JTextField[] namaObatFields,jumlahObatFields;
    JButton buttonHitungTotalHarga,buttonLanjut,buttonPrev;
    JPanel panelContent,panelMenu;
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    String NIKInput;
    double hargaKonsul;
    Transaksi tempTransaksi;
    
    public ViewBeliObatPasien(Transaksi transaksi){
        totalHargaLabel = new JLabel();
        beliObatPasien.setSize(1200, 620);
        jumlahJenisObatLabel = new JLabel("Jumlah Jenis Obat");
        jumlahJenisObatField = new JTextField();
        
        buttonLanjut = new JButton("NEXT");
        buttonHitungTotalHarga = new JButton("HITUNG TOTAL HARGA");
        buttonPrev = new JButton("BACK");
        panelContent = new JPanel();
        panelMenu = new JPanel();
        
        buttonPrev.setVisible(false);
        buttonHitungTotalHarga.setVisible(false);
        panelContent.setLayout(null);
        panelMenu.setLayout(null);
        
        panelContent.setBackground(Color.ORANGE);
        panelMenu.setBackground(Color.ORANGE);
        
        panelMenu.setBounds(10,520,1170,50);
        panelContent.setBounds(10,10,1170,500);
        
        jumlahJenisObatLabel.setBounds(40, 20, 160, 25);
        jumlahJenisObatField.setBounds(150, 20, 160, 25);
        buttonLanjut.setBounds(40, 120, 120, 30);
        buttonPrev.setBounds(40, 120, 120, 30);
        buttonHitungTotalHarga.setBounds(200, 120, 170, 30);
        totalHargaLabel.setBounds(60, 140, 160, 25);
        
        menuPasien.setBounds(320,10,90,30);
        menuDokter.setBounds(520,10,90,30);
        menuAdmin.setBounds(720,10,120,30);
        
        panelContent.add(jumlahJenisObatLabel);
        panelContent.add(jumlahJenisObatField);
        panelContent.add(buttonLanjut);
        panelContent.add(buttonHitungTotalHarga);
        panelContent.add(buttonPrev);
        panelContent.add(totalHargaLabel);
        
        panelMenu.add(menuPasien);
        panelMenu.add(menuDokter);
        panelMenu.add(menuAdmin);
        
        beliObatPasien.add(panelMenu);
        beliObatPasien.add(panelContent);
        beliObatPasien.setLayout(null);
        beliObatPasien.setLocationRelativeTo(null);
        
        buttonLanjut.addActionListener(this);
        buttonHitungTotalHarga.addActionListener(this);
        buttonPrev.addActionListener(this);
        
        menuDokter.addActionListener(this);
        menuPasien.addActionListener(this);
        menuAdmin.addActionListener(this);
        tempTransaksi = transaksi;
        
        beliObatPasien.setUndecorated(true);
        beliObatPasien.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        beliObatPasien.setVisible(true);
        beliObatPasien.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                beliObatPasien.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                beliObatPasien.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                beliObatPasien.setVisible(false);
                break;
            case "NEXT":
                jumlahJenisObatLabel.setVisible(false);
                jumlahJenisObatField.setVisible(false);
                buttonHitungTotalHarga.setVisible(true);
                buttonPrev.setVisible(true);
                buttonLanjut.setVisible(false);
                try {
                    String jmlStr = jumlahJenisObatField.getText();
                    int jml = Integer.parseInt(jmlStr);
                    namaObatFields = new JTextField[jml];
                    namaObatLabel = new JLabel[jml];
                    jumlahObatLabel = new JLabel[jml];
                    jumlahObatFields = new JTextField[jml];
                    for(int i = 0; i < jml; i++){
                        namaObatLabel[i] = new JLabel("Nama Obat " + (i+1));
                        jumlahObatLabel[i] = new JLabel("Jumlah Obat " + (i+1) + " (Miligram)");
                        namaObatFields[i] = new JTextField();
                        jumlahObatFields[i] = new JTextField();
                        
                        namaObatLabel[i].setBounds(10, (i*3+1)*10, 100, 25);
                        namaObatFields[i].setBounds(130, (i*3+1)*10, 120, 25);
                        jumlahObatLabel[i].setBounds(270, (i*3+1)*10, 180, 25);
                        jumlahObatFields[i].setBounds(470, (i*3+1)*10, 120, 25);
                        
                        panelContent.add(namaObatLabel[i]);
                        panelContent.add(namaObatFields[i]);
                        panelContent.add(jumlahObatLabel[i]);
                        panelContent.add(jumlahObatFields[i]);
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "INPUT BUKAN ANGKA!");
                    if(JOptionPane.OK_OPTION == 0){
                        jumlahJenisObatField.setText("");
                    }
                }
                panelContent.validate();
                panelContent.repaint();
                break;
            case "HITUNG TOTAL HARGA":
                int hargaKonsul = 15000;
                int golonganPasien = 0;
                if(ControllerPasien.getPasien(NIKInput).getBPJS() == GolonganPasien.BPJS){
                    golonganPasien = 1;
                }else{
                    golonganPasien = 2;
                }
                t.setHargaKonsultasi(hargaKonsul);
                ControllerObat CO = new ControllerObat();
                int[] stockObat = new int[namaObatFields.length];
                int totalHarga = 0;
                for(int i = 0; i < namaObatFields.length; i++){
                    stockObat[i] = 0;
                    String IDObat = CO.getObat(namaObatFields[i].getText()).getIDObat();
                    stockObat[i] = CO.getStockObat(IDObat);
                    int jumlahBeli = Integer.parseInt(jumlahObatFields[i].getText());
                    totalHarga += CO.getObat(namaObatFields[i].getText()).getHargaJual() * (jumlahBeli/10);
                    CO.updateStockObat(IDObat, stockObat[i] - jumlahBeli);
                }
                if(tempTransaksi.getPasien().getBPJS() == GolonganPasien.BPJS){
                    tempTransaksi.setHargaObat(0);
                    tempTransaksi.setTotal(hargaKonsul);
                }else{
                    tempTransaksi.setHargaObat(totalHarga);
                    tempTransaksi.setTotal(tempTransaksi.getHargaKonsultasi() + totalHarga);
                }
                t.setHargaObat(totalHarga);
                t.setJenisPasien(golonganPasien);
                
                tempTransaksi.setJumlah(namaObatFields.length);
                t.setJumlah(namaObatFields.length);
                Date hariIni = new Date();
                t.setTanggalMasuk(hariIni);
                t.setTotal(totalHarga + hargaKonsul);
                ControllerTransaksi.insertTransaksibyBeliObat(tempTransaksi);
                 //ControllerTransaksi.insertNewTransaksi(t);
                totalHargaLabel.setText("Total Harga : " + t.getTotal());
                beliObatPasien.setVisible(false);
                JOptionPane.showMessageDialog(null, "Pembelian Obat Telah Selesai");
                new MenuAdmin();
                break;
            case "BACK" :
                jumlahJenisObatLabel.setVisible(true);
                jumlahJenisObatField.setVisible(true);
                buttonLanjut.setVisible(true);
                buttonPrev.setVisible(false);
                buttonHitungTotalHarga.setVisible(false);
                if(namaObatFields.length > 0){
                    for(int i = 0 ;i < namaObatFields.length ;i++){
                        namaObatFields[i].setVisible(false);
                        namaObatLabel[i].setVisible(false);
                        jumlahObatFields[i].setVisible(false);
                        jumlahObatLabel[i].setVisible(false);
                        panelContent.remove(namaObatFields[i]);
                        panelContent.remove(namaObatLabel[i]);
                        panelContent.remove(jumlahObatLabel[i]);
                        panelContent.remove(jumlahObatFields[i]);
                    }
                }
            default: 
                break;
        }
    }
}
