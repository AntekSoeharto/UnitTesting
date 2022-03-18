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
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import Controller.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InputDokter implements ActionListener{
    private ControllerDokter control = new ControllerDokter();
    JFrame inputDokter = new JFrame("INPUT DOKTER");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    JButton submit = new JButton("SUBMIT");
    
    JLabel labNik = new JLabel("NIK");
    JLabel labNama = new JLabel("Nama");
    JLabel labTgllahir = new JLabel("Tanggal Lahir");
    JLabel labGoldar = new JLabel("Golongan Darah");
    JLabel labGender = new JLabel("Jenis Kelamin");
    JLabel labNid = new JLabel("NID");
    JLabel labPoli = new JLabel("Poloklinik");
    JLabel labNotelp = new JLabel("No Telepon");
    JLabel labAlamat = new JLabel("Alamat");
    JTextField textNik = new JTextField();
    JTextField textNama = new JTextField();
    UtilDateModel model = new UtilDateModel();
    Properties p = new Properties();
    JRadioButton male = new JRadioButton("Pria");
    JRadioButton female = new JRadioButton("Wanita");
    JTextField textNid = new JTextField();
    JTextField textNotelp = new JTextField();
    JRadioButton golo = new JRadioButton("O");
    JRadioButton gola = new JRadioButton("A");
    JRadioButton golb = new JRadioButton("B");
    JRadioButton golab = new JRadioButton("AB");
    String[] listPoli = {"Belum Dipilih", "Dokter Umum", "Dokter Spesialis Anak", "Dokter THT"};
    JComboBox Poli = new JComboBox(listPoli);
    JTextField textAlamat = new JTextField();
    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    
    public InputDokter(){
        //template
        inputDokter.setSize(1200, 620);
        inputDokter.setLocationRelativeTo(null);
        inputDokter.setLayout(null);
        
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
        //akhir template
        
        //isi menu
        
        labNik.setBounds(40, 10, 160, 25);
        isi.add(labNik);
        textNik.setBounds(120, 10, 160, 25);
        isi.add(textNik);
       
        labNama.setBounds(40, 90, 160, 25);
        isi.add(labNama);
        textNama.setBounds(120, 90, 160, 25);
        isi.add(textNama);
        
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        
        datePicker.setBounds(120, 50, 160, 25);
        labTgllahir.setBounds(40, 50, 160, 25);
        isi.add(labTgllahir);
        isi.add(datePicker);
        
        labGoldar.setBounds(40, 130, 160, 25);
        isi.add(labGoldar);
        
        golo.setBounds(140, 135, 50, 15);
        gola.setBounds(190, 135, 50, 15);
        golb.setBounds(240, 135, 50, 15);
        golab.setBounds(290, 135, 50, 15);
        
        golo.setBackground(Color.ORANGE);
        gola.setBackground(Color.ORANGE);
        golb.setBackground(Color.ORANGE);
        golab.setBackground(Color.ORANGE);
        
        ButtonGroup gd = new ButtonGroup();
        
        gd.add(golo);
        gd.add(gola);
        gd.add(golb);
        gd.add(golab);
        
        isi.add(golo);
        isi.add(gola);
        isi.add(golb);
        isi.add(golab);
        
        labGender.setBounds(40, 160, 160, 25);
        isi.add(labGender);
        
        male.setBounds(140, 165, 50, 15);
        female.setBounds(190, 165, 70, 15);
        
        male.setBackground(Color.ORANGE);
        female.setBackground(Color.ORANGE);
        
        ButtonGroup jenisK = new ButtonGroup();
        
        jenisK.add(male);
        jenisK.add(female);
        
        isi.add(male);
        isi.add(female);
        
        labNid.setBounds(40, 200, 160, 25);
        isi.add(labNid);
        textNid.setBounds(120, 200, 160, 25);
        isi.add(textNid);
        
        labPoli.setBounds(40, 250, 160, 25);
        isi.add(labPoli);
        Poli.setBounds(120, 250, 160, 25);
        isi.add(Poli);
        
        labNotelp.setBounds(40, 300, 160, 25);
        isi.add(labNotelp);
        textNotelp.setBounds(120, 300, 160, 25);
        isi.add(textNotelp);
        
        labAlamat.setBounds(40, 350, 160, 25);
        isi.add(labAlamat);
        textAlamat.setBounds(120, 350, 160, 25);
        isi.add(textAlamat);
        
        submit.setBounds(80,400,100, 25);
        submit.addActionListener(this);
        isi.add(submit);
        
        inputDokter.add(isi);
        inputDokter.add(menu);
        
        inputDokter.setUndecorated(true);
        inputDokter.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        inputDokter.setVisible(true);
        inputDokter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    }
    
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                inputDokter.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                inputDokter.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                inputDokter.setVisible(false);
                break;
            case "SUBMIT":
                String strnik = textNik.getText();
                String strnama = textNama.getText();
                String strlahir = model.getDay() + "-" + model.getMonth() + "-" + model.getYear();
                String strgoldar = "";
                if (gola.isSelected()) {
                    strgoldar = gola.getText();
                } else if (golb.isSelected()) {
                    strgoldar = golb.getText();
                } else if (golo.isSelected()) {
                    strgoldar = golo.getText();
                } else if (golab.isSelected()) {
                    strgoldar = golab.getText();
                }
                
                String strgender = "";
                if (male.isSelected()) {
                    strgender = male.getText();
                } else if (female.isSelected()) {
                    strgender = female.getText();
                }
                
                String strnid = textNid.getText();
                String strpoli = "";
                strpoli = String.valueOf(Poli.getSelectedItem());
                String strnotelp = textNotelp.getText();
                String stralamat = textAlamat.getText();
                
                Date lahir = (Date)datePicker.getModel().getValue();
                Dokter dokter = new Dokter(strnid, strpoli, strnama, strnik, lahir, strgoldar, strgender, stralamat, strnotelp);
                boolean input = control.addDokter(dokter);
                if(input == true){
                    inputDokter.setVisible(false);
                    JOptionPane.showMessageDialog(null,"Data Sudah Di Tambah");
                    new MenuDokter();
                    inputDokter.setVisible(false);
                }                
            default: 
                break;
        }
    }
    
    
    
}
