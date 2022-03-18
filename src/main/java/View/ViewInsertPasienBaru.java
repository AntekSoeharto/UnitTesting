/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerViewPasien;
import Model.DateLabelFormatter;
import Model.GolonganPasien;
import Model.InterfaceGolongan;
import Model.Pasien;
import Model.User;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author V for Vladimir
 */
public class ViewInsertPasienBaru implements InterfaceGolongan{
    JFrame viewInsertNewPatient = new JFrame("FORM PASIEN BARU");
    JLabel NIKLabel,namaLabel,tglLahirLabel,alamatLabel,noKontakLabel,golonganLabel,
            genderLabel,alergiLabel,goldarLabel,penyakitMenurunLabel,rhesusLabel;
    JTextField NIKTextField,namaTextField,alamatTextField,noKontakTextField,
            alergiTextField,penyakitMenurunTextField;
    JRadioButton BPJSRadioButton,nonBPJSRadioButton,
            wanitaRadioButton,priaRadioButton,
            golDarA,golDarB,golDarAB,golDarO,
            rhesusMin,rhesusPlus;
    ButtonGroup genderButtonGroup,golonganButtonGroup,goldarButtonGroup,rhesusButtonGroup;
    JButton insertNewPatient;
    JDatePickerImpl tglLahir;
    JDatePanelImpl datePanel;
    JPanel panelContent,panelMenu,panelWithScroll;
    JScrollPane panelScroll;
    GridBagLayout gbl;
    GridBagConstraints gbc;
    ControllerViewPasien CVP;
    
