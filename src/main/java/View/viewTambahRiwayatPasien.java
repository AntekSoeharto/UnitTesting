/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerObat;
import Controller.ControllerPasien;
import Controller.ControllerRiwayatPasien;
import Model.Obat;
import Model.Pasien;
import Model.RiwayatPasien;
import Model.Singleton;
import com.mysql.cj.util.StringUtils;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author V for Vladimir
 */
public class viewTambahRiwayatPasien implements ActionListener{
    JFrame viewTambahRiwayat = new JFrame("TAMBAH RIWAYAT PASIEN");
    JLabel NIKLabel,namaLabel,penyakitLabel,tanggalKunjunganLabel,jumlahObatLabel,keluhanLabel;
    JLabel[] namaObatLabel;
    JTextField NIKField,namaField,jumlahJenisObatField,keluhanTextField,penyakitTextField;
    JDatePickerImpl tglKunjungan;
    JDatePanelImpl datePanel;
    JTextField[] namaObatFields;
    JButton buttonInsert,buttonNext,buttonPrev;
    JPanel panelContent,panelMenu;
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
   
    public viewTambahRiwayatPasien(){
        jumlahObatLabel = new JLabel("jumlah jenis obat pasien");
        NIKLabel = new JLabel("NIK");
        namaLabel = new JLabel("Nama");
        keluhanLabel = new JLabel("Keluhan");
        penyakitLabel = new JLabel("penyakit");
        tanggalKunjunganLabel = new JLabel("tgl kunjungan");
        jumlahJenisObatField = new JTextField();
        NIKField  = new JTextField();
        namaField = new JTextField();
        keluhanTextField = new JTextField();
        penyakitTextField = new JTextField();
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);
        tglKunjungan = new JDatePickerImpl(datePanel,new Model.DateLabelFormatter());
        panelContent = new JPanel();
        panelMenu = new JPanel();
        buttonInsert = new JButton("TAMBAHKAN RIWAYAT PASIEN");
        buttonNext = new JButton("NEXT");
        buttonPrev = new JButton("PREV");
        panelContent.setLayout(null);
        panelMenu.setLayout(null);
        
        viewTambahRiwayat.setSize(1200, 620);
        viewTambahRiwayat.setLayout(null);
        viewTambahRiwayat.setLocationRelativeTo(null);
        
        panelMenu.setBounds(10,520,1170,50);
        panelContent.setBounds(10,10,1170,500);
        
        panelContent.setBackground(Color.ORANGE);
        panelMenu.setBackground(Color.ORANGE);
        
        NIKLabel.setBounds(40, 10, 100, 25);
        namaLabel.setBounds(40, 40, 100, 25);
        tanggalKunjunganLabel.setBounds(40, 70, 120, 25);
        keluhanLabel.setBounds(40, 100, 100, 25);
        penyakitLabel.setBounds(40, 130, 100, 25);
        jumlahObatLabel.setBounds(40, 160, 160, 25);
        
        NIKField.setBounds(150, 10, 120, 25);
        namaField.setBounds(150, 40, 120, 25);
        tglKunjungan.setBounds(170, 70, 120, 25);
        keluhanTextField.setBounds(150, 100, 120, 25);
        penyakitTextField.setBounds(150, 130, 120, 25);
        jumlahJenisObatField.setBounds(220, 160, 120, 25);
        
        buttonPrev.setBounds(80, 200, 100, 25);
        buttonInsert.setBounds(200, 250, 250, 25);
        buttonNext.setBounds(200,200, 100, 25);
       
        menuPasien.setBounds(320,10,90,30);
        menuDokter.setBounds(520,10,90,30);
        menuAdmin.setBounds(720,10,120,30);
        
        panelContent.add(NIKLabel);
        panelContent.add(namaLabel);
        panelContent.add(tanggalKunjunganLabel);
        panelContent.add(keluhanLabel);
        panelContent.add(penyakitLabel);
        panelContent.add(jumlahObatLabel);
        panelContent.add(NIKField);
        panelContent.add(namaField);
        panelContent.add(tglKunjungan);
        panelContent.add(keluhanTextField);
        panelContent.add(penyakitTextField);
        panelContent.add(jumlahJenisObatField);
        panelContent.add(buttonPrev);
        panelContent.add(buttonNext);
        panelContent.add(buttonInsert);
        
        buttonInsert.setVisible(false);
        buttonPrev.setVisible(false);
        
        panelMenu.add(menuDokter);
        panelMenu.add(menuPasien);
        panelMenu.add(menuAdmin);
        
        viewTambahRiwayat.add(panelContent);
        viewTambahRiwayat.add(panelMenu);
        
