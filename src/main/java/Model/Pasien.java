/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.ControllerPasien;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Pasien extends User implements InterfaceGolongan{
    private ArrayList<RiwayatPasien> listRiwayatPasien = new ArrayList<RiwayatPasien>();
    private GolonganPasien BPJS;
    private String alergi;
    private String penyakitMenurun;
    
    
    public Pasien(){
        
        
    }



    public Pasien(GolonganPasien BPJS) {
        this.BPJS = BPJS;
    }

    public Pasien(GolonganPasien BPJS, String alergi, String penyakitMenurun) {
        this.BPJS = BPJS;
        this.alergi = alergi;
        this.penyakitMenurun = penyakitMenurun;
    }

    public Pasien(GolonganPasien BPJS,
            String alergi,
            String penyakitMenurun, 
            String Nama,
            String NIK,
            Date tglLahir, 
            String Alamat,
            String Telepon,
            String golonganDarah,
            String gender) {
        super(Nama, NIK, tglLahir, Alamat, Telepon, golonganDarah,gender);
        this.BPJS = BPJS;
        this.alergi = alergi;
        this.penyakitMenurun = penyakitMenurun;
    }

    


    public ArrayList<RiwayatPasien> getListRiwayatPasien() {
        return listRiwayatPasien;
    }

    public void setListRiwayatPasien(ArrayList<RiwayatPasien> listRiwayatPasien) {
        this.listRiwayatPasien = listRiwayatPasien;
    }
    public GolonganPasien getBPJS() {
        return BPJS;
    }

    public void setBPJS(GolonganPasien BPJS) {
        this.BPJS = BPJS;

    }


    public String getAlergi() {
        return alergi;
    }

    public void setAlergi(String alergi) {
        this.alergi = alergi;
    }

    public String getPenyakitMenurun() {
        return penyakitMenurun;
    }

    public void setPenyakitMenurun(String penyakitMenurun) {
        this.penyakitMenurun = penyakitMenurun;
    }

    @Override
    public String toString() {
        return super.toString() + "Pasien{" + "listRiwayatPasien=" + listRiwayatPasien + ", BPJS=" + BPJS + ", alergi=" + alergi + ", penyakitMenurun=" + penyakitMenurun + '}';
    }
    
    
    

    public void pasienBaru(Pasien pt){
        ControllerPasien c = new ControllerPasien();
        boolean statusInsert = c.insertNewPasien(pt);
        
        if(statusInsert == true){
            JOptionPane.showMessageDialog(null, "data berhasil dimasukkan ke database");
        }else{
            JOptionPane.showMessageDialog(null, "data gagal dimasukkan!");
        }
    }
    public void ubahDataPasien(){
        
    }
    public void buatJanjidgDokter(){
        
    }
    public void rawatJalan(){
        
    }
    public void lihatDataPasien(){
        
    }
    
}
