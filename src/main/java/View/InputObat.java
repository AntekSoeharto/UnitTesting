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


public class InputObat implements ActionListener{
    private ControllerObat control = new ControllerObat();
    JFrame inputDokter = new JFrame("INPUT OBAT");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    JButton submit = new JButton("SUBMIT");
    
    JLabel labNama = new JLabel("Nama");
    JLabel labBeli = new JLabel("Harga Beli");
    JLabel labJual = new JLabel("Harga Jual");
    JTextField textNama = new JTextField();
    JTextField textBeli = new JTextField();
    JTextField textJual = new JTextField();

    public InputObat(){
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
        
        labNama.setBounds(40, 10, 160, 25);
        isi.add(labNama);
        textNama.setBounds(120, 10, 160, 25);
        isi.add(textNama);
        
        labBeli.setBounds(40, 60, 160, 25);
        isi.add(labBeli);
        textBeli.setBounds(120, 60, 160, 25);
        isi.add(textBeli);
        
        labJual.setBounds(40, 120, 160, 25);
        isi.add(labJual);
        textJual.setBounds(120, 120, 160, 25);
        isi.add(textJual);
        
        submit.setBounds(80,160,100,25);
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
                int beli = Integer.parseInt(textBeli.getText());
                int jual = Integer.parseInt(textJual.getText());
                String strnama = textNama.getText();
                Obat obat = new Obat();
                obat.setIDObat(control.getLastIDObat());
                obat.setNama(strnama);
                obat.setHargaBeli(beli);
                obat.setHargaJual(jual);
                boolean input = control.addObat(obat);
                if(input == true){
                    inputDokter.setVisible(false);
                    JOptionPane.showMessageDialog(null,"Data Sudah Di Tambah");
                    new MenuAdmin();
                    inputDokter.setVisible(false);
                }                
            default: 
                break;
        }
    }
    
    
}
