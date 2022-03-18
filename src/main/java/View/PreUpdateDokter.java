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
import Controller.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;

public class PreUpdateDokter implements ActionListener, MouseListener{
    ControllerDokter control = new ControllerDokter();
    
    JFrame preUpdateDokter = new JFrame("PRE UPDATE DOKTER");
    JPanel menu = new JPanel();
    JPanel isi = new JPanel();
    
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    
    JTable table;
    JScrollPane scroll;
    
    
    public PreUpdateDokter(){
        
        preUpdateDokter.setSize(1200, 620);
        preUpdateDokter.setLocationRelativeTo(null);
        preUpdateDokter.setLayout(null);
    
        menu.setLayout(null);
        isi.setLayout(null);
        
        menu.setBounds(10,520,1170,50);
        isi.setBounds(10,10,1170,500);
        
        isi.setBackground(Color.ORANGE);
        menu.setBackground(Color.ORANGE);
        
        menuPasien.setBounds(320, 10, 90, 30);
        menuDokter.setBounds(520, 10, 90, 30);
        menuAdmin.setBounds(720, 10, 120, 30);
        
        menu.add(menuDokter);
        menu.add(menuPasien);
        menu.add(menuAdmin);
        
        menuDokter.addActionListener(this);
        menuPasien.addActionListener(this);
        menuAdmin.addActionListener(this);
        
        ArrayList<Dokter> dokters = control.getAllDokter();
        String[] header = {"NIK", "NID", "Nama", "Poliklinik"};
        
        String[][] isitable = new String[dokters.size()][5];
        
        for(int i = 0; i < dokters.size(); i++){
            Dokter dokter = dokters.get(i);
            isitable[i][0] = dokter.getNIK();
            isitable[i][1] = dokter.getNID();
            isitable[i][2] = dokter.getNama();
            isitable[i][3] = dokter.getPoliklinik();
        }
        
        table = new JTable(isitable, header);
        scroll = new JScrollPane(table);
        scroll.setBounds(50, 50, 800, 400);
        isi.add(scroll);
        
       
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e){
                if(e.getClickCount() == 1){
                    final JTable jTable= (JTable)e.getSource();
                    final int row = jTable.getSelectedRow();
                    final int column = 0;
                    final String valueInCell = (String)jTable.getValueAt(row, column);
                    Dokter dokter = control.getDokter(valueInCell);
                    preUpdateDokter.setVisible(false);
                    new UpdateDokter(dokter);
                }
            }
        });

        preUpdateDokter.add(isi);
        preUpdateDokter.add(menu);
        
        preUpdateDokter.setUndecorated(true);
        preUpdateDokter.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        preUpdateDokter.setVisible(true);
        preUpdateDokter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                preUpdateDokter.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                preUpdateDokter.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                preUpdateDokter.setVisible(false);
                break;
            default: 
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}