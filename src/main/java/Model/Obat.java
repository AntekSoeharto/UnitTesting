/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hp
 */
public class Obat {
    private String IDObat;
    private String IDMasaLakuObat;
    private String Nama;
    private int hargaBeli;
    private int Stok;
    private int hargaJual;
    private String tgl_beli;
    private String tgl_kadaluarsa;
    private String idObat;
    private String idMlo;
    
    
    public Obat(){
        
    }

    public Obat(String Nama, int hargaBeli, int Stok, int hargaJual, String tgl_beli, String tgl_kadaluarsa, String idObat, String idMlo) {
        this.Nama = Nama;
        this.hargaBeli = hargaBeli;
        this.Stok = Stok;
        this.hargaJual = hargaJual;
        this.tgl_beli = tgl_beli;
        this.tgl_kadaluarsa = tgl_kadaluarsa;
        this.idObat = idObat;
        this.idMlo = idMlo;
    }

    public Obat(String IDObat, String IDMasaLakuObat, String Nama, int hargaBeli, int Stok, int hargaJual, String tgl_beli, String tgl_kadaluarsa) {
        this.IDObat = IDObat;
        this.IDMasaLakuObat = IDMasaLakuObat;
        this.Nama = Nama;
        this.hargaBeli = hargaBeli;
        this.Stok = Stok;
        this.hargaJual = hargaJual;
        this.tgl_beli = tgl_beli;
        this.tgl_kadaluarsa = tgl_kadaluarsa;
    }
    
    public String getIDObat() {
        return IDObat;
    }

    public void setIDObat(String IDObat) {
        this.IDObat = IDObat;
    }

    public String getIDMasaLakuObat() {
        return IDMasaLakuObat;
    }

    public void setIDMasaLakuObat(String IDMasaLakuObat) {
        this.IDMasaLakuObat = IDMasaLakuObat;
    }

    public String getTgl_beli() {
        return tgl_beli;
    }

    public void setTgl_beli(String tgl_beli) {
        this.tgl_beli = tgl_beli;
    }

    public String getTgl_kadaluarsa() {
        return tgl_kadaluarsa;
    }

    public void setTgl_kadaluarsa(String tgl_kadaluarsa) {
        this.tgl_kadaluarsa = tgl_kadaluarsa;
    }
    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public int getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(int hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public int getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(int hargaJual) {
        this.hargaJual = hargaJual;
    }

    public int getStok() {
        return Stok;
    }

    public void setStok(int Stok) {
        this.Stok = Stok;
    }

    @Override
    public String toString() {
        return "Obat{" + "Nama=" + Nama + ", hargaBeli=" + hargaBeli + ", hargaJual=" + hargaJual + ", Stok=" + Stok + '}';
    }
    
    
}
