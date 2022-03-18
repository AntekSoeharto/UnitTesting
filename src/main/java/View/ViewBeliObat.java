/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class ViewBeliObat {
    JFrame beliObat = new JFrame("MASUKAN NAMA OBAT");
    JLabel jumlahJenisObatLabel,namaObatLabel,totalHarga,jumlahObatLabel;
    JTextField jumlahJenisObatField;
    JTextField[] namaObatFields,jumlahObatFields;
    JButton buttonHitungTotalHarga,buttonLanjut;
    JPanel panelContent,panelMenu;
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
   
    public ViewBeliObat(){
        beliObat.setSize(1200, 620);
        beliObat.setLocationRelativeTo(null);
        jumlahJenisObatLabel = new JLabel("Jumlah Jenis Obat");
        jumlahJenisObatField = new JTextField();
        
        buttonLanjut = new JButton("NEXT");
        buttonHitungTotalHarga = new JButton("HITUNG TOTAL HARGA");
        panelContent = new JPanel();
        panelMenu = new JPanel();
        
        panelContent.setLayout(null);
        panelMenu.setLayout(null);
        
        panelContent.setBackground(Color.CYAN);
        panelMenu.setBackground(Color.ORANGE);
        
        panelMenu.setBounds(10,520,1170,50);
        panelContent.setBounds(10,10,1170,500);
        
        jumlahJenisObatLabel.setBounds(40, 20, 160, 25);
        jumlahJenisObatField.setBounds(120, 20, 160, 25);
        buttonLanjut.setBounds(40, 80, 120, 30);
        buttonHitungTotalHarga.setBounds(120, 80, 120, 30);
        
        menuPasien.setBounds(320,10,90,30);
        menuDokter.setBounds(520,10,90,30);
        menuAdmin.setBounds(720,10,120,30);
        
        panelContent.add(jumlahJenisObatLabel);
        panelContent.add(jumlahJenisObatField);
        panelContent.add(buttonLanjut);
        panelContent.add(buttonHitungTotalHarga);
        panelMenu.add(menuPasien);
        panelMenu.add(menuDokter);
        panelMenu.add(menuAdmin);
        
        beliObat.add(panelMenu);
        beliObat.add(panelContent);
        beliObat.setLayout(null);
        
        beliObat.setUndecorated(true);
        beliObat.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        beliObat.setVisible(true);
        beliObat.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        buttonLanjut.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {
                jumlahJenisObatLabel.setVisible(false);
                jumlahJenisObatField.setVisible(false);
                buttonLanjut.setVisible(false);
                try {
                    String jmlStr = jumlahJenisObatField.getText();
                    int jml = Integer.parseInt(jmlStr);
                    namaObatFields = new JTextField[jml];
                    jumlahObatFields = new JTextField[jml];
                    for(int i = 0; i < namaObatFields.length; i++){
                        namaObatLabel = new JLabel("Nama Obat " + (i+1));
                        jumlahObatLabel = new JLabel("Jumlah Obat " + (i+1) + "(Miligram)");
                        namaObatFields[i] = new JTextField();
                        jumlahObatFields[i] = new JTextField();
                        
                        namaObatLabel.setBounds(265, (i*3+1)*10, 100, 25);
                        namaObatFields[i].setBounds(385, (i*3+1)*10, 120, 25);
                        jumlahObatLabel.setBounds(515, (i*3+1)*10, 180, 25);
                        jumlahObatFields[i].setBounds(675, (i*3+1)*10, 120, 25);
                        
                        panelContent.add(namaObatLabel);
                        panelContent.add(namaObatFields[i]);
                        panelContent.add(jumlahObatLabel);
                        panelContent.add(jumlahObatFields[i]);
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "INPUT BUKAN ANGKA!");
                    if(JOptionPane.OK_OPTION == 0){
                        jumlahJenisObatField.setText("");
                    }
                }
            }
        });
        buttonHitungTotalHarga.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                //looping query ke DB bwt cek stok obat
                //tranksaksi masukkin ke db
            }
        });
    }
}
