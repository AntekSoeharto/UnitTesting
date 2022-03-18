/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerPasien;
import Model.Pasien;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

/**
 *
 * @author V for Vladimir
 */
public class ViewUpdateDataPasien implements ActionListener{
    JFrame viewUpdateData = new JFrame("UPDATE DATA PASIEN");
    JLabel golonganPasienBaru,
            alamatInputBaruLabel,
            TeleponInputBaruLabel,ketentuanLabel;
    JTextField alamatInputTextField,
            teleponInputTextField,
            golonganPasienTextField;
    JButton ubahDataPasien,buttonValidasi,buttonBack;
    JCheckBox golonganCheckBox,alamatCheckBox,teleponCheckBox;
    JPanel panelContent,panelMenu;
    JButton menuPasien = new JButton("PASIEN");
    JButton menuDokter = new JButton("DOKTER");
    JButton menuAdmin = new JButton("ADMINISTRASI");
    String NIKSearch;
    public ViewUpdateDataPasien(String NIK){
        NIKSearch = NIK;
        panelContent = new JPanel();
        panelMenu = new JPanel();
        ketentuanLabel = new JLabel("Silahkan Tandai Data Yang Ingin Di Ubah");
        golonganPasienBaru = new JLabel("Golongan Pasien (Tulis dengan Huruf Kapital Semua)");
        alamatInputBaruLabel = new JLabel("Alamat Baru Pasien");
        TeleponInputBaruLabel = new JLabel("No Telepon Baru Pasien");
        alamatInputTextField = new JTextField();
        teleponInputTextField = new JTextField();
        golonganPasienTextField = new JTextField();
        golonganCheckBox = new JCheckBox("ubah golongan");
        alamatCheckBox = new JCheckBox("ubah alamat");
        teleponCheckBox = new JCheckBox("ubah no kontak");
        ubahDataPasien = new JButton("UBAH DATA PASIEN");
        buttonValidasi = new JButton("VALIDASI PILIHAN");
        buttonBack = new JButton("KEMBALI");
        
        alamatInputBaruLabel.setVisible(false);
        TeleponInputBaruLabel.setVisible(false);
        golonganPasienBaru.setVisible(false);
        alamatInputTextField.setVisible(false);
        teleponInputTextField.setVisible(false);
        golonganPasienTextField.setVisible(false);
        ubahDataPasien.setVisible(false);
        buttonBack.setVisible(false);
        
        viewUpdateData.setSize(1200, 620);
        viewUpdateData.setLayout(null);
        viewUpdateData.setLocationRelativeTo(null);
        
        panelMenu.setLayout(null);
        panelContent.setLayout(null);
        panelContent.setBackground(Color.ORANGE);
        panelMenu.setBackground(Color.ORANGE);
        
        golonganCheckBox.setBackground(Color.ORANGE);
        alamatCheckBox.setBackground(Color.ORANGE);
        teleponCheckBox.setBackground(Color.ORANGE);
        
        panelMenu.setBounds(10,520,1170,50);
        panelContent.setBounds(10,10,1170,500);
        
        menuPasien.setBounds(320,10,90,30);
        menuDokter.setBounds(520,10,90,30);
        menuAdmin.setBounds(720,10,120,30);
        
        ketentuanLabel.setBounds(10, 10, 150, 25);
        golonganCheckBox.setBounds(10, 40, 150, 25);
        alamatCheckBox.setBounds(170, 40, 150, 25);
        teleponCheckBox.setBounds(340, 40, 150, 25);
        golonganPasienBaru.setBounds(10, 10, 150, 25);
        alamatInputBaruLabel.setBounds(10, 40, 150, 25);
        TeleponInputBaruLabel.setBounds(10, 70, 150, 25);
        golonganPasienTextField.setBounds(170, 10, 150, 25);
        alamatInputTextField.setBounds(170, 40, 150, 25);
        teleponInputTextField.setBounds(170, 70, 150, 25);
        ubahDataPasien.setBounds(170, 190, 150, 30);
  
        buttonBack.setBounds(10, 190, 150, 30);
        buttonValidasi.setBounds(80, 190, 150, 30);
        
        panelContent.add(ketentuanLabel);
        panelContent.add(golonganCheckBox);
        panelContent.add(alamatCheckBox);
        panelContent.add(teleponCheckBox);
        panelContent.add(ketentuanLabel);
        panelContent.add(alamatCheckBox);
        panelContent.add(golonganCheckBox);
        panelContent.add(teleponCheckBox);
        panelContent.add(golonganPasienBaru);
        panelContent.add(golonganPasienTextField);
        panelContent.add(alamatInputBaruLabel);
        panelContent.add(alamatInputTextField);
        panelContent.add(teleponInputTextField);
        panelContent.add(TeleponInputBaruLabel);
        panelContent.add(ubahDataPasien);
        panelContent.add(buttonValidasi);
        panelContent.add(buttonBack);
        
        panelMenu.add(menuDokter);
        panelMenu.add(menuPasien);
        panelMenu.add(menuAdmin);
        
        menuDokter.addActionListener(this);
        menuPasien.addActionListener(this);
        menuAdmin.addActionListener(this);
        buttonValidasi.addActionListener(this);
        ubahDataPasien.addActionListener(this);
        buttonBack.addActionListener(this);
        
        viewUpdateData.add(panelContent);
        viewUpdateData.add(panelMenu);
        viewUpdateData.setLocationRelativeTo(null);
        viewUpdateData.setUndecorated(true);
        viewUpdateData.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        viewUpdateData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewUpdateData.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "PASIEN": 
                new MenuPasien();
                viewUpdateData.setVisible(false);
                break;
            case "DOKTER":
                new MenuDokter();
                viewUpdateData.setVisible(false);
                break;
            case "ADMINISTRASI":
                new MenuAdmin();
                viewUpdateData.setVisible(false);
                break;
            case "UBAH DATA PASIEN":
                ControllerPasien cp = new ControllerPasien();
                Pasien p = cp.getPasien(NIKSearch);
                String golongan = "",alamat = "",telepon = "";
                if(golonganCheckBox.isSelected()){
                    golongan = golonganPasienTextField.getText();
                }else{
                    golongan = String.valueOf(p.getBPJS());
                }
                
                if(alamatCheckBox.isSelected()){
                    alamat =  alamatInputTextField.getText();
                }else{
                    alamat = p.getAlamat();
                }
                
                if(teleponCheckBox.isSelected()){
                    telepon =  teleponInputTextField.getText();
                }else{
                    telepon = p.getTelepon();
                }
                try {
                    cp.updatePasien(golongan, alamat, telepon, NIKSearch);
                    viewUpdateData.dispose();
                    new MenuPasien();
                    JOptionPane.showMessageDialog(null, "data berhasil diubah");
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(null, "data gagal diubah");
                }
                break;
            case "VALIDASI PILIHAN":
                ketentuanLabel.setVisible(false);
                buttonValidasi.setVisible(false);
                ubahDataPasien.setVisible(true);
                buttonBack.setVisible(true);
                if(alamatCheckBox.isSelected()){
                    alamatCheckBox.setVisible(false);
                    alamatInputBaruLabel.setVisible(true);
                    alamatInputTextField.setVisible(true);
                }else{
                    alamatCheckBox.setVisible(false);
                    alamatInputBaruLabel.setVisible(false);
                    alamatInputTextField.setVisible(false);
                }
                if(teleponCheckBox.isSelected()){
                    teleponCheckBox.setVisible(false);
                    TeleponInputBaruLabel.setVisible(true);
                    teleponInputTextField.setVisible(true);
                }else{
                    teleponCheckBox.setVisible(false);
                    TeleponInputBaruLabel.setVisible(false);
                    teleponInputTextField.setVisible(false);
                }
                if(golonganCheckBox.isSelected()){
                    golonganCheckBox.setVisible(false);
                    golonganPasienBaru.setVisible(true);
                    golonganPasienTextField.setVisible(true);
                }else{
                    golonganCheckBox.setVisible(false);
                    golonganPasienBaru.setVisible(false);
                    golonganPasienTextField.setVisible(false);
                }
                break;
            case "KEMBALI" :
                ketentuanLabel.setVisible(true);
                buttonValidasi.setVisible(true);
                alamatCheckBox.setVisible(true);
                teleponCheckBox.setVisible(true);
                golonganCheckBox.setVisible(true);
                
                alamatInputBaruLabel.setVisible(false);
                TeleponInputBaruLabel.setVisible(false);
                golonganPasienBaru.setVisible(false);
                alamatInputTextField.setVisible(false);
                teleponInputTextField.setVisible(false);
                golonganPasienTextField.setVisible(false);
                ubahDataPasien.setVisible(false);
                buttonBack.setVisible(false);
                break;
            default: 
                break;
        }
    }
}
