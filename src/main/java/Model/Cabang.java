/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Cabang{
    private String Alamat;
    private String Telepon;
    private String Nama;
    private String idCabang;
    private ArrayList<Dokter> listDokter = new ArrayList<Dokter>();
    private ArrayList<Obat> listobat = new ArrayList<Obat>();
    private ArrayList<Transaksi> listTransaksi = new ArrayList<Transaksi>();
    
    public Cabang(){
        
    }

    public Cabang(ArrayList<Dokter> listDokter, ArrayList<Obat> listobat, ArrayList<Transaksi> listTransaksi, String Alamat, String Telepon, String Nama, String idCabang) {
        this.listTransaksi = listTransaksi;
        this.listobat = listobat;
        this.listDokter = listDokter;
        this.Alamat = Alamat;
        this.Nama = Nama;
        this.Telepon = Telepon;
        this.idCabang = idCabang;
        
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public ArrayList<Dokter> getListDokter() {
        return listDokter;
    }

    public void setListDokter(ArrayList<Dokter> listDokter) {
        this.listDokter = listDokter;
    }

    public ArrayList<Obat> getListobat() {
        return listobat;
    }

    public void setListobat(ArrayList<Obat> listobat) {
        this.listobat = listobat;
    }

    public ArrayList<Transaksi> getListTransaksi() {
        return listTransaksi;
    }

    public void setListTransaksi(ArrayList<Transaksi> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }
    
    public String getTelepon() {
        return Telepon;
    }

    public void setTelepon(String Telepon) {
        this.Telepon = Telepon;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    @Override
    public String toString() {
        return "Cabang{" + "Alamat=" + Alamat + ", Telepon=" + Telepon + ", Nama=" + Nama + '}';
    }
}
