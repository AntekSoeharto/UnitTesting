/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerObat;
import Model.Obat;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author hp
 */

public class ReStockObat implements ActionListener{
    private ControllerObat control = new ControllerObat();
    JFrame restockObat = new JFrame("RESTOCK OBAT");
    JLabel namaObatLabel,tglBeliLabel,tglKadaluarsaLabel,StockLabel;
    UtilDateModel model1 = new UtilDateModel();
    UtilDateModel model2 = new UtilDateModel();
    Properties p = new Properties();
    JTextField textStok,namaObatField;
    JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p);
    JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
    JDatePickerImpl tglBeli = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
    JDatePickerImpl tglKadaluarsa = new JDatePickerImpl(datePanel2, new DateLabelFormatter());

    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    
    JButton submit = new JButton("SUBMIT");
    
    public ReStockObat(){
        namaObatLabel = new JLabel("Nama Obat");
        tglBeliLabel = new JLabel("Tanggal Beli");
        tglKadaluarsaLabel = new JLabel("Tanggal Kadaluarsa");
        StockLabel = new JLabel("Stock");
        textStok = new JTextField();
        namaObatField = new JTextField();
        
        restockObat.setSize(1200, 620);
        restockObat.setLocationRelativeTo(null);
        restockObat.setLayout(null);
        
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(10,520,1170,50);
        isi.setBounds(10,10,1170,500);
        
        isi.setBackground(Color.ORANGE);
        menu.setBackground(Color.ORANGE);
        
        menuDokter.setBounds(320,10,90,30);
        menuPasien.setBounds(520,10,90,30);
        menuAdmin.setBounds(720,10,120,30);
        
        namaObatLabel.setBounds(40, 10, 160, 25);
        tglBeliLabel.setBounds(40, 60, 160, 25);
        tglKadaluarsaLabel.setBounds(40, 120, 160, 25);
        StockLabel.setBounds(40, 170, 120, 25);
        
        namaObatField.setBounds(160, 10, 160, 25);
        tglBeli.setBounds(160, 60, 160, 25);
        tglKadaluarsa.setBounds(160, 120, 160, 25);
        textStok.setBounds(160, 170, 160, 25);
        
        submit.setBounds(80, 220, 100, 25);
        
        isi.add(namaObatLabel);
        isi.add(tglBeliLabel);
        isi.add(tglKadaluarsaLabel);
        isi.add(StockLabel);
        isi.add(namaObatField);
        isi.add(tglBeli);
        isi.add(tglKadaluarsa);
        isi.add(textStok);
        isi.add(submit);
        
        menu.add(menuDokter);
        menu.add(menuPasien);
        menu.add(menuAdmin);
        
        menuDokter.addActionListener(this);
        menuPasien.addActionListener(this);
        menuAdmin.addActionListener(this);
        
        submit.addActionListener(this);
        
        restockObat.add(isi);
        restockObat.add(menu);
        
        restockObat.setUndecorated(true);
        restockObat.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        restockObat.setVisible(true);
        restockObat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                restockObat.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                restockObat.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                restockObat.setVisible(false);
                break;
            case "SUBMIT":
                String strnama = namaObatField.getText();
                int stok = Integer.parseInt(textStok.getText());
                String strtglbeli = model1.getYear() + "-" + model1.getMonth() + "-" + model1.getDay();
                String strtglkadal = model2.getYear() + "-" + model2.getMonth() + "-" + model2.getDay();
                
                Obat obat = new Obat();
                obat.setIDMasaLakuObat(control.getIDMLO());
                obat.setIDObat(control.getObat(strnama).getIDObat());
                obat.setStok(stok);
                obat.setTgl_beli(strtglbeli);
                obat.setTgl_kadaluarsa(strtglkadal);
                boolean input = control.beliObat(obat);
                if(input == true){
                    restockObat.setVisible(false);
                    JOptionPane.showMessageDialog(null,"Data Sudah Di Tambah");
                    new MenuAdmin();
                    restockObat.setVisible(false);
                }
            default: 
                break;
        }
    }
}
