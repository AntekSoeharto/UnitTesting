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

import Controller.ControllerDokter;
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
import java.util.Date;
import java.util.Properties;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class ViewAbsensiDokter implements ActionListener{
    
    JFrame absensiDokter = new JFrame("ABSENSI DOKTER");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    JLabel labNid = new JLabel("NID");
    JLabel labTanggal = new JLabel("Tanggal");
    JLabel labStatus = new JLabel("Status");
    JTextField textNid = new JTextField();
     
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    JButton submit = new JButton("SUBMIT");
    UtilDateModel model = new UtilDateModel();
    Properties p = new Properties();
    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    String[] listStatus = {"HADIR", "ALPHA", "IZIN"};
    JComboBox Status = new JComboBox(listStatus);
    private ControllerDokter control = new ControllerDokter();
    
    
    
    public ViewAbsensiDokter(){
        
        absensiDokter.setSize(1200, 620);
        absensiDokter.setLocationRelativeTo(null);
        absensiDokter.setLayout(null);
       
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
        
        labNid.setBounds(40, 10, 160, 25);
        labTanggal.setBounds(40, 50, 160, 25);
        labStatus.setBounds(40, 90, 160, 25);
        textNid.setBounds(120, 10, 160, 25);
        Status.setBounds(120, 90, 160, 25);
        
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePicker.setBounds(120, 50, 160, 25);
        
        submit.addActionListener(this);
        submit.setBounds(80, 150, 100, 25);
        
        isi.add(labNid);
        isi.add(textNid);
        isi.add(labTanggal);
        isi.add(datePicker);
        isi.add(labStatus);
        isi.add(Status);
        isi.add(submit);        
      
        absensiDokter.add(isi);
        absensiDokter.add(menu);
      
        
        absensiDokter.setUndecorated(true);
        absensiDokter.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        absensiDokter.setVisible(true);
        absensiDokter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                absensiDokter.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                absensiDokter.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                absensiDokter.setVisible(false);
                break; 
            case "SUBMIT":
                String strnid = textNid.getText();
                String strtanggal = model.getDay() + "-" + model.getMonth() + "-" + model.getYear();
                String strstatus = String.valueOf(Status.getSelectedItem());
                Date tanggal = (Date)datePicker.getModel().getValue();
                boolean absen = control.addAbsen(strnid, tanggal, strstatus);
                absensiDokter.setVisible(false);
                JOptionPane.showMessageDialog(null,"Absen Dengan NID " + strnid + ", Telah Diisi");
                new MenuDokter();
                
            default: 
                break;
        }
    }
    
}