/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hp
 */
public class RiwayatPasien{
    private String keluhan;
    private String penyakit;
    private List<String> resepObat = new ArrayList<String>();
    private Date tanggalKunjungan;

    public RiwayatPasien() {
    }

    public RiwayatPasien(String keluhan, String penyakit, Date tanggalKunjungan) {
        this.keluhan = keluhan;
        this.penyakit = penyakit;
        this.tanggalKunjungan = tanggalKunjungan;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getPenyakit() {
        return penyakit;
    }

    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }

    public List<String> getResepObat() {
        return resepObat;
    }

    public void setResepObat(List<String> resepObat) {
        this.resepObat = resepObat;
    }

    public Date getTanggalKunjungan() {
        return tanggalKunjungan;
    }

    public void setTanggalKunjungan(Date tanggalKunjungan) {
        this.tanggalKunjungan = tanggalKunjungan;
    }

    @Override
    public String toString() {
        return "RiwayatPasien{" + "keluhan=" + keluhan + ", penyakit=" + penyakit + ", resepObat=" + resepObat + ", tanggalKunjungan=" + tanggalKunjungan + '}';
    }
    
    public void tambahRiwayatPasien(){
        
    }
    public void lihatRiwayat1Pasien(){
        
    }

    
}