        menuDokter.addActionListener(this);
        menuPasien.addActionListener(this);
        menuAdmin.addActionListener(this);
        buttonInsert.addActionListener(this);
        buttonNext.addActionListener(this);
        buttonPrev.addActionListener(this);
        
        viewTambahRiwayat.setUndecorated(true);
        viewTambahRiwayat.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        viewTambahRiwayat.setVisible(true);
        viewTambahRiwayat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                viewTambahRiwayat.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                viewTambahRiwayat.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                viewTambahRiwayat.setVisible(false);
                break;
            case "NEXT":
                NIKLabel.setText("NIK " + NIKField.getText());
                namaLabel.setText("Nama " + namaField.getText());
                tanggalKunjunganLabel.setText("tgl kunjungan " + tglKunjungan.getModel().getValue());
                keluhanLabel.setText("keluhan " + keluhanTextField.getText());
                penyakitLabel.setText("penyakit " + penyakitTextField.getText());
                jumlahObatLabel.setText("jumlah jenis obat " + jumlahJenisObatField.getText());
                NIKField.setVisible(false);
                namaField.setVisible(false);
                tglKunjungan.setVisible(false);
                keluhanTextField.setVisible(false);
                penyakitTextField.setVisible(false);
                jumlahJenisObatField.setVisible(false);
                buttonInsert.setVisible(true);
                buttonPrev.setVisible(true);
                buttonNext.setVisible(false);
                
                String jmlObatStr = jumlahJenisObatField.getText();
                if(!jmlObatStr.equals("")){
                    try {
                        int jml = Integer.parseInt(jmlObatStr);
                        namaObatFields = new JTextField[jml];
                        namaObatLabel = new JLabel[jml];
                        String[] strValue = new String[jml];
                        for(int i = 0;i < namaObatFields.length;i++){
                            namaObatLabel[i] = new JLabel("nama obat " + (i+1));
                            namaObatFields[i] = new JTextField();
                            
                            namaObatFields[i].setBounds(360, 190 + (i * 30), 140, 25);
                            namaObatLabel[i].setBounds(240, 190 + (i * 30), 120, 25);
                            
                            panelContent.add(namaObatFields[i]);
                            panelContent.add(namaObatLabel[i]);
                        }
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(null, "input is not a number!");
                    }
                }
                panelContent.validate();
                panelContent.repaint();
                break;
            case "PREV":
                NIKLabel.setText("NIK");
                namaLabel.setText("Nama");
                tanggalKunjunganLabel.setText("tgl kunjungan");
                keluhanLabel.setText("keluhan");
                penyakitLabel.setText("penyakit");
                jumlahObatLabel.setText("jumlah jenis obat");
                NIKField.setVisible(true);
                namaField.setVisible(true);
                tglKunjungan.setVisible(true);
                keluhanTextField.setVisible(true);
                penyakitTextField.setVisible(true);
                jumlahJenisObatField.setVisible(true);
                buttonInsert.setVisible(false);
                buttonNext.setVisible(true);
                buttonPrev.setVisible(false);
                
                if(namaObatFields.length > 0){
                    for(int i = 0 ;i < namaObatFields.length ;i++){
                        namaObatFields[i].setVisible(false);
                        namaObatLabel[i].setVisible(false);
                        panelContent.remove(namaObatFields[i]);
                        panelContent.remove(namaObatLabel[i]);
                    }
                }
                break;
            case "TAMBAHKAN RIWAYAT PASIEN":
                Pasien p = new Pasien();
                try {
                    p = ControllerPasien.getPasien(NIKField.getText());
                    RiwayatPasien RP = new RiwayatPasien();
                    RP.setKeluhan(keluhanTextField.getText());
                    RP.setPenyakit(penyakitTextField.getText());
                    List<String> namaObats = new ArrayList<>();
                    ArrayList<Obat> obatPasien = new ArrayList<>();
                    RP.setTanggalKunjungan((Date)tglKunjungan.getModel().getValue());
                    System.out.println(p.getNIK());
                    for(int i = 0 ; i < namaObatFields.length ; i++){
                        obatPasien.add(new ControllerObat().getObat(namaObatFields[i].getText()));
                        ControllerObat.insertResepObatPasien(obatPasien.get(i).getIDObat(), NIKField.getText());
                    }
                    RP.setResepObat(namaObats);
                    ControllerRiwayatPasien.insertNewRiwayatPasien(RP,p.getNIK());
                    JOptionPane.showMessageDialog(null, "riwayat pasien berhasil ditambah");
                    viewTambahRiwayat.dispose();
                    new MenuPasien();
                } catch (Exception exc) {
                    p = ControllerPasien.getPasien(NIKField.getText());
                    System.out.println(p.getNama());
                    JOptionPane.showMessageDialog(null, "Pasien tidak ditemukan!");
                }
                break;
            default: 
                break;
        }
    }
}
