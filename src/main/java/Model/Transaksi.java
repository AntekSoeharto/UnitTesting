/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author hp
 */
public class Transaksi implements InterfaceGolongan{
    
    private String idTransaksi;
    private Date tanggalMasuk;
    private int jumlah;
    private int JenisPasien;
    private double hargaKonsultasi;
    private double total;
    private double hargaObat;
    private Pasien pasien;
    private boolean isBayar;
    
    
    public Transaksi(){
        
    }

    public Transaksi(String idTransaksi, Date tanggalMasuk, int jumlah, int JenisPasien, double hargaKonsultasi, double total, double hargaObat, Pasien pasien, boolean isBayar) {
        this.idTransaksi = idTransaksi;
        this.tanggalMasuk = tanggalMasuk;
        this.jumlah = jumlah;
        this.JenisPasien = JenisPasien;
        this.hargaKonsultasi = hargaKonsultasi;
        this.total = total;
        this.hargaObat = hargaObat;
        this.pasien = pasien;
        this.isBayar = isBayar;
    }

   

    public boolean getIsBayar() {
        return isBayar;
    }

    public void setIsBayar(boolean isBayar) {
        this.isBayar = isBayar;
    }
  

    public Pasien getPasien() {
        return pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }


    
    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Date getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(Date tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }


    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getJenisPasien() {
        return JenisPasien;
    }

    public void setJenisPasien(int JenisPasien) {
        this.JenisPasien = JenisPasien;
    }

    public double getHargaKonsultasi() {
        return hargaKonsultasi;
    }

    public void setHargaKonsultasi(double hargaKonsultasi) {
        this.hargaKonsultasi = hargaKonsultasi;
    }

    public double getHargaObat() {
        return hargaObat;
    }

    public void setHargaObat(double hargaObat) {
        this.hargaObat = hargaObat;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Transaksi{" + "idTransaksi=" + idTransaksi + ", tanggakMasuk=" + tanggalMasuk + ", jumlah=" + jumlah + ", JenisPasien=" + JenisPasien + ", hargaKonsultasi=" + hargaKonsultasi + ", hargaObat=" + hargaObat + ", total=" + total + '}';
    }
    
    
}