    public ViewInsertPasienBaru(){
        NIKLabel = new JLabel("NIK");
        namaLabel = new JLabel("Nama Lengkap");
        tglLahirLabel = new JLabel("Tanggal Lahir");
        alamatLabel = new JLabel("Alamat Pasien");
        noKontakLabel = new JLabel("no Kontak Pasien");
        golonganLabel = new JLabel("Golongan Pasien");
        genderLabel = new JLabel("Jenis Kelamin Pasien");
        alergiLabel = new JLabel("Alergi");
        goldarLabel = new JLabel("golongan darah");
        penyakitMenurunLabel = new JLabel("Penyakit Menurun");
        rhesusLabel = new JLabel("Rhesus");
        NIKTextField = new JTextField(20);
        namaTextField = new JTextField(20);
        alergiTextField = new JTextField(20);
        penyakitMenurunTextField = new JTextField(20);
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);
        tglLahir = new JDatePickerImpl(datePanel,new DateLabelFormatter());
        alamatTextField = new JTextField(20);
        noKontakTextField = new JTextField(20);
        BPJSRadioButton = new JRadioButton("BPJS");
        nonBPJSRadioButton = new JRadioButton("NON BPJS");
        wanitaRadioButton = new JRadioButton("wanita");
        priaRadioButton = new JRadioButton("pria");
        golDarA = new JRadioButton("A");
        golDarB = new JRadioButton("B");
        golDarAB = new JRadioButton("AB");
        golDarO = new JRadioButton("O");
        rhesusMin = new JRadioButton("-");
        rhesusPlus = new JRadioButton("+");
        goldarButtonGroup = new ButtonGroup();
        genderButtonGroup = new ButtonGroup();
        golonganButtonGroup = new ButtonGroup();
        rhesusButtonGroup = new ButtonGroup();
        genderButtonGroup.add(wanitaRadioButton);
        genderButtonGroup.add(priaRadioButton);
        golonganButtonGroup.add(BPJSRadioButton);
        golonganButtonGroup.add(nonBPJSRadioButton);
        goldarButtonGroup.add(golDarA);
        goldarButtonGroup.add(golDarB);
        goldarButtonGroup.add(golDarAB);
        goldarButtonGroup.add(golDarO);
        rhesusButtonGroup.add(rhesusMin);
        rhesusButtonGroup.add(rhesusPlus);
        insertNewPatient = new JButton("TAMBAH PASIEN BARU");
        panelContent = new JPanel();
        panelMenu = new JPanel();
        panelWithScroll = new JPanel();
        CVP = new ControllerViewPasien();
        gbc = new GridBagConstraints();
        gbl = new GridBagLayout();
        panelWithScroll.setLayout(gbl);
        panelScroll = new JScrollPane(){
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(600, 500);
            };
        };
        panelScroll.setViewportView(panelWithScroll);
        
        CVP.setGBC(gbc, 0.5, 0.5, 1, 1, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(NIKLabel,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 1, GridBagConstraints.PAGE_START);
        panelWithScroll.add(NIKTextField,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 2, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(namaLabel,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 2, GridBagConstraints.PAGE_START);
        panelWithScroll.add(namaTextField,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 3, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(alergiLabel,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 3, GridBagConstraints.PAGE_START);
        panelWithScroll.add(alergiTextField,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 4, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(goldarLabel,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 5, GridBagConstraints.LINE_START);
        panelWithScroll.add(golDarA,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 5, GridBagConstraints.LINE_START);
        panelWithScroll.add(golDarB,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 3, 5, GridBagConstraints.LINE_START);
        panelWithScroll.add(golDarAB,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 6, GridBagConstraints.LINE_START);
        panelWithScroll.add(golDarO,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 7, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(rhesusLabel,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 8, GridBagConstraints.LINE_START);
        panelWithScroll.add(rhesusMin,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 8, GridBagConstraints.LINE_START);
        panelWithScroll.add(rhesusPlus,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 9, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(penyakitMenurunLabel,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 9, GridBagConstraints.PAGE_START);
        panelWithScroll.add(penyakitMenurunTextField,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 10, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(golonganLabel,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 11, GridBagConstraints.LINE_START);
        panelWithScroll.add(BPJSRadioButton,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 11, GridBagConstraints.LINE_START);
        panelWithScroll.add(nonBPJSRadioButton,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 12, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(tglLahirLabel,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 12, GridBagConstraints.PAGE_START);
        panelWithScroll.add(tglLahir,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 13, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(alamatLabel,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 13, GridBagConstraints.PAGE_START);
        panelWithScroll.add(alamatTextField,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 14, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(noKontakLabel,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 14, GridBagConstraints.PAGE_START);
        panelWithScroll.add(noKontakTextField,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 15, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(genderLabel,gbc);  
        CVP.setGBC(gbc, 0.5, 0.5, 1, 16, GridBagConstraints.LINE_START);
        panelWithScroll.add(wanitaRadioButton,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 2, 16, GridBagConstraints.LINE_START);
        panelWithScroll.add(priaRadioButton,gbc);
        CVP.setGBC(gbc, 0.5, 0.5, 1, 17, GridBagConstraints.FIRST_LINE_START,GridBagConstraints.HORIZONTAL);
        panelWithScroll.add(insertNewPatient,gbc);
        
        panelContent.add(panelScroll,gbc);
        
        viewInsertNewPatient.setContentPane(panelContent);
        viewInsertNewPatient.pack();
        viewInsertNewPatient.setLocationByPlatform(true);
        viewInsertNewPatient.setVisible(true);
        viewInsertNewPatient.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
        insertNewPatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pasien pt = new Pasien();
                pt.setNIK(NIKTextField.getText());
                pt.setNama(namaTextField.getText());
                pt.setAlamat(alamatTextField.getText());
                pt.setPenyakitMenurun(penyakitMenurunTextField.getText());
                pt.setAlergi(alergiTextField.getText());
//                pt.setGolDar(goldarTextField.getText());
                pt.setTglLahir((Date)tglLahir.getModel().getValue());
                pt.setTelepon(noKontakTextField.getText());
                String gender = "";
                if(wanitaRadioButton.isSelected()){
                    gender = "Wanita";
                }else if(priaRadioButton.isSelected()){
                    gender = "Pria";
                }
                if(BPJSRadioButton.isSelected()){
                    pt.setBPJS(BPJS);
                }else if(nonBPJSRadioButton.isSelected()){
                    pt.setBPJS(NON_BPJS);
                }
                String golDar = "";
                if(rhesusMin.isSelected()){
                    golDar = "-";
                }else{
                    golDar = "+";
                }
                if(golDarA.isSelected()){
                    golDar += "A";
                }else if(golDarB.isSelected()){
                    golDar += "B";
                }else if(golDarAB.isSelected()){
                    golDar += "AB";
                }else{
                    golDar += "O";
                }
                pt.setGolDar(golDar);
                pt.setGender(gender);
                pt.setListRiwayatPasien(new ArrayList<>());
                
                pt.pasienBaru(pt);
                viewInsertNewPatient.dispose();
            }
        });
    }
}
